package Day9_12_05_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_TryCatch {
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
        try {
            //enter a home value
            WebElement homeValue = driver.findElement(By.xpath("//*[@id = 'homevall']"));
            //clear the field
            homeValue.clear();
            //enter a value of 950000
            homeValue.sendKeys("950000");
        } catch (Exception e) {
            System.out.println("Unable to enter home value for reason " + e);
        }//end of homevalue try catch
        try {
            //enter a downpayment value
            WebElement dpValue = driver.findElement(By.xpath("//*[@id = 'downpaymentt']"));
            //clear the field
            dpValue.clear();
            //enter a value of 950000
            dpValue.sendKeys("200000");
        }catch (Exception e){
            System.out.println("Unable to enter downpayment value for reason " + e);
        }//end of downpayment try catch
        Thread.sleep(2000);
        //quit the browser
        driver.quit();
    }//end of main
}//end of class
