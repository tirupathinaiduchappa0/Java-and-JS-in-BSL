package HiddenFeatursOfStreamAPi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Next5HiddenMethods {
	public static void main(String[] args) {

		// 1.Collections.nCopies the lift generated here is INMutable

		List<String> repeatedStrig = Collections.nCopies(7, "Tirupath");

		System.out.println("repeatedStrig" + repeatedStrig);

		// 2.Collections.frequencyToFind Duplicates nad unique elements

		Integer[] arrayOfNum = { 1, 1, 2, 4, 7, 2, 3, 4, 5, 6, 7, 8 };

		Set<Integer> Duplicates = Stream.of(arrayOfNum)
				.filter(i -> Collections.frequency(Arrays.asList(arrayOfNum), i) > 1).collect(Collectors.toSet());

		System.out.println("Duplicates" + Duplicates);

		Set<Integer> unoqueElemets = Stream.of(arrayOfNum)
				.filter(i -> Collections.frequency(Arrays.asList(arrayOfNum), 1) == 1).collect(Collectors.toSet());

		System.out.println("unoqueElemets" + unoqueElemets);

		Set<Integer> unique = new HashSet<>();

		List<Integer> dups = Stream.of(arrayOfNum).filter(i -> !unique.add(i)).collect(Collectors.toList());

		System.out.println("dups" + dups);

		System.out.println("unique" + unique);

		// How many times 6 occured in the above array

		System.out.println("2 is present in" + Collections.frequency(Arrays.asList(arrayOfNum), 2) + " times");

		Long cHowmNayTimes = Stream.of(arrayOfNum).filter(x -> x == 6).count();

		Long cHowmNayTimes1 = Stream.of(arrayOfNum).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getKey() == 6).map(x->x.getValue()).findFirst().get();
		System.out.println("cHowmNayTimes" + cHowmNayTimes1);

		// -->

		// 3.Collections.disjoint(listi, list2) if is there any common

		// elements between two lists then it will return false

		// commom elements vuntay--false
		// commom elements lekapotay --true
		String[] array1 = { "java", "python", "js", "react", "angular" };

		String[] array2 = { "c", "python", "c++", "react", "angular", "nextjs" };

		List<String> list1 = Arrays.asList(array1);

		List<String> list2 = Arrays.asList(array2);

		Boolean arebisjoint = Collections.disjoint(list1, list2);

		System.out.println(arebisjoint);// false

		if (arebisjoint)

			System.out.println("No common elemts");

		else

			System.out.println("there are commeon elements");

		// 4.Collections.rotate

		Integer[] arrayOfNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

		List<Integer> list = Arrays.asList(arrayOfNumbers);

		// Collections.rotate(list, 3); //if it is tye number, then those many numbers
		// from right side will move to left side

		System.out.println(list);

		// Collections.rotate(list, 3); //if it is]-ve number, then those many numbers
		// from left side will move to right side

		System.out.println(list);

		// Collections.rotate(list, list.size());

		System.out.println(list);

		Collections.rotate(list, -list.size());

		System.out.println(list);

		Collections.rotate(list, 10);

		System.out.println(list);

		Collections.rotate(list, 10);

		System.out.println(list);

	}
}
