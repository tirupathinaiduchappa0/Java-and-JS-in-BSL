package DesignPatterns;

public class FactoryDesignMainClass {

	public static void main(String[] args) {
		
		
		
		//Factory Pattern = Object creation is moved to a separate class,❌ You do NOT create objects using new in business code
        //✅ You ask the factory to give you the object

		//This is client class
		Computer obj = ComputerFactory.getInstance("LAPTOP");
		obj.compile();//Runtime decides which compile() runs,👉 This is runtime polymorphism
		
		//Client only knows Computer,👉 Does NOT know Laptop / Desktop / Projector,👉 Loose coupling achieved
		
		//ADVANTAges With Factory:
			//Computer c = ComputerFactory.getInstance("LAPTOP");
			//✔ Easy to add new type
			//✔ Centralized creation
			//✔ Cleaner business logic
		
		//Factory Pattern decouples object creation from business logic by providing a common interface and centralizing object creation.
	}

}
