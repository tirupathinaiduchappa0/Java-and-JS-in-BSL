package DemoQuestions;

public class demo3Sub {
	
	/*Non-static variables are instance-specific, so each object has its own copy.
    Static variables are class-level and shared across all instances.
    Even though non-static variables can be modified inside methods, the change is limited to "that particular object",
     whereas static variable changes affect all objects.”*/
	
	public int x = 10; // non-static (instance) variable
	public static int y = 20; // static variable (class level)

	public void modifyVal() {
		x = x + 20;
	}

	public static void modifyVal1() {
		/* x = x + 20; // ❌ Not allowed: non-static variable cannot be accessed in static method
		Static methods are loaded without creating any object,
		but non-static variables exist only after object creation. */
		
		y = y + 20;
	}

	public static void main(String[] args) {
		
		demo3Sub d1 = new demo3Sub();//d1.x = 10
		demo3Sub d2 = new demo3Sub();//d2.x = 10
		d1.modifyVal(); //After calling this mthd d1.x = 30 and d2.x = 10 
		//d1 reference has changed and d2 reference has not changed. it is non-static var, so it is not shared across all instances(Objects).
		System.out.println(d1.x);
		System.out.println(d2.x);

		modifyVal1();
		System.out.println(y);
	}
}
/*
❗ Now the CORE CONFUSION (Interview Key Point)
❓ “x is non-static but still updating — how?”

✔ Because non-static variables are tied to the object, not frozen values.

Each object gets its own copy.


Non-static variable → belongs to object → each object has its own copy

Static variable → belongs to class → shared by all objects
*/