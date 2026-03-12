package DemoQuestions;

public class demo3Sub0 {
	int i = 10;
	static int j = 20;

	static int count = 1;

	public static void main(String[] args) {
		demo3Sub0 d1 = new demo3Sub0();
		d1.i = 11;
		d1.j = 21;
		demo3Sub0 d2 = new demo3Sub0();
		System.out.println(d2.i);
		System.out.println(d2.j);
		d2.i = 12;
		d2.j = 22;
		demo3Sub0 d3 = new demo3Sub0();
		System.out.println(d3.i);
		System.out.println(d3.j);
		System.out.println(d1.i);

		demo3Sub0 t1 = new demo3Sub0();
		t1.count++;

		demo3Sub0 t2 = new demo3Sub0();
		System.out.println(t2.count);

	}

}
