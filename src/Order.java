import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private String orderId;
    private String customerAddress;
    private String orderDate;
    private String orderTime;
    private List<OrderItem> items;
    private static final String ORDER_FILE = "OrderDetails.txt";

    public Order(){

    }
    public Order(String customerAddress) {
        this.orderId = generateOrderId();
        this.customerAddress = customerAddress;
        this.orderDate = getCurrentDate();
        this.orderTime = getCurrentTime();
        this.items = new ArrayList<>();
    }

    private String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    private String generateOrderId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void saveOrder() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ORDER_FILE, true))) {
            for (OrderItem item : items) {
                writer.println(String.join(",",
                        orderId,
                        item.getProductId(),
                        item.getProductName(),
                        item.getProductPrice(),
                        String.valueOf(item.getQuantity()),
                        customerAddress,
                        orderDate,
                        orderTime
                ));
            }
        }
    }

    public static List<Order> loadOrders() throws IOException {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8) {
                    Order order = new Order(data[5]); // Customer address
                    order.orderId = data[0];
                    order.orderDate = data[6];
                    order.orderTime = data[7];
                    order.addItem(new OrderItem(data[1], data[2], data[3], Integer.parseInt(data[4])));
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Time: " + orderTime);
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void displayAllOrders() {
        try {
            List<Order> orders = loadOrders();
            if (orders.isEmpty()) {
                System.out.println("No orders found.");
                return;
            }

            orders.forEach(Order::displayOrder);
        } catch (IOException e) {
            System.err.println("Error loading orders: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Order[id=%s, date=%s, time=%s, items=%s]", orderId, orderDate, orderTime, items);
    }
}
