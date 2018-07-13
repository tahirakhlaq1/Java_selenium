package com.cd.scripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cd.generic.BaseLib;
import com.cd.pom.LeadFromListingPage;
import com.cd.pom.LeadFromDetailPage;

public class LeadFromListingPageTest extends BaseLib {
	
	LeadFromListingPage llp;
	
	@Test(priority=3)
	public void LeadInListingPage() throws InterruptedException {
		 llp = new LeadFromListingPage(driver);
		 wLib.implicitWaitForSeconds(driver, 10);
		 llp.bTechCollege(driver);
		 llp.listingCollege();
		 llp.verifyLeadMsg();
		
		
		 Reporter.log("Add lead method Executed",true);
		 
	}
	
	@Test(priority=4)
	public void VerifyInLmsFormListingPage() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://lms.collegedekho.com/login");
		wLib.implicitWaitForSeconds(driver, 10);
		llp= new LeadFromListingPage(driver);
		 llp.LogininLms();
		 llp.leadPhoneNumberInLms(driver);
		
		Reporter.log("Lead Verified In LMS", true);
		driver.quit();
	}
		
	}
