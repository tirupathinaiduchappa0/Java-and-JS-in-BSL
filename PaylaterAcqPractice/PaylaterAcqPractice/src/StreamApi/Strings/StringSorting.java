package StreamApi.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSorting {
	public static void main(String[] args) {

		String[] names = { "Vivek", "naresh", "Sumit", "gaurav", "Mohit", "ram", "oy" };

		List<String> namesList = Arrays.asList(names);

		namesList.sort(Comparator.comparingInt(s -> s.length())); // (String::length) ~== s->s.length()

		// System.out.println("String sorting based on length assending order" +
		// namesList);

		namesList.sort(Comparator.comparingInt(String::length).reversed());

		// System.out.println("String sorting based on length descending order" +
		// namesList);

		namesList.sort(Comparator.naturalOrder());

		// System.out.println(namesList);// natrual order it is case sensitive

		namesList.sort(String.CASE_INSENSITIVE_ORDER);

		// System.out.println(namesList);

		namesList.sort(Comparator.reverseOrder());

		// System.out.println(namesList);

		// 1) form this array ("P", "A", "XYZ", "AA", "BB", "c", "DDD", "DDDDD"), Based
		// on string length i want assending order and //if string length is equal then
		// i
		// want alphabet order in java 8

		String[] arr = { "P", "A", "XYZ", "AA", "BB", "C", "DDD", "DDDDD", "m", "boys" };

		List<String> StringSLengthAndAlphabetAssendingOrder = Stream.of(arr)
				.sorted(Comparator.comparingInt(String::length).thenComparing(x -> x.toLowerCase()))
				.collect(Collectors.toList());

		System.out.println("StringSLengthAndAlphabetAssendingOrder" + StringSLengthAndAlphabetAssendingOrder);

		// convert given list of strings in to array of strings.

		String[] convertListInToStringArray = StringSLengthAndAlphabetAssendingOrder.stream().toArray(String[]::new);
		System.out.println("convertListInToStringArray:" + Arrays.toString(convertListInToStringArray));


		// TreeMap will give in alphabetical order where as LinkedHashMap preserves the
		// insertion order.

		
	}

}
