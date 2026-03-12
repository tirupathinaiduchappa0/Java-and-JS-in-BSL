package CodeDecode;

import java.util.function.Function;

public class Person {
	public String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public void display() {
		System.out.println("name is:::" + name);
	};

	public static void main(String[] args) {

		Function<String, Person> lambda = somu -> new Person(somu);

		Person pp = lambda.apply("John");

		pp.display();

		Function<String, Person> Withoutlambda = Person::new;

		Person p = Withoutlambda.apply("John");

		p.display();

		Person n1 = new Person("somu");

		Person n2 = new Person("somu");

		boolean x = n1 == n2;

		System.err.println("n1===n2" + x); // False

		System.out.println("n1.equals(n2)" + n1.equals(n2)); // False
		
		//==	         Compares memory references
		//equals()	    Compares content ONLY if overridden
		//Objects	     Two new objects are never equal by ==
		
		String s1 = "Java";
		String s2 = "Java";

		System.out.println(s1 == s2);        // true
		System.out.println(s1.equals(s2));   // true
       /*
		| Operator    | What it checks                 |
		| ----------- | ------------------------------ |
		| `==`        | **Reference (memory address)** |
		| `.equals()` | **Content (value)**            |
		
		== → checks memory address
        equals() → checks content ONLY if overridden
		
		String literals go into String Constant Pool
		Both s1 and s2 point to the same memory object
		*/
		
		
		String s11 = new String("Java");
		String s22 = new String("Java");

		System.out.println(s11 == s22);        // false
		System.out.println(s11.equals(s22));   // true


	}
}
