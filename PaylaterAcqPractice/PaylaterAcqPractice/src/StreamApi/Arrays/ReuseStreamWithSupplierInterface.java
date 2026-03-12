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

		

		// 1) From the list sort the elements and find all the missing elements from
		// list

		// i/p: (3,1,7,4,9,15,8)

		Integer nums[] = { 3, 1, 7, 4, 9, 15, 8 };

		Arrays.sort(nums);

		int max = nums[nums.length - 1];

		int min = nums[0];

		List<Integer> list1 = List.of(nums);

		List<Integer> missingNums = new ArrayList<>();

		for (int i = min; i <= max; i++) {

			if (!list1.contains(i)) {

				missingNums.add(i);

			}

		}

		System.out.println("missingNums is::" + missingNums);

		List<Integer> list2 = new ArrayList<>(List.of(3, 1, 7, 4, 9, 15, 8));

		Collections.sort(list1);

		int maxNum = list1.get(list1.size() - 1);

		int minNum = list1.get(0);

		System.out.println("min max" + min + ":" + max);

		List<Integer> missingNums1 = new ArrayList<>();

		for (int i = minNum; i <= maxNum; i++) {

			if (!list2.contains(i)) {

				missingNums1.add(i);

			}

		}
		System.out.println("missingNums is::" + missingNums1);

	}

}
