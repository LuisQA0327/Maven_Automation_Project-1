package Day10_12_11_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Method {
    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }//end of click method

    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
        }
    }//end of submit method

    public static String captureText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
        }
        return result;
    }//end of capture text method

    public static WebDriver setUpDriver() {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options variable
        ChromeOptions options = new ChromeOptions();
        //maximize for windows
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //return a driver instance
        return driver;
    }//end of setupdriver method

    //create a click method to click on any web element by index
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }
    }//end of click by index method

    public static void sendKeys(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
        }// end of try catch
    }//end of send keys method

    public static void sendKeysByIndexMethod(WebDriver driver, String xpath, int index, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
        }// end of try catch
    }//end of send keys method

    public static void clearMethod(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).clear();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
        }//end of try catch
    }

    public static void scrollIntoMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath(xpath));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + e);
        }//end of try catch
    }

    public static void selectByVisibleText(WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Unable to select " + visibleText + " from " + elementName + ": " + e);
        }//end of catch
    }//end of select

    public static void mouseActionsClickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }
    }//end of mouse actions method

    public static void switchingTabsMethod(WebDriver driver, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
        } catch (Exception e) {
            System.out.println("Unable to Switch Tabs" + elementName);
        }//end of try catch
    }//end of switching to tabs method

    public static void mouseActionsMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).perform();
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
        }//end of catch
    }//end of second mouse action
}//end of class



