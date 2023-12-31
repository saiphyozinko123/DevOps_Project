package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * CREATED ON Dec.28.2022
 * CREATED BY GROUP-1
 * JAVA CLASS FILE TO GENERATE QUERY FOR POPULATION REPORT
 */
public class population_info {
    /**
     * METHOD TO GET PEOPLE POPULATION WHO LIVE IN CITIES, NOT LIVING IN CITIES IN EACH CONTINENT
     */

    //population number in commas format
    DecimalFormat decFormat = new DecimalFormat("###,###");//comma format for population digit

    public ArrayList<Population> getCities_population_continent(Connection con1)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Continent, SUM(DISTINCT country.Population) AS con_population, SUM(city.Population) AS city_population FROM city INNER JOIN country ON city.CountryCode = country.Code GROUP BY Continent ORDER BY con_population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<Population> populationList_con = new ArrayList<>();
            // Print header
            System.out.println("POPULATION WHO LIVE IN CITIES AND NOT LIVING IN CITIES IN EACH CONTINENT");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.format("%20s %25s %25s %25s %30s %30s",
                        "Continent", "Population of continent", "Population of cities", "Population % of cities", "Population outside of cities", "Population % outside of cities");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


            while (rset.next())
            {
                Population ct = new Population();

                ct.setPopulation(rset.getLong("con_population"));
                ct.setCity_population(rset.getLong("city_population"));
                ct.setContinent(rset.getString("country.Continent"));

                String continent = ct.getContinent();
                long cities_population = ct.getCity_population();
                long con_population = ct.getPopulation();
                long population_not = con_population - cities_population;
                float cities_population_per = ((float) cities_population / (float)con_population) * 100;
                float not_cities_population_per = 100 - cities_population_per;

                ct.setPopulation_not_city(population_not);
                ct.setCities_population_percentage(cities_population_per);
                ct.setNot_cities_population_percentage(not_cities_population_per);
                //long get_population_not_city = ct.getPopulation_not_city();
                String con_population_comma_str = decFormat.format(con_population); //continent population comma format
                String cities_population_comma_str = decFormat.format(cities_population); //cities population comma format
                String population_not_city_comma_str = decFormat.format(ct.getPopulation_not_city()); //not cities population comma format

                float get_cities_population_per = ct.getCities_population_percentage();
                float get_not_cities_population_per = ct.getNot_cities_population_percentage();


                populationList_con.add(ct);

                System.out.format("%20s %25s %25s %,25.2f %30s %,30.2f",
                        continent, con_population_comma_str, cities_population_comma_str, get_cities_population_per, population_not_city_comma_str, get_not_cities_population_per);
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            return populationList_con;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }




    /**
     * METHOD TO GET PEOPLE POPULATION WHO LIVE IN CITIES, NOT LIVING IN CITIES IN EACH REGION
     */
    public ArrayList<Population> getCities_population_region(Connection con1)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, SUM(DISTINCT country.Population) AS region_population, SUM(city.Population) AS city_population FROM city INNER JOIN country ON city.CountryCode = country.Code GROUP BY country.Region ORDER BY region_population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<Population> populationList_region = new ArrayList<>();
            // Print header
            System.out.println("POPULATION WHO LIVE IN CITIES AND NOT LIVING IN CITIES IN EACH REGION");

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.format("%40s %25s %25s %25s %30s %30s",
                    "Region", "Population of country", "Population of cities", "Population % of cities", "Population outside of cities", "Population % outside of cities");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


