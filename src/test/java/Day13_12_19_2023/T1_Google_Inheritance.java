package Day13_12_19_2023;

import Day10_12_11_2023.Reusable_Method;
import org.testng.annotations.Test;

public class T1_Google_Inheritance extends TestParent {
    @Test(priority = 1)
    public void searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Method.sendKeys(driver,"//*[@name= 'q']","BMW","SearchField");
        //hit submit on the google search button
        Reusable_Method.submitMethod(driver,"//*[@name= 'btnK']","Submit");
        Thread.sleep(1000);
    }//end of test case 1
    @Test(priority = 2)
    public void captureSearchResult(){
        //store the search result into a string variable
        String result = Reusable_Method.captureText(driver,"//*[@id = 'result-stats']","SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
    }//end of test case 2
}//end of class
