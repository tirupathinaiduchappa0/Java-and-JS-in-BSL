package DesignPatterns;

public class Laptop implements Computer {
	// Laptop is one type of Computer
	// Implements compile() in its own way

	@Override
	public void compile() {
		System.out.println(" i am from laptop class");
	}

	public static void main(String[] args) {

	}

}
