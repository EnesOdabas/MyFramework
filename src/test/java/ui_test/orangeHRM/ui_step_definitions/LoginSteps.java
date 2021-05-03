package ui_test.orangeHRM.ui_step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_test.orangeHRM.ui_pages.LoginPages;
import utils.ConfigReader;
import utils.Driver;

public class LoginSteps {
    WebDriver driver;

    LoginPages loginPage;

    @Given("the user navigate to the page")
    public void the_user_navigate_to_the() {
        driver= Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
    }
    @When("user enter the {string} and {string}")
    public void user_enter_the_and(String userN, String passW) {
        loginPage=new LoginPages(driver);
    loginPage.setLoginButton(userN, passW);

    }
    @Then("user click the login button")
    public void user_click_the_login_button() {
        loginPage=new LoginPages(driver);
        loginPage.loginButton.click();


    }
    @When("user clicks the admin function")
    public void user_clicks_the_admin_function() throws InterruptedException {
        loginPage=new LoginPages(driver);
        loginPage.adminFunction.click();
        Thread.sleep(3000);

    }
    @Then("user clicks first checkbox next to the Username")
    public void user_clicks_first_checkbox_next_to_the_username() {
        loginPage=new LoginPages(driver);
        loginPage.checkboxUsername.click();

    }
    @Then("Validate that all checkboxes are selected")
    public void validate_that_all_checkboxes_are_selected() {
        Assert.assertTrue(loginPage.checkboxUsername.isSelected());

    }
    @Then("Click on top of username {int} times")
    public void click_on_top_of_username_times(Integer int1) {
        loginPage=new LoginPages(driver);
        loginPage.clickOnUserName.click();
        loginPage.clickOnUserName.click();

    }
    @Then("Validate usernames are listed in descending order")
    public void validate_usernames_are_listed_in_descending_order() {
        loginPage.descendingNames();


    }

}
