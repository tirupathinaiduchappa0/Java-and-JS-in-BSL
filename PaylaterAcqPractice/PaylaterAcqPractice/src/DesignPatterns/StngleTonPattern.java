package DesignPatterns;

public class StngleTonPattern {
	//SINGLETON ENSURES THAT ONLE ONE INSTANCE OF THE CLASS EXISISTS IN THE ENTIRE JVM.
	
	//Spring already creates Singleton objects for you ➡️ You do NOT need to write that Singleton code
	
	//Why was this Singleton code written at all?
			//Because Java by default allows multiple objects:
			//MyClass obj1 = new MyClass();
			//MyClass obj2 = new MyClass(); // DIFFERENT object syso(obj1==obj2)-> false coz their address is diff.
			//If you want ONLY ONE object in the entire JVM, you must control object creation.
			//That’s exactly what Singleton Pattern does.

	private static StngleTonPattern instance; //Holds ONLY ONE object,👉 static = belongs to class, not object 👉 Same instance shared across JVM

	private StngleTonPattern() {
		//private constructor means: ❌ No one can do new Singleton() from outside,👉 Prevents multiple objects
	}

	public static StngleTonPattern getInstance() {
		//Only way to get the object,👉 static so no object needed to call it
		if (instance == null) {
			instance = new StngleTonPattern();
			//Object created only once, 👉 First call → object created,👉 Next calls → same object returned
		}
		return instance;//Always returns same object
	}

	public static void main(String[] args) {
		
		StngleTonPattern s1 = StngleTonPattern.getInstance();
		StngleTonPattern s2 = StngleTonPattern.getInstance();

		System.out.println(s1 == s2); // true // ONLY ONE INSTANCE IN ENTIRE JVM THATS WHY IT IS TRUE OR ELSE IT WILL FALSE.
		
		
		//Is Singleton thread-safe? ❌ (unless synchronized),How Spring handles it? ✅ (IoC container)
		//Do we need to write Singleton code in Spring?, ❌ No, Why?
				//✔ Spring beans are Singleton by default
				//✔ Spring container manages object lifecycle
				//@Autowired
		 		//UserService u1;
				//@Autowired
				//UserService u2;
		        //👉 u1 == u2 → true
		
		
//		public class Singleton {
//
//		    private static Singleton instance;
//
//		    private Singleton() {} // private constructor
//
//		    public static Singleton getInstance() {
//		        if (instance == null) {
//		            instance = new Singleton();
//		        }
//		        return instance;
//		    }
//		psvm(){}
//		}



	}

}
