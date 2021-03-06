package com.qpros.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qpros.common.Base;
import com.qpros.helpers.ActionsHelper;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

public class ExtentManager extends Base {

    private static ExtentReports extent;
    private static String reportClassName;
    public static String reportFileName = String.format("QPros-Automation_Report-%s-%s.html",
            ActionsHelper.getTodayDate(),System.currentTimeMillis());
    public static String path = System.getProperty("user.dir") + "/src/main/resources/Reports/";

    public static ExtentReports getInstance() throws GeneralSecurityException, MessagingException {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() throws GeneralSecurityException, MessagingException {
        StateHelper.setStepState("reportName", reportFileName);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path + reportFileName);
        htmlReporter.config().setTestViewChartLocation( ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme( Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        return extent;
    }

    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        createInstance();
    }

}
