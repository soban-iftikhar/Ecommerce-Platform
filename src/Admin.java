import java.io.IOException;
import java.util.*;

public class Admin extends Person {
    private List<Product> products = new ArrayList<>(); // List to store Product objects
    private Scanner input = new Scanner(System.in);
    private Order order = new Order(); // Assuming an Order class exists

    public Admin() {
    }

    public Admin(String name, String username, String email, String password, String phone, String address) {
        super(name, username, email, password, phone, address);
    }

    @Override
    public void signup(String name, String username, String email) {
        throw new UnsupportedOperationException("Admin signup is not supported.");
    }

    @Override
    public void signin(String username, String email, String password) {
        // Hard-coded admin credentials (for demonstration only; replace with secure authentication)
        String adminUsername = "admin";
        String adminPassword = "admin";

        System.out.print("Enter Username: ");
        username = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();

        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void addProduct() {
        System.out.println("Enter Product Details:");

        System.out.print("Product ID: ");
        int id = input.nextInt();
        input.nextLine(); // Consume newline

        System.out.print("Product Name: ");
        String name = input.nextLine();

        System.out.print("Company Name: ");
        String company = input.nextLine();

        System.out.print("Product Price: ");
        double price = input.nextDouble();

        System.out.print("Stock Quantity: ");
        int stock = input.nextInt();
        input.nextLine(); // Consume newline

        Product product = new Product(id, name, company, price, stock);
        products.add(product);

        System.out.println("Product added successfully!");
    }

    public void removeProduct() {
        System.out.print("Enter the Product ID to remove: ");
        int id = input.nextInt();
        input.nextLine(); // Consume newline

        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void updateProduct() {
        System.out.print("Enter the Product ID to update: ");
        int id = input.nextInt();
        input.nextLine(); // Consume newline

        boolean found = false;
        for (Product product : products) {
            if (product.getId() == id) {
                found = true;

                System.out.print("New Name (leave blank to keep current): ");
                String name = input.nextLine();
                if (!name.isEmpty()) {
                    product.setName(name);
                }

                System.out.print("New Company (leave blank to keep current): ");
                String company = input.nextLine();
                if (!company.isEmpty()) {
                    product.setCompany(company);
                }

                System.out.print("New Price (-1 to keep current): ");
                double price = input.nextDouble();
                if (price != -1) {
                    product.setPrice(price);
                }

                System.out.print("New Stock (-1 to keep current): ");
                int stock = input.nextInt();
                input.nextLine(); // Consume newline
                if (stock != -1) {
                    product.setStock(stock);
                }

                System.out.println("Product updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    public void viewOrders() throws IOException {
        List<Order> orderList = order.loadOrders();
        for (Order o : orderList) {
            System.out.println(o);
        }
    }

    @Override
    public void logout() {
        System.out.println("Logged out successfully.");
    }

    @Override
    public void getProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("Product not found.");
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
