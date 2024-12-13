package Model;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String ORDER_FILE = "orders.txt";

    private String orderId;
    private String customerAddress;
    private LocalDateTime orderDateTime;
    private List<OrderItem> items;

    public Order(String customerAddress) {
        this.orderId = generateOrderId();
        this.customerAddress = customerAddress;
        this.orderDateTime = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    private String generateOrderId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public String getOrderDate() {
        return orderDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getOrderTime() {
        return orderDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void saveOrder() throws IOException {
        List<Order> orders = loadOrders();
        orders.add(this);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDER_FILE))) {
            oos.writeObject(orders);
        }
    }

    public static List<Order> loadOrders() {
        File file = new File(ORDER_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Order>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return String.format("Model.Order[id=%s, date=%s, time=%s, items=%s]", orderId, getOrderDate(), getOrderTime(), items);
    }
}

