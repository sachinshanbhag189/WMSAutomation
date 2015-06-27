package com.selenium.data;
//package com.selenium.pagefactory;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import PageFactory.DataProviderClass;
//
//public class TestParameterization {
//
//	WebDriver driver;
//
//	@BeforeMethod
//	@Parameters("browser")
//	public void setup(String browser) throws Exception {
//
//		// Check if parameter passed from TestNG is 'firefox'
//
//		if (browser.equals("Firefox")) {
//
//			driver = new FirefoxDriver();
//
//		}
//
//		// Check if parameter passed as 'chrome'
//
//		else if (browser.equals("Chrome")) {
//
//			System.setProperty(
//					"webdriver.chrome.driver",
//					"D:/SELENIUM TRAING WITH PAWAN/Essential Installers/chromedriver_win32/chromedriver.exe");
//
//			driver = new ChromeDriver();
//
//		}
//
//		else if (browser.equalsIgnoreCase("IE")) {
//
//			System.setProperty(
//					"webdriver.ie.driver",
//					"D:/SELENIUM TRAING WITH PAWAN/Essential Installers/IEDriverServer_Win32_2.41.0/IEDriverServer.exe");
//
//			// create chrome instance
//
//			driver = new InternetExplorerDriver();
//
//		}
//
//		else {
//
//			// If no browser passed throw exception
//
//			throw new Exception("Browser is not correct");
//
//		}
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//	}
//
//	@Test(dataProvider = "Login to AM", dataProviderClass = DataProviderClass.class)
//	public void testMethod(String username, String password)
//			throws InterruptedException {
//
//		{
//
//			driver.navigate().to("https://mail.google.com/mail/");
//			WebElement username_ui = driver.findElement(By
//					.xpath("//input[@id='Email' and @name='Email']"));
//
//			WebElement password_ui = driver.findElement(By
//					.xpath("//input[@id='Passwd' and @name='Passwd']"));
//
//			// Search text in google text box
//
//			username_ui.sendKeys(username);
//
//			password_ui.sendKeys(password);
//
//			Thread.sleep(3000);
//
//			driver.quit();
//
//			// get text from search box
//
//		}
//
//	}
//
//}