package DemoQuestions;

public class demo3Sub1 {

	int a = 10;
	static int b = 20;

	public static void main(String[] args) {
		demo3Sub1 t1 = new demo3Sub1();
		demo3Sub1 t2 = new demo3Sub1();

		t1.a = 100;
		t1.b = 200;

		System.out.println(t2.a); //?
		System.out.println(t2.b);//?
	}

}
