interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class ShoppingCart {
    private int total = 0;

    public void addItem(String item, int price) {
        total += price;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(total);
    }
}

// Usage
public class test {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 15);
        cart.addItem("Pen", 5);

        PaymentStrategy creditCardPayment = new CreditCardPayment();
        cart.pay(creditCardPayment);

        PaymentStrategy paypalPayment = new PayPalPayment();
        cart.pay(paypalPayment);
    }
}

