package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverMRS {

    private static WebDriver driver;

    private DriverMRS(){}

    public static WebDriver getDriver(String driverName){

        if(driver==null){
            switch (driverName){
                case "chrome":
                    try {
                        String nodeUrl = "http://3.96.62.227:4444/wd/hub";
                        File file = new File("C:\\Users\\Administrator\\Downloads\\chromedriver.exe");
                        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        capabilities.setPlatform(Platform.ANY);
                        capabilities.setBrowserName("Chrome");
                        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
                    }catch (MalformedURLException ml){
                        ml.printStackTrace();
                    }
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();

        return driver;
    }

}
