package com.qpros.common;

import com.fasterxml.jackson.core.JsonParseException;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarLog;
import de.sstoehr.harreader.model.HarPage;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DTCMAnalysis2 {

    String driverPath = "C:\\Users\\HamzahAlrawi\\IdeaProjects\\ScholarshipsAutomatedTests\\src\\main\\resources\\browserDrivers\\windowschromedriver.exe";
    String sFileName = "C:\\HARFiles\\SeleniumEasy.har";

    public WebDriver driver;
    public BrowserMobProxy proxy;

    @BeforeTest
    public void setUp() {

        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        //get the Selenium proxy object - org.openqa.selenium.Proxy;
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //set chromedriver system property
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(capabilities);

        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);



    }

    @Test
    public void doMagic() throws HarReaderException, IOException {
        // create a new HAR with the label "seleniumeasy.com"
        int totalNumberOfPages = 5;
        String fileReadPath = "C:\\HARFiles\\pageList.csv";
        String fileResultPath = "C:\\HARFiles\\Result.csv";
        driver.get("https:\\www.facebook.com");
        String[][] pageList = ReadWriteHelper.readCSVFile(fileReadPath, totalNumberOfPages);
        String[] resultData = new String[totalNumberOfPages + 2];
        resultData[0] = "Pagelink, Filesize before scrolling, number of requests before scrolling, page load time, filesize after scrolling, number of requests after scrolling \n";
        for (int i = 0; i<totalNumberOfPages; i++) {
            String savePath = "C:\\HARFiles\\cuurentHAR" + i + ".har";
            proxy.newHar(savePath);
            driver.get(pageList[i][0]);
            saveHarFile(savePath);
            int oldNumRequests = getNumberRequests(savePath);
            double pageTime = calculatePageLoadTime(savePath);
            double fileSize = getFileSize(savePath);
            try {
                long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

                while (true) {
                    for (int j = 10; j<1; j--) {
                        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/" + j + ");");
                        Thread.sleep(2000);
                    }
                    long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                    if (newHeight == lastHeight) {
                        break;
                    }
                    lastHeight = newHeight;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveHarFile(savePath);
            resultData[i + 1] = pageList[i][0] + "," +
                    Double.toString(fileSize) + "," +
                    Integer.toString(oldNumRequests) + "," +
                    Double.toString(pageTime) + "," +
                    Double.toString(getFileSize(savePath)) + "," +
                    Integer.toString(getNumberRequests(savePath));
            System.out.println(resultData[i + 1]);
        }
        for (String result : resultData){
            System.out.println(result);
        }
        ReadWriteHelper.writeCSVFile(fileResultPath,resultData);


    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            proxy.stop();
            driver.quit();
        }
    }

    public void saveHarFile(String path){
        Har har = proxy.getHar();

        // Write HAR Data in a File
        File harFile = new File(path);
        try {
            har.writeTo(harFile);
        } catch (IOException ex) {
            System.out.println (ex.toString());
            System.out.println("Could not find file " + sFileName);
        }
    }

    public double getFileSize(String filePath){
        File file =new File(filePath);
        double bytes = file.length();
        double kilobytes = (bytes / 1024);
        return kilobytes;
    }

    public double calculatePageLoadTime(String filename) throws HarReaderException {
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har = harReader.readFromFile(new File(filename));

        HarLog log = har.getLog();

        // Access all pages elements as an object

        long startTime =   log.getPages().get(0).getStartedDateTime().getTime();

        // Access all entries elements as an object

        List<HarEntry> hentry = log.getEntries();

        long loadTime = 0;

        int entryIndex = 0;
        //Output "response" code of entries.
        for (HarEntry entry : hentry)
        {


            long entryLoadTime = entry.getStartedDateTime().getTime() + entry.getTime();

            if(entryLoadTime > loadTime){
                loadTime = entryLoadTime;
            }

            entryIndex++;
        }

        long loadTimeSpan = loadTime - startTime;

        Double webLoadTime = ((double)loadTimeSpan) / 1000;
        double webLoadTimeInSeconds = Math.round(webLoadTime * 100.0) / 100.0;

        return webLoadTimeInSeconds;
    }

    public static int getNumberRequests(String filename) throws HarReaderException {
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har = harReader.readFromFile(new File(filename));

        HarLog log = har.getLog();
        return log.getEntries().size();
    }

    public static void main(String[] args) throws HarReaderException {
        System.out.println(getNumberRequests("myfile.har"));
    }
}
