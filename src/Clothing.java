    public class Clothing extends Product {
    private String color;
    private String size;

    public Clothing(String color,String size,int stockQuantity,String productName,double productPrice,int productId, String imagePath) {
        super(productName, productPrice, productId, imagePath, stockQuantity);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String toString(){
        return "clothing color " + color + ", size " + size + ", " + super.toString();
    }

}
