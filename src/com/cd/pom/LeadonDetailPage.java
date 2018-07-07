package com.cd.pom;

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

	@FindBy(how = How.ID, using = "id_name")
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

	public LeadonDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void addLead() {
		applyOnlineBtn.click();
		name.sendKeys("tom");
		emailField.sendKeys("QA@yopmai.com");
		phoneField.sendKeys("6789054321");
		Select select = new Select(stateDrpdwn);
		select.selectByIndex(9);
		Select select1 = new Select(courseDrpdwn);
		select1.selectByIndex(1);
		submitBtn.click();

	}

	public void verifyLeadMsg() {
		String expPopUpMsg = "Thanks!! your Preferences are saved..";
		String actulaMsg = getMSg.getText();
		Assert.assertEquals(actulaMsg, expPopUpMsg, "msg is not verified");
		Reporter.log("No data Found", true);
	}

}
