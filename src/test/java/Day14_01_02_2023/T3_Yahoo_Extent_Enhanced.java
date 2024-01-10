package Day14_01_02_2023;

import Day13_12_19_2023.TestParent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_Yahoo_Extent_Enhanced extends TestParent {

    @Test
    public void tc001_verifyStaySignedInIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        ReusableMethods_Loggers.clickMethod(driver, "//*[text() = 'Sign in']", logger, "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if condition is true
        ReusableMethods_Loggers.isConditionTrue(isStaySignedInChecked, logger);
    }//end of tc 01
}//end of class
