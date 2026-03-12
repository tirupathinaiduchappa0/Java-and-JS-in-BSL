package StreamApi.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CStringWithLength {
	public static void main(String[] args) {

		String str1 = "Hello world my name naidu and i love coding";

		String firstLetterCapital = Stream.of(str1.split(" "))
				.map(x -> x.substring(0, 1).toUpperCase().concat(x.substring(1).toLowerCase()))
				.collect(Collectors.joining(" "));

		// System.out.println("firstLetterCapital::::::::: ::::::" +
		// firstLetterCapital);

		String firstLetterCapitalWithPlus = Stream.of(str1.split(" "))
				.map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase())
				.collect(Collectors.joining(" "));

		// System.out.println("firstLetter CapitalWithPlus::::::" +
		// firstLetterCapitalWithPlus);

		String[] strings = { "sumit", "ramu", "somesh", "tirupathi", "naidu", "saikumarbro" };

		List<String> lst = Arrays.asList(strings);

		// Strings with length

		Map<Object, Object> StringsWithlength = Arrays.stream(strings)

				.collect(Collectors.toMap(x -> x, x -> x.length()));

		// System.out.println(StringsWithlength);

		// Find the string with maximum length

		Optional<String> maxLenthStr = Arrays.stream(strings).max((s1, s2) -> s1.compareTo(s2));
		Optional<String> maxLenthStr11 = Arrays.stream(strings).max(Comparator.comparing(String::length));

		// System.out.println("maxLenthStr++++++>" + maxLenthStr.get());

		Optional<String> maxLenthStr1 = Arrays.stream(strings).max((s1, s2) -> s1.length() - s2.length());

		// System.out.println("maxLenthStr1" + maxLenthStr1.get());

		Optional<String> maxLenthStrUsingComp = Arrays.stream(strings).max(Comparator.comparingInt(s -> s.length()));

		// System.out.println(maxLenthStrUsingComp.get());

		Optional<String> maxLenthStrUsingComp1 = Arrays.stream(strings).max(Comparator.comparingInt(String::length));

		// System.out.println(maxLenthStrUsingCompl.get());

		Optional<String> maxLenthStrReduce = Arrays.stream(strings)
				.reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);

		// System.out.println(maxLenthStrReduce.get());

		String Stringswithlength1 = Arrays.stream(strings).collect(Collectors.toMap(x -> x, x -> x.length())).entrySet()
				.stream().collect(Collectors.maxBy(Map.Entry.comparingByValue())).map(x -> x.getKey()).get();

		System.out.println("StringsWithlength:::::::::::::" + Stringswithlength1);

		String sbb = "iamramu";

		String FirstRepeatedcahr = Arrays.stream(sbb.split("")).

				collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream().

				filter(c -> c.getValue() > 1).map(c -> c.getKey()).findFirst().get();

		// System.out.println("FirstRepeatedcahr + FirstRepeatedcahr );

		StringBuffer sbf = new StringBuffer(sbb).reverse();

		// System.out.println(sbf);

		// Reverse each word in the string

		String[] stringss = { "ramu", "somu", "beemu", "seetha" };

		List<String> strs = Arrays.asList(stringss);

		System.out.println(strs.stream().map(x -> new StringBuilder(x).reverse()).collect(Collectors.toList()));

		// if we use word.split("") then dont use mapToObj(c->(char)c) directly use like

		// this way /

		// Stream.of(s.split("")).distinct().collect(Collectors.joining("-")); // if we
		// use sentense.chars() then you can use mapToobj(c->(char)c)

		// from the given String str = "information", replace "form" with XXX;

		String string = "information";

		// System.out.println("Replace form with some other value: " +

		// string.replace(string.substring(2,6), "XXXX"));

		// Replace all i's with z

		// System.out.println("" + string.replaceAll("i", "z"));

		// Replace all first n with m

		// System.out.println("---"+string.replaceFirst("n", "m"));

		// from the given word String str "Independence" replace first two letters with

		// XX and last two letters with YY.

		String stri = "Independence";

		String replaceFirstTwoAndLastLetters = stri.replace(stri.substring(0, 2), "XX")
				.replace(stri.substring(stri.length() - 2), "YY");

		System.out.println("replaceFirstTwoAndLastLetters " + replaceFirstTwoAndLastLetters);

		// Replace all capital letters with x and all small letters with y

		String sti = "India";

		System.out.println(

				"Replace All capital letters with X" + sti.replaceAll("[A-Z]", "X").replaceAll("[a-z]", "Y"));

		String st = "aba";

		System.out.println("st.toCharArray() :::" + Arrays.toString(st.toCharArray()));

		// Palindrome

		String sbd = new StringBuilder(st.toLowerCase()).reverse().toString();

		if (st.equals(sbd))

			System.out.println("is palindrome");

		else

			System.out.println("Not palindrome");

		// 22) For the given String s = "I am good", string needs to be reversed and we

		// Need to preserve teh spaces, expected o/p: is "d oo gmai";

		String s = "I am good";

		String reverse = new StringBuffer(s.replace(" ", "")).reverse().toString();
		char[] rv = reverse.toCharArray();
		char[] output = new char[s.length()];
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				output[i] = rv[index];
				index++;
			}
		}
		System.out.println(new String(output));

	}

}
