package com.napier.sem;


/**
 * CREATED ON 12.12.2022
 * CREATED BY GROUP-1
 * REPRESENT POPULATION DATA
 */

public class Population {

    //-------------------------------- GET and Set method for COUNTRY NAME ----------------------------------------

    private String country_name;
    public String getCountry_name() {
        return country_name;
    }
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    //-------------------------------- END OF GET and Set method for NAME ----------------------------


    //-------------------------------- GET and Set method for REGION ----------------------------------

    private String region;
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {this.region = region;}

    //-------------------------------- END OF GET and Set method for REGION ----------------------------------


    //-------------------------------- GET and Set method for Population ----------------------------------

    private long population;
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {this.population = population;}

    //-------------------------------- End Of GET and Set method for Population -------------------------------


    //-------------------------------- GET and Set method for Continent ---------------------------------------

    private String continent;
    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }

    //-------------------------------- End Of GET and Set method for Continent ----------------------------------



    //-------------------------------- GET and Set method for CITY POPULATION ----------------------------------

    private long city_population;
    public long getCity_population() {
        return city_population;
    }

    public void setCity_population(long city_population) {
        this.city_population = city_population;
    }

    //--------------------------------END OF GET and Set method for CITY POPULATION ----------------------------------


    //-------------------------------- GET and Set method for NOT CITY POPULATION ----------------------------------
    private long population_not_city;

    public long getPopulation_not_city() {
        return population_not_city;
    }

    public void setPopulation_not_city(long population_not_city) {
        this.population_not_city = population_not_city;
    }
    //-------------------------------- END of GET and Set method for NOT CITY POPULATION ----------------------------------

    //-------------------------------- GET and Set method for CITY POPULATION PERCENTAGE----------------------------------
    private float cities_population_percentage;

    public float getCities_population_percentage() {
        return cities_population_percentage;
    }

    public void setCities_population_percentage(float cities_population_percentage) {
        this.cities_population_percentage = cities_population_percentage;
    }
    //-------------------------------- END of GET and Set method for CITY POPULATION PERCENTAGE----------------------------------

    //-------------------------------- GET and Set method for NOT CITY POPULATION PERCENTAGE----------------------------------
    private float not_cities_population_percentage;
    public float getNot_cities_population_percentage() {
        return not_cities_population_percentage;
    }

    public void setNot_cities_population_percentage(float not_cities_population_percentage) {
        this.not_cities_population_percentage = not_cities_population_percentage;
    }

    //-------------------------------- END of GET and Set method for NOT CITY POPULATION PERCENTAGE----------------------------------



}
