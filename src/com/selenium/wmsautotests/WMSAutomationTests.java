package com.selenium.wmsautotests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.data.DataProviderClass;
import com.selenium.pagefactory.AMLogin;
import com.selenium.pagefactory.SearchDevices;

public class WMSAutomationTests {


	WebDriver driver;

	AMLogin objLogin;

	SearchDevices objSearchDevices;

	public  WMSAutomationTests() {	

		driver = new FirefoxDriver();
		
		//For chrome browser
//		System.setProperty(
//				"webdriver.chrome.driver",
//				"C:/SELENIUM TRAING WITH PAWAN/SELENIUM TRAING WITH PAWAN/Essential Installers/chromedriver_win32/chromedriver.exe");
//		
//		driver = new ChromeDriver();
		
//  for IE browser
//		System.setProperty(
//				"webdriver.ie.driver",
//				"C:/SELENIUM TRAING WITH PAWAN/SELENIUM TRAING WITH PAWAN/Essential Installers/IEDriverServer_Win32_2.41.0/IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeSuite(description="Verify that the Login to the AM page is successful",enabled = true, groups = {"Sanity"})
	@Parameters({"username","password"})
	public void test_Login_to_AM(String username, String password) 
	{
		driver.get("http://10.14.41.39:8089/AM/login.xhtml");
		driver.manage().window().maximize();
		objLogin = new AMLogin(driver);

		String loginPageTitle = objLogin.getLoginTitle();

		Assert.assertTrue(loginPageTitle.toLowerCase().contains("logga in"));
		System.out.println("The menu title on the Login Page is : "
				+ loginPageTitle);

		String loginPageLogo = objLogin.getAMLogoText();

		Assert.assertTrue(loginPageLogo.toLowerCase().contains("am"));
		System.out.println("The logo title on the Login Page is : "
				+ loginPageLogo);

		objLogin.loginToAM(username, password);

		objSearchDevices = new SearchDevices(driver);

		Assert.assertTrue(objSearchDevices.getSearchDevicesMenuTitle()
				.toLowerCase().contains("manage devices> search devices"));

		System.out.println("The WMS Menu Name on the Dashboard is : "
				+ objSearchDevices.getSearchDevicesMenuTitle());

	}

	@Test(dataProvider = "QuickSearchText", dataProviderClass = DataProviderClass.class,priority= 0,alwaysRun=true, description="Verify that Quick Search returns 0 results when search with Blank value or returns some records when searched with some text ",enabled = true, groups = {"Sanity"})
	public void test_Quick_Search_returns_results(String text)
	{		
		//Assert.assertTrue(objSearchDevices.text_in_quick_search_textbox("").equals(""));
		objSearchDevices.quick_search_textbox.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objSearchDevices.quick_search(text);

		if(text.equals("")){


			Assert.assertTrue(objSearchDevices.messagePanel_zero_records_text.getText().equals("0 records found."));

			Assert.assertEquals(objSearchDevices.verify_results_for_no_search(), 0);
			System.out.println("The no of records returned : "+objSearchDevices.verify_results_for_no_search());

		}else{

			Assert.assertFalse(objSearchDevices.messagePanel_records_text.getText().equals("0 records found."));

			Assert.assertNotEquals(objSearchDevices.verify_results_for_search(), 0); 
			System.out.println("The no of records returned : "+objSearchDevices.verify_results_for_search());
		}

	}

	@Test(dataProvider = "DeviceSearchText", dataProviderClass = DataProviderClass.class,priority= 1,alwaysRun=true, description="Verify that Device Search returns 0 results when search with Blank value or returns some records when searched with some text. ",enabled = true, groups = {"Sanity"})
	public void test_Device_Search_returns_results(String text)
	{		
		//Assert.assertTrue(objSearchDevices.text_in_quick_search_textbox("").equals(""));
		objSearchDevices.device_search_textbox.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objSearchDevices.device_search(text);


		if(text.equals("")){


			Assert.assertTrue(objSearchDevices.messagePanel_zero_records_text.getText().equals("0 records found."));

			Assert.assertEquals(objSearchDevices.verify_results_for_no_search(), 0);
			System.out.println("The no of records returned : "+objSearchDevices.verify_results_for_no_search());

		}else{

			Assert.assertFalse(objSearchDevices.messagePanel_records_text.getText().equals("0 records found."));

			Assert.assertNotEquals(objSearchDevices.verify_results_for_search(), 0); 
			System.out.println("The no of records returned : "+objSearchDevices.verify_results_for_search());
		}
	}

//	@Test(priority= 2,alwaysRun=true, description="Verify that General Search returns some results.",enabled = true, groups = {"Sanity"})
//	public void test_General_Search()
//	{
//		objSearchDevices.generalSearch();
//		Assert.assertNotEquals(objSearchDevices.verify_results_for_search(), 0); 
//		System.out.println("The no of records returned : "+objSearchDevices.verify_results_for_search());
//	}

}