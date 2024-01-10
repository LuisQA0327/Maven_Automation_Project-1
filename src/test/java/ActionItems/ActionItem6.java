/*package ActionItems;

import Day10_12_11_2023.Reusable_Method;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import javax.xml.xpath.XPath;
import java.sql.Driver;
import java.util.ArrayList;*/

/*public class ActionItem6 {
   /* public static void main(String[] args) {
        WebDriver driver = Reusable_Method.setUpDriver();

        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("07083");
        zipcode.add("07208");
        zipcode.add("07087");
        for (int i =0; i < zipcode.size(); i++) {
            driver.navigate().to("https://www.weightwatchers.com/us/");
            Reusable_Method.clickMethod(driver, "//*[@icon= 'location']", "Find a Workshop");
            Reusable_Method.clickMethod(driver, "//*[@id = 'location-search']", "Search Bar");
            Reusable_Method.clearMethod(driver, "//*[@id = 'location-search']", 0, "clear search");
            //Reusable_Method.sendKeys(driver, "//*[@id = 'location-search']", zipcode.get(i), 0, "search Field");
            Reusable_Method.clickMethod(driver, "//*[@class='rightArrow-daPRP']", "sending zip");
            if (i == 0) {
                Reusable_Method.clickByIndexMethod(driver, "//*[contains(@class,'linkUnderline-1_h4g')]", 1, "studio link");
            } else if (i == 1) {
                Reusable_Method.clickByIndexMethod(driver, "//*[contains(@class,'linkUnderline-1_h4g')]", 2, "studio link");
            } else if (i == 2) {
                Reusable_Method.clickByIndexMethod(driver, "//*[contains(@class,'linkUnderline-1_h4g')]", 0, "studio link");
            } //end of if condition
            String address = Reusable_Method.captureText(driver, "//*[@class = 'address-2PZwW']", "address");
            System.out.println(address);
            Reusable_Method.scrollIntoMethod(driver, "//*[contains(@id, 'studioW')]", "Studio Hours");
            String studioHours = Reusable_Method.captureText(driver, "//*[contains(@id, 'studioW')]", "Studio Times");
            System.out.println(studioHours);
        }//end of loop
        driver.quit();
    }//end of main
}//emd of class*/
