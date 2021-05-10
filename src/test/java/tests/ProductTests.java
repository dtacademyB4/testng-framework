package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.ListOfProductsPage;
import pages.LoginPage;
import utilities.BrowserUtilities;

import java.util.Arrays;
import java.util.List;

public class ProductTests extends TestBase{


    @BeforeMethod (alwaysRun = true)
    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        new AllOrdersPage().allProductsLink.click();
    }


    @Test (groups = "smoke")
    public void verifyColumnNames(){
        // Column names should be Product name, Price, Discount

        List<String> expectedList = Arrays.asList("Product name", "Price", "Discount");

        ListOfProductsPage listOfProductsPage = new ListOfProductsPage();

        List<String> actualList = BrowserUtilities.getElementsText(listOfProductsPage.products);

        Assert.assertEquals(actualList, expectedList);

    }


}
