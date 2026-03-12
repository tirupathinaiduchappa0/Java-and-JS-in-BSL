package BasicQuestions;

interface Payment {
    void pay();
}

class CreditCard implements Payment {
    public void pay() {
        System.out.println("Credit Card Payment");
    }
}

class UPI implements Payment {
    public void pay() {
        System.out.println("UPI Payment");
    }
}


class PaymentFactory {
    public static Payment getPayment(String type) {
        if (type.equals("CARD")) return new CreditCard();
        if (type.equals("UPI")) return new UPI();
        return null;
    }
    public static void main(String[] args) {
    	Payment p = PaymentFactory.getPayment("UPI");
    	p.pay();
	}
}

