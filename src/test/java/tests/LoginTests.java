package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{






    @Test (groups = "smoke")
    public void positiveLogin(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("username"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test
    public void positiveLoginMethod(){

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertTrue(driver.getTitle().equals("Web Orders"));

    }

    @Test
    public void negativeTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.usernameBox.sendKeys("WrongUsername");
        loginPage.passwordBox.sendKeys("wrongPass");
        loginPage.loginButton.click();

        String expectedMessage = "Invalid Login or Password.";

        assertTrue(loginPage.errorMessage.isDisplayed());
        assertEquals(loginPage.errorMessage.getText(), expectedMessage);
    }














}
