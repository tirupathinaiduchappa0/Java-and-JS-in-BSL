package BasicQuestions;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sumOfNumbers {

	public static void main(String[] args) {
		// sum of numbers

				Integer[] array = { 1, 4, 5, 20, 30 };

				Integer sum = Stream.of(array).reduce(0, (a, b) -> a + b);

				Optional<Integer> sumOptional = Stream.of(array).reduce((a, b) -> a + b);
				// System.out.println(sumOptional.get() + "sumOptional");

				Optional<Integer> ReducellthdRefSum = Stream.of(array).reduce(Integer::sum);
				// System.out.println(ReducellthdRefSum.get() + "ReduceMthdRefSum");

				int sum1 = Stream.of(array).mapToInt(i -> i).sum();

				int sum2 = Stream.of(array).collect(Collectors.summingInt(i -> i));

				OptionalInt maximumNumbe = Stream.of(array).mapToInt(i -> i).max();

				// System.out.println("maximumNumber + maximumNumbe);

				// Average of numbers

				Double averagel = Stream.of(array).collect(Collectors.averagingInt(i -> i));

				OptionalDouble average2 = Stream.of(array).mapToInt(i -> i).average();

				System.out.println("avg==>" + average2.getAsDouble());

				// square of each number and average of all those numbers

				OptionalDouble squareAvg = Stream.of(array).mapToInt(x -> x * x).average();

				Double squareAvgi = Stream.of(array).collect(Collectors.averagingDouble(i -> i * i));
				// System.out.println(squareAvgi);
				// System.out.println(squareAvg);

				OptionalDouble squareAvgFilter = Stream.of(array).mapToInt(x -> x * x).filter(x -> x > 100 & x < 900).average();

				// System.out.println(squareAvgFilter.getAsDouble());

				// using Bit wise operators binary x binar 0000 then it is even

				// binary x binar 0001 then it is odd
				Integer[] arra = { 1, 4, 5, 20, 30 };

				List<Integer> evenNumbers = Stream.of(arra).filter(i -> (i & 1) == 0).collect(Collectors.toList());
				List<Integer> oddNumbers = Stream.of(arra).filter(i -> (i & 1) != 0).collect(Collectors.toList());

				//System.out.println("evenNumbers" + evenNumbers);
				//System.out.println("OddNumbers" + oddNumbers);

	}

}
