package DesignPatterns;

//"Template Method" Pattern defines the skeleton of an algorithm in a base class and
//allows subclasses to override specific steps without changing the overall structure.

//Why do we need this pattern?

//Without it: ❌ Duplicate code,❌ Different developers break the flow, ❌ No control over order of steps
//With it: ✅ One standard flow,✅ Flexibility where needed,✅ Rules enforced

abstract class PaymentProcess {
	//abstract class = cannot create object,Acts as a base template,Defines common payment flow

	public final void processPayment() {//final = subclasses CANNOT change this flow,👉 This is the template method
		validate();
		debit();
		notifyUser();
		//👉 Fixed order of steps,👉 Every payment MUST follow this sequence,👉 Subclasses only customize specific steps
		//🚨 This is the core of Template Method Pattern
	}

	abstract void validate();//No implementation here,Subclasses must implement,These are the variable parts

	abstract void debit();

	void notifyUser() {//Common logic for all payments,Can be reused,Avoids duplication
		System.out.println("User notified");
	}
}

class UPIPayment extends PaymentProcess {//UPIPayment follows same payment flow,Only customizes required steps
	void validate() {
		System.out.println("UPI validation");
	}

	void debit() {
		System.out.println("UPI debit");
	}
	public static void main(String[] args) {
		PaymentProcess payment = new UPIPayment();
		payment.processPayment();
	/*	Actual flow:
			1️⃣ validate() → UPI validation
			2️⃣ debit() → UPI debit
			3️⃣ notifyUser() → common logic

			👉 Flow is controlled by parent class
			👉 Behavior is decided by child class

			This is called:

			✅ Inversion of Control (IoC)
	*/
		
		//Why final keyword is important? public final void processPayment()

				//👉 Prevents subclasses from:
				//Changing order,Skipping steps,Breaking business rules
				//📌 Lead-level thinking:“Business flow must not be altered”
		
		
		//Where is this used in REAL applications?
				//✔ Payment processing:::   UPI,CardNet,banking
				//✔ Report generation:: Read data, Process, Export
				//✔ Data pipelines: Fetch,Transform,Save
		
	/*	Spring Example (VERY IMPORTANT 🔥)
		JdbcTemplate (Classic Template Method)

		Spring fixes the flow:

		Open connection

		Execute query

		Handle exceptions

		Close connection

		You only write:

		jdbcTemplate.query("SELECT * FROM users", rowMapper);


		👉 Spring controls the algorithm
		👉 You plug in custom logic

		📌 Perfect Template Method Pattern

		9️⃣ Why your Lead answered “Template Pattern”?

		Because:

		Flow must be standard

		Steps must be controlled

		Only specific logic should vary

		💡 That is exactly Template Method Pattern
	*/
	}
}
