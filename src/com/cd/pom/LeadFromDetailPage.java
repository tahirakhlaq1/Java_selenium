package com.cd.pom;

import java.sql.Timestamp;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class LeadonDetailPage extends BaseMenuPage {

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
	
	//*********************LMS LOCATORS******************************
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='E-mail']")
	private WebElement user1Name;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement pwd;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(how = How.ID, using = "search_phone")
	private WebElement searchphn;

	public LeadonDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static long globalvariable;

	public void addLead() {
		applyOnlineBtn.click();
		name.sendKeys("QaAutomation" + randomName());
		phoneField.sendKeys(randomNumber());
		emailField.sendKeys(globalvariable+"@cd.com");
		Select select = new Select(stateDrpdwn);
		select.selectByIndex(9);
		Select select1 = new Select(courseDrpdwn);
		select1.selectByIndex(1);
		submitBtn.click();
		System.out.println(globalvariable);

	}
	WebDriver driver;
	public void verifyLead() {
		driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys("admin@collegedekho.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("6e3whGoqm9OM");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	//	user1Name.sendKeys("");
//		pwd.sendKeys("6e3whGoqm9OM");
//		loginBtn.click();
		searchphn.sendKeys(""+globalvariable);
	}

	public void verifyLeadMsg() {
		String expPopUpMsg = "Thanks!! your Preferences are saved..";
		String actulaMsg = getMSg.getText();
		Assert.assertEquals(actulaMsg, expPopUpMsg, "msg is not verified");
		Reporter.log("No data Found", true);
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
