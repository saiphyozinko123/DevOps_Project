package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
/**
 * Author: Group1
 * Created date: Dec.22.2022
 * This class represents unit test for capital
 */
class CapitalTest {
    static capitalcity_info capital;


    @BeforeAll
    static void init()
    {
        capital = new capitalcity_info();

    }

    /**
     * This method tests the object is not null
     */
    @Test
    void displayCapitalCityEmpty()
    {
        ArrayList<City> capitalcityList = new ArrayList<>();
        capital.displayCapitalcity(capitalcityList);
    }


    /**
     * This method tests displayCapitalCity method is not null
     */
    @Test
    void displayCapitalCityNull()
    {

        capital.displayCapitalcity(null);
    }

    /**
     * unit testing for array list with null member in it
     */
    @Test
    void displayCapitalCityContainsNull()
    {
        ArrayList<City> capitalcityList = new ArrayList<>();
        capitalcityList.add(null);
        capital.displayCapitalcity(capitalcityList);
    }

    /**
     * This is the unit testing for displayCapitalCity method.
     */
    @Test
    void displayCapitalCity()
    {
        ArrayList<City> capitalcityList = new ArrayList<>();
        City ct = new City();
        ct.setCity_name("Tokyo");
        ct.setCountry_name("Japan");
        ct.setCity_population(126714000);
        capitalcityList.add(ct);
        capital.displayCapitalcity(capitalcityList);

    }
}
