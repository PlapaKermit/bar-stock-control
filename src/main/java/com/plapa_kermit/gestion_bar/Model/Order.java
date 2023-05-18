package com.plapa_kermit.gestion_bar.Model;
import java.util.List;

public class Order {
    private int orderId;
    private String clientName;
    private String orderDate;
    private List<Beer> beerList;
    private String deliveryStatus;

    public Order(int orderId, String clientName, String orderDate, List<Beer> beerList, String deliveryStatus) {
        this.orderId = orderId;
        this.clientName = clientName;
        this.orderDate = orderDate;
        this.beerList = beerList;
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

    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
