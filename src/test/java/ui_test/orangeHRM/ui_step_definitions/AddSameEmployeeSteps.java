package ui_test.orangeHRM.ui_step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ui_test.orangeHRM.ui_pages.AddEmployeePages;
import ui_test.orangeHRM.ui_pages.LoginPages;
import utils.Driver;

public class AddSameEmployeeSteps {
    WebDriver driver;
    LoginPages loginPage;
    AddEmployeePages addEmployeePages;


    @When("user click admin button")
    public void user_click_admin_button() {
        driver= Driver.getDriver();
        addEmployeePages=new AddEmployeePages(driver);
        loginPage=new LoginPages(driver);
        loginPage.adminFunction.click();


    }
    @When("user click add user button")
    public void user_click_add_user_button() {
        addEmployeePages.addButton.click();

    }
    @Then("user enter the username {string} which is already exist")
    public void user_enter_the_username_which_is_already_exist(String username) throws InterruptedException {
        addEmployeePages.userName.sendKeys(username+ Keys.ENTER);
        addEmployeePages.setStatus("Enabled");
        Thread.sleep(3000);
    }
    @Then("validate Already exits text is  displayed")
    public void validate_already_exits_text_is_displayed() {
        Assert.assertEquals("Already exits",addEmployeePages.exitMessage.isDisplayed());

    }

}
