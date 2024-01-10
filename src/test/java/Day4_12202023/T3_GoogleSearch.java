package Day4_12202023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver
        WebDriver driver = new ChromeDriver();
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //maximize the driver
        driver.manage().window().maximize();
        //wait for 3 second
        Thread.sleep(3000);
        //quit the browser
        driver.quit();
    }//end of main
}//end of main

