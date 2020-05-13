package com.qpros.helpers;

import com.qpros.common.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ActionsHelper extends Base {
    protected static Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
    public static WebDriverWait wait;

    public static void waitForSeconds(Integer timeWait) {
        driver.manage().timeouts().implicitlyWait(timeWait, TimeUnit.SECONDS);
    }

    public static boolean waitVisibility(WebElement element, int time) {
        boolean isElementPresent = false;
        try {
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOf(element));
            isElementPresent = element.isDisplayed();
        } catch (Exception e) {
        }
        return isElementPresent;

    }

    public static void selectByIndex(WebElement element, int index) {
        try {
            org.openqa.selenium.support.ui.Select make = new org.openqa.selenium.support.ui.Select(element);
            make.selectByIndex(index);
        } catch (Exception e) {
            throw new RuntimeException("Element is: " + element);

        }
    }

    public static void selectByValue(WebElement element, String value) {
        try {
            org.openqa.selenium.support.ui.Select make = new org.openqa.selenium.support.ui.Select(element);
            make.selectByValue(value);
        } catch (Exception e) {
            throw new RuntimeException("Element is: " + element);

        }
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void safeJavaScriptClick(WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                LOGGER.info("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            LOGGER.info("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            LOGGER.info("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            LOGGER.info("Unable to click on element " + e.getStackTrace());
        }
    }

    public String getImagePath(String imageName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/images/" + imageName;
        return path;
    }

    public String getXMLPath(String xmlFileName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/xmlfiles/" + xmlFileName;
        return path;
    }

}
