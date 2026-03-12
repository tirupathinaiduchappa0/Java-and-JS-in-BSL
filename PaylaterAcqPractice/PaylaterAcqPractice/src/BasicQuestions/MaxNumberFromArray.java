package BasicQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxNumberFromArray {
	public static void main(String[] args) {

		List<String> list = List.of("seetha", "geetha", "geetha");
		Map<String, Long> map = new HashMap<>();

		for (String i : list) {
			if (map.containsKey(i)) {
				Long cnt = map.get(i);
				map.put(i, cnt + 1);
			} else {
				map.put(i, 1L);
			}
		}
        //other logic
		for (String s : list) {
			Long count = map.get(s);
			if (count == null) {
				map.put(s, 1L);
			} else {
				map.put(s, count + 1);
			}
		}

		System.out.println("howmaytimeseach str" + map);

		Integer[] array = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9 };

		// comparator internally uses the quick sort so time complexity is O(nlogn)
		// Find Min and max number in the array
		// if you want second max skip
		Optional<Integer> sortedElements = Stream.of(array).sorted(Comparator.reverseOrder()).findFirst();
		System.out.println(sortedElements);

		List<Integer> sortingOrder = Stream.of(array).sorted((a, b) -> b.compareTo(a)).toList();
		System.out.println(sortingOrder);

		Optional<Integer> maxval = Stream.of(array).max(Comparator.comparing(Integer::valueOf));
		Optional<Integer> maxval2 = Stream.of(array).max(Comparator.comparing(x -> x));
		Optional<Integer> maxval1 = Stream.of(array).max((a, b) -> a - b);
		System.out.println(maxval);
		System.out.println(maxval1);

		Optional<Integer> maxnum = Stream.of(array).reduce((a, b) -> a > b ? a : b);

		Optional<Integer> ReduceftthdReflex = Stream.of(array).reduce(Integer::max);

		Optional<Integer> maxnumber = Stream.of(array).max((a, b) -> a - b);

		Optional<Integer> maxnumber1 = Stream.of(array).max((a, b) -> a.compareTo(b));

		Optional<Integer> maxnumber2 = Stream.of(array).max(Integer::compareTo);

		IntSummaryStatistics summarystat = Stream.of(array).collect(Collectors.summarizingInt(x -> x));
		System.out.println("summarystat" + summarystat);

		OptionalInt maxNub = Stream.of(array).mapToInt(i -> i).max();

	}
}
