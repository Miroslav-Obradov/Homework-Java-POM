import files.payloadPet;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Pet {

//    @Test
//    public void createPet() {
//        RestAssured.baseURI = "https://petstore.swagger.io/v2";
//        given().log().all()
//                .header("Content-Type", "application/json")
//                .body("{\n" +
//                        "    \"id\" : \"15\",\n" +
//                        "    \"category\" : {\n" +
//                        "        \"id\" : \"10\",\n" +
//                        "        \"name\" : \"Misko\"\n" +
//                        "    },\n" +
//                        "    \"name\" : \"Misa\",\n" +
//                        "    \"photoUrls\" : [\n" +
//                        "        \"string\"\n]," +
//                        "    \"tags\" : [{\n" +
//                        "        \"id\" : \"0\",\n" +
//                        "        \"name\" : \"string\"\n" +
//                        "    }]," +
//                        "    \"status\" : \"sold\"\n" +
//                        "}")
//                .when().post("/pet")
//                .then().log().all()
//                .assertThat().statusCode(200);
//    }
    @Test(priority = 10)
    public void createPetJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(payloadPet.createPetBody())
                .when().post("/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        int id = js.getInt("id");
        String name = js.getString("category.name");
        String name2 = js.getString("name");
        String status = js.getString("status");

        Assert.assertEquals(id, 15);
        Assert.assertEquals(name, "Misko");
        Assert.assertEquals(name2, "Misa");
        Assert.assertEquals(status, "sold");
    }
    @Test(priority = 20)
    public void getPetByStatusID() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        given().log().all()
                .when().get("/15")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test(priority = 30)
    public void updatePetJson() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(payloadPet.createUpdatePetBody())
                .when().put("/pet")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        int id = js.getInt("id");
        String name = js.getString("category.name");
        String name2 = js.getString("name");
        String status = js.getString("status");

        Assert.assertEquals(id, 15);
        Assert.assertEquals(name, "Hamster");
        Assert.assertEquals(name2, "Djole");
        Assert.assertEquals(status, "available");
    }
    @Test(priority = 40)
    public void getUpdatePetByStatusID() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        given().log().all()
                .when().get("/15")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test(priority = 50)
    public void deletePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        given().log().all()
                .when().delete("/15")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void getPetByStatusSold() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        given().log().all()
                .when().get("/findByStatus?status=sold")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void getPetByStatusAvailable() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        given().log().all()
                .when().get("/findByStatus?status=available")
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void getPetByStatusPending() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        given().log().all()
                .when().get("/findByStatus?status=pending")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}

