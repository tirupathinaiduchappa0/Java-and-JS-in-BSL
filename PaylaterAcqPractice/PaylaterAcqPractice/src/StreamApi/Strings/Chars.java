package StreamApi.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chars {

	public static void main(String[] args) {

		String sbb = "iamramu";

		// System.out.println("split chars is" + Arrays.toString(sbb.split("")));

		String s = "i am naidu";

		String[] array = s.split(" ");

		// System.out.println("Array.ToString is" + Arrays.toString(array));

		String charsJoiningword = Stream.of(array).collect(Collectors.joining(""));

		// System.out.println(charsJoiningword);

		String simpleword = String.join("", array);

		// System.out.println(simpleword);

		// charsJoiningword===simpleword

		List<String> individualchars = Arrays.stream(simpleword.split("")).collect(Collectors.toList());

		// System.out.println(individualchars);

		List<Character> individualchars1 = simpleword.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		// System.out.println(individualchars1);

		// from string s find each vowel is repated howmany times

		String vowels = "aeiou";

		String mySentense = "Mera Baarath Mahaan".toLowerCase();

		Map<Character, Long> map = new HashMap<>();
		for (char c : mySentense.replace(" ", "").toCharArray()) {
			if ("aeiou".indexOf(c) >= 0) {
				if (map.containsKey(c)) {
					Long cnt = map.get(c);
					cnt += 1;
					map.put(c, cnt);
				} else {
					map.put(c, 1L);
				}
			}
		}
		System.out.println("vowels count in mysentesne" + map);

		Map<Object, Long> duplicateVoweils = Stream.of(String.join("", mySentense.split(" ")).split(""))
				.filter(c -> vowels.indexOf(c) >= 0)
				.collect(Collectors.groupingBy(x -> x.toLowerCase(), Collectors.counting()));

		// System.out.println("duplicateVoweils with string::: " + duplicateVoweils);

		List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u');

		Map<Object, Long> duplicateVoweilswithList = mySentense.replace(" ", "").toLowerCase().chars()
				.mapToObj(c -> (char) c).filter(c -> vowelsList.contains(c))
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// System.out.println("duplicateVoweilswithList" + duplicateVoweilswithList);

		Map<Object, Long> duplicateVoweilsUsingChars = String.join("", mySentense.split(" ")).chars()
				.mapToObj(c -> (char) c).filter(c -> vowels.indexOf(c) >= 0)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// System.out.println("duplicateVoweilsUsingChars" +
		// duplicateVoweilsUsingChars);

		// find vowel duplicates

		List<String> duplicateVoweils2 = Arrays.stream(simpleword.split("")).filter(c -> vowels.indexOf(c) >= 0)
				.collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()

				.filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());

		System.out.println(" duplicateVoweils2::" + duplicateVoweils2);

		Map<Object, Object> duplicateVoweils3 = mySentense.replace(" ", "").toLowerCase().chars()
				.mapToObj(c -> (char) c).filter(x -> vowelsList.contains(x))
				.collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

		System.out.println(" duplicateVoweils3::" + duplicateVoweils3);

		Set<String> withoutdups = new HashSet<>();

		List<String> dups = Arrays.stream(simpleword.split("")).filter(x -> !withoutdups.add(x))

				.collect(Collectors.toList());

		System.out.println("duplicates are:" + dups);

		System.out.println("Non-duplicates are:" + withoutdups);

	}

}
