package API_Testing;

import API_Testing.POJO.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoRestTest {
    public String randomName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String randomEmail() {
        return RandomStringUtils.randomAlphabetic(6) + "@tester.com";
    }

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setUp() {
        baseURI = "https://gorest.co.in/public/v2/users";

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer 1352035115bdf297fee05d2110140e048fa57732bcdf430aa119426721d3f505")
                .setContentType(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test (priority = 1)
    void getUsersList() {
        given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("", hasSize(10))
                .spec(responseSpecification);
    }
    User newUser;
    User userFromResponse;
    @Test(priority = 2)
    void createNewUser() {
    newUser = new User();
        newUser.setName(randomName());
        newUser.setEmail(randomEmail());
        newUser.setGender("male");
        newUser.setStatus("active");

    userFromResponse = given()
                .spec(requestSpecification)
                .body(newUser)
                .when()
                .post()
                .then()
                .statusCode(201)
                .spec(responseSpecification)
                .body("email", equalTo(newUser.getEmail()))
            .extract().as(User.class);
}

    @Test(dependsOnMethods = "createNewUser", priority = 3)
    void createUserNegativeTest() {
        newUser.setName(randomName());
        newUser.setGender("female");

        given()
                .spec(requestSpecification)
                .body(newUser)
                .when()
                .post()
                .then()
                .statusCode(422)
                .spec(responseSpecification)
                .body("[0].message", equalTo("has already been taken"));
    }

    @Test(dependsOnMethods = "createNewUser", priority = 4)
    void getUserById() {
        given()
                .spec(requestSpecification)
                .pathParam("userId", userFromResponse.getId())
                .when()
                .get("/{userId}")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("email", equalTo(newUser.getEmail()));
    }


    @Test(dependsOnMethods = "createNewUser", priority = 5)
    void updateUser() {
        userFromResponse.setName(randomName());
        userFromResponse.setEmail(randomEmail());

        given()
                .spec(requestSpecification)
                .body(userFromResponse)
                .pathParam("userId", userFromResponse.getId())
                .when()
                .put("/{userId}")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("name",equalTo(userFromResponse.getName()))
                .body("email",equalTo(userFromResponse.getEmail()));
    }

    @Test(dependsOnMethods = "createNewUser", priority = 6)
    void deleteUser(){

        given()
                .spec(requestSpecification)
                .pathParam("userId",userFromResponse.getId())
                .when()
                .delete("/{userId}")
                .then()
                .statusCode(204);
    }

    @Test(dependsOnMethods = {"createNewUser", "deleteUser"}, priority = 7)
    void deleteUserNegativeTest(){

        given()
                .spec(requestSpecification)
                .pathParam("userId",userFromResponse.getId())
                .when()
                .delete("/{userId}")
                .then()
                .statusCode(404);
    }

    @Test(dependsOnMethods = {"createNewUser", "deleteUser"}, priority = 8)
    void getUserByIdNegativeAfterDelete() {
        given()
                .spec(requestSpecification)
                .pathParam("userId", userFromResponse.getId())
                .when()
                .get("/{userId}")
                .then()
                .statusCode(404);
    }
}