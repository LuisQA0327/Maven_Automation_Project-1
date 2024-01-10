package Day11_12_12_2023;

import Day10_12_11_2023.Reusable_Method;
import org.openqa.selenium.WebDriver;

public class T1_Reusable_Metlife {
    public static void main(String[] args) {
        //instantiate the driver
        WebDriver driver = Reusable_Method.setUpDriver();
        //navigate to metlife
        driver.navigate().to("https://www.metlife.com/");
        //click on the solutions tab
        Reusable_Method.clickMethod(driver, "//*[@aria-controls = 'section1']", "Solutions Tab");
        //click on the dental menu
        Reusable_Method.clickMethod(driver, "//*[text() = 'Dental']", "Solutions Tab");
        //quit the driver
        driver.quit();
    }//end of main
}//end of class
