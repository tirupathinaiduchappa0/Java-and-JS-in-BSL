package BasicQuestions;

public class dummy {

	public static int testmethod() {
		// If finally contains a return, it always overrides returns from try or catch.
		// “Even if try or catch has a return statement, the finally block always
		// executes.If finally also has a return, it overrides all previous returns.”
		try {
			return 10;
		} catch (Exception e) {
			return 20;
		} finally {
			return 30;
		}
	}

	public static void main(String[] args) {
		System.out.println("" + 'j' + 'a' + 'v' + 'a');
		System.out.println('j' + 'a' + 'v' + 'a');

		System.out.println("testmethod()::: " + testmethod());

		try {
			int result = 10 / 0;
			System.out.println("result is:::" + result);
		} catch (ArithmeticException e) {
			System.out.println("arithmatic exe iss ====>::" + e.getMessage());
		} finally {
			System.out.println("finally block executed");
		}
		// When does finally NOT execute? ANS)) Only in rare cases: System.exit(0) or
		// JVM crash

//		try {
//		    System.exit(0); // in this case Finally block will not execute.
//		} finally {
//		    System.out.println("finally");
//		}

	}

}
