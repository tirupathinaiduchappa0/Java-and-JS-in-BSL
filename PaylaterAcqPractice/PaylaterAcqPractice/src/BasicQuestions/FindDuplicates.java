package BasicQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicates {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>(List.of(1, 2, 3, 4, 1, 3));
		Set<Integer> duplicates1 = new HashSet<>();
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				if (i != j && l.get(i) == l.get(j)) {
					duplicates1.add(l.get(j));
				}
			}
		}
		System.out.println("duplicates::" + duplicates1);

		// Duplicates Using normal for loops

		Integer[] arr = { 1, 2, 3, 4, 4, 3 };

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == arr[j] && !list.contains(arr[j])) {
					list.add(arr[i]);
				}

			}

		}
		System.out.println("duplicate nums" + list);

		// interview preferred solution
		Set<Integer> seen = new HashSet<>();
		Set<Integer> dups = new HashSet<>();
		for (int i : arr) {
			if (!seen.add(i)) {
				dups.add(i);
			}
		}
		System.out.println("dups are::" + dups);
		/*
		 * Filter mthd return boolean value always (predicate-test-inp:any,o/p:boolean),
		 * if it adds to set it will return True, if it not adds it will return false
		 * Anyway duplicate elements will not add to set, it will return false, to make
		 * false as true we are using! here so finally true elements will store in only
		 * dup if dint use this, in both withoutdup and only dup are filled with
		 * withoutdup only [1, 18, 2, 3, 19, 20, 10, 30]
		 */

		Set<Integer> withoutdup = new HashSet<Integer>();

		Object onlyDup = list.stream().filter(i -> !withoutdup.add((Integer) i)).collect(Collectors.toSet());

		System.out.println("duploicates are..." + onlyDup);

		System.out.println(" without duploicates are..." + withoutdup);

		List<Integer> lis = List.of(1, 2, 3, 4, 4, 3);

		List<Integer> dupli = lis.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).toList();
		System.out.println("dups::::" + dupli);

		/*
		 * This frequency mthd will chcek all the integers in the list,the frequency of
		 * the element i in the list is graterthan 1 then it will return all the those
		 * elemets if integer is repated means greater than 1 then it will return those
		 * integers frequency mthd takes n square complexity where as set mthd takes
		 * O(n)
		 */
		Integer[] arrofNumb = { 1, 3, 10, 20, 30, 18, 1, 19, 19, 3, 2, 2, 10, 3, 3, 3, 3 };

		List list1 = Arrays.asList(arrofNumb);

		// if we use list here it will give duplicates with repetation also, o/p: [1, 3,
		// 10, 1, 3, 2, 2, 18, 3]duplicates

		// so use Set o/p: [1, 2, 3, 19, 10]duplicates

		Object duplicates = list1.stream().filter(i -> Collections.frequency(list1, i) > 1).collect(Collectors.toSet());

		// Find the Duplicate names froms below given string

		String s = "ramu somu beemu ramu saomu beemu seetha geetha";

		String[] arrr = s.split(" ");

		List<String> output = Arrays.stream(arrr).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());

		System.out.println(output);
	}

}
