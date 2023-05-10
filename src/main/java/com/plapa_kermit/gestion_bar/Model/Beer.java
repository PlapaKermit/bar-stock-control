package com.plapa_kermit.gestion_bar.Model;


public class Beer {
    //Can be associate to brewery
    private Brewery brewery;
    private String name;
    private String id;
    private double aclohol;
    private double price;


    public void new_Beer(String name, String id, double aclohol, double price) {
        this.name = name;
        this.id = id;
        this.aclohol = aclohol;
        this.price = price;
    }
}
