package BasicQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LimitAndSkipProgramms {

	public static void main(String[] args) {
		// from array of 10 numbers find first 4 numbers and give the sum of those 4 numbers
		// we have a skip method also
		//list.size(), array.lenth()

		Integer[] array  = {1, 3, 8, 4, 5, 6, 7, 2, 23, 5, 9, 6, 3, 39};

		Integer Limitsum =Stream.of(array).limit(5).reduce(0, (a, b) -> a + b);
		//int Limitsum1 = Arrays.stream(array).limit(5).mapToInt(x->x).sum();

		System.out.println("Limitsum" + Limitsum);
		
		// from array of numbers i want the sum of numers from index 3 to index
		//7(Skip andLimit)

		Integer LimitSumwithSkip = Stream.of(array).skip(3).limit(5).reduce(0, (a, b) -> a + b);

		//System.out.println(LimitSumithSkip);

		Integer LimitSumwithSKipsum = Stream.of(array).skip(3).limit(5).mapToInt(i -> i).sum();

		//System.out.println(LimitSumvithSkipsum); 11 I want numbers from 5 të 8 by using skip and limit

		//IntStream.rangeClosed(1, 10).skip(4).limit(4).forEach(x-> System.out.println(x));

		// Generate 10 random Numbers

		Random Rand  =new Random();

		//Stream.generate (Rand::nextInt).limit(10).forEach(System.out::println);
		// we can use stream.iterate method also

		//Stream.iterate(0, n->n+1).limit(10).forEach(System.out::println); // 0,1,2,3...9,10
		//Stream.iterate (1, n->n+2).limit(10).forEach(System.out::println); // 1,,3,5..
		//Stream.iterate(4, n->n+2).limit(10).forEach(System.out::println); // 4,6,8..

		// swap two strings

		String a  = "hello"; //5

		String b  = "world"; //6

		a = a+b; // 11 //helloworld

		b =a.substring(0, a.length() -b.length()); // hello

		a=a.substring(b.length());
		
		System.out.println(a + b);
		
		String s1 = "ramu";
		String s2 = "seetha";
		
		StringBuilder sb = new StringBuilder();
		sb.append(s1).append(s2); //Here sb is a 3rd variable
		
		s2= sb.substring(0,s1.length());
		s1= sb.substring(s2.length());
		System.out.println(s1 + s2);

		//i/p: "I Love My India", o/p: "I-Love-My-India";

		String s= "I Love My India";
		List<String> s11 = Arrays.asList(s.split(" "));
		System.out.println("------" + s11.stream().map(x->x.substring(0,1).toUpperCase().concat(x.substring(1).toLowerCase()))
				.collect(Collectors.joining("_")));
	}
}
