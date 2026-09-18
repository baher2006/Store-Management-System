public class Product {
    private String productName;
    private double productPrice;
    private int productId;
    private String imagePath;
    private int stockQuantity;

    public Product(String productName, double productPrice, int productId, String imagePath , int stockQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productId;
        this.imagePath = imagePath;
        this.stockQuantity = stockQuantity;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public double getProductPrice() {
        return productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getImagePath() {
        return imagePath;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public void increaseStock(int amount){
        this.stockQuantity += amount;
    }
    public void decreaseStock(int amount){
        this.stockQuantity -= amount;
    }

    public String toString(){
        return "product Name " + productName + ", product Price " + productPrice +
                ", stock Quantity " + stockQuantity + ", product Id " + productId + ", imagePath " + imagePath;
    }

}
