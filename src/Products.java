import java.io.*;
import java.util.*;

public class Products {

    // Lists to store product details
    public final ArrayList<String> prodId = new ArrayList<>();
    public final ArrayList<String> prodName = new ArrayList<>();
    public final ArrayList<String> prodCompany = new ArrayList<>();
    public final ArrayList<String> prodPrice = new ArrayList<>();
    public final ArrayList<String> prodStock = new ArrayList<>();

    // Scanner for user input
    Scanner input = new Scanner(System.in);

    // Method to save all products to a file
    public void saveProducts() {
        try {
            // Open the products file for writing (overwrites the file)
            FileOutputStream fos = new FileOutputStream("Products.txt");
            PrintStream ps = new PrintStream(fos);

            // Write each product's details to the file
            for (int i = 0; i < prodName.size(); i++) {
                ps.println(prodId.get(i) + "," + prodName.get(i) + "," + prodCompany.get(i) + "," + prodPrice.get(i) + "," + prodStock.get(i));
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            System.out.println(e.getMessage());
        }
    }

    // Method to load all products from a file
    public void loadProducts() {
        try {
            // Open the products file for reading
            FileInputStream fis = new FileInputStream("Products.txt");
            Scanner input = new Scanner(fis);

            // Read each line from the file and split it into product details
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] data = line.split(",");
                prodId.add(data[0]);       // Product ID
                prodName.add(data[1]);     // Product Name
                prodCompany.add(data[2]);  // Product Company
                prodPrice.add(data[3]);    // Product Price
                prodStock.add(data[4]);    // Remaining Stock
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            System.out.println(e.getMessage());
        }
    }

    // Method to display all products
    public void displayProducts() {
        // Load products before displaying
        loadProducts();

        // Display each product's details
        for (int i = 0; i < prodId.size(); i++) {
            System.out.println("Product ID: " + prodId.get(i));
            System.out.println("Product Name: " + prodName.get(i));
            System.out.println("Product Company: " + prodCompany.get(i));
            System.out.println("Product Price: " + prodPrice.get(i));
            System.out.println("Remaining Stock: " + prodStock.get(i));
            System.out.println();
        }
    }

    // Method to browse and display products based on user input
    public void browseProducts() {
        // Load products before browsing
        loadProducts();

        // Get product name from user
        System.out.println("Enter product name: ");
        String name = input.nextLine();

        // Display details of products that match the search
        for (int i = 0; i < prodId.size(); i++) {
            if (prodName.get(i).toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Product Id: " + prodId.get(i));
                System.out.println("Product Name: " + prodName.get(i));
                System.out.println("Product Company: " + prodCompany.get(i));
                System.out.println("Product Price: " + prodPrice.get(i));
                System.out.println("Remaining Stock: " + prodStock.get(i));
                System.out.println();
            }
        }
    }
}
