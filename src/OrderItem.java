
public class OrderItem {
    private Product product;
    private int quantity;
    private double price;

    public  OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getProductPrice() * quantity;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.price = product.getProductPrice() * quantity;
    }

}
