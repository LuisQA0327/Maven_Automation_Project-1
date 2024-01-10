package Day8_12_04_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T2_SelectBy_XpathText {
    public static void main(String[] args) throws InterruptedException {
        //declare web driver manager to set up chrome driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.mortgagecalculator.org");
        //wait a few seconds
        Thread.sleep(2000);
        //clear and enter the home value
        WebElement homeVal = driver.findElement(By.xpath("//*[@id = 'homeval']"));
        homeVal.clear();
        homeVal.sendKeys("45000");
        //clear and enter the down payment
        WebElement downPay = driver.findElement(By.xpath("//*[@id = 'downpayment']"));
        downPay.clear();
        downPay.sendKeys("9000");
        //click on dropdown
        driver.findElement(By.xpath("//*[@name= 'param[start_month]']")).click();
        //click by xpath visible text for January
        driver.findElement(By.xpath("//*[text()= 'Jan']")).click();
        //select january from the month dropdown
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()= 'Dec']")).click();
        //select january from the month dropdown
        driver.quit();
    }//end of main
}//end of class
