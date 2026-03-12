package DemoQuestions;

class MyObject {
	int value;
}

public class InterviewTest {

	public static void main(String[] args) {

		int num = 100;
		methodOne(num);
		System.out.println("Value of num: " + num);

		MyObject obj = new MyObject();
		obj.value = 50;
		methodTwo(obj);
		System.out.println("Value of obj.value: " + obj.value);

		methodThree(obj);
		System.out.println("Value of obj.value: " + obj.value);
	}

	public static void methodOne(int n) {
		n = 200;
	}

	public static void methodTwo(MyObject o) {
		o.value = 150;
	}

	public static void methodThree(MyObject o) {
		o = new MyObject(); // new reference
		o.value = 300;
	}
}
