package ParallelStram;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ParallelStreamProgrammes {
	public static void main(String[] args) {
		// plain stream follows the sequential order of execution and it will use only
		// one core of processer and takes more time to execute
		// It will take only one main thread to exceute the all the code

		long start = 0;

		long end = 0;

		start = System.currentTimeMillis();

		// IntStream.range(1, 100).forEach(x -> System.out.println(x));

		end = System.currentTimeMillis();

		// System.out.println("time taken by plain stream I:::" + (end start));

		System.out.println(" ");

		// PARALLEL stream follows the random order of execution and it will use all

		// the cores of processer and takes less time to execute

		// It will take main thread along with so many threads in random order to
		// exceute the all the code

		start = System.currentTimeMillis();

		// IntStream.range(1, 100).parallel().forEach(x -> System.out.println(x));

		end = System.currentTimeMillis();

		// System.out.println("time taken by parallel stream I:::" + (end - start));

		List<Employeeee> empList = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {

			empList.add(new Employeeee(i, "employee" + i, "A", Double.valueOf(new Random().nextInt(1000 * 100))));
		}

		start = System.currentTimeMillis();

		Double averageSalaryOfEmpNormal = empList.stream().collect(Collectors.summingDouble(x -> x.getSalary()));

		end = System.currentTimeMillis();

		System.out.println(

				"time taken by plain stream I:::" + (end - start) + " NormalStram" + averageSalaryOfEmpNormal);

		System.out.println("============================");

		start = System.currentTimeMillis();

		Double averageSalaryOfEmpParallel = empList.parallelStream()
				.collect(Collectors.averagingDouble(x -> x.getSalary()));

		end = System.currentTimeMillis();

		System.out.println("time taken by parallel stream :::" + (end - start) + " parallelStream"

				+ averageSalaryOfEmpParallel);

		// finally time taken by the parallel stream is very less when compared with

		// normal stream

	}
}
