package com.plapa_kermit.gestion_bar.Model;

public class OrderItem {
    private Beer beer;
    private int quantity;

    public OrderItem(Beer beer, int quantity) {
        this.beer = beer;
        this.quantity = quantity;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

