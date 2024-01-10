package ActionItems;

import Day10_12_11_2023.Reusable_Method;
import Day13_12_19_2023.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class actionItem_7 extends TestParent {
    @Test
    public void tc001_fid() throws InterruptedException {
        //navigate to fidelis care
        driver.navigate().to("https://www.fideliscare.org/");
        //click on the search menu
        Reusable_Method.clickByIndexMethod(driver, "//*[@class='tool dropdown search']", 0, "Search Button");
        Thread.sleep(1000);
        //now search the box
        Reusable_Method.clickByIndexMethod(driver, "//*[@class='form-control search-input']", 0, "Search box");
        //add in the words
        Reusable_Method.sendKeys(driver, "//*[@class='form-control search-input']", "Get Dental Coverage", "Dental coverage");
        //click on the search button
        Reusable_Method.clickByIndexMethod(driver, "//*[@class= 'btn btn-primary btn-search']", 0, "Search Button");
        Reusable_Method.captureText(driver, "//*[@class='gsc-control-cse gsc-control-cse-en']", "Search Result");
        //create a string to split
        String searchNumber = new String(Reusable_Method.captureText(driver, "//*[@class='gsc-result-info']", "Search Number"));
        String[] searchNumberSplit = searchNumber.split(" ");
        System.out.println("The search number is " + searchNumberSplit[1]);
        Reusable_Method.clickByIndexMethod(driver, "//*[text()= 'Get Dental Coverage']", 0, "Get Dental Coverage");
    Thread.sleep(3000);

    }//end of test
    //add depends on method
    @Test (dependsOnMethods = "tc001_fid")
    public void tc002_switchingTabs() throws InterruptedException {
        //switch tabs
        Reusable_Method.switchingTabsMethod(driver,1,"Second tab");
        //add in values for the text box
        Reusable_Method.sendKeysByIndexMethod(driver,"//*[@id='firstName']",0,"Zach","First Name Field");
        Reusable_Method.sendKeysByIndexMethod(driver,"//*[@id='lastName']",0,"King","last Name Field");
        Reusable_Method.sendKeysByIndexMethod(driver,"//*[@id='zipCode']",0,"12490","zipCodeField");
        //use the select method
        Reusable_Method.selectByVisibleText(driver,"//*[@id='county']","Ulster","County Field");
        Reusable_Method.sendKeysByIndexMethod(driver,"//*[@id='phoneNumber']",0,"7188021983","Phone Number Field");
        Reusable_Method.sendKeysByIndexMethod(driver,"//*[@id='email']",0,"JmeahQA@Gmail.com","Email Field");
        //add the mouse action, have tried so many xpaths!
        Reusable_Method.mouseActionsClickMethod(driver,"//*[(text()='By checking this box you are agreeing to have a Fidelis Care representative contact you about health insurance.')]","Contact Me Box");
        Reusable_Method.clickByIndexMethod(driver,"//*[@type='submit']",0,"Contact Me Button");
        //create a string
        String postSubmissionMessage = new String(Reusable_Method.captureText(driver,"//*[@class='alert alert-success']","Thank You Message"));
        System.out.println(postSubmissionMessage);
        driver.close();
    }//end of test

    @Test(dependsOnMethods = "tc001_fid")
    public void tc3_Login()throws InterruptedException{
        //switch tabs
        Reusable_Method.switchingTabsMethod(driver,0,"Main Page Tab");
        //click the login button
        Reusable_Method.clickByIndexMethod(driver,"//*[contains(text(),'Login')]",0,"Login Button");
        Reusable_Method.clickByIndexMethod(driver,"//*[text()= 'Member Online Portal']",0,"Member Online Portal Button");
        Thread.sleep(1000);
        //switch tabs
        Reusable_Method.switchingTabsMethod(driver,1,"Member Portal Tab");
        //print it out
        String helpfulHintsMessage = new String(Reusable_Method.captureText(driver,"//*[@class='flex flex-column p-8']","Helpful Hints Box"));
        System.out.println(helpfulHintsMessage);
        driver.close();
    }//end of test
}//end of class






//end of test
//end of class
