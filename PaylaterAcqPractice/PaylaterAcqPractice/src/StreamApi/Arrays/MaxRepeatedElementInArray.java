package StreamApi.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxRepeatedElementInArray {

	public static void main(String[] args) {
		// Find the Max Repeated Number in an array ***VVVIMP
		Integer[] array = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 9 };

		List<Integer> list = List.of(array);
		int maxCount =0;
		int maxEle = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			int count=0;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(i) == list.get(j)) {
					count++;
				}
			}
			if(count > maxCount) {
				maxCount =count;
				maxEle = list.get(i);
			}
		}
		System.out.println("maxrepeatedNumCount using loops ::::" + maxCount);
		System.out.println("maxrepeatedNum using loops ::::" + maxEle);
		
		Map<Integer,Long> map = new HashMap<>();
		for(int i :list) {
			if(map.containsKey(i)) {
				Long cnt = map.get(i);
				cnt += 1;
				map.put(i, cnt);
			} else {
				map.put(i, 1L);
			}
		}
		Long maxCount1 =0L;
		int maxEle1 = list.get(0);
		for( Entry<Integer, Long> entry : map.entrySet()) {
			if(entry.getValue() > maxCount1) {
				maxCount1 = entry.getValue();
				maxEle1 = entry.getKey();
			}
		}
		
		System.out.println("maxrepeatedNumCount using loops ::::" + maxCount1);
		System.out.println("maxrepeatedNum using loops ::::" + maxEle1);
		

		Optional<Object> maxrepeatedNum = Stream.of(array).collect(Collectors.groupingBy(x -> x, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).map(x -> x.getKey());

		// System.out.println(maxrepeatedNum.get());

		Optional<Object> maxrepeatedNum1 = Stream.of(array)

				.collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream()
				.max(Comparator.comparingLong(x -> x.getValue())).map(x -> x.getKey());

		System.out.println(">>>" + maxrepeatedNum1.get());

		Optional<Integer> moreOccuredNumber = Stream.of(array).reduce((a,
				b) -> Collections.frequency(Arrays.asList(array), a) > Collections.frequency(Arrays.asList(array), b)
						? a
						: b);

		long val = Stream.of(array).filter(x -> "9".equals(x.toString())).count();
		System.out.println("val is;;;;" + val);

		long val1 = Stream.of(array).filter(x -> x.toString().equals("9")).count();
		System.out.println("vali is;;;;" + val1);

		// System.out.println(moreOccuredNumber.get());

		// How many times 6 occured in the above array

		// System.out.println("6 is present in "+

		// Collections.frequency(Arrays.asList(array), 6));

		// System.out.println(Stream.of(array).filter(x->x.toString().equals("6")).mapToInt(x->x).count());

		// ========================================================================
		String s = " I am good boy and she is a good girl";

		System.out.println("+++++0:::"

				+ Stream.of(String.join("", s.split(" ")).split("")).filter(x -> "o".equalsIgnoreCase(x)).count());

	}

}
