package BasicQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberStartsWith {
	public static void main(String[] args) {
		// .filter(s2::contains) == filter(e->s2.contains(e))
		// .map(Integer::valueOf) == map(e->Integer.valueOf(e))
		// ..map(String::valueof) == map(i-> String.valueOf(i))

		Integer[] arrayOfNumbers = { 2, 22, 343, 234, 267, 222, 567, 987, 212, 543, 2000 };

		List<Integer> outputNumWith2 = new ArrayList<>();
		int count =0;
		for (int num : arrayOfNumbers) {
			int value = Math.abs(num);
			// extract first digit
			while (value >= 10) {
				value = value / 10;
			}
			if (value == 2) {
				outputNumWith2.add(num);
				count++;
			}
		}
		System.out.println("outputNumWith2:::" + outputNumWith2 + "count" + count);

		List<Integer> outputNumWith2Stream = Stream.of(arrayOfNumbers).filter(x -> {
			int value = Math.abs(x);
			while (value >= 10)
				value /= 10;
			return value == 2;
		}).toList();
		System.out.println("outputNumWith2Stream:::" + outputNumWith2Stream);

		List<String> op = Stream.of(arrayOfNumbers).map(i -> String.valueOf(i))
				.filter(s -> s.startsWith("2") || s.startsWith("-2")).toList();

		System.out.println("op is" + op);

		List<Integer> numStartwith2 = Stream.of(arrayOfNumbers).map(i -> String.valueOf(i))
				.filter(s -> s.startsWith("2") || s.startsWith("-2")).map(s -> Integer.valueOf(s)).toList();
		System.out.println("op is numStartwith2" + numStartwith2);

		List<String> integerplusemptystr =

				Stream.of(arrayOfNumbers).map(x -> x + "").filter(x -> x.startsWith("2")).collect(Collectors.toList());

		System.out.println("integerplusemptystr" + integerplusemptystr);

		List<Integer> numStartwithh2 = Stream.of(arrayOfNumbers).map(String::valueOf)
				.filter(s -> s.startsWith("2") || s.startsWith("-2")).map(Integer::valueOf).toList();

		List<Integer> numStartwith22 = Stream.of(arrayOfNumbers)
				.filter(i -> i.toString().charAt(0) == '2' || i.toString().charAt(0) == '3')
				.collect(Collectors.toList());

		// System.out.println(nurStartwith22);

		List<Integer> ss = Stream.of(arrayOfNumbers).filter(i -> String.valueOf(i).charAt(0) == '2')
				.collect(Collectors.toList());

		System.out.println("ss+" + ss);

		List<Integer> ssss = Stream.of(arrayOfNumbers).filter(i -> String.valueOf(i).startsWith("2"))
				.collect(Collectors.toList());

		System.out.println("sssssssssss" + ssss);

		List<Integer> numStartwith222 = Stream.of(arrayOfNumbers).filter(i -> i.toString().startsWith("2"))
				.collect(Collectors.toList());

		System.out.println("numStartwith222" + numStartwith222);

		String[] array1 = { "amit", "sunil", "Akash", "Arul", "somu", "Beemu" };

		List<String> output = Stream.of(array1).filter(s -> s.toLowerCase().startsWith("a"))
				.collect(Collectors.toList());

		System.out.println(output);

	}
}
