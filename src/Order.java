import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Order extends Products {
    protected ArrayList<String> orders = new ArrayList<>();
    private String date;
    private String time;
    Scanner input = new Scanner(System.in);

    public Order() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.date = now.format(dateFormatter);
        this.time = now.format(timeFormatter);
    }

    public void saveOrder(String productId, String productName, String productPrice) {
        try {
            // Appending to the file instead of overwriting
            FileOutputStream fos = new FileOutputStream("OrderDetails.txt", true);
            PrintStream ps = new PrintStream(fos);
            ps.println(productId + "," + productName + "," + productPrice + "," + date + "," + time);
            ps.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadOrders() {
        try {
            FileInputStream fis = new FileInputStream("OrderDetails.txt");
            Scanner input = new Scanner(fis);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(",");
                orders.add(data[0]); // productId
                orders.add(data[1]); // productName
                orders.add(data[2]); // productPrice
                orders.add(data[3]); // date
                orders.add(data[4]); // time
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayOrderHistory() {
        loadOrders();
        for (int i = 0; i < orders.size(); i += 5) {
            System.out.println("Product ID: " + orders.get(i));
            System.out.println("Product Name: " + orders.get(i + 1));
            System.out.println("Product Price: " + orders.get(i + 2));
            System.out.println("Order Date: " + orders.get(i + 3));
            System.out.println("Order Time: " + orders.get(i + 4));
            System.out.println();
        }
    }

    public void orderProduct() {
        loadProducts();
        boolean productFound = false;
        System.out.println("Enter product ID to order!");
        String productId = input.next();
        System.out.println("Enter Your Address!");      // add this to ADMIN File address so admin can access it
        String address = input.next();
        for (int i = 0; i < prodId.size(); i++) {
            if (prodId.get(i).equals(productId)) {
                saveOrder(prodId.get(i), prodName.get(i), prodPrice.get(i));
                productFound = true;
                System.out.println("Order successfully placed for Product ID: " + productId);
                break;
            }
        }
        if (!productFound) {
            System.out.println("Product not found.");
        }
    }
}
