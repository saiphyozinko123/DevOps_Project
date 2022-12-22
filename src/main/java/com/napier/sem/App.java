package com.napier.sem;



public class App
{
    public static void main(String[] args)
    {
        /*
         * Display country information sorted by population
         */
        // Create instance for countries_info class
        countries_info ct = new countries_info();
        // Get and display country information organized by largest to the smallest population in the world
        ct.displayCountry(ct.getCountry_inWorld());

        // all the countries in a continent organized by largest to the smallest population
        ct.displayCountry(ct.getCountry_inContinent("Asia"));
        ct.displayCountry(ct.getCountry_inRegion("Southeast Asia"));




    }


}