package com.cd.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


public class BaseLib {
	public WebDriver driver;
	public WaitStatementLib wLib;
	public SoftAssert sAssert;
	@BeforeMethod
	@Parameters(value="browser")
	
	public void preCondition(){
		//http://52.66.22.86/travelawareqa/public_html/index.html#/personnel/search
		//System.setProperty("webdriver.firefox.marionette"," .\\exefiles\\geckodriver.exe");
		//driver = new FirefoxDriver();
	//	System.setProperty("webdriver.chrome.driver"," .\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
	
	/*	if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.firefox.marionette"," .\\exefiles\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		//driver=new RemoteWebDriver(DesiredCapabilities.firefox());
		Reporter.log("Firefox launched", true);
	}
	else if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver=new RemoteWebDriver(DesiredCapabilities.chrome());
		Reporter.log("chrome launched", true);
	}
	/*else if(browser.equalsIgnoreCase("ie")){
		System.setProperty("webdriver.ie.driver", ".\\exefiles\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver=new RemoteWebDriver(DesiredCapabilities.internetExplorer());
		Reporter.log("IE launched", true);
	}
	else{
		//driver=new FirefoxDriver();
		driver=new RemoteWebDriver(DesiredCapabilities.firefox());
		Reporter.log("Firefox launched", true);
	}*/
		
		driver.manage().window().maximize();
		driver.get("https://www.collegedekho.com/colleges/iit-delhi");
		Reporter.log("Navigating to the url", true);
		wLib=new WaitStatementLib();
		wLib.implicitWaitForSeconds(driver, 20);
		Reporter.log("wait impliment", true);
		sAssert=new SoftAssert();
		}
	
	
	@AfterMethod
	public void postCondition(){
		
		driver.quit();
		Reporter.log("browsers closed", true);
	}

}