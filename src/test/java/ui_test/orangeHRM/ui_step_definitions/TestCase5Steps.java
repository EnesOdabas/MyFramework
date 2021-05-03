package ui_test.orangeHRM.ui_step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_test.orangeHRM.ui_pages.AddEmployeePages;
import ui_test.orangeHRM.ui_pages.DeleteEmployePages;
import ui_test.orangeHRM.ui_pages.SearchPages;
import utils.Driver;

public class TestCase5Steps {
    WebDriver driver;
    DeleteEmployePages deleteEmployePages;
    AddEmployeePages addEmployeePages;
    SearchPages searchPages;

    @Then("click the checkbox for the user,click delete button")
    public void click_the_checkbox_for_the_user() {
       driver= Driver.getDriver();
       deleteEmployePages=new DeleteEmployePages(driver);
       deleteEmployePages.checkBox.click();
       deleteEmployePages.deleteButton.click();
    }
    @Then("validate popup is displayed,click ok button")
    public void validate_popup_is_displayed_click_ok_button() {
        Assert.assertTrue(deleteEmployePages.popupDisplayed.isDisplayed());
        deleteEmployePages.alert.click();


    }
    @Then("validate successfully deleted message")
    public void validate_successfully_deleted_message() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("Successfully Deleted"));

    }
    @Then("search with same username")
    public void search_with_same_username() throws InterruptedException {
        searchPages=new SearchPages(driver);
    addEmployeePages=new AddEmployeePages(driver);
    deleteEmployePages.searchField.sendKeys("David-12D");
    searchPages.search.click();
    }
    @Then("validate no records found text")
    public void validate_no_records_found_text() {
    Assert.assertTrue(deleteEmployePages.noRecordsMessage
            .getText().contains("No Records Found"));

    }


}
