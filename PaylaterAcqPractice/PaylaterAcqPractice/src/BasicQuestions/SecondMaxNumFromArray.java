package BasicQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondMaxNumFromArray {
	
	//Reverse of string
	public static String reverseFor(String str) {
	    String result = "";
	    for (int i = 0; i < str.length(); i++) {
	        result = str.charAt(i) + result;  // prepend
	    }
	    return result;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(List.of(5, 2, 6, 1, 5, 12, 12, 8, 5, 8, 8, 3));

		int MaxNum = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		for (int num : list) {
			if (num > MaxNum) {
				secMax = MaxNum;
				MaxNum = num;
			} else if (num < MaxNum && num > secMax) {
				secMax = num;
			}
		}

		System.out.println("second max without sorting::::: " + secMax);

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				if (list.get(j) > list.get(j + 1)) {
					int temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set((j + 1), temp);
				}
			}
		}
		System.out.println("sorted List is" + list);

		int secondMaxEle = list.get(list.size() - 1);
		for (int i = list.size() - 2; i >= 0; i--) {
			if (secondMaxEle != list.get(i)) {
				secondMaxEle = list.get(i);
				break;
			}
		}
		System.out.println("second Max ele is::::" + secondMaxEle);

		Optional<Integer> secondMax = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();

		System.out.println(secondMax.orElse(null));

		// 18) Sort the numbers by using normal for loops (dont use inbuilt methods).
	
		Integer[] array = { 5, 2, 6, 1, 5, 12, 12, 8, 5, 8, 8, 3 };

		for (int i = 0; i < array.length; i++) {		
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("sorting of nums without using for loop" + Arrays.toString(array));

		Integer secondMaxEle1 = array[array.length - 1];

		for (int i = array.length - 2; i >= 0; i--) {
			if (secondMaxEle1 != array[i]) {
				secondMaxEle1 = array[i];
				break;
			}
		}

		System.err.println("secondMax::::" + secondMaxEle1);
		
		
		

	}

}
