package Day10_12_11_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //set chromeoption for preset of arguments for driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chromedriver
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.usps.com/");
        Thread.sleep(1000);
        Actions mouseAction = new Actions(driver);
        //hover to quick tools module
        WebElement quickTool = driver.findElement(By.xpath("//*[text()='Quick Tools']"));

        mouseAction.moveToElement(quickTool).perform();

        WebElement trackPackage = driver.findElement(By.xpath("//*[text() = 'Track a Package']"));

        mouseAction.moveToElement(trackPackage).click().perform();

        Thread.sleep(3000);

        WebElement searchField = driver.findElement(By.xpath("//*[@id='tracking-input']"));

        mouseAction.moveToElement(searchField).click().sendKeys("1181818181818818188").perform();

    }//end of main
}//end of class
