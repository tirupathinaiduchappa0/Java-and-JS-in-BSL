package StreamApi;

public class Employee {
public Employee(long id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
private long id;
private String name;
private String city;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Employee [id=");
	builder.append(id);
	builder.append(", name=");
	builder.append(name);
	builder.append(", city=");
	builder.append(city);
	builder.append("]");
	return builder.toString();
}


}
