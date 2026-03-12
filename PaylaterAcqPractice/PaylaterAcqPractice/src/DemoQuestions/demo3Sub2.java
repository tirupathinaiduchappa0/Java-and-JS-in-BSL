package DemoQuestions;

public class demo3Sub2 {

	static int count = 0;
	int cnt = 0;
	static int c = 0;

	demo3Sub2() {
		count++;
		cnt++;
		c++;
	}

	public static void main(String[] args) {
		new demo3Sub2();// Shows static shared value
		new demo3Sub2();// Shows static shared value
		new demo3Sub2();// Shows static shared value
		System.out.println(count);

		demo3Sub2 d1 = new demo3Sub2();
		demo3Sub2 d2 = new demo3Sub2();
		demo3Sub2 d3 = new demo3Sub2();
		System.out.println(d1.cnt);
		System.out.println(d2.cnt);
		System.out.println(d3.cnt);

		demo3Sub2 dm1 = new demo3Sub2();// Shows static shared value
		System.out.println(dm1.c);
		demo3Sub2 dm2 = new demo3Sub2();// Shows static shared value
		System.out.println(dm2.c);
		demo3Sub2 dm3 = new demo3Sub2();// Shows static shared value
		System.out.println(dm3.c);
		//You are printing after each object creation.The value increases step by step, not all at once

		System.out.println(dm1.c);
		System.out.println(dm2.c);
		System.out.println(dm3.c);
		
		
		
		
		/* “Static variables exist once per class, while non-static variables exist once per object.
		 Updating a non-static variable affects only that object, but updating a static variable affects all instances.”*/

	}

}
