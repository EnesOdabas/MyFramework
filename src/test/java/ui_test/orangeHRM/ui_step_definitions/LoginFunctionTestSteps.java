package ui_test.orangeHRM.ui_step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_test.orangeHRM.ui_pages.LoginPages;
import utils.ConfigReader;
import utils.Driver;

public class LoginFunctionTestSteps {
    WebDriver  driver= Driver.getDriver();
    LoginPages  loginPages=new LoginPages(driver);

    @Given("the user navigate to the login page")
    public void the_user_navigate_to_the_login_page() {
      driver.get(ConfigReader.getProperty("url"));

    }
    //scenario Outline

    @When("user enter {string} and {string}")
    public void user_enter_and(String username, String password) {
        loginPages.setLoginButton(username, password);
    }
    @Then("validate {string}")
    public void validate(String expectedErrorMes) {
        Assert.assertEquals(expectedErrorMes,loginPages.spanMessage.getText());
    }

    @When("Verify if a user will be able to login with a valid username and valid password")
    public void verify_if_a_user_will_be_able_to_login_with_a_valid_username_and_valid_password() {
    loginPages.setLoginButton("Admin","admin123");
    Assert.assertEquals("Welcome 563dfd",loginPages.logoutMenu.getText());
    loginPages.logoutMenu.click();
    loginPages.logout.click();

    }
    @When("Verify the messages for invalid login")
    public void verify_the_messages_for_invalid_login() throws InterruptedException {
        Thread.sleep(2000);
        loginPages.setLoginButton("invalid","invalid");
        Assert.assertEquals("Invalid credentials",loginPages.spanMessage.getText());

    }





}
