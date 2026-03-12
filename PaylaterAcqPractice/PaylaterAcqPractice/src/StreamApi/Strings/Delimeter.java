package StreamApi.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Delimeter {

	public static void main(String[] args) {

		// String.join(delimeter, list) introduced in java8 vvvvIMP***

		String str = "Hi How are you";

		// Expected out put Hi-How-are-you

		String[] strarray = str.split(" ");

		String result = String.join("-", strarray);

		// System.out.println(result);

		String output = Arrays.stream(strarray).collect(Collectors.joining("-"));

		// System.out.println(output);

		String[] numbser = { "1", "2", "3", "4", "5" };
		List<String> list = Arrays.asList(numbser);

		System.out.println(String.join("<", list));

		System.out.println(String.join("->", "wakeUp", "breakfast", "Lunch", "snaks", "dinner"));

		System.out.println(list.stream().collect(Collectors.joining("<")));
		StringJoiner sj = new StringJoiner("-", "[", "]");
		for (String str1 : strarray) {
			sj.add(str1);
		}
		System.out.println(sj);

		// Reverese each word in the sentense o/p: [iH, woH, era, uoy]

		List<StringBuilder> reverseOfEachWord = Arrays.stream(strarray).map(x -> new StringBuilder(x).reverse())

				.collect(Collectors.toList());

		System.out.println(reverseOfEachWord);

	}

}
