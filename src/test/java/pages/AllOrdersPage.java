package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AllOrdersPage {



    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;

    @FindBy(className = "btnDeleteSelected")
    public WebElement deleteButton;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement message;

    @FindBy (id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy (id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(linkText = "View all products")
    public WebElement allProductsLink;

    public void checkAllCheckboxes(){
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
