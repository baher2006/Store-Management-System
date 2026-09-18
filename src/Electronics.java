public class Electronics extends Product {
    private int warrantyMonth;
    private String brand;
    private String color;
    private String typeOfElectronics;

    public Electronics(int warrantyMonth,String brand,String color,  int stockQuantity,
                       String typeOfElectronics, String productName,double productPrice,
                       int productId,String imagePath) {
        super(productName, productPrice, productId, imagePath,  stockQuantity);
        this.warrantyMonth = warrantyMonth;
        this.brand = brand;
        this.color = color;
        this.typeOfElectronics = typeOfElectronics;
    }

    public String getColor(){
        return color;
    }

    public String getTypeOfElectronics(){
        return typeOfElectronics;
    }
    public String getBrand(){
        return brand;
    }
    public int getWarrantyMonth(){
        return warrantyMonth;
    }

    public String toString(){
        return "Electronics type " + typeOfElectronics + " Electronics color " + color + " Electronics brand " +
                brand + " Electronics warranty month " + warrantyMonth +" "+ super.toString();
    }

}
