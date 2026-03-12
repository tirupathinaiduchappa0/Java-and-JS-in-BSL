package BasicQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionByProgramms {

	public static void main(String[] args) {

		Integer[] array = { 1, 4, 5, 20, 30 };

		// using Bit wise operators binary x binary 0000 then it is even
		// binary x binary 0001 then it is odd

		List<Integer> evenNumbers = Stream.of(array).filter(i -> (i & 1) == 0).collect(Collectors.toList());

		List<Integer> oddNumbers = Stream.of(array).filter(i -> (i & 1) != 0).collect(Collectors.toList());
		System.out.println("evenNumbers" + evenNumbers);

		System.out.println("oddNumbers" + oddNumbers);

		Map<Boolean, List<Integer>> seperateEvenAndOdd = Stream.of(array)
				.collect(Collectors.partitioningBy(x -> (x & 1) == 0));

		System.out.println(seperateEvenAndOdd);// {false=[1, 5], true=[4, 20, 30])

		Stream.of(array).collect(Collectors.partitioningBy(x -> (x & 1) == 0)).forEach((k, v) -> {
			if (k) {

				System.out.println("even numbers are" + v);

			} else {

				System.out.println("odd numbers are" + v);

			}
		});

		// First Find the seperate odd and even numbers from the list and then

		// sort odd numbers in assending order and even number in descending order

		Integer[] newarray = { 12, 3, 19, 0, 99, 1, 4, 5, 20, 30, 17, 17, 7 };

		Stream.of(newarray).distinct().collect(Collectors.partitioningBy(x -> (x & 1) == 0)).forEach((key, value) -> {

			if (key) {
				System.out.println("even num " + value.stream().sorted((a, b) -> b - a).toList());
				// value.sort(Collections.reverseOrder());
				// System.out.println("Even : " + value);
			} else {
				System.out
						.println("odd numbers in sorting order are" + value.stream().sorted((a, b) -> a - b).toList());
				// Collections.sort(value);
				// System.out.println("Odd : " + value);

			}
		});

	}
}
