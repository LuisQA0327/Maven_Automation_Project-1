package Day15_01_08_2024;

import Day10_12_11_2023.Reusable_Method;
import Day13_12_19_2023.TestParent;
import Day14_01_02_2023.ReusableMethods_Loggers;
import org.testng.annotations.Test;

public class T1_Google_screenshot extends TestParent {
    @Test
    public void searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        ReusableMethods_Loggers.sendKeys(driver, "//*[@name= 'q']", "BMW", "car", logger);
        //hit submit on the google search button
        ReusableMethods_Loggers.submitMethod(driver, "//*[@name= 'btnK']", logger, "Submit");
        Thread.sleep(1000);
    }//end of test
    //giancarlo built like the 
}//end of class
