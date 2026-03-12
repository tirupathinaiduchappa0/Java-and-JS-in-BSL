package BasicQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MissingNumsinArray {

	public static void main(String[] args) {

		// 1) From the list sort the elements and find all the missing elements from
		// list
		// 1/p: (3,1,7,4,9,15,8)
		List<Integer> l = Arrays.asList(3, 7, 4, 9, 15, 8);

		Set<Integer> set = new HashSet<>(l);

		List<Integer> missingNum = new ArrayList<>();

		Optional<Integer> minNum = l.stream().min(Comparator.comparing(x -> x));

		Optional<Integer> maxNum = l.stream().max((a, b) -> a - b);

		int min = Collections.min(l);
		int max = Collections.max(l);

		for (int i = minNum.get(); i <= maxNum.get(); i++) {
			if (!l.contains(i)) { // if (!set.contains(i)) {
				missingNum.add(i);
			}
		}
		System.out.println("missinglium are::::" + missingNum);

		// Given a list of integers, write a Java program to find and print all the
		// missing numbers between
		// consecutive elements after sorting the list.
		// List.of(...) is Immutable so better use like below
		List<Integer> l1 = new ArrayList<>(List.of(3, 7, 4, 9, 15, 8));
		Collections.sort(l1);
		List<Integer> misNum = new ArrayList<>();
		for (int i = 0; i < l1.size() - 1; i++) {
			var currentEle = l1.get(i);
			var next = l1.get(i + 1);
			for (int j = currentEle + 1; j < next; j++) {
				misNum.add(j);
			}
		}
		System.out.println("mis Num is:::" + misNum);

		
	}

}
