package DesignPatterns;

public class ComputerFactory { // Special class responsible ONLY for object creation
	public static Computer getInstance(String type) {// static → no need to create factory object
		// 👉 Returns Computer interface, not concrete class
		// 👉 This is polymorphism

		// Factory decides which object to create,👉 Client does NOT use new Laptop()
		if (type.equalsIgnoreCase("LAPTOP")) {
			return new Laptop();
		}
		if (type.equalsIgnoreCase("DESKTOP")) {
			return new Desktop();
		}
		if (type.equalsIgnoreCase("PROJECTOR")) {
			return new Projector();
		}

		return null;
	}

}
