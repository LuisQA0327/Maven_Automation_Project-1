package Day14_01_02_2023;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethods_Loggers {
    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL,"unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of click method
    public static void isConditionTrue(boolean bool, ExtentTest logger){
        if(bool == true) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        }else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }//end of isConditionTrue method
    public static void captureHrefAndClick(WebDriver driver, String xpath, int Index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement newMailingLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            String hrefAttributeValue = newMailingLink.getAttribute("href");
            System.out.println("Href Attribute Value: " + hrefAttributeValue);
            openNewTab(driver);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(Index));
            driver.get(hrefAttributeValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture href and Open tab" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }
    public static void openNewTab(WebDriver driver) {
        // Execute JavaScript to open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }//end of click by index method

    public static void sendKeys(WebDriver driver, String xpath, String userValue, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }// end of try catch
    }//end of send keys method

    public static void sendKeysByIndexMethod(WebDriver driver, String xpath, int index, String userValue, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }// end of try catch
    }//end of send keys method

    public static void clearMethod(WebDriver driver, String xpath, int index, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).clear();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
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

    public static void selectByVisibleText(WebDriver driver, String xpath, String visibleText, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select " + visibleText + " from " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }//end of catch
    }//end of select

    public static void mouseActionsClickMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).click().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of mouse actions method

    public static void switchingTabsMethod(WebDriver driver, int index, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to Switch Tabs" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }//end of try catch
    }//end of switching to tabs method

    public static void mouseActionsMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            Actions mouseAction = new Actions(driver);
            WebElement quickTool = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(quickTool).perform();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to mouseAction to" + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }//end of catch
    }//end of second mouse action
    public static void clickMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of click method

    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }//end of submit method

    public static String captureText(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            System.out.println(result);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
        return result;
    }//end of capture text method
    public static void clickByIndexMethodV(WebDriver driver, String xpath, int index, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }//end of click
    public static void clickMethodWithoutIndexClickable(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of click
    public static void clickMethodWithoutIndexP(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of presence

    public static void clickMethodWithoutIndexV(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of vis
    public static void clickMethodB(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
            getScreenShot(driver, elementName, logger);
        }
    }//end of without B
    public static void clickbyelementclickable(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }//end of click
    public static void scrollToElementByXPath(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll to element " + e);
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }//end of catch
    }//end of method

    public static void scrollByPixel(WebDriver driver, String xValue, String yValue, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + xValue + "," + yValue + ")");
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixels ");
            logger.log(LogStatus.FAIL, "unable to click on " + elementName);
        }
    }//end of method
        public static void hoverActionsMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                Actions mouseAction = new Actions(driver);
                WebElement quickTool = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                mouseAction.moveToElement(quickTool).perform();
                logger.log(LogStatus.PASS, "Successfully hovered " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to mouseAction to" + elementName);
                logger.log(LogStatus.FAIL, "Failed to hovered " + elementName);
            }
}//end of method
    //create a verify title method using titleContains
    public static void  verifyTitleContains(WebDriver driver, String  expectedTitle, ExtentTest logger){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            logger.log(LogStatus.PASS,"Successfully verified title: " + expectedTitle);
        } else {
            logger.log(LogStatus.FAIL,"Unable to verify title: " + expectedTitle);
        }//end of if else

    }//end of verifyTitleContains
    public static void clickElementWithJs(WebDriver driver, String xpath, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to click element using JavascriptExecutor");
        }
    }//end of test
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS, "Successfully submitted on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "unable to submit on " + elementName);
            getScreenShot(driver, elementName, logger);
        }//end of try catch
    }//end of submit method
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
}//end of class
