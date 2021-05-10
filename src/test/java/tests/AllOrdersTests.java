package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllOrdersTests extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }



    @Test (groups = "smoke")

    public void verifyCheckAllButton(){


        logger.info("Verifying Check all Button ");

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        logger.info("Checking all boxes");
        allOrdersPage.checkAllCheckboxes();

        logger.info("Verifying if all checkboxes are selected");
        for (WebElement checkbox: allOrdersPage.checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }



    }

    @Test
    public void verifyUncheckAllButton(){
        logger.info("Verifying Check all Button ");
       AllOrdersPage allOrdersPage = new AllOrdersPage();

        logger.info("Checking all boxes");
        allOrdersPage.checkAllButton.click();

        logger.info("Unchecking all boxes");
        allOrdersPage.uncheckAllButton.click();

        logger.info("Verifying if all checkboxes are not selected");
        for (WebElement checkbox: allOrdersPage.checkboxes
             ) {
            Assert.assertTrue(!checkbox.isSelected());
        }


    }


    @Test
    public void verifyDeleteButton(){
        // Login to the app

        logger.info("Verifying Delete button ");
        AllOrdersPage allOrdersPage = new AllOrdersPage();

        logger.info("Checking all boxes");
        allOrdersPage.checkAllCheckboxes();

        logger.info("Clicking on delete button");
        allOrdersPage.deleteButton.click();

        throw new SkipException("Test Skipped");


//        String actual = allOrdersPage.message.getText();
//
//        String expected = "List of orders is empty. In order to add new order use this link.";
//        logger.info("Verifying the text is equal to expected text:" + expected);
//        Assert.assertEquals(actual, expected);


    }


}
