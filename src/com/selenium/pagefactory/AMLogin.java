package com.selenium.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMLogin {

	/*
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(id = "j_username")
	WebElement am_username;


	@FindBy(id = "j_password")
	WebElement am_password;

	@FindBy(xpath = "//td[@class='wms-logo']//label[contains(@id,'j_idt')]")
	WebElement AMLogo;

	@FindBy(xpath = "//label[@id='breadcrumbId' and text()='Logga in']")
	WebElement logintext;	

	@FindBy(id = "loginButton")
	WebElement login;

	public AMLogin(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Set user name in textbox

	public void setUserName(String strUserName) {

		am_username.sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		am_password.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	// Get the title of Login Page

	public String getLoginTitle() {

		return logintext.getText();

	}

	public String getAMLogoText(){
		return AMLogo.getText();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @return
	 */

	public void loginToAM(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}

}