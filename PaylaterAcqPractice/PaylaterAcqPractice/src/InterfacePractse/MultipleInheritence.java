package InterfacePractse;

public class MultipleInheritence implements Left, Right {

	@Override
	public void m1() {
		Left.super.m1();
		//Right.super.m1();
	}

	public static void main(String[] args) {
		MultipleInheritence mI = new MultipleInheritence();
		mI.m1();
	}
}
