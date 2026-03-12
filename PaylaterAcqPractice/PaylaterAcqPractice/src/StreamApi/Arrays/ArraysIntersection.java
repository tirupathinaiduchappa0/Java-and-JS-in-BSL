package StreamApi.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysIntersection {
	public static void main(String[] args) {

		String[] array1 = { "java", "python", "js", "react", "angular" };

		String[] array2 = { "c", "python", "c++", "react", "angular", "nextjs" };

		// Integer[] array1 = {1,2,3,4,5};

		// Integer[] array2 = {5,9,4};

		// Set<Integer> newArray = new HashSet<>();

		// here we are using two for loops then we will get Big On square complexity

		Set<String> newArray = new HashSet<>();

		for (int i = 0; i < array1.length; i++) {

			for (int j = 0; j < array2.length; j++) {

				if (array1[i] == array2[j] && !newArray.contains(array2[j])) {

					newArray.add(array1[i]);

				}
			}
		}

		System.out.println(newArray);

		List<String> list1 = Arrays.asList(array1);

		List<String> list2 = Arrays.asList(array2);

		// .filter(s2::contains)~== .filter(e->s2.contains(e))

		// .map(Integer::valueOf)~== .map(e->Integer.valueOf(e))

		// List<String> output
		// =s1.stream().filter(s2::contains).collect(Collectors.toList());

		List<String> duplicates = list1.stream().filter(e -> list2.contains(e)).collect(Collectors.toList());

		System.out.println("duplicates:" + duplicates);

		List<String> duplicatesUsingAnyMatch =
			    list1.stream()
			         .filter(arr1Num ->
			             Arrays.stream(array2)
			                   .anyMatch(arr2Num -> arr2Num == arr1Num))
			         .collect(Collectors.toList());


		// System.out.println("duplicatesusingAnyMatch:" + duplicatesusingAnyMatch);

		List<String> combineTwoArraysandUniqueElements = Stream.concat(list1.stream(), list2.stream()).distinct()
				.collect(Collectors.toList());

		System.out.println("combineTwoArraysandUniqueElements" + combineTwoArraysandUniqueElements);

	}

}
