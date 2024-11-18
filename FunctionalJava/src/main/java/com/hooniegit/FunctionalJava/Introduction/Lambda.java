package com.hooniegit.FunctionalJava.Introduction;

import com.hooniegit.FunctionalJava.Introduction.Interface.GenericToBoolean;
import com.hooniegit.FunctionalJava.Introduction.Interface.IntToBoolean;
import com.hooniegit.FunctionalJava.Introduction.Interface.StringToBoolean;
import com.hooniegit.FunctionalJava.Introduction.Interface.VoidToVoid;

/**
 * lambda 표현식
 * : (<parameters>) -> {<body>}
 */
public class Lambda {

    /**
     * String 입력, Boolean 반환
     */
    public StringToBoolean checker = (String str) -> {
        return str == null; 
    };

    /**
     * void 반환
     */
    public VoidToVoid printer = () -> System.out.println("Hello, World!");

    /**
     * <Generic>
     * All-Type 입력, Boolean 반환
     */
    public GenericToBoolean Tchecker = data -> data == null;
    
    /**
     * <Capturing>: Body 내에서 외부 데이터를 사용
     * - Capturing 데이터는 Effectively Final 해야 함
     * - Capturing 은 오버헤드를 발생시킬 수 있으므로, 불필요한 캡처링은 지양하는 것이 좋음
     * Int 입력, Boolean 반환
     */
    private int num = 29;
    public IntToBoolean Ichecker = n -> n == num;

}
