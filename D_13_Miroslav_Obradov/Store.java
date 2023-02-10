import files.payloadPet;
import files.payloadStore;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Store {

    @Test(priority = 10)
    public void createOrderJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(payloadStore.createOrderBody())
                .when().post("/store/order")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        int id = js.getInt("id");
        int petID = js.getInt("petId");
        String status = js.getString("status");
        String complete = js.getString("complete");

        Assert.assertEquals(id, 10);
        Assert.assertEquals(petID, 10);
        Assert.assertEquals(status, "placed");
        Assert.assertEquals(complete, "true");
    }
    @Test(priority = 20)
    public void getOrderJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
                given().log().all()
                .when().get("/store/order/10")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 30)
    public void deleteOrderJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
                given().log().all()
                .when().delete("/store/order/10")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    @Test(priority = 40)
    public void getDeletedOrderJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/store/order/10")
                .then().log().all()
                .assertThat().statusCode(404)
                .extract().response().asString();
    }
    @Test(priority = 50)
    public void getStoreInventoryJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given().log().all()
                .when().get("/store/inventory")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
}

