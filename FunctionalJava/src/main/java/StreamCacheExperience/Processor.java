package StreamCacheExperience;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Processor {
	/**
	 * Cache Map
	 */
    private final Map<Integer, NEW_BODY> cache = new ConcurrentHashMap<>();

    /**
     * <New> Use Stream API and Cache to create Map<Integer, List<NEW_BODY>>.
     * @param list
     * @param reference
     * @return
     */
    public Map<Integer, List<NEW_BODY>> processAndGroupNewBody(List<RAW_BODY> list, Map<Integer, Integer> reference) {
        return list.stream()
            .map(rawBody -> getCachedOrCreateNewBody(rawBody, reference))
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(newBody -> (newBody.getINDEX() - 1) / 2000 + 1));
    }

    /**
     * <New> Return cached NEW_BODY or create new.
     * @param rawBody
     * @param reference
     * @return
     */
    private NEW_BODY getCachedOrCreateNewBody(RAW_BODY rawBody, Map<Integer, Integer> reference) {
    	// computeIfAbsent : Depends on result of `rawBody.getPARAMETER()`
        return cache.computeIfAbsent(rawBody.getPARAMETER(), ref -> {
            Integer index = reference.get(ref);
            if (index != null) {
                return new NEW_BODY(index, rawBody.getVALUE(), rawBody.getTIMESTAMP());
            }
            return null;
        });
    }
    
    /**
     * <Old> Use Stream API to create Map<Integer, List<NEW_BODY>>.
     * @param list
     * @param reference
     * @return
     */
    public Map<Integer, List<NEW_BODY>> processAndGroupNewBody_old(List<RAW_BODY> list, Map<Integer, Integer> reference) { 
        return list.stream()
            .map(rawBody -> {
                Integer index = reference.get(rawBody.getPARAMETER()); 
                if (index != null) {
                    return new NEW_BODY(index, rawBody.getVALUE(), rawBody.getTIMESTAMP()); 
                } else {
                    return null;
                }
            })
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(newBody -> (newBody.getINDEX() - 1) / 2000 + 1));
    } 
    
}
