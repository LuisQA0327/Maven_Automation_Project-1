package Day14_01_02_2023;

import Day10_12_11_2023.Reusable_Method;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Yahoo_Extent_Report {
    //declare webdriver
    WebDriver driver;
    //declare extentreports variable
    ExtentReports reports;
    //declare logger variable
    ExtentTest logger;
    @BeforeSuite
    public void setUpChromeDriver() {
        //driver setup
        driver = Reusable_Method.setUpDriver();
        //set up report path
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html", true);
    }//end of before suite
    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        logger = reports.startTest("tc001_verifyStaySignedInIsChecked");
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Method.clickMethod(driver, "//*[text() = 'Sign in']", "Sign In Button");
        //use logger info to indicate that user is clicking
        logger.log(LogStatus.INFO, "Successfully clicked on the sign in button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if its true
        if (isStaySignedInChecked == true) {
            logger.log(LogStatus.PASS, "The checkbox is checked " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked " + isStaySignedInChecked);
        }
    }//end of tc 01
    @AfterSuite
    public void quitDriver() {
        driver.quit();
        //needed to create the html report after test execution
        reports.flush();
    }//end of after suite
}//end of class
