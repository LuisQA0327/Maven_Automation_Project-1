package ActionItems;

import Day3_11_14_2023.T1_Whileloop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ActionItem3 {
    public static void main(String[] args) throws InterruptedException {
        //set up webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //start the arraylist
        ArrayList<String> sports = new ArrayList<>();
        //adding values for variables
        sports.add("volleyball");
        sports.add("basketball");
        sports.add("tennis");
        sports.add("soccer");
        sports.add("baseball");
        //for or while loop
        int i = 0;
        while (i < sports.size()) {
            //go to bing.com
            driver.navigate().to("https://www.bing.com/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(sports.get(i));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class = 'gray70_fill_sb']")).submit();
            Thread.sleep(2000);
            String searchResult = driver.findElement(By.xpath("//*[@class = 'sb_count']")).getText();
            String[] splitsearchResult = searchResult.split(" ");
            System.out.println("Search result number is " + splitsearchResult[1]);
            i++;
        }//end of while loop
        driver.quit();
    }//end of main method
}//end of action item

