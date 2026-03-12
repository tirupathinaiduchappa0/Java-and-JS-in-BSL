package BasicQuestions;

@FunctionalInterface
public interface CalculateSum {
	abstract int operate(int a, int b);

	public static void main(String s) {
		System.out.println(" I am From main method in interface");
		
	/*	“Given an Employee table containing employee IDs and names, and a Salary table containing employee IDs, salary amounts, and month names, write an SQL query to find the highest salaried employee for each month along with the month name and salary.”

		(Optional – Shorter Version for Exams)

		“Write an SQL query to display the month-wise highest salaried employee and their salary using Employee and Salary tables.”
		
					SELECT
				    s.month_name,
				    e.empname,
				    s.salary
				FROM salary s
				JOIN employee e
				ON s.id = e.empid
				WHERE s.salary = (
				    SELECT MAX(salary)
				    FROM salary
				    WHERE month_name = s.month_name
				);

				or
				
				SELECT s.month_name, e.empname, s.salary
				FROM salary s
				JOIN employee e ON s.id = e.empid
				WHERE (s.month_name, s.salary) IN (
				    SELECT month_name, MAX(salary)
				    FROM salary
				    GROUP BY month_name
				);
           */

	}

}
