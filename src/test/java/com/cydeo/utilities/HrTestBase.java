package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.helpers.AnnotationRegistry.reset;

public class HrTestBase {
    //create BeforeAll method
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://3.83.127.158:1000";
        RestAssured.basePath = "/api";

    }
    @AfterAll
    public static void  resetApi() {
        reset();
    }

}

