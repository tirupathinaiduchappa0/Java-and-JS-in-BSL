package Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import StreamApi.Employee;

public class Sorting {

	public static void main(String[] args) {

		// 18) Sort the numbers by using normal for loops (dont use inbuilt methods).

		Integer[] array1 = { 5, 2, 6, 1, 5, 12, 12, 8, 5, 8, 8, 3 };

		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1.length - 1; j++) {
				if (array1[j] > array1[j + 1]) {
					int temp = array1[j];
					array1[j] = array1[j + 1];
					array1[j + 1] = temp;

				}

			}

		}
		System.out.println("arrayToSort:::" + Arrays.toString(array1));

		List<Integer> list = new ArrayList<>(List.of(5, 2, 6, 1, 5, 12, 12, 8, 5, 8, 8, 3));

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				if (list.get(j) > list.get(j + 1)) {
					int temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);

				}
			}
		}
		System.out.println("list sort:::" + list);

		List<Employee> empList = new ArrayList<>();
		Employee el = new Employee(112, "ramu", "mumbai");

		Employee e2 = new Employee(2, "somu", "banglore");

		Employee e3 = new Employee(33, "beemu", "noida");

		Employee e4 = new Employee(14, "suresh", "mumbai");

		Employee e5 = new Employee(53, "ramesh", "mumbai");

		Employee e6 = new Employee(06, "mahesh", "noida");

		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);

// sorting based on emp name

		List<Employee> SortedByName = empList.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());

//System.out.println(SortedByName);

		List<Employee> SortedById = empList.stream().sorted(Comparator.comparingLong(Employee::getId))
				.collect(Collectors.toList());

//System.out.println(SortedById);

// Reverse sorting based on emp name

		List<Employee> ReverseSortedByName = empList.stream().sorted(Comparator.comparing(Employee::getName).reversed())

				.collect(Collectors.toList());

//ystem.out.println(ReverseSortedByName);

		List<Employee> ReverseSortedByCity = empList.stream().sorted((a, b) -> a.getCity().compareTo(b.getCity()))
				.toList();

		System.out.println(ReverseSortedByCity);

		empList.sort(Comparator.comparing(Employee::getName));
//System.out.println("list is ---->" + empList);

//sortingbasedonBothCityandname --thenComparing

		List<Employee> sortingbasedonBothCityandname = empList.stream()
				.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getCity)).toList();
		System.out.println(sortingbasedonBothCityandname);

		Integer[] array = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9 };

		List<Integer> sortingOrder = Stream.of(array).sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

		System.out.println("sortingOrder" + sortingOrder);

	}
}
