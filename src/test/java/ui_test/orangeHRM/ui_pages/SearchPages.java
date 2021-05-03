package ui_test.orangeHRM.ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class SearchPages {
    public SearchPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchSystemUser_userName")
    public WebElement userNameButton;
    @FindBy(xpath = "//select[@name='searchSystemUser[userType]']")
    public WebElement roleButton;
    @FindBy(xpath = "//input[@name='searchSystemUser[employeeName][empName]']")
    public WebElement empNameButton;
   @FindBy(id = "searchSystemUser_status")
    public WebElement statusButton;
   @FindBy(id = "searchBtn")
    public WebElement search;

   @FindBy(xpath = "//td/a[contains(@href,'saveSystemUser?userId')]")
   public WebElement userNameVal;
   @FindBy(xpath = "//tbody/tr[1]/td[3]")
   public WebElement userRoleVal;
   @FindBy(xpath = "//tbody/tr[1]/td[4]")
   public WebElement empNameVal;
   @FindBy (xpath = "//tbody/tr[1]/td[5]")
   public WebElement statusVal;

   @FindBy(id = "btnSave")
   public WebElement editButton;

   @FindBy(id = "systemUser_status")
   public WebElement changeStatus;
   @FindBy(id = "btnSave")
   public WebElement saveButton;
   @FindBy(xpath = "table[@id='resultTable']//tbody//a")
    public List<WebElement> listResult;



   public void changeStatus(String status){
       Select select=new Select(changeStatus);
       select.selectByVisibleText(status);
       saveButton.click();
   }



   public void buttons(String username,String role,String name,String status){
       userNameButton.sendKeys(username);
       Select select=new Select(roleButton);
       select.selectByVisibleText(role);
       empNameButton.sendKeys(name);
       Select select1=new Select(statusButton);
       select1.selectByVisibleText(status);

   }

}
