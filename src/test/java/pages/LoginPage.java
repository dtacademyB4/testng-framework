package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);  // PageFactory class is used to initialize the variables of the page class
    }

     //Page classes can contain variables and methods that deal with actions on the UI

    @FindBy (id = "ctl00_MainContent_username")
    public WebElement usernameBox;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorMessage;



    public void login(){
        usernameBox.sendKeys(ConfigReader.getProperty("username"));
        passwordBox.sendKeys(ConfigReader.getProperty("password"));
        loginButton.click();
    }


}
