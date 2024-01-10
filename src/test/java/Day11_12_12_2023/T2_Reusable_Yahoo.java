package Day11_12_12_2023;


import Day10_12_11_2023.Reusable_Method;
import org.openqa.selenium.WebDriver;

public class T2_Reusable_Yahoo {
    public static void main(String[] args) {
        //instantiate the driver
        WebDriver driver = Reusable_Method.setUpDriver();
        //navigate to metlife
        driver.navigate().to("https://www.yahoo.com/");
        //click on the sports menu (third tab, index 2)
        Reusable_Method.clickByIndexMethod(driver, "//*[contains(@class,'_yb_q22uj')]", 2, "yahoo headers");
        //quit driver
        driver.quit();
    }
}