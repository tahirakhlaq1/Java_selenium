package com.cd.generic;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;




public class MyTestNGListener implements ITestListener{
	Logger log;
	public MyTestNGListener() {
		
	DateFormat	dateformat= new SimpleDateFormat("dd_MM_YY_hh_mm_ss");
	Date date= new Date();
	System.setProperty("LongTimeDate", dateformat.format(date));
	log= Logger.getLogger(this.getClass());
	PropertyConfigurator.configure("log4j.properties");
	}
	@Override
	public void onFinish(ITestContext context) {
		log.info("Test Has Been Completed Successfully");
			}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		log.info("Test Failed Within Success Percentage");
		
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		log.info("Test has been Started ");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test Has Been failed ");
		BaseLib obj=(BaseLib)result.getInstance();
		log.error("Calling on TestFailure: ");
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_YY_hh_mm_ss");
		Date date= new Date();
		String fileName=result.getMethod().getMethodName();
		EventFiringWebDriver efw= new EventFiringWebDriver(obj.driver);
		File srcFile=efw.getScreenshotAs(OutputType.FILE);
	//	File srcFile=((TakesScreenshot)obj.driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("/home/tahir/eclipse-workspace/Collegedekho_Java/screenshots"+fileName+dateFormat.format(date)+".png");
		
	
	try{
	FileUtils.copyFile(srcFile, destFile);
	}catch(IOException e){
		e.printStackTrace();
		}
	
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		log.info("Test Has Been Skiped");
		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		log.info("Test Has been executed Successfully");
		
	}
	@Override
	public void onStart(ITestContext arg0) {
		log.info("Test has been executed");
		
	}
	
}
