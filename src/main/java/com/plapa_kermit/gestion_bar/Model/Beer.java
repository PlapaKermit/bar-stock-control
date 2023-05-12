package com.plapa_kermit.gestion_bar.Model;


public class Beer {
    private String name;
    private int id;
    private double aclohol;
    private double price;
    private int quantity;
    private String description;


    public Beer(String name, int id, double aclohol, double price, int quantity, String description) {
        this.name = name;
        this.id = id;
        this.aclohol = aclohol;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
}