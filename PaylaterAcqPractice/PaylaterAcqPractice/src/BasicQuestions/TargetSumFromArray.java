package BasicQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TargetSumFromArray {

	public static void main(String[] args) {

		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 9, 8);

		Map<Integer, Integer> map = new HashMap<>();

		int targetNum = 8;
		for (int i : list) {
			int complementNum = targetNum - i;
			if (complementNum > i) { // seen.contains(complementNum)
				map.put(complementNum, i);
			}
		}
		System.out.println("Map:::: " + map);

		Set<Integer> seen = new HashSet<>();
		Map<Integer, Integer> map1 = new HashMap<>();

		int targetNum1 = 8;
		for (int i : list) {
			int complementNum = targetNum1 - i;
			if (seen.contains(complementNum)) { // seen.contains(complementNum)
				map1.put(complementNum, i);
			}
			seen.add(i);
		}
		System.out.println("Map with set is:::: " + map);

		// Now return the indexs insted of values

		List<int[]> listB = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if ((list.get(i) + list.get(j)) == targetNum) {
					// System.out.println(list.get(i) + " " + list.get(j));
					listB.add(new int[] { i, j });
				}
			}
		}
		;
		for (int[] pair : listB) {
			System.out.println(Arrays.toString(pair));
		}

		Map<Integer, Integer> map3 = new HashMap<>();
		List<int[]> listA = new ArrayList<>();
		int target = 8;

		for (int i = 0; i < list.size(); i++) {
			int current = list.get(i);
			int complement = target - current;

			if (map3.containsKey(complement)) {
				listA.add(new int[] { map3.get(complement), i });
			}
			map3.put(current, i);
		}

		for (int[] pair : listA) {
			System.out.println(Arrays.toString(pair));
		}

	}

}
