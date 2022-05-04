package com.cydeo.day2;

import com.cydeo.enums.Gender;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import javax.management.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class T1_QueryParameters extends SpartanTestBase {
    // Use SpartanTestBase instead of keep typing BeforeAll and AfterAll

    /**
     * 1- Given accept type is Json
     * 2- Query Parameters values are
     * - gender —> Female
     * - nameContains —> e
     * 3- When user sends GET request to /spartans/search
     * 4- Print out Followings
     * - Total Element Number
     * - Get me first spartan name
     * - Get me second spartan id
     * - Get me last spartan name
     * - Get me all Spartan Names
     * 5- Verify followings
     * - Status code should be 200
     */

    @Test
    public void test1_Using_Path() {


//*1- Given accept type is Json
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .and()
//     *2- Query Parameters values are
//     *     - gender —> Female
//     *     - nameContains —> e
                .queryParam("gender", Gender.Female)
                .queryParam("nameContains",'e')
//     *3- When user sends GET request to /spartans/search
        .when()
                .get("/spartans/search");
        //     *4- Print out Followings
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println(response.prettyPrint());

        //     *     - Total Element Number
        int totalElement = response.path("totalElement");
        System.out.println("totalElement = " + totalElement);

//     *     - Get me first spartan name
       String firstSpartanName = response.path("content[0].name");
        System.out.println(firstSpartanName);

//     *     - Get me second spartan id
       int secondSpartanId = response.path("content[1].id");
        System.out.println("secondSpartanId = " + secondSpartanId);

//     *     - Get me last spartan name
        String lastSpartanName = response.path("content[-1].name");
        System.out.println(lastSpartanName);

//     *     - Get me all Spartan Names
        // - Get me all Spartan Names
        List<String> names = response.path("content.name");
        System.out.println(names);
//     * 5- Verify followings
//     *     - Status code should be 200

    }

    @Test
    public void test1_Using_JsonPath(){

        Map<String,String>queryParams = new HashMap<String,String>();
        queryParams.put("gender",Gender.Female.toString());
        queryParams.put("nameContains","e");
        //*1- Given accept type is Json
        Response response = RestAssured.given()
                .accept(ContentType.JSON)

//     *2- Query Parameters values are
//     *     - gender —> Female
//     *     - nameContains —> e
             //   .queryParam("gender", Gender.Female)
            //    .queryParam("nameContains",'e')
                .queryParams(queryParams)
//     *3- When user sends GET request to /spartans/search
                .and()
                .get("/spartans/search");
        //     *4- Print out Followings
        System.out.println("response.statusCode() = " + response.statusCode());
        JsonPath jsonPath       = response.jsonPath();
        String firstSpartanName = jsonPath.getString("content[0].name");
        System.out.println("firstSpartanName = " + firstSpartanName);
    }
}