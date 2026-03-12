package StreamApi.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Duplicates {

	public static void main(String[] args) {
		
		String nameNaidu = "naiduChappaTirupathiNaidu";
		//split with captal letters and add spaces and convert all to Lower cases Infor company asked this & code is in java files

		StringBuilder sb = new StringBuilder();
		for (char c : nameNaidu.toCharArray()) {
		  if (c >= 'A' && c <= 'Z') {
			  sb.append(" ").append(Character.toLowerCase(c));
		  } else {
			  sb.append(c);
		  }
		}
		System.out.println("sb is:: " + sb);

		// Find duplicates from the array
		// This frequency mthd will chcek all the integers in the list,
		// the frequency of the element i in the list is graterthan 1 then it will
		// return all the those elemets
		// if integer is repated means greater than 1 then it will return those integers

		Integer[] arrofNumb = { 1, 3, 10, 20, 30, 18, 1, 19, 19, 3, 2, 2, 10, 3 };

		List<Integer> list = Arrays.asList(arrofNumb);

		// if we use list here it will give duplicates with repetation also, o/p: [1, 3,

		// 10, 1, 3, 2, 2, 10, 3]

		// so use Set -o/p: [1, 2, 3, 19, 10] duplicates

		Object duplicates = list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet());

		System.out.println(duplicates + "duplicates");

		// Filter mthd return boolean value always(Predicate-test), if it adds to set it will return
		// True, if it not adds it will return false
		// Anyway duplicate elements will not add to set, it will return false, to make
		// false as true we are using ! here
		// so finally true elements will store in only dup

		Set<Integer> withoutdup = new HashSet<Integer>();

		Object onlyDup = list.stream().filter(i -> !withoutdup.add((Integer) i)).collect(Collectors.toSet());

		System.out.println("duploicates are...." + onlyDup);

		System.out.println(" without duploicates are." + withoutdup);

		// How many times each word is repeated and duplicate strings from this list

		String s = "ramu somu beemu ramu saomu beemu seetha geetha";

		String[] arr = s.split(" ");

		List<String> output = Arrays.stream(arr).collect(Collectors.groupingBy(x -> x, Collectors.counting()))

				.entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).toList();

		// System.out.println(output);

		Object duplicateStrings = Arrays.stream(arr).filter(i -> Collections.frequency(Arrays.asList(arr), i) > 1)
				.collect(Collectors.toSet());

		System.out.println("duplicateStrings" + duplicateStrings);
		// Find the count of vowels in the string
		String str = "i love my country";

		// *** INSTED OF USING ""TNPUT. CHARS().MAPTOOBJ (X->(CHAR)X)"" THIS USE
		// Arrays.stream(input.split("")) here input is one single word if you want more
		// refer chars.java class
		// System.out.println(vowelsCount);
		// How many times each vowel is repeated

		String vowels = "aeiou";

		Map<Object, Long> eachVowelWithCount = str.chars().mapToObj(c -> (char) c).filter(c -> vowels.indexOf(c) >= 0)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// System.out.println(eachVowelWithCount);

		String st = "I love my country which is India";

		String wordsMerged = String.join("", st.split(""));

		// System.out.println("wordsMerged :: + wordsMerged);

		String[] Vow = { "a", "e", "i", "o", "u" };

		List<String> li = Arrays.asList(Vow);

		// List<String> vowlist = Stream.of(Vow).collect(Collectors.toList());

		Map<String, Long> eachVowelCount =

				Stream.of(wordsMerged.split("")).filter(x -> li.contains(x.toLowerCase()))
						.collect(Collectors.groupingBy(x -> x.toLowerCase(), Collectors.counting()));

		System.out.println("VowelsCount is ++++" + eachVowelCount);

		// Count of all vowels in given string

		Long allVowelsCount = Stream.of(wordsMerged.split("")).filter(x -> li.contains(x.toLowerCase())).count();
		System.out.println("allVowelsCount::::" + allVowelsCount);


		Map<Object, Long> eachWordlWithCount = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// System.out.println(eachWordlWithCount);
		// Here in the eachWordlWithCount space is also counting so remove that space
		// and then count all letters
		// first remove space by usyng delimeter

		String wordsWithoutSpace = Arrays.stream(str.split(" ")).collect(Collectors.joining(""));

		Map<Object, Long> eachwordlWithCountWithoutSpaceCount = wordsWithoutSpace.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// System.out.println(eachWordlWithCountWithout SpaceCount);

		List<Character> eachWordlWithCountWithoutSpaceCountOnlyDuplicates = wordsWithoutSpace.chars()
				.mapToObj(c -> (char) c).collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		// System.out.println(eachWordlWithCountWithout SpaceCountOnlyDuplicates);
		
		
	}

}
