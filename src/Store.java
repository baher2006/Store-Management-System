import java.util.ArrayList;
public class Store {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        Product product = searchProduct(productId);
        if (product != null) {
            products.remove(product);
        }
    }
    public Product searchProduct(int productId) {
        for (Product product : products) {
            if (productId == product.getProductId()) {
                return product;
            }
        }
        return null;
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public double sellProduct(int productId, int amount) {
        Product product = searchProduct(productId);
        if (product != null) {
            if (amount > 0 && amount <= product.getStockQuantity()) {
                product.decreaseStock(amount);
                return product.getProductPrice() * amount;
            }
        }
        return 0;
    }

}
