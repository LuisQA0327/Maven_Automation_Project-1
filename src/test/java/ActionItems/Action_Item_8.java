package ActionItems;

import Day13_12_19_2023.TestParent;
import Day14_01_02_2023.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Action_Item_8 extends TestParent {
 @Test
 public void tc001_verifyFidelisTitle() throws InterruptedException {
     driver.navigate().to("https://www.fideliscare.org/");
     String actualTitle = driver.getTitle();
     //store the expected title
     String expectedTitle = "Home";
     Assert.assertEquals(actualTitle, expectedTitle);
 }//end of test1

  @Test
  public void tc002_findAdoctor() throws InterruptedException {
      driver.navigate().to("https://www.fideliscare.org/");
      ReusableMethods_Loggers.clickMethodWithoutIndexV(driver, "//*[text()= 'Member']","member", logger);
      ReusableMethods_Loggers.clickMethod(driver,"//*[text() = 'Members']", logger, "Members");
      ReusableMethods_Loggers.scrollToElementByXPath(driver, "//*[@class ='card-icon fal fa-binoculars fa-show']","Find a Doctor", logger);
      ReusableMethods_Loggers.clickMethodWithoutIndexV(driver, "//*[@class= 'btn btn-outline-primary btn-show link-external']", "Link", logger);
      // ReusableMethods_Loggers.clickElementWithJs(driver, "//*[@id='searchLocation']","location", logger);
      //ReusableMethods_Loggers.sendKeys(driver,"//*[@class='form-control aa-input']", "07083", "zip code", logger);
 }//end of test
    @Test
    public void tc003_SwitchingTabs(){
        driver.navigate().to("https://www.fideliscare.org/");
        ReusableMethods_Loggers.scrollToElementByXPath(driver, "//*[text()= '24/7 Telemedicine Visits']", "visits", logger);
        ReusableMethods_Loggers.clickByIndexMethod(driver,"//*[text() = 'Make a Payment']",0, "payment", logger);
        ReusableMethods_Loggers.clickMethodWithoutIndexV(driver, "//*[contains(text(), 'Make Your First Payment')]", "payment", logger);
        ReusableMethods_Loggers.switchingTabsMethod(driver, 0, "first tab", logger);
        ReusableMethods_Loggers.clickByIndexMethodV(driver, "//*[@class='btn btn-outline-primary btn-show link-external']", 1, "pay", logger);
        ReusableMethods_Loggers.switchingTabsMethod(driver, 1, "third tab", logger);
 }//end of test
    @Test
    public void tc004_fillindata() throws InterruptedException {
        driver.navigate().to("https://www.fideliscare.org/");
        ReusableMethods_Loggers.scrollToElementByXPath(driver, "//*[text()= '24/7 Telemedicine Visits']", "visits", logger);
        ReusableMethods_Loggers.clickByIndexMethod(driver,"//*[text() = 'Make a Payment']",0, "payment", logger);
        ReusableMethods_Loggers.clickMethodWithoutIndexV(driver, "//*[contains(text(), 'Make Your First Payment')]", "payment", logger);
        ReusableMethods_Loggers.switchingTabsMethod(driver, 1, "tab", logger);

       ReusableMethods_Loggers.clickbyelementclickable(driver, "//*[@id='FirstName']","name", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='FirstName']", "Zach", "name", logger);
        ReusableMethods_Loggers.clickbyelementclickable(driver, "//*[@id='LastName']","last", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='LastName']", "Martin", "name", logger);
        ReusableMethods_Loggers.clickbyelementclickable(driver, "//*[@id='Email']","email", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='Email']", "Zachm@gmail.com", "name", logger);
        ReusableMethods_Loggers.clickbyelementclickable(driver, "//*[@id='DOB']","dob", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='DOB']", "11101993", "name", logger);
        ReusableMethods_Loggers.clickbyelementclickable(driver, "//*[@id='TotalMonthlyPremium']","premium", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='TotalMonthlyPremium']", "200", "name", logger);


    }//end of test
    @Test
    public void tc_getCovered() throws InterruptedException {
        driver.navigate().to("https://www.fideliscare.org/");
        ReusableMethods_Loggers.clickMethodWithoutIndexV(driver, "//*[@class='btn ng-binding btn-primary']", "Get coverage", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='firstName']", "Josh", "first name", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='lastName']", "Beth", "last name", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='zipCode']", "11434", "zip", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='phoneNumber']", "9082487120", "number", logger);
        ReusableMethods_Loggers.sendKeys(driver, "//*[@id='email']", "Joshb@gmail.com", "email", logger);
        ReusableMethods_Loggers.clickByIndexMethod(driver, "//*[@for='contactMe']", 1, "click", logger);
        boolean contactMe = driver.findElement(By.xpath("//*[@for='contactMe']")).isSelected();
        Thread.sleep(2000);
        //Assert.assertTrue(contactMe);
    }//end of test


}//end of class
