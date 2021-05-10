package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;

    protected static ExtentReports reporter;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentTest logger;
    protected static int count = 1;




    @BeforeSuite (alwaysRun = true)
    public void setupSuite(){
        reporter = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/extentReports/index.html";
        htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setReportName("WEB ORDERS AUTOMATION TESTS");
        reporter.attachReporter(htmlReporter);

    }


    @BeforeMethod (alwaysRun = true)
    @Parameters ("browser")
    public void setUpMethod(@Optional String browser){

        driver = Driver.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));

        logger = reporter.createTest("TESTCASE " + count);
        count++;
    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod( ITestResult testResult){
        if(testResult.getStatus() == testResult.SUCCESS){
            logger.pass("TEST PASSED: " + testResult.getName() );
        }else if(testResult.getStatus() == testResult.FAILURE){
            logger.fail("TEST FAILED: " + testResult.getName());
            logger.fail("EXCEPTION: " + testResult.getThrowable());

            String path = BrowserUtilities.getScreenshot("Failed");
            logger.addScreenCaptureFromPath(path);
        }else if(testResult.getStatus() == testResult.SKIP){
            logger.skip("TEST SKIPPED: " + testResult.getName() );
        }



        Driver.quitDriver();
    }


    @AfterSuite
    public void teardownSuite(){
        reporter.flush();
    }

}
