import java.io.*;
import java.util.*;

public class Customer extends Person {

    // Lists to store usernames and passwords for user management
    private final ArrayList<String> usernames = new ArrayList<>();
    private final ArrayList<String> passwords = new ArrayList<>();

    // Constructor
    public Customer() {
    }

    public Customer(String name, String username, String email, String password, String phone, String address) {
        super(name, username, email, password, phone, address);
    }

    @Override
    public void signup(String username, String email, String password) {
        // Check if the username already exists
        if (usernames.contains(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return;
        }

        // Add the new user credentials
        usernames.add(username);
        passwords.add(password);

        // Save the credentials to a file
        saveUserCredentials();
        System.out.println("Registration successful!");
    }

    @Override
    public boolean signIn(String username,String password) {
        for (int i = 0; i < usernames.size(); i++) {
            if (username.equals(usernames.get(i)) && password.equals(passwords.get(i))) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    @Override
    public void logout() {
        // remaining implementation
        System.out.println("You have logged out.");
    }

    @Override
    public List<Product> getProducts() {
        // remaining implementation
        System.out.println("Fetching products...");

        return null;
    }

    @Override
    public Product getProductById(int id) {
       // remaining implementation
        System.out.println("Fetching product with ID: " + id);
        return null;

    }

    // Method to save user credentials to a file
    private void saveUserCredentials() {
        try (FileOutputStream fos = new FileOutputStream("Credentials.txt", true);
             PrintStream ps = new PrintStream(fos)) {
            for (int i = 0; i < usernames.size(); i++) {
                ps.println(usernames.get(i) + "," + passwords.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error saving credentials: " + e.getMessage());
            usernames.clear();
            passwords.clear();
        }
    }

    // Method to load user credentials from a file
    public void loadUserCredentials() {
        File credentials = new File("Credentials.txt");
        try (FileInputStream fis = new FileInputStream(credentials);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                usernames.add(data[0]);
                passwords.add(data[1]);
            }
        } catch (IOException e) {
            System.out.println("Error loading credentials: " + e.getMessage());
        }
    }
}
