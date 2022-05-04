package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TBeforeAll_AfterAll {

    @BeforeAll
    public void BeforeAll(){

        RestAssured.baseURI="http://3.83.127.158:1000";
        RestAssured.basePath="/ords/hr";
    }
    @Test
    public void test1(){

        // 1. Send request to HR url and save the response
        //         * 2. GET /regions
        //         * 3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("http://3.83.127.158:1000/ords/hr/regions");

        //print response
        response.prettyPrint();
        //         * 4. Print out followings
        //         * - Headers
        System.out.println("======================================");
        System.out.println("response.headers() = " + response.headers());
        //         * Content-Type
        System.out.println("======================================");
        response.contentType();
        //         * Status Code
        System.out.println("======================================");
        response.statusCode();
        //         * Response
        //         * - Date
        System.out.println(response.header("Data"));
        //         * 5.Verify response body has"Europe"
        Assertions.assertTrue(response.body().asString().contains("Europe"));
        //         * 6. Verify response has Date
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
    }
}


