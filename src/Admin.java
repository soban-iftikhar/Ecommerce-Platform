import java.io.IOException;
import java.util.*;

public class Admin extends Products implements Manageable {
Order order = new Order();
    @Override
    // Method for admin login
    public void login() {
        // Hard-coded admin credentials
        String adminUsername = "s";
        String adminPassword = "s";

        Scanner input = new Scanner(System.in);

        // Get username and password from admin
        System.out.print("Enter Admin Username: ");
        String username = input.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = input.nextLine();

        // Validate admin credentials
        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            System.out.println("You have successfully logged in!");

            // Display options for admin
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product"); // Pending implementation...
            System.out.println("4. View Orders");

            // Handle menu options
            switch (input.nextInt()) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProducts(); // Method yet to be implemented
                    break;
                case 4:
                    vieworders();
                default:
                    System.out.println("Invalid option selected.");
            }
        } else {
            // Provide feedback on incorrect username or password
            if (!adminUsername.equals(username)) {
                System.out.println("The username you have entered is incorrect!");
            }
            if (!adminPassword.equals(password)) {
                System.out.println("The password you have entered is incorrect!");
            }
            if (!adminUsername.equals(username) && !adminPassword.equals(password)) {
                System.out.println("The username & password you have entered are incorrect!");
            }
        }
    }

    // Method for adding a product (accessible only by admins)
    protected void addProduct() {
        // Get product details from admin
        System.out.println("Enter Product ID: ");
        String id = input.next();
        prodId.add(id);

        System.out.println("Enter Product Name: ");
        String name = input.next();
        prodName.add(name);

        System.out.println("Enter Company Name: ");
        String company = input.next();
        prodCompany.add(company);

        System.out.println("Enter Product Price: ");
        String price = input.next();
        prodPrice.add(price);

        System.out.println("Enter Product Stock: ");
        String stock = input.next();
        prodStock.add(stock);

        // Confirm that the product has been added
        System.out.println("Product Added Successfully!");

        // Load and save the updated product list
        loadProducts();
        saveProducts();
    }

    // Method for removing a product (accessible only by admins)
    protected void removeProduct() {
        // Load products before attempting to remove one
        loadProducts();

        // Get product ID from admin
        System.out.println("Enter the product ID of the product you want to delete: ");
        String pId = input.nextLine();

        boolean prodFound = false;

        // Search for the product by ID and remove it
        for (int i = 0; i < prodId.size(); i++) {
            if (prodId.get(i).equals(pId)) {
                prodId.remove(i);
                prodName.remove(i);
                prodCompany.remove(i);
                prodPrice.remove(i);
                prodStock.remove(i);
                prodFound = true;
                break;
            }
        }

        // Confirm removal or indicate that the product was not found
        if (prodFound) {
            System.out.println("Product has been successfully deleted");
            saveProducts();
        } else {
            System.out.println("The product ID you have entered doesn't exist!");
        }
    }

    // Placeholder method for updating products (to be implemented)
    public void updateProducts() {
        // Implementation pending
    }
// dummy to implement intrface
    @Override
    public void registration() {
        // Optionally, provide a dummy implementation or leave it empty
        throw new UnsupportedOperationException("Registration is not supported for Admins.");
    }

    public void vieworders(){
        order.loadOrders();
        for (int i = 0; i < order.orders.size(); i += 5) {
            System.out.println("Product ID: " + order.orders.get(i));
            System.out.println("Costumer Email: " + order.orders.get(i + 3));
            System.out.println("Costumer Address: " + order.orders.get(i + 4));
            System.out.println("Order Date: " + order.orders.get(i + 5));
            System.out.println("Order Time: " + order.orders.get(i + 6));
            System.out.println();
        }
    }
}
