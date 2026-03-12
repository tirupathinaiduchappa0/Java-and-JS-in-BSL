package HyrTutorialsAssignMent;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringsAssignMent {
	public static void main(String[] args) {

		// 1.WAP count the number of characters in given string

		String str = "I Love JavaScript";

		// String Removespaces Arrays.toString(str.split(""));

		String joinedString = String.join("", str.split(" "));

		long strlength = Stream.of(joinedString.split("")).count();

		long strlength1 = str.chars().filter(c -> c != ' ').count();

		// System.out.println(striength);

		// 2:MAP count the number of words in given string

		String str1 = "I Love JavaScript";

		Long Noofwords = Stream.of(str1.split(" ")).map(x -> x).count();

		// System.out.println(Noofwords + " Noofwords");

		// 3.Count total number of occurances of a given charcter in give sentence

		String str2 = "Hello Hello world";

		String strings = String.join("", str2.split(" "));

		Long count = Stream.of(strings.split("")).filter(x -> "l".equalsIgnoreCase(x)).count();

//		Long LCharcount1 = Stream.of(strings.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
//				.entrySet().stream().filter(x -> x.getKey().equals('l')).map(x -> x.getValue()).findFirst().get();

		// System.out.println("count" + count + "LCharcount1" + LCharcount1);

		// 4. How to reverse the whole sentence and reverse each word in the sentense

		List<StringBuilder> reversedword = Stream.of(str.split(" ")).map(x -> new StringBuilder(x).reverse())
				.collect(Collectors.toList());

		// System.out.println("reversedword:1" + reversedword);

		String reversedsentense = new StringBuffer().reverse().toString();

		// System.out.println(reversedsentense);

		// 5.Convert even position words in to uppercase and odd position words is to
		// lower case

		String s1 = "ramu is drunken driver";

		List<String> words = Arrays.asList(s1.split(""));

		String PositionisecowerUpper = IntStream.range(0, words.size())
				.mapToObj(i -> i % 2 == 0 ? words.get(i).toLowerCase() : words.get(i).toUpperCase())
				.collect(Collectors.joining(""));

		System.out.println("PositionisecowerUpper" + PositionisecowerUpper);

		// 6. In a given sentence find how many small letters, how many capital letters,

		// how many numbers, how many alphanumarics are there

		String alphanumaricSentence = "ramu is GOOD $%& somu is 231";


		Map<String, Long> charTypes =
		        alphanumaricSentence.chars()
		                .filter(c -> c != ' ')
		                .mapToObj(c -> (char) c)
		                .collect(Collectors.groupingBy(c -> {
		                    if (Character.isLowerCase(c)) return "Lower Case";
		                    else if (Character.isUpperCase(c)) return "Upper Case";
		                    else if (Character.isDigit(c)) return "Digits";
		                    else return "Special Characters";
		                }, Collectors.counting()));

		System.out.println("Character types: " + charTypes);

		// Below one is It is taking spaces if directly apply chars on sentence

		// System.out.println(alphanumaricSentence.chars().mapToobj(i->(char)

		// i).collect(Collectors.toList()));

		// 7.Find First Repeated char and First Non repeated char in given sentense

		String sent = "java is super easy";

		System.out.println("sent.split(\" \")::" + Arrays.toString(sent.split(" ")));

		List<String> abcd = Arrays.asList(sent.split(""));
		String wordIs = String.join("", sent.split(" "));

		System.out.println("wordIs" + wordIs);

		// LinkedHashMap preserves the insertion order. where as tree map will give in
		// alphabetical order.
		Object firstNonRepetedChar = Arrays.stream(wordIs.split(""))
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).map(x -> x.getKey()).findFirst();
		System.out.println("firstlonRepetedChar" + firstNonRepetedChar);

		// 8.print only odd positions words frm senetence

		List<String> oddPositionWords = IntStream.range(0, abcd.size()).filter(i -> (i & 1) != 0).mapToObj(abcd::get)
				.collect(Collectors.toList());

		List<String> oddPositionwards1 = IntStream.range(0, abcd.size()).mapToObj(i -> i % 2 == 0 ? abcd.get(i) : "")
				.collect(Collectors.toList());

		System.out.println("oddPositionWords" + oddPositionWords);

		// 8. Verify given string is palindrome or not

		String inputStr = "Jaj";

		String reversed = new StringBuilder(inputStr.toLowerCase()).reverse().toString();

		// StringBuilder sbd new StringBuilder(inputStr).reverse();

		System.out.println(reversed);

		if (reversed.equals(inputStr))

			System.out.println("it is palidrome");
		else

			System.out.println("It is not palidrome");

		// System.out.println(IntStream.range(200,
		// 500).filter(i->1%2==0).boxed().collect(Collectors.toList())); /
		// System.out.println(IntStream.range(150, 200).filter(1->1%7
		// ==0).boxed().collect(Collectors.toList

	}
}
