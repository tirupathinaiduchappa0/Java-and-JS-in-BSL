package StreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();

		Employee e1 = new Employee(1, "ramu", "mumbai");
		Employee e2 = new Employee(2, "somu", "bangalore");
		Employee e3 = new Employee(3, "beemu", "noida");
		Employee e4 = new Employee(4, "suresh", "mumbai");
		Employee e5 = new Employee(5, "ramesh", "mumbai");
		Employee e6 = new Employee(6, "mahesh", "noida");
		Employee e7 = new Employee(7, "naressh", "pune");

		empList.add(e6);
		empList.add(e5);
		empList.add(e4);
		empList.add(e3);
		empList.add(e2);
		empList.add(e1);
		empList.add(e7);

		// Grouping By city name

		Map<Object, List<Object>> result = empList.stream().collect(
				Collectors.groupingBy(x -> x.getCity(), Collectors.mapping(x -> x.getName(), Collectors.toList())));

		System.out.println("result is:::::" + result);

		Map<Object, Object> result1 = empList.stream().collect(Collectors.groupingBy(Employee::getCity)).entrySet()
				.stream().collect(Collectors.toMap(x -> x.getKey(), e -> e.getValue()));

		System.out.println("result is::;" + result1);

		List<String> list = List.of("seetha", "geetha", "geetha");
		Map<String, Long> map = new HashMap<>();

		for (String i : list) {
			if (map.containsKey(i)) {
				Long cnt = map.get(i);
				map.put(i, cnt + 1);
			} else {
				map.put(i, 1L);
			}
		}
		// other logic
//		for (String s : list) {
//			Long count = map.get(s);
//			if (count == null) {
//				map.put(s, 1L);
//			} else {
//				map.put(s, count + 1);
//			}
//		}

		System.out.println("howmaytimeseach str" + map);

//I want total marks of all the students with marks graterthan 60 after 20 marks havebeen added to these students who scored lessthan 60.
		List<Integer> l = List.of(45, 55, 60, 65, 70, 80);
		int sum = l.stream().map(m -> m < 60 ? m + 20 : m).filter(m -> m > 60).mapToInt(m -> m).sum();
		System.out.println("sum is::" + sum);

	}
}