            while (rset.next())
            {
                Population ct = new Population();
                ct.setRegion(rset.getString("country.Region"));
                ct.setPopulation(rset.getLong("region_population"));
                ct.setCity_population(rset.getLong("city_population"));



                String region_name = ct.getRegion();
                long cities_population = ct.getCity_population();
                long region_population = ct.getPopulation();
                long population_not = region_population - cities_population;
                float cities_population_per = ((float) cities_population / (float)region_population) * 100;
                float not_cities_population_per = 100 - cities_population_per;

                ct.setPopulation_not_city(population_not);
                ct.setCities_population_percentage(cities_population_per);
                ct.setNot_cities_population_percentage(not_cities_population_per);
                //long get_population_not_city = ct.getPopulation_not_city();
                String region_population_comma_str = decFormat.format(region_population); //region population comma format
                String cities_population_comma_str = decFormat.format(cities_population); //cities population comma format
                String population_not_city_comma_str = decFormat.format(ct.getPopulation_not_city()); //not cities population comma format


                float get_cities_population_per = ct.getCities_population_percentage();
                float get_not_cities_population_per = ct.getNot_cities_population_percentage();

                populationList_region.add(ct);

                System.out.format("%40s %25s %25s %,25.2f %30s %,30.2f",
                        region_name, region_population_comma_str, cities_population_comma_str, get_cities_population_per, population_not_city_comma_str, get_not_cities_population_per);

                System.out.println();

            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            return populationList_region;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }




    /**
     * METHOD TO GET PEOPLE POPULATION WHO LIVE IN CITIES, NOT LIVING IN CITIES IN EACH COUNTRY
     */
    public ArrayList<Population> getCities_population_country(Connection con1)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, SUM(DISTINCT country.Population) AS country_population, SUM(city.Population) AS city_population FROM city INNER JOIN country ON city.CountryCode = country.Code GROUP BY country.Name ORDER BY country_population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<Population> populationList_country = new ArrayList<>();
            // Print header
            System.out.println("POPULATION WHO LIVE IN CITIES AND NOT LIVING IN CITIES IN EACH COUNTRY");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.format("%40s %25s %25s %25s %30s %30s",
                    "Country", "Population of country", "Population of cities", "Population % of cities", "Population outside of cities", "Population % outside of cities");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            //System.out.println("\n"+"The population of people living in cities in each Continent \n");

            while (rset.next())
            {
                Population ct = new Population();
                ct.setCountry_name(rset.getString("country.Name"));
                ct.setPopulation(rset.getLong("country_population"));
                ct.setCity_population(rset.getLong("city_population"));



                String country_name = ct.getCountry_name();
                long cities_population = ct.getCity_population();
                long country_population = ct.getPopulation();
                long population_not = country_population - cities_population;
                float cities_population_per = ((float) cities_population / (float)country_population) * 100;
                float not_cities_population_per = 100 - cities_population_per;

                ct.setPopulation_not_city(population_not);
                ct.setCities_population_percentage(cities_population_per);
                ct.setNot_cities_population_percentage(not_cities_population_per);
                //long get_population_not_city = ct.getPopulation_not_city();
                String country_population_comma_str = decFormat.format(country_population); //country population comma format
                String cities_population_comma_str = decFormat.format(cities_population); //cities population comma format
                String population_not_city_comma_str = decFormat.format(ct.getPopulation_not_city()); //not cities population comma format


                float get_cities_population_per = ct.getCities_population_percentage();
                float get_not_cities_population_per = ct.getNot_cities_population_percentage();

                populationList_country.add(ct);

                System.out.format("%40s %25s %25s %,25.2f %30s %,30.2f",
                        country_name, country_population_comma_str, cities_population_comma_str, get_cities_population_per, population_not_city_comma_str, get_not_cities_population_per);

                System.out.println();

            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            return populationList_country;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }


    /**
     * METHOD TO GET WORLD POPULATION
     */
    public Population getWorld_Population(Connection con1)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS world_population FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Print header
            System.out.println("TOTAL POPULATION WHO LIVE IN WORLD, A CONTINENT, A REGION, A COUNTRY, A DISTRICT, A CITY");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            //create population obj
            Population ct = new Population();
            while (rset.next())
            {

                ct.setPopulation(rset.getLong("world_population"));

                //long world_population = ct.getPopulation();
                String world_population = decFormat.format(ct.getPopulation()); //world population comma format

                System.out.println("The population of the world : " + world_population);
            }
            return ct;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * METHOD TO GET Continent POPULATION
     */
    public Population getContinent_Population(Connection con1, String continent_name)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS continent_population, Continent FROM `country` WHERE Continent = '" + continent_name +"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //create population obj
            Population ct = new Population();
            while (rset.next())
            {
                ct.setPopulation(rset.getLong("continent_population"));

                //long continent_population = ct.getPopulation();
                String continent_population = decFormat.format(ct.getPopulation()); //continent population comma format


                System.out.println("The population of a continent '" + continent_name +"': " + continent_population);
            }

