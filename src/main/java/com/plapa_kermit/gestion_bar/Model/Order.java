package com.plapa_kermit.gestion_bar.Model;
import java.util.List;

public class Order {
    private int orderId;
    private String clientName;
    private String orderDate;
    private List<OrderItem> orderItems;
    private String deliveryStatus;

    public Order(int orderId, String clientName, String orderDate, List<OrderItem> orderItems, String deliveryStatus) {
        this.orderId = orderId;
        this.clientName = clientName;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.deliveryStatus = deliveryStatus;
    }

    public int getOrderId() {
        return orderId;
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
}

