package com.cydeo.utilities;

import com.cydeo.pojos.pojo.Spartan;
import com.github.javafaker.Faker;

public class SpartanUtils {

    public static Spartan createSpartan(){
        Faker faker = new Faker();
        String name = faker.name().firstName();


        return null;
    }
}
