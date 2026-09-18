import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Store store = new Store();

        FileManager.loadProducts(store);

        while (true) {

            System.out.println("===== STORE SYSTEM =====");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product");
            System.out.println("3. Search Product");
            System.out.println("4. Create Order");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();

            if (choice == 1) {

                store.displayProducts();

            } else if (choice == 2) {

                System.out.println("1. Clothing");
                System.out.println("2. Electronics");
                System.out.print("Choose product type: ");

                int type = input.nextInt();

                if (type == 1) {

                    System.out.print("Enter color: ");
                    String color = input.next();

                    System.out.print("Enter size: ");
                    String size = input.next();

                    System.out.print("Enter stock quantity: ");
                    int stockQuantity = input.nextInt();

                    System.out.print("Enter product name: ");
                    String productName = input.next();

                    System.out.print("Enter product price: ");
                    double productPrice = input.nextDouble();

                    System.out.print("Enter product ID: ");
                    int productId = input.nextInt();

                    if (store.searchProduct(productId) != null) {
                        System.out.println("Product ID already exists!");
                        continue;
                    }

                    System.out.print("Enter image path: ");
                    String imagePath = input.next();

                    Clothing clothing = new Clothing(color, size, stockQuantity, productName, productPrice, productId,
                            imagePath);

                    store.addProduct(clothing);

                    FileManager.saveProducts(store);

                    System.out.println("Product added successfully!");

                } else if (type == 2) {

                    System.out.print("Enter warranty months: ");
                    int warrantyMonth = input.nextInt();

                    System.out.print("Enter brand: ");
                    String brand = input.next();

                    System.out.print("Enter color: ");
                    String color = input.next();

                    System.out.print("Enter stock quantity: ");
                    int stockQuantity = input.nextInt();

                    System.out.print("Enter electronics type: ");
                    String typeOfElectronics = input.next();

                    System.out.print("Enter product name: ");
                    String productName = input.next();

                    System.out.print("Enter product price: ");
                    double productPrice = input.nextDouble();

                    System.out.print("Enter product ID: ");
                    int productId = input.nextInt();

                    if (store.searchProduct(productId) != null) {
                        System.out.println("Product ID already exists!");
                        continue;
                    }

                    System.out.print("Enter image path: ");
                    String imagePath = input.next();

                    Electronics electronics = new Electronics(warrantyMonth, brand, color, stockQuantity,
                            typeOfElectronics, productName, productPrice, productId, imagePath);

                    store.addProduct(electronics);

                    FileManager.saveProducts(store);

                    System.out.println("Product added successfully!");

                } else {

                    System.out.println("Invalid product type!");
                }

            } else if (choice == 3) {

                System.out.print("Enter Product ID: ");
                int productId = input.nextInt();

                Product product = store.searchProduct(productId);

                if (product != null) {

                    System.out.println(product);

                } else {

                    System.out.println("Product Not Found!");
                }

            } else if (choice == 4) {

                System.out.print("Enter customer name: ");
                String customerName = input.next();

                System.out.print("Enter payment method: ");
                String paymentMethod = input.next();

                Customer customer = new Customer(customerName, paymentMethod, 0);

                Order order = new Order(customer, store);

                System.out.print("Enter product ID: ");
                int productId = input.nextInt();

                Product product = store.searchProduct(productId);

                if (product != null) {

                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();

                    if (quantity <= 0 ||
                            quantity > product.getStockQuantity()) {

                        System.out.println(
                                "Invalid quantity or not enough stock!"
                        );

                        continue;
                    }

                    OrderItem orderItem =
                            new OrderItem(product, quantity);

                    order.addOrderItem(orderItem);

                    order.displayOrder();

                    System.out.print("Enter payment amount: ");
                    double amount = input.nextDouble();

                    Payment payment = new Payment(amount, paymentMethod, order);

                    payment.pay();

                    if (payment.getPaid()) {

                        System.out.println("Payment successful!");

                        System.out.println(
                                "Change: " + payment.getChange()
                        );

                        order.checkout(payment);

                        FileManager.saveProducts(store);
                    }

                } else {

                    System.out.println("Product Not Found!");
                }

            } else if (choice == 5) {

                System.out.println("Good Bye!");
                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}