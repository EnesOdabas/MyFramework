package api_test.api_step_definitions;

import api_test.pojo.PetPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetStorePutRequest_steps {

    Response response;
    @Given("User checks pet 789456 is created before")
    public void user_checks_pet_is_created_before() {
        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/789456")
                .then().statusCode(200);
    }
    @When("User executes put request for pet 789456")
    public void user_executes_put_request_for_pet() {
        PetPojo petPojo=new PetPojo();
        petPojo.setId(Long.parseLong(ConfigReader.apiPropertyReaderByKey("updatedPetId")));
        petPojo.setName(ConfigReader.apiPropertyReaderByKey("updatedPetName"));
        petPojo.setStatus(ConfigReader.apiPropertyReaderByKey("updatedPetStatus"));
        response=given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(petPojo)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .extract().response();
        }
    @Then("Status code is {int} or not")
    public void status_code_is_or_not(Integer statusCode) {
       response.then().statusCode(statusCode);

    }
    @Then("Pet has following updated attributes")
    public void pet_has_following_updated_attributes(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> maps=dataTable.asMaps();
        Map<String,String> petData=maps.get(0);

        String petName=petData.get("petName");
        String petStatus=petData.get("petStatus");
        long petId=Long.parseLong(petData.get("petId"));

        PetPojo petPojo=new PetPojo();

        Assert.assertEquals(petId,petPojo.getId());
        Assert.assertEquals(petName,petPojo.getName());
        Assert.assertEquals(petStatus,petPojo.getStatus());
    }
}
