package Personal_Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ac4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chrome driver
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.ups.com/us/en/Home.page");
        Thread.sleep(2000);
        //click on ups link
        driver.findElements(By.xpath("//*[@class= 'ups-link']")).get(0).click();
       //class="ups-link"
        Thread.sleep(2000);
        //create arraylist for the tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the first page
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Shipping']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Create a Shipment']")).click();
        Thread.sleep(2000);
        WebElement us = driver.findElement(By.xpath("//*[@id= 'origin-cac_country']"));
        Thread.sleep(2000);
        us.click();
        Thread.sleep(3000);
        Select usD = new Select(us);
        usD.selectByVisibleText("Puerto Rico");
        Thread.sleep(2000);
        us.click();
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Newsroom']")).click();
        Thread.sleep(2000);
        driver.quit();
    }//end of main
}//end of class
