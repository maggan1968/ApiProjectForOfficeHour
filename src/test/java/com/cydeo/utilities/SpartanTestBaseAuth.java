package com.cydeo.utilities;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanTestBaseAuth {
    //beforeAll is the same thing with beforeClass in testng
    @BeforeAll
    public static void init(){
        RestAssured.baseURI ="http://3.83.127.158:7000";
        RestAssured.basePath = "/api";

      /*  String dbURL="jdbc:oracle:thin:@3.83.127.158:1521:XE";
        String dbPassword="SP";
        String dbUsername="SP";
        DBUtils.createConnection(dbURL, dbUsername, dbPassword);
       */

    }

    @AfterAll
    public static void close(){
       RestAssured.reset();
        // DBUtils.destroy();
    }
}
