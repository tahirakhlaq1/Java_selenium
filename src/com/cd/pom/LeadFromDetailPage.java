package com.cd.pom;

import java.sql.Timestamp;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class LeadFromDetailPage extends BaseMenuPage {

	

	// Locators are using for performing action
	@FindBy(how = How.XPATH, using = "//a[@title='IIT Delhi (IITD), Delhi']")
	private WebElement iitDelhi;
	
	@FindBy(how = How.ID, using = "apply-btn")
	private WebElement applyOnlineBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='form-group']//input[@id='id_name']")
	private WebElement name;

	@FindBy(how = How.ID, using = "id_email")
	private WebElement emailField;

	@FindBy(how = How.ID, using = "id_phone")
	private WebElement phoneField;

	@FindBy(how = How.ID, using = "id_state")
	private WebElement stateDrpdwn;

	@FindBy(how = How.ID, using = "id_course")
	private WebElement courseDrpdwn;

	@FindBy(how = How.XPATH, using = "//button[@type='submit'][contains(text(),'Submit')]")
	private WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Thanks!! your Preferences are saved..')]")
	private WebElement getMSg;

	@FindBy(how = How.XPATH, using = "//button[@type='button'][contains(text(),'Close')]")
	private WebElement msgClosed;

	// *********************LMS LOCATORS******************************

	@FindBy(how = How.XPATH, using = "//input[@placeholder='E-mail']")
	private WebElement user1Name;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement pwd;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement loginBtn;

	@FindBy(how = How.ID, using = "search_phone")
	private WebElement searchphn;

	public LeadFromDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Search lead in lms with Phone number as parameter in xapth for finding lead

	public void leadPhoneNumberInLms(WebDriver driver) {
		WebElement phoneNumberInList = driver.findElement(By.xpath("//td[contains(text(),'" + globalvariable + "')]"));
		String gvLead = Long.toString(globalvariable);
		String lead = phoneNumberInList.getText();
		Assert.assertEquals(lead, gvLead, "Lead Not Found In LMS");
		Reporter.log("Entered Lead matched in Lms, Lead Found");
	}

	public static long globalvariable;
	
	//This Message Used For the Addind the lead From the College Detail Page.
	
	public void addLead() {
		iitDelhi.click();
		applyOnlineBtn.click();
		Reporter.log("Clicked On Apply Button", true);
		name.sendKeys("QaAutomation" + randomName());
		phoneField.sendKeys(randomNumber());
		emailField.sendKeys(globalvariable + "@cd.com");
		Select select = new Select(stateDrpdwn);
		select.selectByIndex(9);
		Select select1 = new Select(courseDrpdwn);
		select1.selectByIndex(1);
		submitBtn.click();
		System.out.println(globalvariable);

	}
	
	//This Method Login into the lms and Search the lead by Phone number
	public void SearchLead() throws InterruptedException {

		user1Name.sendKeys("admin@collegedekho.com");
		pwd.sendKeys("6e3whGoqm9OM");
		loginBtn.click();
		Thread.sleep(4000);
		searchphn.sendKeys("" + globalvariable, Keys.ENTER);

	}
	//This method Verify the Lead Success message On Collegedekho website
	
	public void verifyLeadMsg() {
		String expPopUpMsg = "Thanks!! your Preferences are saved..";
		String actulaMsg = getMSg.getText();
		Assert.assertEquals(actulaMsg, expPopUpMsg, "msg is not verified");
		Reporter.log("Success Meassage Verified Successfully = "+getMSg.getText(), true);
	}

	public static String randomName() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	public static String randomNumber() {
		globalvariable = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		String num = Long.toString(globalvariable);
		return num;
	}

}
