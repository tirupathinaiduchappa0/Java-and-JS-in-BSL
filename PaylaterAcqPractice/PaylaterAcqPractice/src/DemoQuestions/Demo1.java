package DemoQuestions;
/*
class A {
    public void run() {   // public method
        System.out.println("A");
    }
}
class B extends A {
    // ❌ COMPILE-TIME ERROR, You are trying to OVERRIDE a public method with a private method,Java DOES NOT allow reducing access visibility
    private void run() { //public → private is NOT allowed
        System.out.println("B");
    }
}

class Main {
    public static void main(String[] args) {

        A a1 = new A();   // ✅ VALID
        A b1 = new B();   // ✅ VALID (upcasting)
        B a2 = new A(); //COMPILE-TIME ERROR,Cannot assign parent object to child reference,Reason: Child reference cannot point to parent object
        B b2 = new B(); //COMPILE-TIME ERROR (because class B itself is invalid due to method override issue)

        a1.run();   // Would print "A" if compilation succeeded
        b1.run();   // Would call A's run(), not B's, if compilation succeeded
        a2.run(); // ❌ a2 itself is invalid
        b2.run(); // ❌ b2 invalid
    }
}
*/
