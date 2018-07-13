package com.cd.scripts;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cd.generic.BaseLib;
import com.cd.pom.LeadonDetailPage;

public class LeadonTest extends BaseLib{

	LeadonDetailPage lp;
	
	@Test
	public void leadFill() throws InterruptedException {
		lp= new LeadonDetailPage(driver);
		lp.addLead();
		lp.verifyLeadMsg();
		Reporter.log("Lead Filled Succefully", true);
		
		
		
	}
}
