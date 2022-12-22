package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class city_info {

    // create instance for DB_connect
    DB_connect db = new DB_connect();

    Connection con1;

    /**
     * method to get country data
     */
    public ArrayList<City> getCity() {
        try {
            // connection to the database
            db.connect();
            con1 = db.getCon();
            if (con1 == null) {
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population  FROM city INNER JOIN country ON city.CountryCode = country.Code ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<City> cityList = new ArrayList<>();
            System.out.println("\n" + "All the cities in the world organised by largest population to smallest");

            while (rset.next()) {
                // get country data
                City ct = new City();
                ct.setCity_name(rset.getString("city.Name"));
                ct.setCountry_name(rset.getString("country.Name"));
                ct.setCity_district(rset.getString("city.District"));
                ct.setCity_population(rset.getInt("city.population"));


                cityList.add(ct);

            }
            return cityList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

        public void displayCity(ArrayList<City> cityList)
        {
            if (cityList != null)
            {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%5s %45s %15s %30s", "City Name", "Country Name", "District", "Population");
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (City ct : cityList) {

                    String cityname = ct.getCity_name();
                    String name = ct.getCountry_name();
                    String citydistrict = ct.getCity_district();
                    int population = ct.getCity_population();
                    System.out.format("%5s %45s %15s %30d",
                            cityname, name, citydistrict, population);

                    System.out.println();
                }
            }
        }
    }

