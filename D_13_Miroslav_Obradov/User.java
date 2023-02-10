import files.payloadStore;
import files.payloadUser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class User {
    @Test(priority = 10)
    public void createUserJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(payloadUser.createUserBody())
                .when().post("/user")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

    }
    @Test(priority = 20)
    public void getUserJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/Peraperic")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 30)
    public void getUserLoginJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/login?username=Peraperic&password=bing")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

    }
    @Test(priority = 40)
    public void updateUserJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
                String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(payloadUser.createUpateUserBody())
                .when().put("/user/Praperic")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 50)
    public void getUpdatedUserLoginJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/login?username=Zikazikic&password=bing")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 60)
    public void getUpdatedUserJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/Zikazikic")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 70)
    public void deleteUserJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().delete("/user/Zikazikic")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 80)
    public void getDeletedUpdatedUserJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/user/Zikazikic")
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().response().asString();
    }
}
