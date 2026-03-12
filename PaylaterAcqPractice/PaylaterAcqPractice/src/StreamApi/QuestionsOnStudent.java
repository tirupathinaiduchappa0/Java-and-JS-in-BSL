package StreamApi;

import java.util.ArrayList;
import java.util.List;

public class QuestionsOnStudent {
	public static void main(String[] args) {

		List<student> stdList = new ArrayList<>();

		student d1 = new student(10, "siva", 70);

		student d2 = new student(11, "reddy", 40);

		student d3 = new student(12, "somuaju", 50);

		student d4 = new student(13, "sivaan", 80);

		student d5 = new student(14, "bob", 45);

		student d6 = new student(15, "alice", 20);

		student d7 = new student(16, "srinu", 30);

		stdList.add(d1);

		stdList.add(d2);

		stdList.add(d3);

		stdList.add(d4);

		stdList.add(d5);

		stdList.add(d6);

		stdList.add(d7);
		
		//I want total marks of all the students with marks graterthan 60 after 20 marks havebeen added to these students who scored lessthan 60.
				List<Integer> l = List.of(45, 55, 60, 65, 70, 80); 
				int sum = l.stream().map(m -> m < 60 ? m + 20 : m).filter(m -> m > 60).mapToInt(m -> m).sum();
				System.out.println("sum is::" + sum);
				
				
				int totalMarks =
		        stdList.stream()
		                // adjust marks
		                .map(s -> s.getMarks() < 60 ? s.getMarks() + 20 : s.getMarks())
		                // filter > 60
		                .filter(m -> m > 60)
		                // sum
		                .mapToInt(Integer::intValue)
		                .sum();

		System.out.println("Total Marks: " + totalMarks);

				
				
				

	


	}
}
