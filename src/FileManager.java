import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class FileManager {
    public static void saveProducts(Store store){
        try {
            FileWriter writer = new FileWriter("products.txt");
            for(Product product : store.getProducts()) {
                if (product instanceof Clothing) {
                    Clothing clothing = (Clothing) product;
                    writer.write("Clothing: " + clothing.getColor() + "," +
                            clothing.getSize() + "," + clothing.getStockQuantity() + "," +
                            clothing.getProductName() + "," + clothing.getProductPrice() + "," +
                            clothing.getProductId() + "," + clothing.getImagePath() + "\n");
                } else if(product instanceof Electronics) {
                    Electronics electronics = (Electronics) product;
                    writer.write("Electronics:" +
                            electronics.getWarrantyMonth() + "," + electronics.getBrand() + "," +
                            electronics.getColor() + "," + electronics.getStockQuantity() + "," +
                            electronics.getTypeOfElectronics() + "," + electronics.getProductName() + "," +
                            electronics.getProductPrice() + "," + electronics.getProductId() + "," +
                            electronics.getImagePath() + "\n");

                }
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving products");
        }
    }

    public static void loadProducts(Store store) {
        try {
            FileReader reader = new FileReader("products.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                String[] firstParts = data[0].split(":");

                String type = firstParts[0].trim();
                String firstValue = firstParts[1].trim();


                if (type.equals("Clothing")) {

                    String color = firstValue;
                    String size = data[1];
                    int stockQuantity = Integer.parseInt(data[2]);
                    String productName = data[3];
                    double productPrice = Double.parseDouble(data[4]);
                    int productId = Integer.parseInt(data[5]);
                    String imagePath = data[6];

                    Clothing clothing = new Clothing(
                            color,
                            size,
                            stockQuantity,
                            productName,
                            productPrice,
                            productId,
                            imagePath
                    );

                    store.addProduct(clothing);


                } else if (type.equals("Electronics")) {

                    int warrantyMonth = Integer.parseInt(firstValue);
                    String brand = data[1];
                    String color = data[2];
                    int stockQuantity = Integer.parseInt(data[3]);
                    String typeOfElectronics = data[4];
                    String productName = data[5];
                    double productPrice = Double.parseDouble(data[6]);
                    int productId = Integer.parseInt(data[7]);
                    String imagePath = data[8];

                    Electronics electronics = new Electronics(
                            warrantyMonth,
                            brand,
                            color,
                            stockQuantity,
                            typeOfElectronics,
                            productName,
                            productPrice,
                            productId,
                            imagePath
                    );

                    store.addProduct(electronics);
                }
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error loading products");
        }
    }
}
