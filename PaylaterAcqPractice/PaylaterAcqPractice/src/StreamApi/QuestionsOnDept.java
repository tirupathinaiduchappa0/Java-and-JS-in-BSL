package StreamApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionsOnDept {
	public static void main(String[] args) {
		List<Department> list = new ArrayList<>();

		Department d1 = new Department(10, "siva", 101, "active", 1300);

		Department d2 = new Department(11, "reddy", 101, "active", 1200);

		Department d3 = new Department(12, "somuaju", 102, "inactive", 1300);
		Department d4 = new Department(13, "sivaam", 102, "active", 1200);

		Department d5 = new Department(14, "bob", 103, "active", 1200);

		Department d6 = new Department(15, "alice", 103, "inactive", 1000);

		Department d7 = new Department(16, "srinu", 104, "active", 500);

		Department d8 = new Department(10, "siva", 101, "active", 12300);

		Department d9 = new Department(11, "reddy", 101, "active", 14300);

		Department d10 = new Department(12, "somuaju", 102, "inactive", 164300);

		Department d11 = new Department(13, "sivaam", 102, "active", 12003);

		Department d12 = new Department(14, "bob", 103, "active", 98765);

		Department d13 = new Department(15, "alice", 103, "inactive", 14000);

		Department d14 = new Department(16, "srinu", 104, "active", 500000);

		list.add(d1);

		list.add(d2);

		list.add(d3);

		list.add(d4);

		list.add(d5);

		list.add(d6);

		list.add(d7);

		list.add(d8);

		list.add(d9);

		list.add(d10);

		list.add(d11);

		list.add(d12);

		list.add(d13);

		list.add(d14);

		Optional<Department> maxsalariedperson = list.stream().max(Comparator.comparing(Department::getSalary));
		// System.out.println("maxsalariedperson" + maxsalariedperson);

		// 1) Grouping based on Dept. Name/ Dept Id

		// 2) employee count working on each dept

		// 3) find the list of active and inactive employees

		// 4) find second max salary among of all employees (WWIMP) 5) find maximum
		// salary from each dept (WWIMP)

		Map<Integer, Long> result = list.stream()
				.collect(Collectors.groupingBy(Department::getDeptId, Collectors.counting()));

		// System.out.println("result" + result);

		Map<Integer, Long> count = list.stream()

				.collect(Collectors.groupingBy(d -> d.getDeptId(), Collectors.counting()));

		// System.out.println("count" + count);

		List<Department> r1 = list.stream().filter(x -> "active".equals(x.getStatus())).collect(Collectors.toList());

		long r2 = list.stream().filter(x -> "active".equals(x.getStatus())).count(); // using partion By find active and
																						// inactive and similar way find
																						// even and odd
		Map<Boolean, List<Department>> oup = list.stream()
				.collect(Collectors.partitioningBy(x -> "active".equals(x.getStatus())));

		list.stream().collect(Collectors.partitioningBy(x -> x.getStatus() == "active")).forEach((key, value) -> {
			if (key) {
				// System.out.println("Active is:::" + value); I
			} else { // System.out.println("InActive is:::" + value);
			}

		});

		// 2nd maximum salary

		Optional<Department> output = list.stream().sorted(Comparator.comparingDouble(Department::getSalary).reversed())

				.skip(1).findFirst();

		// if we have duplicate salaries see the last progrrammin this file

		// System.out.println(output.get());
		// By using max/min keyword

		Optional<Department> d = list.stream().max(Comparator.comparing(Department::getSalary));

		// System.out.println(d.get());

		// max salary Department wise

		Map<Integer, Double> op = list.stream()
				.collect(Collectors.toMap(Department::getDeptId, Department::getSalary, Double::max));

		// System.out.println("op is" + op);

		Map<Integer, Optional<Double>> op1 = list.stream().collect(Collectors.groupingBy(Department::getDeptId,
				Collectors.mapping(Department::getSalary, Collectors.maxBy(Double::compareTo))));

		// System.out.println("op1 is" + op1);

		Map<Object, Object> topsalaryemp1 = list.stream()
				.collect(Collectors.groupingBy(Department::getDeptId,
						Collectors.mapping(Department::getSalary, Collectors.toList())))
				.entrySet().stream().collect(Collectors.toMap(x -> x.getKey(),
						y -> y.getValue().stream().sorted(Comparator.reverseOrder()).limit(1).toList()));

		//System.out.println("topsalaryemp is:::----->>>>  " + topsalaryemp1);

		Map<Object, Object> DeptWiseMaxsalariedpersonname = list.stream()
				.collect(Collectors.groupingBy(Department::getDeptId,
						Collectors.maxBy(Comparator.comparingDouble(Department::getSalary))))
				.entrySet().stream()
				.collect(Collectors.toMap(s -> s.getKey(), x -> x.getValue().map(Department::getEmpName)));
		//System.out.println("DeptwiseMaxsalariedpersonname" + DeptWiseMaxsalariedpersonname);

		Map<Integer, Optional<Department>> topsalaryempwithoutMthdRef = list.stream().collect(Collectors
				.groupingBy(e -> e.getDeptId(), Collectors.maxBy(Comparator.comparingDouble(x -> x.getSalary()))));

		// System.out.println(topsalaryempwithoutMthdRef); //here value is coming as
		// full object.

		// ***** SUMMARIZING IS USED TO FIND MIN, MAX, AVERAGE, COUNT ALL THE THING AT
		// ONCE *****.

		Map<Integer, DoubleSummaryStatistics> outputll =

				list.stream().collect(Collectors.groupingBy(Department::getDeptId,
						Collectors.summarizingDouble(Department::getSalary)));

		// System.out.println(outputll);

		Optional<Department> maxSalriedperson = list.stream().max(Comparator.comparingDouble(Department::getSalary));

		Optional<Department> maxSalriedperson1 = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Department::getSalary)));

		// System.out.println(maxSalriedperson + + maxSalriedperson);

		// sorting of employees based on salary

		List<Department> sortingbasedonsalary = list.stream()
				.sorted(Comparator.comparingDouble(Department::getSalary).reversed()).collect(Collectors.toList());

		// System.out.println("sortingbasedonsalary--->" + sortingbasedonsalary);

		List<Department> sortingbasedonName = list.stream().sorted(Comparator.comparing(Department::getEmpName))
				.collect(Collectors.toList());

		// System.out.println("sortingbasedonName" + sortingbasedonName);

		List<Department> sortingbasedonsalaryandid = list.stream()
				.sorted(Comparator.comparingDouble(Department::getSalary).thenComparing(Department::getEmpName))
				.collect(Collectors.toList());

		// System.out.println("sortingbasedonsalaryandid" + sortingbasedonsalaryandid);

		list.stream().sorted(Comparator.comparing(Department::getSalary).reversed()).skip(1).findFirst();

		// Find the second highsetsalaryied employee if we have duplecate salaries

		Map<Object, List<String>> secondHighsetSalariedempsalaryandnameOnly = list.stream().collect(Collectors.

				groupingBy(x -> x.getSalary(), Collectors.mapping(Department::getEmpName, Collectors.toList())));
		// System.out.println(secondHighsetSalariedempsalaryandnameOnly);

		// reverse sorting order of salaries

		List<Entry<Double, List<String>>> sortingOfSalariesInDesc = list.stream()
				.collect(Collectors.groupingBy(x -> x.getSalary(),
						Collectors.mapping(Department::getEmpName, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(x -> x.getKey())))
				.toList();

		// System.out.println("123456789" + sortingOfSalariesInDesc);

		List<Entry<Double, List<String>>> sortingOfSalariesASc = list.stream()
				.collect(Collectors.groupingBy(x -> x.getSalary(),

						Collectors.mapping(Department::getEmpName, Collectors.toList())))
				.entrySet().stream().sorted(Comparator.comparingDouble(x -> x.getKey()))

				.collect(Collectors.toList());

		// System.out.println("123456789" + sortingOfSalariesASc);

		Optional<Entry<Double, List<String>>> secondHighsetSalariedempsalaryandnameOnlySorting = list.stream()
				.collect(Collectors.groupingBy(x -> x.getSalary(),
						Collectors.mapping(Department::getEmpName, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(x -> x.getKey())))
				.skip(1).findFirst();

		// Top 3 highest paid employees employees having duplicate salary

		List<String> top3salriedemp = list.stream().sorted(Comparator.comparingDouble(Department::getSalary).reversed())
				.limit(3).map(Department::getEmpName).collect(Collectors.toList());

		// System.out.println("top3salriedemp" + top3salriedemp);

		// Department wise employee names starting with letter s

		// First grouping by dept, and then filter

		Map<Integer, List<Object>> DeptWiseEmpNameStartwiths = list.stream()
				.collect(Collectors.groupingBy(Department::getDeptId, Collectors.mapping(Department::getEmpName,
						Collectors.filtering(x -> x.startsWith("s"), Collectors.toList()))));
		// System.out.println("DeptwiseEmpNameStartwiths + DeptwiseEmpNameStartwiths);

		// First filter and then grouping by dept

		Map<Integer, List<String>> DeptwiseEmpNameStartwithS1 = list.stream().filter(x -> x.getEmpName().startsWith("s"))
				.collect(Collectors.groupingBy(Department::getDeptId,
						Collectors.mapping(Department::getEmpName, Collectors.toList())));


		// Grouping inside grouping

		// *****WIMP

		// Find the male and female employee from each depaertment male as active and
		// female as inactive /

		Map<Object, Map<Object, List<String>>> gropubydeptandsatues = list.stream().collect(Collectors
				.groupingBy(x -> x.getDeptId(), Collectors.groupingBy(x -> x.getStatus(), Collectors.mapping(Department::getEmpName, Collectors.toList()))));
		 //System.out.println("gropubydeptandsatues:: \n" + gropubydeptandsatues);

		//Department wise howmany active and inactive 
		
		Map<Object, Map<Object, Long>> statusCountByDept = list.stream().collect(Collectors
				.groupingBy(x -> x.getDeptId(), Collectors.groupingBy(x -> x.getStatus(), Collectors.counting())));

		 System.out.println("statusCountByDept:: \n"+ statusCountByDept);	 
		 
		Map<Object, Map<Object, List<Object>>> gropubydeptandsatusi = list.stream()
				.collect(Collectors.groupingBy(x -> x.getDeptId(), Collectors.groupingBy(x -> x.getStatus(),
						Collectors.mapping(x -> x.getEmpName(), Collectors.toList()))));
		System.out.println("gropubydeptandsatusi" + gropubydeptandsatusi);

		Map<Object, Map<Boolean, List<Department>>> gropubydeptandsatusl = list.stream().collect(
				Collectors.groupingBy(x -> x.getDeptId(), Collectors.partitioningBy(x -> x.getStatus() == "active")));

		System.out.println("gropubydeptandsatus1+++:" + gropubydeptandsatusl);

		System.out.println("===gropubydeptandsatues1:: \n" + gropubydeptandsatusi);

		// sum of salary of employees

		Double sumOFsalaries = list.stream().collect(Collectors.summingDouble(Department::getSalary));
		
		// System.out.println("sumOFsalaries" + sumOFsalaries);

		// sum of salary of employees whose status is active

		Double sumOFsalariesOfActiveemp = list.stream().filter(x -> "active".equalsIgnoreCase(x.getStatus()))
				.collect(Collectors.summingDouble(Department::getSalary));

		// System.out.println("sumOFsalariesOfActiveemp" + sumOFsalariesOfActiveemp);

		// Department wise sum of salaries of employees

		Map<Integer, Double> deptWiseSumOfSalaries = list.stream()

				.collect(Collectors.groupingBy(x -> x.getDeptId(), Collectors.summingDouble(Department::getSalary)));

		// System.out.println("deptWiseSumOfSalaries" + deptWiseSumOfSalaries);

		// Find Average employee salary of each department

		Map<Integer, Double> averageSalaryOfEachDept = list.stream()

				.collect(Collectors.groupingBy(x -> x.getDeptId(), Collectors.averagingDouble(Department::getSalary)));

		// System.out.println("averageSalaryOfEachDept :: " + averageSalaryOfEachDept);

		// Department wise min and max mum salary

		Map<Object, Object> departmentWiseMaxAndMinSalary = list.stream()
				.collect(Collectors.groupingBy(x -> x.getDeptId(),
						Collectors.teeing(
								Collectors.maxBy(Comparator.comparing(x -> x.getSalary())),
								Collectors.minBy(Comparator.comparing(x -> x.getSalary())),
								(el, e2) -> Map.of(" \n max value is: ", el.get().getSalary(), "\n min value is: ",
										e2.get().getSalary()))));

		System.out.println("DepartmentWiseMaxAndMinSalary :: \n" + departmentWiseMaxAndMinSalary);

		// Department wise difference between minimum and maximum salary

		Map<Object, Object> departmentWiseMaxAndMinSalaryDifference = list.stream()
				.collect(Collectors.groupingBy(x -> x.getDeptId(),
						Collectors.teeing(
								Collectors.maxBy(Comparator.comparing(x -> x.getSalary())),
								Collectors.minBy(Comparator.comparing(x -> x.getSalary())),
								(maxSal, minSal) -> maxSal.get().getSalary() - minSal.get().getSalary())));
		// (maxSal,minSal)->(Map.of("max sal:", maxSal.get().getSalary(), "min sal::",
		// maxSal.get().getSalary()))

		System.out.println("departmentWiseMaxAndMinSalaryDifference:: \n" + departmentWiseMaxAndMinSalaryDifference);

	}
}
