package com.plapa_kermit.gestion_bar.Model;

import java.util.ArrayList;

//Aggregation of Beer
public class BeerList {
    private ArrayList<Beer> beers;

    public BeerList() {
        beers = new ArrayList<>();
    }

    public int size() {
        return beers.size();
    }

}

