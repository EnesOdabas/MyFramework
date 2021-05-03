package ui_test.orangeHRM.ui_step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_test.orangeHRM.ui_pages.AddEmployeePages;
import ui_test.orangeHRM.ui_pages.LoginPages;
import utils.Driver;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps {
    WebDriver driver;
    LoginPages loginPage;
    AddEmployeePages addEmployeePages;


    @Then("user clicks add button")
    public void user_clicks_add_button(DataTable employee) throws InterruptedException {
        driver= Driver.getDriver();
        addEmployeePages=new AddEmployeePages(driver);
        loginPage=new LoginPages(driver);
        loginPage.adminFunction.click();
        Thread.sleep(1000);
        addEmployeePages.addButton.click();

        List<Map<String,String>> rows=employee.asMaps();

        for (int i=0;i<rows.size();i++){
            Map<String,String> columns=rows.get(i);
            addEmployeePages.setSelectRole(columns.get("role"));
            addEmployeePages.employee(columns.get("employeeName"), columns.get("username"));
            addEmployeePages.setStatus(columns.get("status"));
            addEmployeePages.passwordAndSave(columns.get("password"), columns.get("confirmPassword"));
            Thread.sleep(1000);
            addEmployeePages.saveButton.click();

            if(i<rows.size()-1){
                loginPage.adminFunction.click();
                addEmployeePages.addButton.click();
            }
        }

    }

    @Then("validate the message")
    public void validate_the_message() {
       // Assert.assertEquals(expected,addEmployeePages.messageVal.getText());
        Assert.assertTrue(driver.getPageSource().contains("Successfully Saved"));
    }

}
