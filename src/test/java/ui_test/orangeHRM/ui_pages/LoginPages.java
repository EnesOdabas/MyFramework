package ui_test.orangeHRM.ui_pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPages {
    public LoginPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txtUsername")
    public WebElement userNameW;
    @FindBy(id = "txtPassword")
    public WebElement passwordW;
    @FindBy(id = "btnLogin")
    public WebElement loginButton;
    @FindBy (xpath = "//li/a[@id='menu_admin_viewAdminModule']")
    public WebElement adminFunction;
    @FindBy(id = "ohrmList_chkSelectAll")
    public WebElement checkboxUsername;
    @FindBy(xpath = "//a[contains(text(),'Username')]")
    public WebElement clickOnUserName;
    @FindBy(tagName = "//tr")
    public List<WebElement> userNames;
    @FindBy(id = "spanMessage")
    public WebElement spanMessage;
    @FindBy(id = "welcome")
    public WebElement logoutMenu;
    @FindBy(xpath = "//li/a[@href='/index.php/auth/logout']")
    public WebElement logout;



    public void setLoginButton(String username,String password){
        userNameW.sendKeys(username);
        passwordW.sendKeys(password);
        loginButton.click();
    }

    public void descendingNames(){
        for (int i = 0; i <userNames.size(); i++) {
            if(userNames.get(i).getText().charAt(0)>=userNames.get(i+1).getText().charAt(0)){
                Assert.assertTrue("descending order",true);
            }

        }
    }



}
