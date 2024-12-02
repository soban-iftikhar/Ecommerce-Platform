import java.io.Serializable;

public class OrderItem implements Serializable {
    private String productId;
    private String productName;
    private String productPrice;
    private int quantity;

    public OrderItem(){
        }

    public OrderItem(String productId, String productName, String productPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Product ID: %s, Product Name: %s, Price: %s, Quantity: %d",
                productId, productName, productPrice, quantity);
    }
}
