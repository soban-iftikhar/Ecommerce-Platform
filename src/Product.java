import java.io.*;
import java.util.*;

public class Product {
    // Attributes
    private int id;
    private String name;
    private String company;
    private double price;
    private int stock;

    // Static list to store all products
    private static List<Product> productList = new ArrayList<>();

    // Constructor
    public Product(int id, String name, String company, double price, int stock) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.stock = stock;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Save products to file
    public static void saveProductsToFile() {
        try (FileOutputStream fos = new FileOutputStream("Products.txt");
             PrintStream ps = new PrintStream(fos)) {
            for (Product product : productList) {
                ps.println(product.id + "," + product.name + "," + product.company + "," + product.price + "," + product.stock);
            }
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    // Load products from file
    public static void loadProductsFromFile() {
        productList.clear();
        try (FileInputStream fis = new FileInputStream("Products.txt");
             Scanner input = new Scanner(fis)) {
            while (input.hasNextLine()) {
                String[] data = input.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String company = data[2];
                double price = Double.parseDouble(data[3]);
                int stock = Integer.parseInt(data[4]);
                productList.add(new Product(id, name, company, price, stock));
            }
        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    // Get all products
    public static List<Product> getAllProducts() {
        return productList;
    }

    // Find a product by ID
    public static Product findProductById(int id) {
        for (Product product : productList) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Company: " + company + ", Price: " + price + ", Stock: " + stock;
    }
}
