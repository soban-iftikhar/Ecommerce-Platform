import java.io.*;
import java.util.*;

public class Cart extends Products {

    // Scanner for user input
    Scanner input = new Scanner(System.in);

    // List to store items in the cart
    private ArrayList<String> cart = new ArrayList<>();

    // Method to save selected product to the cart
    protected void saveCart() {
        try {
            // Load the list of products from the file
            loadProducts();

            // Open the cart file in append mode
            FileOutputStream fos = new FileOutputStream("cart.txt", true);
            PrintStream ps = new PrintStream(fos);

            // Get the product ID from user
            System.out.println("Enter the id of the product you want to add to cart! ");
            String id = input.nextLine();

            // Search for the product ID in the product list and save it to the cart file
            for (int i = 0; i < prodId.size(); i++) {
                if (prodId.get(i).equals(id)) {
                    ps.println(prodId.get(i) + "," + prodName.get(i) + "," + prodPrice.get(i));
                }
            }
            System.out.println("Added to cart successfully");
        } catch (IOException e) {
            // Handle any IO exceptions
            System.out.println(e.getMessage());
        }
    }

    // Method to load cart items from the file
    public void loadCart() {
        try {
            // Open the cart file for reading
            FileInputStream fis = new FileInputStream("cart.txt");
            Scanner input = new Scanner(fis);

            // Read each line from the file and split it into product details
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] cData = line.split(",");
                cart.add(cData[0]); // Product ID
                cart.add(cData[1]); // Product Name
                cart.add(cData[2]); // Product Price
            }
        } catch (FileNotFoundException e) {
            // Handle case where the cart file does not exist
            System.out.println(e.getMessage());
        }
    }

    // Method to display the contents of the cart
    public void displayCart() {
        // Load the cart items
        loadCart();

        // Display each product's details
        for (int i = 0; i < cart.size(); i += 3) {
            System.out.println("Product ID: " + cart.get(i));
            System.out.println("Product Name: " + cart.get(i + 1));
            System.out.println("Product Price: " + cart.get(i + 2));
            System.out.println();
        }
    }
}
