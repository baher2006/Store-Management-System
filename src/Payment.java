public class Payment {
    private double amount;
    private String paymentType;
    private boolean paid;
    private Order order;
    private double change;

    public  Payment(double amount, String paymentType, Order order) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.order = order;
        this.paid = false;
    }

    public void pay() {

        if (order.getTotalPrice() <= 0) {
            paid = false;
            System.out.println("Payment failed: Order is empty");
            return;
        }
        if (amount >= order.getTotalPrice() ) {
            paid = true;
            change = amount - order.getTotalPrice();

        } else {
            paid = false;
            System.out.println("Payment failed: Not enough money");
        }
    }

    public boolean getPaid() {
        return paid;
    }

    public double getChange() {
        return change;
    }

}
