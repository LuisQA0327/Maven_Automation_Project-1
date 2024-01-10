package Day7_11_28_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class t3_Scroll {
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
        driver.navigate().to("https://www.mlcalc.com/");
        //declare javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down 800 pixels (based on your need you can adjust the number by + or - 200)
        jse.executeScript("scroll(0,1500)");
        //wait 2 seconds
        Thread.sleep(2000);
        //scroll down 400 pixels
        jse.executeScript("scroll(0,-400)");
        //wait 2 seconds
        Thread.sleep(2000);
        //store the calculate button in webelement variable
        WebElement calcButton = driver.findElement(By.xpath("//*[@value = 'Calculate']"));
        //scroll in element
        jse.executeScript("arguments[0].scrollIntoView(true);" , calcButton);
        //wait two seconds
        Thread.sleep(2000);
        driver.quit();
    }//end of main
}//end of class

