package com.selenium.data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "QuickSearchText")
	public static Object[][] getDataFromDataproviderQuickSearck() {

		return new Object[][] {

				{""}, {"1"},
		};

	}
	
	@DataProvider(name = "DeviceSearchText")
	public static Object[][] getDataFromDataproviderDeviceSearch() {

		return new Object[][] {

				{""}, {"1"},
		};

	}

	@DataProvider(name = "Browser")
	public static Object[][] getBrowserDataFromDataprovider() {

		return new Object[][] {

				{ "firefox" }, { "chrome" },

		};

	}
}