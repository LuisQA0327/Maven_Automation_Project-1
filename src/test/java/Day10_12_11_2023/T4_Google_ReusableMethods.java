package Day10_12_11_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_Google_ReusableMethods {
    public static void main(String[] args) {
//declare webdrivermanager to set up the chromedriver
        WebDriverManager.chromedriver().setup();
        //set chromeoptions for preset of arguments for the driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        //declare your web driver and pass the options variable inside the chromedriver
        WebDriver irfDriver = new ChromeDriver(options);
        //navigate to google site
        irfDriver.navigate().to("https://www.google.com");

        //click on Google Search button
        Reusable_Method.submitMethod(irfDriver, "//*[@name='btnK']", "Search Button");

        Reusable_Method.clickMethod(irfDriver, "//*[text()='About']", "About Link");




}//end of class
}//end of class
//public static void main{ args { string xpaths,