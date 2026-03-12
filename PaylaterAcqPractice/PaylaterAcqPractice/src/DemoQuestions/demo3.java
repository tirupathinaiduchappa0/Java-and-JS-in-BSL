package DemoQuestions;

public class demo3 {
	public int value;

	public demo3(int value) {
		this.value = value;
	}

	public static void modifyObj(demo3 ref) {
		ref.value = 100;
	}

	public static void main(String[] args) {

		demo3 d = new demo3(10);
		modifyObj(d);
		System.out.println(d.value);

	}

}
