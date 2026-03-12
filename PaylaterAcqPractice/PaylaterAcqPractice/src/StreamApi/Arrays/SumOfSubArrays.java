package StreamApi.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import StreamApi.Employee;

public class SumOfSubArrays {

	public static void main(String[] args) {

		// HOW to use FlatMap-List of lists

		// Flat Map in non-stream approach
		List<List<Integer>> lis = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

		List<Integer> result = new ArrayList<>();

		for (List<Integer> inner : lis) {
			for (Integer val : inner) {
				result.add(val);
			}
		}

		System.out.println(result);

		List<List<String>> listOfLists = Arrays.asList(Arrays.asList(), Arrays.asList(), Arrays.asList());

		List<String> output = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());

		// System.out.println(output);

		// flatmap having an array of arrays

		// / .flatMap(Arrays::stream) ~ flatMap (Stream::of)

		Integer[][] arrayOfArrays = { { 1, 2, 3 }, { 1, 3, 3, 23, 3 }, { 1, 9 } };

		List<Integer> output1 = Arrays.stream(arrayOfArrays).flatMap(Arrays::stream).collect(Collectors.toList());

		// List<Integer> output1 =

		// Arrays.stream
		// (arrayOfArrays).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

		System.out.println(output1);

		List<List<Integer>> li = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 7));

		List<Integer> op = li.stream().flatMap(List::stream).collect(Collectors.toList());

		System.out.println("op is::::" + op);

		// Employee emp = new Employee(101, "ramu", 2000, "sales",
		// Arrays.asList("9542098867", "8367717261", "8500046389"));
		// If employe having list of phone numbers then you want all those ph num
		// in a singl array then useFlatmap

		// li.stream().flatMap(x ->
		// x.getPhoneNum().stream()).collect(Collectors.toList());

		// Difference between maximum number and minimum number from array

		int[] arrayOfNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer minMaxDifference = Arrays.stream(arrayOfNum).boxed()
				.collect(Collectors.teeing(Collectors.maxBy(Integer::compareTo), // Integer::compareTo
						Collectors.minBy(Integer::compareTo), (max, min) -> max.get() - min.get()));

		System.out.println("minMaxDifference::::: " + minMaxDifference);

		Integer minMaxDifferenceAnotherWay = Arrays.stream(arrayOfNum).boxed()
				.collect(Collectors.teeing(Collectors.maxBy(Comparator.comparing(x -> x)),
						Collectors.minBy(Comparator.comparing(x -> x)), (max, min) -> max.get() - min.get()));

		System.out.println("minMaxDifferenceAnotherway:::::::::" + minMaxDifferenceAnotherWay);

	}

}
