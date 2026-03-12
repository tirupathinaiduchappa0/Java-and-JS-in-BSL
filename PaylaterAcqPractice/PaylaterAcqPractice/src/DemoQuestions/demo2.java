package DemoQuestions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class demo2 {
	
	/*
	        Why must you override both equals() and hashCode() together?
			Answer:
			Because of the contract in Java:
			If two objects are equal (a.equals(b) == true), they must have the same hashCode.
			If you override only one, you break this contract → unpredictable behavior in HashSet/HashMap (duplicates or lost elements).
			
			 */
	private int age;
	private String name;

	public demo2(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "demo2 [age=" + age + ", name=" + name + "]";
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		demo2 other = (demo2) obj;
//		return age == other.age && Objects.equals(name, other.name);
//	}

	public static void main(String[] args) {

		demo2 d1 = new demo2(25, "ramu");
		demo2 d2 = new demo2(25, "ramu");
		Set<demo2> demoSet = new HashSet<>();

		demoSet.add(d1);
		demoSet.add(d2);
		
		System.out.println("demo set is:::" + demoSet);
		
		/*
		Why both objects are added to the HashSet

		A HashSet does not allow duplicates, but it uses equals() and hashCode() to determine if two objects are the same.

		Right now, your demo2 class does not override equals() and hashCode(), so each object is considered different,
		 even if age and name are the same.

		✅ How to fix it

		Override toString() for readable output.

		Override equals() and hashCode() to make HashSet recognize duplicates.
		
		HashSet does NOT check duplicate based on object data.
		It checks duplicates using hashCode() and equals() methods.
		
		HashSet internally uses a HashMap

When you add an object:

First → hashCode() is called

Then → equals() is called (if hashCode matches)

❌ In your class:

You did NOT override equals()

You did NOT override hashCode()

So Java uses Object class implementations, which compare:

Memory address (reference)  results in Different memory locations
➡️ Different hashCode
➡️ equals() returns false

✅ So HashSet thinks they are different objects
✅ Both are added

“Set does not allow duplicates based on equals() and hashCode(), not based on object data.
 Since these methods are not overridden, HashSet treats both objects as unique.”
      	*/
		
	/*	First: hashCode() – If two objects have different hash codes, they are considered different (no further check).
		Second: equals() – If hash codes are the same, then it calls equals() to confirm if they are logically equal.

		In your demo2 class:

		You haven't overriddenhashCode() or equals().
		So it uses the default implementations from Object class:
		equals() → checks reference equality (==), i.e., are they the same object in memory?
		hashCode() → usually based on memory address, so different objects → different hash codes.


		Even though d1 and d2 have the same field values (age=25, name="ramu"), they are two different objects (new instances), so:

		Different hash codes → HashSet treats them as different → both added.

		That's why duplicates appear.
		*/
	}

}
