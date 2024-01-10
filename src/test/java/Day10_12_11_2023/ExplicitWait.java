package Day10_12_11_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //set chromeoption for preset of arguments for driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chromedriver
        WebDriver driver = new ChromeDriver(options);
        //declare your explicit wait statement here
        WebDriverWait wait = new WebDriverWait(driver,5);
        //declare your implicit wait statement here
        driver.manage().timeouts().wait(5, TimeUnit.SECONDS.ordinal());

          //navigate to google site
        driver.navigate().to("https://www.google.com");
        //search for a car
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='q']"))).sendKeys("cars");
        }catch (Exception e){
            System.out.println("Unable to enter value on search field: " + e);
        }//end of search exception

        //submit
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='btnK']"))).submit();
        }catch (Exception e){
            System.out.println("Unable to submit on search button: " + e);
        }//end of submit exception
//capture the result and print it
        try{
            String result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='result-stats']"))).getText();
            System.out.println("Result is: " + result);
        }catch (Exception e){
            System.out.println("Unable to capture search result: " + e);
        }//end of search result exception

    }//end of main
}//end of class
