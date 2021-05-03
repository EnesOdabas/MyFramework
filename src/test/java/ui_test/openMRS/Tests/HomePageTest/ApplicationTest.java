package ui_test.openMRS.Tests.HomePageTest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui_test.openMRS.Pages.HomePage;
import ui_test.openMRS.Pages.LoginPage;
import ui_test.openMRS.Tests.TestBase;

import java.util.List;

public class ApplicationTest extends TestBase {

    LoginPage page;
    HomePage homePage;

    @BeforeClass
    public void setupPage(){
        page=new LoginPage(driver);
        homePage=new HomePage(driver);
    }


    @Parameters({"username","password","locationName"})
    @Test
    public void validationFunctionalities(String username,String password, String locationName){
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
        page.login(username,password,locationName);
        List<WebElement> apps=homePage.applications;
        Assert.assertEquals(apps.size(),9);// --> actual 5 but expected 9

        for (WebElement app:apps){
            Assert.assertTrue(app.isDisplayed());
        }



    }
}
