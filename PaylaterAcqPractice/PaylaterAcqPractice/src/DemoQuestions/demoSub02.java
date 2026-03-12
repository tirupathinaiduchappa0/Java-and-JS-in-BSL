package DemoQuestions;

public class demoSub02 {

	static int x;
	int y;

	demoSub02() {
		x++;
		y++;
	}

	public static void main(String[] args) {
		demoSub02 t1 = new demoSub02();
		demoSub02 t2 = new demoSub02();

		System.out.println(t2.x);
		System.out.println(t2.y);

	}

}
