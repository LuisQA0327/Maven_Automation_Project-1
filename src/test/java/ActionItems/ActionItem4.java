package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem4 {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //create arraylist for zipcode
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("07083");
        zipcode.add("07208");
        zipcode.add("07087");
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
            for (int i =0; i < zipcode.size(); i++){
            //navigate to weight watchers
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            Thread.sleep(2000);
            //click on the find a workshop link
            driver.findElement(By.xpath("//*[text() = 'Find a Workshop']")).click();
            //click on the in-person
            driver.findElement(By.xpath("//*[text()='In-Person']")).click();
            Thread.sleep(2000);
            WebElement search = driver.findElement(By.xpath("//*[@id = 'location-search']"));
            search.clear();
            search.sendKeys(zipcode.get(i));
            search.submit();
            Thread.sleep(2000);
            ArrayList<WebElement> studio = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline-1_h4g')]")));
            if (i == 0) {
              studio.get(1).click();
            } else if (i == 1) {
                studio.get(2).click();
            } else if (i == 2) {
                studio.get(0).click();
            } //end of if condition
            Thread.sleep(2000);
            String address = driver.findElement(By.xpath("//*[@class = 'address-2PZwW']")).getText();
            System.out.println("The address is " + address);
            //add java script executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            //add web element for the schedule
            WebElement upComing = driver.findElement(By.xpath("//*[@class = 'title-bEfSM']"));
            //scroll in element  class="title-bEfSM"
                jse.executeScript("arguments[0].scrollIntoView(true);" , upComing);

            WebElement studioWorkshops = driver.findElement(By.xpath("//*[contains(@id, 'studioW')]"));
            System.out.println(" " + studioWorkshops.getText());
            Thread.sleep(10000);
        } //end of loop
        //quit the browser
        driver.quit();
    }//end of main
}//end of class
