package BasicQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeperateIntegersAndStrings {

	public static void main(String[] args) {
		/*
		 * You are given a List<Object> in Java that contains a mix of Integer and
		 * String elements, for example:Write a Java program to separate the integers
		 * and strings into two different lists using Java Streams. After separation,
		 * the program should print the lists of integers and strings separately.
		 */
		List<Object> mixedList = List.of(1, "hello", 42, "world");

		List<Integer> intList = new ArrayList<>();
		List<String> strList = new ArrayList<>();

		for (Object obj : mixedList) {
			if (obj instanceof Integer) {
				intList.add((Integer) obj);
			} else if (obj instanceof String) {
				strList.add((String) obj);
			}
		}
		System.out.println("intList" + intList);
		System.out.println("strList" + strList);

		List<Integer> listOfIntegersResult = mixedList.stream().filter(obj -> obj instanceof Integer)
				.map(o -> (Integer) o).toList();
		List<String> listOfStringsResult = mixedList.stream().filter(obj -> obj instanceof String).map(o -> (String) o)
				.toList();
		System.out.println("listOfIntegersResult:::" + listOfIntegersResult);
		System.out.println("listOfStringsResult:::" + listOfStringsResult);

		/*
		 * You are given a List<String> in Java that contains a mix of numeric strings
		 * and non-numeric strings, for example:List<String> listOfStr = List.of("1",
		 * "2", "ramu", "3", "seetha"); Write a Java program to collect only the numeric
		 * values from the list into a List<Integer> using Java Streams. Strings that
		 * cannot be converted to integers should be ignored. Expected Output:[1, 2,
		 * 3,4]
		 */

		List<String> listOfStr = List.of("1", "2", "ramu", "3", "seetha", "4");
		List<Integer> listofInt = listOfStr.stream().filter(i -> {
			try {
				Integer.parseInt(i);
				return true;
			} catch (Exception e) {
				return false;
			}
		}).map(Integer::valueOf).toList();
		System.out.println("listofInt:::" + listofInt);
		
		List<String> integers = listOfStr.stream()
                .filter(s -> s.matches("\\d+")) //.filter(s -> s.matches("-?\\d+"))
                .toList();
		
		System.out.println("integers:::=====>" + integers);

		Map<Boolean, List<String>> partitioned = listOfStr.stream()
		    .collect(Collectors.partitioningBy(s -> s.matches("\\d+")));

		List<String> integers1 = partitioned.get(true);    // ["1", "2", "3", "4"]
		List<String> nonIntegers = partitioned.get(false); // ["ramu", "seetha"]
	}

}
