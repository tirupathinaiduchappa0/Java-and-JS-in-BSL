package StreamApi;

public class Engineering {
	public Engineering(String name, int dept, String role, double salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.role = role;
		this.salary = salary;
	}
	public Engineering(String name2, String string, String role2, int salary2) {
		// TODO Auto-generated constructor stub
	}
	private String name;
	private int dept;
	private String role;
	private double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Engineering [name=");
		builder.append(name);
		builder.append(", dept=");
		builder.append(dept);
		builder.append(", role=");
		builder.append(role);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}
	
	
}