            return ct;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * METHOD TO GET Region POPULATION
     */
    public Population getRegion_Population(Connection con1, String region_name)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS region_population, Region FROM `country` WHERE Region = '" + region_name +"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //create population obj
            Population ct = new Population();
            while (rset.next())
            {
                ct.setPopulation(rset.getLong("region_population"));

                //long region_population = ct.getPopulation();
                String region_population = decFormat.format(ct.getPopulation()); //region population comma format


                System.out.println("The population of a region '" + region_name +"': " + region_population);
            }

            return ct;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * METHOD TO GET Country POPULATION
     */
    public Population getCountry_Population(Connection con1, String country_name)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Population FROM `country` WHERE Name =  '" + country_name +"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //create population obj
            Population ct = new Population();
            while (rset.next())
            {
                ct.setPopulation(rset.getLong("Population"));

                //long country_population = ct.getPopulation();
                String country_population = decFormat.format(ct.getPopulation()); //country population comma format


                System.out.println("The population of a country '" + country_name +"': " + country_population);
            }

            return ct;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * METHOD TO GET District POPULATION
     */
    public Population getDistrict_Population(Connection con1, String district_name)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) AS district_population FROM `country`INNER JOIN city ON country.Code = city.CountryCode WHERE city.District = '" + district_name +"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //create population obj
            Population ct = new Population();
            while (rset.next())
            {
                ct.setPopulation(rset.getLong("district_population"));

                //long district_population = ct.getPopulation();
                String district_population = decFormat.format(ct.getPopulation()); //district population comma format


                System.out.println("The population of a district '" + district_name +"': " + district_population);
            }

            return ct;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * METHOD TO GET City POPULATION
     */
    public Population getCity_Population(Connection con1, String city_name)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Population FROM `country` INNER JOIN city ON country.Code = city.CountryCode WHERE city.Name = '" + city_name +"'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //create population obj
            Population ct = new Population();
            while (rset.next())
            {
                ct.setPopulation(rset.getLong("city.Population"));

                //long city_population = ct.getPopulation();
                String city_population = decFormat.format(ct.getPopulation()); //city population comma format


                System.out.println("The population of a city '" + city_name +"': " + city_population);
            }
            //create footer
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            return ct;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }


    /**
     * METHOD TO GET PEOPLE POPULATION WHO SPEAK Chinese, English, Hindi, Spanish, Arabic
     */

    public ArrayList<CountryLanguage> get_language_population(Connection con1, Population ctp)
    {
        try
        {
            // check connection obj is null
            if (con1==null){
                System.out.println("con is null");
            }
            // Create an SQL statement
            Statement stmt = con1.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT (SUM(countrylanguage.Percentage*country.Population/100)) AS Language_Population, (SUM(countrylanguage.Percentage*country.Population/100)*100/'"+ctp.getPopulation()+"') AS Language_Population_Percent, countrylanguage.Language FROM `countrylanguage` INNER JOIN country ON countrylanguage.CountryCode = country.Code WHERE countrylanguage.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') GROUP BY LANGUAGE  ORDER BY Language_Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //ArrayList Obj created
            ArrayList<CountryLanguage> populationList_language = new ArrayList<>();
            // Print header
            System.out.println("POPULATION WHO SPEAK Chinese, English, Hindi, Spanish, Arabic");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.format("%10s %35s %40s",
                    "Language", "Population of Spoken Language", "Population % of Spoken language in world");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


            while (rset.next())
            {
                CountryLanguage ct = new CountryLanguage();
                ct.setLanguage(rset.getString("countrylanguage.Language"));
                ct.setPopulation(rset.getLong("Language_Population"));
                ct.setLanguage_population_percent(rset.getFloat("Language_Population_Percent"));

                populationList_language.add(ct);

                String language = ct.getLanguage();
                //long language_population = ct.getPopulation();
                String language_population = decFormat.format(ct.getPopulation()); //language population comma format

                float language_population_percent = ct.getLanguage_population_percent();

                System.out.format("%10s %35s %,40.2f",
                        language, language_population, language_population_percent);
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            return populationList_language;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }




}
