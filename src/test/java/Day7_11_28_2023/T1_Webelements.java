package Day7_11_28_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_Webelements {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //declare the chrome options
        ChromeOptions options = new ChromeOptions();
        //add some options for chrome options
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //run in headless mode (runs in the background)
//        options.addArguments("headless");
        //define the web driver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgage calculator
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //store the home value into the web element variable
        WebElement homeValue = driver.findElement(By.xpath("//*[@id = 'homeval']"));
        //clear the home value field
        homeValue.clear();
        //type in 90000 in the home value field
        homeValue.sendKeys("90000");
        //wait 3 seconds
        Thread.sleep(2000);
        //quit the browser
        driver.quit();
    }//end of main
}//end of class
