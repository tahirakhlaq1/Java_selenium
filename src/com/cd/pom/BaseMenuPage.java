package com.cd.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseMenuPage {
	
	@FindBy(how = How.XPATH, using = "//div[@class='nav-link'][contains(text(),'Engineering')]")
	private WebElement mainMenu;

	@FindBy(how = How.XPATH, using = "//a[@href='/btech-colleges-in-india/']")
	private WebElement btechCollege;

	@FindBy(how = How.XPATH, using = "//a[@title='IIT Delhi (IITD), Delhi']")
	private WebElement iitDelhi;
	
	public BaseMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void bTechCollege(WebDriver driver) throws InterruptedException
	{
		mainMenu.click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(btechCollege).perform();
		btechCollege.click();
	}
	
}
