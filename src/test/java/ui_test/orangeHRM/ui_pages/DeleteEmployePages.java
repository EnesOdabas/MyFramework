package ui_test.orangeHRM.ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteEmployePages {
    public DeleteEmployePages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//td/input['ohrmList_chkSelectRecord_45']")
    public WebElement checkBox;
    @FindBy(id = "btnDelete")
    public WebElement deleteButton;
    @FindBy(id = "dialogDeleteBtn")
    public WebElement alert;
    @FindBy(xpath = "//td[@colspan='5']")
    public WebElement noRecordsMessage;
    @FindBy(xpath = "//li/input[@name='searchSystemUser[userName]']")
    public WebElement searchField;
    @FindBy(xpath = "//div[@id='deleteConfModal']//h3")
    public WebElement popupDisplayed;
}
