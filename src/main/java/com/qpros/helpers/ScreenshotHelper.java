package com.qpros.helpers;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class ScreenshotHelper {

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Example usage:         ScreenshotHelper.takeSnapShot(driver, "C:\\Users\\HamzahAlrawi\\Desktop\\MyImage.png");
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

}