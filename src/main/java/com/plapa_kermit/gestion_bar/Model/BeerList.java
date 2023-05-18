package com.plapa_kermit.gestion_bar.Model;

import java.util.ArrayList;
import java.io.*;


public class BeerList {
    private ArrayList<Beer> beerList;

    public BeerList() {
        beerList = new ArrayList<>();
    }

    public void addBeer(String name, String type, double alcohol, double price, int stock) {
        Beer b = new Beer(name, type, alcohol, price, stock);
        beerList.add(b);
    }

    public void afficher()  {
        for (Beer b : beerList) {
            System.out.println(b.toString());
        }
    }

    public ArrayList<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(ArrayList<Beer> beerList) {
        this.beerList = beerList;
    }

    public void saveToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Name, Type, Alcohol, Price, Quantity"); // Write header line

            for (Beer beer : beerList) {
                writer.println(beer.getName() + ","  + beer.getType() +
                        "," + beer.getAlcohol() + "," + beer.getPrice() + "," + beer.getStock());
            }
        } catch (IOException e) {
            System.err.println("Error saving beer list to CSV: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
    //beerList.clear();  // Clear the existing beer list

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line = reader.readLine(); // Read the header line and discard it

        while ((line = reader.readLine()) != null) {
            String[] beerData = line.split(",");
            if (beerData.length == 5) {
                String name = beerData[0].trim();
                String type = beerData[1].trim();
                double alcohol = Double.parseDouble(beerData[2].trim());
                double price = Double.parseDouble(beerData[3].trim());
                int stock = Integer.parseInt(beerData[4].trim());

                Beer beer = new Beer(name, type, alcohol, price, stock);
                beerList.add(beer);
            } else {
                System.err.println("Invalid CSV format: " + line);
            }
        }
    } catch (IOException e) {
        System.err.println("Error loading beer list from CSV: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.err.println("Error parsing numeric value in CSV: " + e.getMessage());
    }
    }
}

