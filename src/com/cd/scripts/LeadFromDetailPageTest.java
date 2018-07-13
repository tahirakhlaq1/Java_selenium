package com.cd.scripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cd.generic.BaseLib;
import com.cd.pom.LeadFromDetailPage;
import com.cd.pom.LeadFromListingPage;

public class LeadFromDetailPageTest extends BaseLib{

	LeadFromDetailPage lp;
	LeadFromListingPage llp;
	
	@Test(priority=1)
	public void LeadInDetailpage() throws InterruptedException {
		lp= new LeadFromDetailPage(driver);
		wLib.implicitWaitForSeconds(driver, 10);
		lp.bTechCollege(driver);
		lp.addLead();
		lp.verifyLeadMsg();
		Reporter.log("Lead Filled Succefully", true);
		
	}

	
	@Test(priority=2)
		public void VerifyInLmsFormDetailPage() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://lms.collegedekho.com/login");
		lp= new LeadFromDetailPage(driver);
		lp.SearchLead();
		wLib.implicitWaitForSeconds(driver, 10);
		lp.leadPhoneNumberInLms(driver);
		Reporter.log("Lead Verified In LMS", true);
		driver.quit();
	}
	
	
	
}
