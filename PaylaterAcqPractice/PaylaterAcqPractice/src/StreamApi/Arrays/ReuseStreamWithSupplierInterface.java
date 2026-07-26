package StreamApi.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReuseStreamWithSupplierInterface {
	public static void main(String[] args) {
		//Read about Predicate(test), Supplier(get),Consumer,Function(apply)
		
//		Interface	        Method	      Purpose
//		Supplier<T>	        get()	      Supplies a value, no input
//		Predicate<T>     	test(T)	      Returns boolean
//		Consumer<T>	        accept(T)	  Consumes input, no return
//		Function<T,R>    	apply(T)	  Transforms input
		
		
		//Predicate<String> isSomu = s -> "somu".equals(s);

		//Function<String, String> toUpper = String::toUpperCase;

		//Consumer<String> printer = System.out::println;

		//Supplier<String> defaultName = () -> "Guest";


		String[] list = { "Ramu", "somu", "naresh", "somu" };
		// Supplier it doesn't take any input but it return something, internally it

		// uses get() method

		Supplier<Stream<String>> str1 = () -> Arrays.stream(list);

		long cnt = str1.get().filter(x -> "somu".equals(x)).count();

		str1.get().forEach(x -> System.out.println(x));

		System.out.println(cnt);
	}

}
