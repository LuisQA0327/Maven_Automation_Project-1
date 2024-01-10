package Day5_11_21_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class T1_GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
//setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //define the webdriver
        WebDriver driver = new ChromeDriver();
        //navigate to google webpage
        driver.navigate().to("https://www.google.com");
        //maximize the window
        driver.manage().window().maximize();
        //search for cars (using relative x path)
        driver.findElement(By.xpath("//*[@name= 'q']")).sendKeys("cars");
//search for cars (using absolute xpath)
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cars");
        //hit submit to google search button
        driver.findElement(By.xpath("//*[@name= 'btnK']")).submit();
        //slow down by 2 seconds
        Thread.sleep(2000);
        //store the results in a string variable
        String searchResult = driver.findElement(By.xpath("//*[@id= 'result-stats']")).getText();
        //print out the result to the console
        System.out.println("Search result is " + searchResult);
        //split the search result using split command
        String[] searchResultArray = searchResult.split(" ");
        //print out only the search result number
        System.out.println("Search result number is" + searchResultArray[1]);
    }//end of main
}
