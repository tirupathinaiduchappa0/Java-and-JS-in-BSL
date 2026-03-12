package DemoQuestions;

public class demoSub01 {
	static int a = 10;
	int b = 20;

	static {
		a = 15;
	}

	public static void main(String[] args) {
		demoSub01 t = new demoSub01();
		System.out.println(t.a);
		System.out.println(t.b);

	}

}
