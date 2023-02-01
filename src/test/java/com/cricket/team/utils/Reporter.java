package com.cricket.team.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Reporter {

    public static ExtentReports extent = new ExtentReports();
    public ExtentTest test;
    public String className = "";
    protected JsonReader jsonReader = new JsonReader();

    @BeforeSuite
    public static void setup(){
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/report.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Blog Name", "RCB");
        extent.setSystemInfo("Author", "Indhu");
    }

    @BeforeMethod
    public void createTest(ITestContext iTestContext){
        className = iTestContext.getSuite().getAllMethods().get(0).getQualifiedName();
        test = extent.createTest(className);
    }

    @AfterSuite
    public static void save(){
        extent.flush();
    }
}
