package BasicQuestions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateTimeApi {

	public static void main(String[] args) {

		// Interface Static methods should be called by using interface name only.
		CalculateSum.main("a");

		System.out.println("currentDate ===" + LocalDate.now());
		System.out.println("currentTime ===" + LocalTime.now());
		System.out.println("both date and time are--- --" + LocalDateTime.now());

		// Explain how the lambda expression (a, b) -> a + b works with the CalculateSum
		// interface.

		// int a=7 & b=10, add these variables by using java lambada expression?

		CalculateSum add = (a, b) -> a + b; // CalculateSum add = Integer::sum;
		int result = add.operate(7, 10);
		System.out.println(result);

		// find given number is even or odd
		int n = 8;

		// Using Bit wise operator

		// 1000 & 0001--0000

		if ((n & 1) == 0)
			System.out.println("even");
		else
			System.out.println("odd");

		// Fail-fast // here we will get concurrent mdodication exception
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");

		for (Integer key : map.keySet()) {
			map.put(3, "C"); // ❌ modifying while iterating
		}

		// Fail-safe // here we will get concurrent mdodication exception
//		Map<Integer, String> map1 = new ConcurrentHashMap<>();
//		map.put(1, "A");
//		map.put(2, "B");
//
//		for (Integer key : map.keySet()) {
//			map.put(3, "C"); // ❌ modifying while iterating
//		}

	}
}
