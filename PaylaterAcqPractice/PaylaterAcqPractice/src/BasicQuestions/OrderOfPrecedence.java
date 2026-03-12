package BasicQuestions;

public class OrderOfPrecedence {

	/*** vvv Imp */

	// what is the Order of precedence for staticBlock, NonStaticBlock,Constructer
	// and Main Method in java.

	/*
	 * Static block executes when the class is loaded. Main method always executes
	 * next. Non-static block and constructor execute only when an object is
	 * created.
	 *  Static blocks execute once when the class is loaded. Main method
	 * executes after class loading. Instance blocks execute before the constructor
	 * when an object is created.
	 */

	static {

		System.out.println("I am static block");

	};
	{
		System.out.println("i am non-static block");
	}

	public OrderOfPrecedence() {
		System.out.println("i am constructer");
	};

	public static void main(String[] args) {
		System.out.println("i am from main method before any instance");

		OrderOfPrecedence op = new OrderOfPrecedence();

		System.out.println("i am from main method after instance creation");

		 OrderOfPrecedence op1 = new OrderOfPrecedence();
		 
		 OrderOfPrecedence op2 = new OrderOfPrecedence();
		 
		// if we create object/instance 2 time then 2 times non-static block and
		// constructer will execute.

		// Output
		/*
		 * Static Block Main Method (before object creation) Non-Static Block
		 * Constructor Main Method (after object creation)
		 */

	}

}
