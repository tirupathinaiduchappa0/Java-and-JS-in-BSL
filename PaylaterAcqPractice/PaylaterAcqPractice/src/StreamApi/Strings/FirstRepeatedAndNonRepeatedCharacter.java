package StreamApi.Strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstRepeatedAndNonRepeatedCharacter {
	public static void main(String[] args) {

		String stri = "Hello welcome";

		String ss = Stream.of(stri.split(" ")).collect(Collectors.joining(""));

		// System.out.println(ss); // output===== Helloworld

		// LinkedHashMap::new it preserves the Insertion Order
		// TreeMap::new will give in Alphabetical order

		// without linkedhashmap{ r = 1 , d = 1 e = 1 , w = 1 , H = 1 , l = 3 o = 2 )
		// RANDOM ORDER OF CHARACTERS
		Map<Object, Long> withouhashmap = ss.chars().mapToObj(c -> (char) c)

				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		System.out.println(withouhashmap);

		// with linkedhasmap( H = 1 , e = 1 , l = 3 o = 2 w = 1 , r = 1 d = 1 \
		// ----INSERTION ORDER FOLLWED
		Map<Object, Long> withhashmap = ss.chars().mapToObj(c -> (char) c)

				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));
		System.out.println(withhashmap);

		Optional<Object> firstNonRepeated = withhashmap.entrySet().stream()

				.filter(c -> c.getValue() == 1).map(c -> c.getKey()).findFirst();

		System.out.println("firstNonRepeated:::::" + firstNonRepeated.get());

		Optional<Object> firstRepeated = withhashmap.entrySet().stream()

				.filter(c -> c.getValue() > 1).map(c -> c.getKey()).findFirst();

		System.out.println("firstRepeated:::::" + firstRepeated.get());

		String str = "gain java knowledge";

		Optional<Character> firstRepeatedChar = String.join("", str.split(" ")).chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(c -> c.getValue() > 1).map(c -> c.getKey()).findFirst(); // System.out.println("firstRepeatedChar
																					// ++++++" firstRepeatedChar.get());

		Optional<Character> charactre = Stream.of(str.split("")).collect(Collectors.joining("")).chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(c -> c.getValue() == 1).map(c -> c.getKey()).findFirst();

		System.out.println("firstNonRepeated:::::" + charactre.get());

		// without converting the word in to chars dirctly using empty split("")

		Optional<String> charactr = Arrays.stream(str.replace(" ", "").split(""))
				.collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream().

				filter(c -> c.getValue() == 1).map(c -> c.getKey()).findFirst();

		System.out.println("firstNonRepeatedwithsplitOnly:::" + charactr.get());

		// Brute Force / Core Logic
		char FirstRepeated = 0;
		char FirstNonRepated = 0;
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count == 1) {
				FirstNonRepated = str.charAt(i);
				break;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count > 1) {
				FirstRepeated = str.charAt(i);
				break;
			}
		}
		System.out.println("FirstRepeated::: " + FirstRepeated + " " + "FirstNonRepated:: " + FirstNonRepated);

		Map<Character, Long> map = new LinkedHashMap<>();
		for (char c : str.replace(" ", "").toLowerCase().toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1L);
			}
		}
		for (Map.Entry<Character, Long> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("First Repeated: " + entry.getKey());
				break;
			}
		}
		for (Map.Entry<Character, Long> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("First Non Repeated: " + entry.getKey());
				break;
			}
		}

	}

}
