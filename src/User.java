import java.util.*;
import java.io.*;

public class User implements Manageable{

    // List to store usernames and passwords
    private final ArrayList<String> name = new ArrayList<>();
    private final ArrayList<String> pass = new ArrayList<>();

    // Scanner for user input
    Scanner input = new Scanner(System.in);

    // Instances of Cart and Products classes
    Cart cart = new Cart();
    Products products = new Products();
    Order order = new Order();

    // Constructor
    User() {
    }

    // Method for user login
    public void login() {
        // Load user credentials
        userLogin();

        // Get username and password from user
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();

        boolean loginSuccessful = false;

        // Validate user credentials
        for (int i = 0; i < name.size(); i++) {
            if (username.equals(name.get(i)) && password.equals(pass.get(i))) {
                System.out.println("You have successfully logged in");
                loginSuccessful = true;
                break;
            }
        }
        if (loginSuccessful) {

            System.out.println("1. Browse Product");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Order Product");
            System.out.println("5. Display Order History");
            int option = input.nextInt();
            input.nextLine();

            // Handle menu options
            switch (option) {
                case 1:
                    products.browseProducts();
                    break;
                case 2:
                    cart.saveCart();
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    order.orderProduct();
                    break;
                case 5:
                    order.displayOrderHistory();
                default:
                    System.out.println("Invalid option selected.");
            }
        }
        else {
            System.out.println("Invalid username or password.");
        }
    }
    // Method for user registration
    public void registration() {
        System.out.println("Registration...");

        // Get username from user
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        name.add(username);

        // Get password from user
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        pass.add(password);

        // Save user credentials to file
        userRegistration();
    }

    // Method to save user credentials to a file
    public void userRegistration() {
        try {
            FileOutputStream fos = new FileOutputStream("Credentials.txt", true);
            PrintStream ps = new PrintStream(fos);

            // Save each username and password to the file
            for (int i = 0; i < name.size(); i++) {
                ps.println(name.get(i) + "," + pass.get(i));
            }
            System.out.println("You have successfully registered!");
        } catch (IOException e) {
            // Handle exceptions and clear lists on error
            System.out.println(e.getMessage());
            name.clear();
            pass.clear();
        }
    }

    // Method to load user credentials from a file
    public void userLogin() {
        File credentials = new File("Credentials.txt");
        try {
            FileInputStream fis = new FileInputStream(credentials);
            Scanner input = new Scanner(fis);

            // Read each line from the file and split into username and password
            while (input.hasNextLine()) {
                String Line = input.nextLine();
                String[] data = Line.split(",");
                name.add(data[0]);
                pass.add(data[1]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // If the credentials file is empty, prompt user to register
        if (credentials.length() == 0) {
            System.out.println("You haven't registered yet!");
            registration();
        }
    }
}
