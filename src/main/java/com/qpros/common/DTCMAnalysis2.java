package com.qpros.common;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.fasterxml.jackson.core.JsonParseException;
import com.qpros.helpers.ActionsHelper;
import com.qpros.helpers.ReadWriteHelper;
import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarLog;
import de.sstoehr.harreader.model.HarPage;
import de.sstoehr.harreader.model.HarPageTiming;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DTCMAnalysis2 {

    String driverPath = "C:\\Users\\Hamza\\IdeaProjects\\ScholarshipsAutomatedTests\\src\\main\\resources\\browserDrivers\\windowschromedriver.exe";
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
        DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito --media-cache-size=1 --disk-cache-size=1");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //set chromedriver system property
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(capabilities);
        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);



    }

    @Test
    public void doMagic() throws HarReaderException, IOException, InterruptedException {
        // create a new HAR with the label "seleniumeasy.com"
        //DevTools devTools = driver.getDevTools();
        //devTools.createSession();

        int totalNumberOfPages = 5;
        String fileReadPath = "C:\\HARFiles\\pageList.csv";
        String fileResultPath = "C:\\HARFiles\\Result.csv";
        driver.get("https://www.visitdubai.com/ar");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
        int x = 0;
        for (LogEntry le : les) {
            x++;
            //System.out.println(le.getMessage());
        }
        System.out.println("Total number of request using a different method: " + x);
        testing();
        Thread.sleep(2000002);
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
                    for (int j = 1; j <= 100; j++) {
                        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/" + j + ");");
                        Actions builder = new Actions(driver);
                        builder.sendKeys(Keys.DOWN);
                        builder.perform();
                        Thread.sleep(50);
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
    public void performanceAnalysis(String filepath, String currentURL){
        for (LogEntry logEntry : driver.manage().logs().get(LogType.PERFORMANCE).getAll())
        {
            System.out.println(logEntry);
            LogEntries logs = driver.manage().logs().get("performance");

            int status = -1;

            System.out.println("\nList of log entries:\n");
            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
            {
                LogEntry entry = it.next();

                try
                {
                    JSONObject json = new JSONObject(entry.getMessage());

                    System.out.println(json.toString());

                    JSONObject message = json.getJSONObject("message");
                    String method = message.getString("method");

                    if (method != null
                            && "Network.responseReceived".equals(method))
                    {
                        JSONObject params = message.getJSONObject("params");

                        JSONObject response = params.getJSONObject("response");
                        String messageUrl = response.getString("url");

                        if (currentURL.equals(messageUrl))
                        {
                            status = response.getInt("status");

                            System.out.println(
                                    "---------- bingo !!!!!!!!!!!!!! returned response for "
                                            + messageUrl + ": " + status);

                            System.out.println(
                                    "---------- bingo !!!!!!!!!!!!!! headers: "
                                            + response.get("headers"));
                        }
                    }
                } catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            System.out.println("\nstatus code: " + status);
        }
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

    public int getOnLoad(String filepath) throws HarReaderException {
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har = harReader.readFromFile(new File(filepath));

        HarLog log = har.getLog();
        HarPageTiming myTest = log.getPages().get(0).getPageTimings();
        return myTest.getOnLoad().intValue();

    }

    public int getContentLoad(String filepath) throws HarReaderException {
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har = harReader.readFromFile(new File(filepath));

        HarLog log = har.getLog();
        HarPageTiming myTest = log.getPages().get(0).getPageTimings();
        return myTest.getOnContentLoad().intValue();

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

    public int getNumberRequests(String filename) throws HarReaderException {
        HarReader harReader = new HarReader();
        de.sstoehr.harreader.model.Har har = harReader.readFromFile(new File(filename));

        HarLog log = har.getLog();
        return log.getEntries().size();
    }

    public void testing() throws HarReaderException {
        JavascriptExecutor js1=((JavascriptExecutor)driver);
        try {
            Thread.sleep(5000);
        }catch(Exception e) {e.printStackTrace();}
        String url=driver.getCurrentUrl();
        System.out.println("Current URL :"+url);
        long pageLoadTime= (Long)js1.executeScript("return (window.performance.timing.loadEventEnd-window.performance.timing.responseStart)");
        long TTFB= (Long)js1.executeScript("return (window.performance.timing.responseStart-window.performance.timing.navigationStart)");
        long endtoendRespTime= (Long)js1.executeScript("return (window.performance.timing.loadEventEnd-window.performance.timing.navigationStart)");

        Date date = new Date();
        //Timestamp ts=new Timestamp(date.getTime());

        System.out.println("PageLoadTime Time :"+pageLoadTime);
        System.out.println("TTFB :"+TTFB);
        System.out.println("Customer perceived Time :"+endtoendRespTime);
        System.out.println("timeStamp");
        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
        String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
        System.out.println("Net data: " + netData);
        String anotherScript = "return performance\n" +
                "  .getEntriesByType(\"resource\")\n" +
                "  .map((x) => x.transferSize)\n" +
                "  .reduce((a, b) => (a + b), 0);";
        System.out.println("THIS IS HOPEFULLY THE TOTAL TRANSFER SIZE (it is not)" + js1.executeScript((anotherScript)).toString());
        String importantResult = js1.executeScript((anotherScript)).toString();
        Matcher dataLengthMatcher1 = Pattern.compile("transferSize=(.*?),").matcher(netData);
        int sumEncoded = 0;
        int numberOfRequests = 0;
        while (dataLengthMatcher1.find()){
            System.out.println("File size: " + dataLengthMatcher1.group(1));
            sumEncoded = sumEncoded + Integer.parseInt(dataLengthMatcher1.group(1));
            numberOfRequests++;

        }
        Matcher domInteractive = Pattern.compile("domInteractive=(.*?),").matcher(netData);
        while (domInteractive.find()){
            System.out.println("DomInteractive: " + domInteractive.group(1));

        }
        Matcher loadEventEnd = Pattern.compile("loadEventEnd=(.*?),").matcher(netData);
        while (loadEventEnd.find()){
            System.out.println("LoadEventEnd: " + loadEventEnd.group(1));

        }

        Matcher maxResponse = Pattern.compile("responseEnd=(.*?),").matcher(netData);
        double makResponseTime = 0.0;
        while (maxResponse.find()){
            System.out.println("MaxResponse: " + maxResponse.group(1));
            if (Double.parseDouble(maxResponse.group(1)) >= makResponseTime){
                makResponseTime = Double.parseDouble(maxResponse.group(1));
            }
        }
        System.out.println("Max response time (FINISH)" + makResponseTime);


        Matcher linkMatcher = Pattern.compile("name=(.*?),").matcher(netData);
        //String linkText = "";
        while (linkMatcher.find()){
            System.out.println("Link: " + linkMatcher.group(1));

        }
        System.out.println("Number of requests " + numberOfRequests);
        System.out.println("Matcher result2" + sumEncoded);
        Matcher dataLengthMatcher2 = Pattern.compile("encodedBodySize=(.*?),").matcher(netData);
        int sumEncoded2 = 0;
        int numberOfRequests2 = 0;
        while (dataLengthMatcher2.find()){
            System.out.println("File size2: " + dataLengthMatcher2.group(1));
            sumEncoded2 = sumEncoded + Integer.parseInt(dataLengthMatcher2.group(1));
            numberOfRequests2++;
        }
        System.out.println("Number of requests " + numberOfRequests2);
        System.out.println("Matcher result2 " + sumEncoded2);

        int totalBytes = 0;
        for (LogEntry entry : driver.manage().logs().get(LogType.PERFORMANCE)) {
            if (entry.getMessage().contains("Network.dataReceived")) {
                Matcher dataLengthMatcher = Pattern.compile("dataLength\":(.*?),").matcher(entry.getMessage());
                dataLengthMatcher.find();
                totalBytes = totalBytes + Integer.parseInt(dataLengthMatcher.group(1));
                //Do whatever you want with the data here.
            }
        }
        System.out.println(totalBytes);
    }

    public static void main(String[] args) throws HarReaderException, IOException {
        DTCMAnalysis2 test = new DTCMAnalysis2();
        System.out.println(test.getContentLoad("C:\\HARFiles\\cuurentHar3.har"));
        System.out.println(test.getOnLoad("C:\\HARFiles\\cuurentHar3.har"));
        System.out.println(test.calculatePageLoadTime("C:\\HARFiles\\cuurentHar3.har"));

    }
}
