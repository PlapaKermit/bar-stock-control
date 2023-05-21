package com.plapa_kermit.gestion_bar.Model;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String clientName;
    private String orderDate;
    private List<OrderItem> orderItems;
    private String deliveryStatus;

    public Order( String clientName, String orderDate, List<OrderItem> orderItems, String deliveryStatus) {

        this.clientName = clientName;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.deliveryStatus = deliveryStatus;
    }


    public String getClientName() {
        return clientName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
     public static List<Order> loadOrdersFromCSV(String filename) {
        List<Order> orderList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the header line

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String clientName = parts[0];
                    String orderDate = parts[1];
                    String deliveryStatus = parts[2];

                    Order order = new Order(clientName, orderDate, new ArrayList<>(), deliveryStatus);
                    orderList.add(order);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading order list from CSV: " + e.getMessage());
        }

         return orderList;
    }

   public void saveToCSV(String filename) {
        try {
            boolean fileExists = Files.exists(Paths.get(filename));
            PrintWriter writer = new PrintWriter(new FileWriter(filename, true));

            // Check if the file exists and it's empty, then write the header line
            if (!fileExists || Files.size(Paths.get(filename)) == 0) {
                writer.println("Client Name, Order Date, Item Name, Quantity, Delivery Status"); // Write header line
            }

            for (OrderItem orderItem : orderItems) {
                // Check if the order item with the same name already exists in the file
                boolean orderItemExists = false;
                if (fileExists) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.startsWith(clientName + "," + orderDate + "," + orderItem.getBeer() + ",")) {
                                orderItemExists = true;
                                break;
                            }
                        }
                    }
                }

                // If the order item doesn't exist, write it to the CSV file
                if (!orderItemExists) {
                    writer.println(clientName + "," + orderDate + "," + orderItem.getBeer() +
                            "," + orderItem.getQuantity() + "," + deliveryStatus);
                }
            }

            writer.close();
        } catch (IOException e) {
            System.err.println("Error saving order to CSV: " + e.getMessage());
        }
    }


}


