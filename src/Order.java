import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> orderItems;
    private double totalPrice;
    private Customer customer;
    private Store store;
    private boolean confirmed;

    public Order(Customer customer, Store store) {
        this.totalPrice = 0;
        this.customer = customer;
        this.store = store;
        this.confirmed = false;
        this.orderItems = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        if (confirmed){
            System.out.println("Order has been confirmed");
            return;
        }
        double result = store.sellProduct(orderItem.getProduct().getProductId(),orderItem.getQuantity());
        if (result > 0) {
            this.orderItems.add(orderItem);
            this.totalPrice += orderItem.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void removeOrderItem(int productId) {
        if (confirmed){
            System.out.println("Order has been confirmed");
            return;
        }
        for (int j = 0; j < orderItems.size(); j++) {
            OrderItem orderItem = orderItems.get(j);
            if (orderItem.getProduct().getProductId() == productId) {
                totalPrice -= orderItem.getPrice();
                orderItem.getProduct().increaseStock(orderItem.getQuantity());
                orderItems.remove(j);
                break;
            }
        }
    }

    public void updateQuantity(int productId, int newQuantity) {
        if (confirmed){
            System.out.println("Order has been confirmed");
            return;
        }

        if(newQuantity <= 0){
            removeOrderItem(productId);
            return;
        }

        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().getProductId() == productId) {
                int oldQuantity = orderItem.getQuantity();
                int difference = newQuantity - oldQuantity;
                if (difference > 0) {
                    double result = store.sellProduct(productId, difference);
                    if (result > 0) {
                        orderItem.setQuantity(newQuantity);
                        totalPrice += orderItem.getProduct().getProductPrice() * difference;
                    }
                } else if (difference < 0) {
                    orderItem.getProduct().increaseStock(-difference);
                    orderItem.setQuantity(newQuantity);
                    totalPrice += orderItem.getProduct().getProductPrice() * difference;
                }
                break;
            }
        }
    }

    public void checkout(Payment payment) {
        if(!payment.getPaid()){
            System.out.println("Payment failed, order cannot be confirmed");
            return;
        }
        confirmed = true;
            System.out.println("Order has been confirmed");
    }

    public void displayOrder() {
        System.out.println("Customer: " + customer.getCustomerName());

        for (OrderItem item : orderItems) {
            System.out.println(
                    "Product: " + item.getProduct().getProductName()
                            + ", Quantity: " + item.getQuantity()
                            + ", Price: " + item.getPrice()
            );
        }

        System.out.println("Total Price: " + totalPrice);
    }
}
