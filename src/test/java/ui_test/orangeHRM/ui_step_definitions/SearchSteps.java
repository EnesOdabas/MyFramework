package ui_test.orangeHRM.ui_step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_test.orangeHRM.ui_pages.AddEmployeePages;
import ui_test.orangeHRM.ui_pages.LoginPages;
import ui_test.orangeHRM.ui_pages.SearchPages;
import utils.Driver;

import java.util.List;
import java.util.Map;

public class SearchSteps {
    WebDriver driver;
    SearchPages searchPages;
    AddEmployeePages addEmployeePages;
    LoginPages loginPage;


    @Then("under System User search with the username which you have saved")
    public void under_system_user_search_with_the_username_which_you_have_saved(DataTable employee) throws InterruptedException {
    driver= Driver.getDriver();
    searchPages=new SearchPages(driver);
    addEmployeePages=new AddEmployeePages(driver);
    loginPage=new LoginPages(driver);
        List<Map<String,String>> rows=employee.asMaps();

        for (int i=0;i<rows.size();i++){
            Map<String,String> columns=rows.get(i);
            searchPages.buttons(columns.get("username"),
                    columns.get("role"),
                    columns.get("employeeName"),
                    columns.get("status") );
            Thread.sleep(1000);
            searchPages.search.click();

            Assert.assertEquals(rows.get(i).get("username"),columns.get("username"));
////table[@id='resultTable']//tbody//a
            if(i<rows.size()-1){
                loginPage.adminFunction.click();
            }
        }

    }

    @Then("validate only one user displayed after a search")
    public void validate_only_one_user_displayed_after_a_search() {
        for (int i = 0; i <searchPages.listResult.size() ; i++) {
            Assert.assertEquals(1,i);

        }



    }

    @Then("validate username , user role, employee name and status of the employee")
    public void validate_username_user_role_employee_name_and_status_of_the_employee() {
        Assert.assertEquals("Jack-023-7",searchPages.userNameVal.getText());
        Assert.assertEquals("Admin",searchPages.userRoleVal.getText());
        Assert.assertEquals("Dominic Chase",searchPages.empNameVal.getText());
        Assert.assertEquals("Enabled",searchPages.statusVal.getText());


    }

    @Then("click on top the username")
    public void click_on_top_the_username() {
    searchPages.userNameVal.click();
    }

    @Then("click edit button")
    public void click_edit_button() {
    searchPages.editButton.click();
    }

    @Then("change the status and click save button")
    public void change_the_status_and_click_save_button() {
    searchPages.changeStatus("Disabled");
    }

    @Then("validate updated message")
    public void validate_updated_message() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Successfully Updated"));



    }

    @Then("search with the username")
    public void search_with_the_username() {
    searchPages.userNameButton.sendKeys("Jack-023-7");
    searchPages.search.click();

    }

    @Then("validate status us updated for the user")
    public void validate_status_us_updated_for_the_user() {
    Assert.assertEquals("Disabled",searchPages.statusVal.getText());
    }


}
