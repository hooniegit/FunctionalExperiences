package Functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Basic {
	
	/**
	 * Class for Practices
	 */
	public static void basic() {
		
		/**
		 * <Custom>
		 */
		
		// int type functional interface
		CalculatorInterface cal = (a, b) -> a + b;
		int c = cal.calculate(1, 2);
		
		// boolean type functional interface
		BooleanInterface bool = input -> input != null;
		Boolean output_1 = bool.define(null);
		
		/**
		 * <Default>
		 */
		
		// Runnable ( ** No PARAMS ** )
		Runnable print = () -> System.out.println("Hello, World!");
		print.run();
		
		// Predicate : Return boolean
		Predicate<String> boolP = value -> value != null;
		
		// BiPredicate : Return boolean with two parameters.
		BiPredicate<Integer, Integer> equals = (a, b) -> a == b;
		
		// IntPredicate : Return boolean with int parameter.
		IntPredicate divide = a -> a % 4 == 0;
		
		// Function : Return
		Function<String, Integer> func = String -> String.length();
		Function<String, Integer> funcSugar = String::length;
		
		// Consumer : Void with One Params
		Consumer<String> printer = String -> System.out.println(String);
		Consumer<String> printerSugar = System.out::println;
		
		// BiConsumer : Void with Two Params
		BiConsumer<String, String> printerTwo = (str1, str2) -> System.out.println(str1 + str2);
		Map<String, String> map = new HashMap<>();
		BiConsumer<String, String> put = map::put;
		
		// Supplier : Return with No Param
		Supplier<Double> randomDouble = () -> Math.random();
		Supplier<Double> randomDoubleSugar = Math::random;
		
		// Int / Double Supplier
		IntSupplier fixedInt = () -> Math.addExact(100, 100);
		DoubleSupplier sup = () -> Math.E; // Cannot use sugar for Property (only for method)
		
		
	}
}
