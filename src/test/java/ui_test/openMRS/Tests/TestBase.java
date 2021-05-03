package ui_test.openMRS.Tests;

import org.testng.annotations.Parameters;
import utils.DriverMRS;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @Parameters("driverName")
    @BeforeTest(alwaysRun = true)
    public static void setup(String driverName){
        driver=DriverMRS.getDriver(driverName);
        // put in here implicitly wait if it doesnt wait for page element,
        // then put one more time after navigating to the page
        // it will wait for your all page element until it is loaded.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
