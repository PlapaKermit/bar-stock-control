package com.plapa_kermit.gestion_bar.Model;

import java.nio.file.Files;
import java.nio.file.Paths;
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

    public ArrayList<Beer> getBeersList() {
        return beerList;
    }

    public void setBeersList(ArrayList<Beer> beerList) {
        this.beerList = beerList;
    }

    public void saveToCSV(String filename) {
    try {
        boolean fileExists = Files.exists(Paths.get(filename));
        PrintWriter writer = new PrintWriter(new FileWriter(filename, true));

        // Check if the file exists and it's empty, then write the header line
        if (!fileExists || Files.size(Paths.get(filename)) == 0) {
            writer.println("Name, Type, Alcohol, Price, Quantity"); // Write header line
        }

        for (Beer beer : beerList) {
            // Check if the beer with the same name already exists in the file
            boolean beerExists = false;
            if (fileExists) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith(beer.getName() + ",")) {
                            beerExists = true;
                            break;
                        }
                    }
                }
            }

            // If the beer doesn't exist, write it to the CSV file
            if (!beerExists) {
                writer.println(beer.getName() + "," + beer.getType() +
                        "," + beer.getAlcohol() + "," + beer.getPrice() + "," + beer.getStock());
            }
        }

        writer.close();
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
    public void deleteBeerByName(String filename, String beerName) {
        ArrayList<Beer> updatedList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] beerData = line.split(",");
                if (beerData.length == 5) {
                    String name = beerData[0].trim();
                    if (!name.equals(beerName)) {
                        String type = beerData[1].trim();
                        double alcohol = Double.parseDouble(beerData[2].trim());
                        double price = Double.parseDouble(beerData[3].trim());
                        int stock = Integer.parseInt(beerData[4].trim());

                         Beer beer = new Beer(name, type, alcohol, price, stock);
                        updatedList.add(beer);
                    }
                } else {
                    System.err.println("Invalid CSV format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error deleting beer from CSV: " + e.getMessage());
            return;  // Exit the method if an error occurs
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric value in CSV: " + e.getMessage());
            return;  // Exit the method if an error occurs
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Beer beer : updatedList) {
                writer.println(beer.getName() + "," + beer.getType() +
                        "," + beer.getAlcohol() + "," + beer.getPrice() + "," + beer.getStock());
            }
        } catch (IOException e) {
            System.err.println("Error updating beer list in CSV: " + e.getMessage());
        }
    }

}

