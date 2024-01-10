package Day7_11_28_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElements_Arraylist {
    public static void main(String[] args) {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare the chrome options
        ChromeOptions options = new ChromeOptions();
        //add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //run in headless mode (runs in the background)
//        options.addArguments("headless");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com/");
        ArrayList<WebElement> yahooHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'_yb_yc')]")));
        //print out hw many headers there are
        System.out.println("There are " + yahooHeaders.size() + "yahoo headers");
        for (int i = 0; i < yahooHeaders.size(); i++) {
        System.out.println("Yahoo Headers are " + yahooHeaders.get(i).getText());
        }//end of for loop
        //quit the browser
        driver.quit();
    }//end of main
}//end of class