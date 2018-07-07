package com.cd.scripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cd.generic.BaseLib;
import com.cd.pom.LeadonDetailPage;

public class LeadonTest extends BaseLib{

	LeadonDetailPage lp;
	Logger log;
	@Test
	public void leadFill() {
		lp= new LeadonDetailPage(driver);
		lp.addLead();
		lp.verifyLeadMsg();
		log.info("Method Executed");
		
		
		
	}
}
