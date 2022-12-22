package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class countries_info {

    // create instance for DB_connect
    DB_connect db = new DB_connect();

    Connection con1;

    /**
     * method to get country data
     */
    public ArrayList<Country> getCountry_inWorld()
    {
        try
        {
            // connection to the database
            db.connect();
            con1= db.getCon();
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<Country> countryList_wld = new ArrayList<>();
            System.out.println("\n"+"All the countries in the world organised by largest population to smallest");

            while (rset.next())
            {
                // get country data
                Country ct = new Country();
                ct.setCountry_code(rset.getString("Code"));
                ct.setCountry_name(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));

                countryList_wld.add(ct);

            }
            return countryList_wld;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //All the countries in a continent organised by largest population to smallest
    public ArrayList<Country> getCountry_inContinent(String continent_name)
    {
        try
        {
            // connection to the database
            db.connect();
            con1= db.getCon();
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect1 =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = '" + continent_name +"' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(strSelect1);
            //ArrayList Obj created
            ArrayList<Country> countryList_con = new ArrayList<>();
            System.out.println("\n"+"All the countries in " + continent_name + " organised by largest population to smallest");
           while (rset1.next())
            {
                // get country data
                Country ct = new Country();
                ct.setCountry_code(rset1.getString("Code"));
                ct.setCountry_name(rset1.getString("Name"));
                ct.setContinent(rset1.getString("Continent"));
                ct.setRegion(rset1.getString("Region"));
                ct.setPopulation(rset1.getInt("Population"));
                ct.setCapital(rset1.getInt("Capital"));

                countryList_con.add(ct);

            }

            return countryList_con;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }



    //All the countries in a region organised by largest population to smallest
    public ArrayList<Country> getCountry_inRegion(String region_name)
    {
        try
        {
            // connection to the database
            db.connect();
            con1= db.getCon();
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect1 =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = '" + region_name +"' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(strSelect1);
            //ArrayList Obj created
            ArrayList<Country> countryList_reg = new ArrayList<>();
            System.out.println("\n"+"All the countries in " + region_name + " organised by largest population to smallest");
            while (rset1.next())
            {
                // get country data
                Country ct = new Country();
                ct.setCountry_code(rset1.getString("Code"));
                ct.setCountry_name(rset1.getString("Name"));
                ct.setContinent(rset1.getString("Continent"));
                ct.setRegion(rset1.getString("Region"));
                ct.setPopulation(rset1.getInt("Population"));
                ct.setCapital(rset1.getInt("Capital"));

                countryList_reg.add(ct);

            }

            return countryList_reg;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * The top N populated cities in the world
     * where N is provided by the user.
     */
    public ArrayList<Country> getTopNCountry_inWorld(int n)
    {
        try
        {
            // connection to the database
            db.connect();
            con1= db.getCon();
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population DESC LIMIT "+n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<Country> countryList_wld = new ArrayList<>();
            System.out.println("\n"+"The top "+n+" populated cities in the world where N is provided by the user.");

            while (rset.next())
            {
                // get country data
                Country ct = new Country();
                ct.setCountry_code(rset.getString("Code"));
                ct.setCountry_name(rset.getString("Name"));
                ct.setContinent(rset.getString("Continent"));
                ct.setRegion(rset.getString("Region"));
                ct.setPopulation(rset.getInt("Population"));
                ct.setCapital(rset.getInt("Capital"));

                countryList_wld.add(ct);

            }
            return countryList_wld;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * method to display country information
     */
    public void displayCountry(ArrayList<Country> countryList)
    {
        if (countryList != null)
        {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %45s %15s %30s %10s %20s", "Code", "Country Name", "Population","Region", "Capital","Continent");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Country ct : countryList) {

            String code = ct.getCountry_code();
            String name = ct.getCountry_name();
            String continent = ct.getContinent();
            String region = ct.getRegion();
            int population = ct.getPopulation();
            int capital = ct.getCapital();
            System.out.format("%5s %45s %15d %30s %10d %20s",
                    code, name, population, region, capital, continent);

            System.out.println();
        }
        }
    }
}
