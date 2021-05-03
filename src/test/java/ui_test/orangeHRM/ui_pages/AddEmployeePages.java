package ui_test.orangeHRM.ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployeePages {
    public AddEmployeePages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='btnAdd']")
    public WebElement addButton;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    public WebElement selectRole;
    @FindBy(xpath = "//li/input[@name='systemUser[employeeName][empName]']")
    public WebElement employeeName;
    @FindBy(xpath = "//li/input[@name='systemUser[userName]']")
    public WebElement userName;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    public WebElement status;
    @FindBy(id = "systemUser_password")
    public WebElement passwordW;
    @FindBy(id = "systemUser_confirmPassword")
    public WebElement confPassW;
    @FindBy(xpath = "//input[@class='addbutton']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@id='successBodyEdit']")
    public WebElement messageVal;

    @FindBy(xpath = "//span[@for='systemUser_userName']")
    public WebElement exitMessage;



    public void passwordAndSave(String pass, String confPass){
        passwordW.sendKeys(pass);
        confPassW.sendKeys(confPass);

    }


    public void setSelectRole(String str){
        Select select=new Select(selectRole);
        select.selectByVisibleText(str);

    }

    public void employee(String empName,String userN){
        employeeName.sendKeys(empName);
        userName.sendKeys(userN);

    }
    public void setStatus(String str){
        Select select=new Select(status);
        select.selectByVisibleText(str);
    }
}
