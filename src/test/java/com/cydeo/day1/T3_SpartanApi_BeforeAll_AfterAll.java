package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.helpers.AnnotationRegistry.reset;

public class T3_SpartanApi_BeforeAll_AfterAll {
    /**
     * Task 3:
     * 1. Send request to Spartan url and save the response
     * 2. GET /spartans
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *      - response
     *      - Content-Type
     *      - Status Code
     *      - Get me third spartan
     *      - Get me third spartan gender
     *      - Get me third spartan name
     *      - Get me all spartan name
     */

    //create BeforeAll method
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://3.83.127.158:8000";
        RestAssured.basePath = "/api";

    }
    @AfterAll
    public static void  resetApi() {
        reset();
    }

        @Test
    public void test(){

    //    Task 3:
    //    1. Send request to Spartan url and save the response
    //    2. GET /spartans
    //    3. Store the response in Response Object that comes from get Request
       Response response =RestAssured.get("/spartans");

            //    4. Print out followings
            //            - response
            //response.prettyPrint();
            //            - Content-Type
            System.out.println("===============================");
            System.out.println(response.contentType());
            //            - Status Code
            System.out.println("================================");
            System.out.println(response.statusCode());

            //     - Get me third spartan gender
            System.out.println("===================================");
            String gender = response.path("[2].gender");
            String gender2 = response.path("gender[2]");
            //gender=gender2
            System.out.println("gender = " + gender);
            //     - Get me third spartan name
            System.out.println("===================================");
            String name = response.path("[2].name");
            System.out.println("name = " + name);

            //     - Get me all spartan name
            List<String> names = response.path("name");
            System.out.println("names = " + names);
    }
}
