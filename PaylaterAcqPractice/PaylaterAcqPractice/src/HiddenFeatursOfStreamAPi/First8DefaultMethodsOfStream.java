package HiddenFeatursOfStreamAPi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class First8DefaultMethodsOfStream {
	public static void main(String[] args) {
//**********   Exploring Hidden Features **********

		// 1.Stream.OfNullable, 2.Stream.iterate, 3.Collectors.collectingAnd Then,
		// 4.stream.takewhil
		// and stream.dropwhile
		// 5.collectors.teeing, 6.stream.concat, 7.collectors.partioningBy 8. IntStream
		// for
		// Ranges
		// 1.========
		// It will not allow null values, gives only proper values

		String[] strings = { "ramu", "somu", "beemu", null, "seeta", "geetha", null };

		List<String> stringslist = Arrays.asList(strings);

		List<String> notNullvalues = stringslist.stream().filter(s -> s != null).collect(Collectors.toList());

		// System.out.println("notNullvalues: " + notNullvalues);

		// here Stream:: ofNullable~==x->Stream.ofNullable(x)

		// Here we are getting List<stream> as output, so we need to use FlatMap

		List<Stream<String>> notNullvalues1 = stringslist.stream().map(Stream::ofNullable).collect(Collectors.toList());

		// System.out.println("notNullvalues1:" + notNullvalues1);

		List<String> notNullvalues2 = stringslist.stream().flatMap(x -> Stream.ofNullable(x))
				.collect(Collectors.toList());

		// System.out.println("notNullvalues2" + notNullvalues2);

		// 2.===============

		// used to generate infine number stream

		// List<Integer> numbers-Stream.iterate(1, n->n+3).collect(Collectors.toList());

		// System.out.println(numbers);//it will give infine numberss

		// 1,4,7,10,13,outOfMemoryissue will come

		List<Integer> numbersLimit = Stream.iterate(1, n -> n + 3).limit(6).collect(Collectors.toList());

		System.out.println(numbersLimit);// [1, 4, 7, 10, 13, 16] as output

		// 3====================

		// first collect something and perform some operation on that collected value

		// here we first collected the avg value and then we rounded it to nearest

		// integer

		Integer[] nums = { 1, 2, 3, 4, 5 };
		Object FindAverageAvgThenRound = Stream.of(nums).collect(
				Collectors.collectingAndThen(Collectors.averagingDouble(x -> x), average -> Math.round(average)));
		System.out.println("FindAverageAvgThenRound" + FindAverageAvgThenRound);
		// 4. ===========================================================
		// when your condition is satisified take the value and drop the value when your

		// condition is satsifiedit peforms the same like filter

		Integer[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13 };

		// we can perfrom same with filete

		System.out.println(Stream.of(nums1).takeWhile(n -> n < 5).collect(Collectors.toList()));// filetr(i->i<5)

		System.out.println(Stream.of(nums1).dropWhile(n -> n < 5).collect(Collectors.toList()));// filetr(1->1>5)

		System.out.println(Stream.of(nums1).dropWhile(n -> n < 4).takeWhile(n -> n < 7).collect(Collectors.toList()));
		System.out.println(Stream.of(nums1).filter(s -> s > 3 && s < 7).collect(Collectors.toList()));

		// Q find department wise min and max salary of employeee related to this teeing

		// only

		// this teeing method allows to perfform two operations in parallel and then

		// combine their result using specific function

		Integer[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13 };

		Map<String, Integer> minMaxMap = Stream.of(nums2)
				.collect(Collectors.teeing(Collectors.maxBy(Comparator.comparingInt(x -> x)), // Collectors.maxBy(Integer::compareTo)
						Collectors.minBy(Comparator.comparingInt(x -> x)), // Collectors.maxBy(Integer::compareTo)
						(el, e2) -> Map.of("max", el.get(), "min", e2.get())));
		System.out.println("MinMaxMap" + minMaxMap);

		// 6=========
		// concat method

		String[] array1 = { "java", "python", "js", "react", "angular" };
		String[] array2 = { "c", "python", "c++", "react", "angular", "nextjs" };

		List<String> list1 = Arrays.asList(array1);

		List<String> list2 = Arrays.asList(array2);

		List<String> combineTwoArrays = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());

		System.out.println("combineTwoArrays" + combineTwoArrays);

		List<String> combineTwoArraysandUniqueElements = Stream.concat(list1.stream(), list2.stream()).distinct()
				.collect(Collectors.toList());
		System.out.println("combineTwoArraysandUniqueElements" + combineTwoArraysandUniqueElements);

		List<String> duplicatesFromBotharrays = list1.stream().filter(s -> list2.contains(s)) // filter(list2::contains)
				.collect(Collectors.toList());

		System.out.println("duplicates FromBotharrays" + duplicatesFromBotharrays);

		Integer[] array11 = { 1, 2, 3, 4, 5, 6, 7, 8 };

		Integer[] array22 = { 6, 7, 8, 9, 10 };

		List<Integer> listll = Arrays.asList(array11);

		List<Integer> list22 = Arrays.asList(array22);

		Integer sum = Stream.concat(listll.stream(), list22.stream()).distinct().mapToInt(i -> i).sum();

		System.out.println("sum is :::" + sum);

		// 7

		// partioningBy male/femal,active/inactive, even/odd

		Integer[] arrayOfNum = { 1, 2, 3, 4, 5, 6, 7, 8 };

		Stream.of(arrayOfNum).collect(Collectors.partitioningBy(x -> (x & 1) == 0)).forEach((key, value) -> {

			if (key) {

				System.out.println("Even numbers" + value);

			} else {

				System.out.println("Odd numbers" + value);

			}
		});

		// if we get output as Map<Boolean, List<Integer>> result then we can use
		// System.out.println("Odd Numbers are" + result.get(Boolean.FALSE));

		// aSystem.out.println("Even Numbers are" + result.get(Boolean.TRUE));

		// 8=================

		// IntStream.range-it excludes last element

		// IntStream.rangeClosed---it includes last element also

		// IntStream.range(1, 10).forEach(System.out::print);

		// IntStream.rangeClosed (1, 10).forEach(System.out::print);

		// 9.allmatch
		// 10.anyMatch it will check all the given elements and return boolean value

		Integer[] arrayOfNumberss = { 1, 2, 3, 4, 5, 6, 7, 8 };

		List<Integer> list = Arrays.asList(arrayOfNumberss);

		Boolean Result = list.stream().allMatch(x -> (x & 1) == 0); // checking all numbers are even or not

		System.out.println("Result " + Result);

		Boolean Resultl = list.stream().anyMatch(x -> (x & 1) != 0); // checking is there any odd numbers are there

		System.out.println("Result1 " + Resultl);

		

	}
}
