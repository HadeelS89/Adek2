package com.qpros.helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static com.qpros.common.Base.driver;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class FileHelper {


    public void uploadFile(String inputXpath, String fileDirectory, String uploadButtonXpath, String conditionXpath) throws InterruptedException {
        driver.findElement(By.xpath(inputXpath)).click();
        WebElement addFile;
        //addFile = driver.findElement(By.linkText("Upload a File...")).click();

        //addFile.sendKeys(fileDirectory);// For setting a profile picture

        driver.findElement(By.linkText("Set new profile picture")).click();
        driver.wait(2000); // Image name can be of your choice

        if (driver.findElement(By.xpath(conditionXpath)).isDisplayed()) {
            assertTrue(true, "File is Uploaded");
        } else {
            fail("File not Uploaded");
        }
    }

}

