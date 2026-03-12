package StreamApi.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IncreaseSalaryByTenPercent {
	public static void main(String[] args) {
		List<Labours> list = new ArrayList<>();
		
		Labours lb1 = new Labours (1, "ramu", 20, 10000.00, "civil", "mumbai"); 

		Labours lb2 = new Labours (1, "ramu", 20, 10000.00, "civil", "mumbai");

		Labours lb3 = new Labours (2, "somu", 23, 30000.00, "it", "chennai");

		Labours lb4 = new Labours (3, "beemu", 24, 3000.00, "mech", "pune");
		
		Labours lb5  =new Labours (4, "senta", 19, 130000.00, "civil", "vizag");

		Labours lb6 =  new Labours (5, "geetha", 13, 230000.00, "civil", "mumbai");

		Labours lb7 = new Labours (6, "reeta", 29, 530000.00, "it", "hyd");

		list.add(lb1);

		list.add(lb2);

		list.add(lb3);

		list.add(lb4);

		list.add(lb5);

		list.add(lb6);

		List<Labours> labs1 = list.stream().filter( l->l.getSalary() > 30000)
		.map(x->{
		x.setSalary(x.getSalary() + 10000);
		return x;
		}).collect(Collectors.toList());

		System.out.println("labs" + labs1);

		List<Object> labs11  =list.stream().filter(l->l.getSalary() > 30000)

		.map(x->{//it is anonymous function

		x.setSalary(x.getSalary()+10000);

		return x; }).collect(Collectors.mapping(x->x.getName(), Collectors.toList()));

		System.out.println("labs" + labs11);
		
		//I want total marks of all the students with marks graterthan 60 after 20 marks havebeen added to these students who scored lessthan 60.
		List<Integer> l = List.of(45, 55, 60, 65, 70, 80); 
		int sum = l.stream().map(m -> m < 60 ? m + 20 : m).filter(m -> m > 60).mapToInt(m -> m).sum();
		System.out.println("sum is::" + sum);
		
		
//		int totalMarks =
//        stdList.stream()
//                // adjust marks
//                .map(s -> s.getMarks() < 60 ? s.getMarks() + 20 : s.getMarks())
//                // filter > 60
//                .filter(m -> m > 60)
//                // sum
//                .mapToInt(Integer::intValue)
//                .sum();

//System.out.println("Total Marks: " + totalMarks);
		
		
		
	}

}
