package DesignPatterns;

public interface Computer {
	// Computer is a contract

	// Any class that implements Computer must implement compile()

	// Client code will depend on interface, not concrete class

	// 👉 This is the core idea of Factory Pattern

	void compile();

}
