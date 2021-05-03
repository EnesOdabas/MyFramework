package api_test.api_step_definitions;

import api_test.pojo.PetPojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetStoreGetRequest_steps {

    Response response;

    @When("User executes get request")
    public void user_executes_get_request() {
    response=given().accept(ContentType.JSON)
            .when().get("https://petstore.swagger.io/v2/pet/789456")
            .then().extract().response();

    }
    @Then("User validates status code is {int}")
    public void user_validates_status_code_is(Integer statusCode) {
       response.then().statusCode(statusCode);
    }
    @Then("Pet has following items")
    public void pet_has_following_items(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> maps=dataTable.asMaps();
        Map<String,String> petData=maps.get(0);

        String petName=petData.get("petName");
        String petStatus=petData.get("petStatus");
        long petId=Long.parseLong(petData.get("petId"));

        PetPojo petPojo=response.as(PetPojo.class);

        Assert.assertEquals(petId,petPojo.getId());
        Assert.assertEquals(petName,petPojo.getName());
        Assert.assertEquals(petStatus,petPojo.getStatus());



    }


}
