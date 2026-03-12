package CodeDecode;

import java.util.Arrays;
import java.util.Collections;

public class ReverseElementsInArray {

	public static void main(String[] args) {

		// java 8 to reverse an array of integers in place,
		// (Dont create new array to store result, use the exisisting array).

		int[] numbers = { 1, 2, 3, 4, 5 };

//				for(int i=0; i<numbers.length-1;i++) {
//					int temp = numbers[i];
//					numbers[i] = numbers[numbers.length-i-1];
//					numbers[numbers.length - i - 1] = temp;
//				}

		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int temp = numbers[left];
			numbers[left] = numbers[right];
			numbers[right] = temp;
			left++;
			right--;
		}

//				IntStream.range(0, numbers.length / 2).forEach(i -> {
//					int temp = numbers[i];
//					numbers[i] = numbers[numbers.length - i - 1];
//					numbers[numbers.length - i - 1] = temp;
//				});

		System.out.println("Reversed array is ====>" + Arrays.toString(numbers));

		Integer[] array = { 1, 2, 3, 4, 5 };

		// if we have array must of type Integer[] then we cane use collections.reverse
		// method

		// collections works with Objects, not with primitive types,

		// if you have array int[] then you can use the above way.

		Collections.reverse(Arrays.asList(array));

		// System.out.println("Integer type array is:" + Arrays.toString(array));

		// it is by creating a new array

		int[] reversedArrsay = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {

			reversedArrsay[i] = numbers[numbers.length - i - 1];

		}
		System.out.println("reversedArrsay--->>>>>>" + Arrays.toString(reversedArrsay));
	}

}
