package com.selenium.pagefactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchDevices {


	WebDriver driver;

	@FindBy(xpath = "//label[contains(@id,'j_idt') and contains(@id,'breadcrumbId') and text()='Manage Devices> Search Devices']")
	public
	WebElement searchdevices_menu_title;

	@FindBy(xpath = "//input[contains(@id,'j_idt') and contains(@id,'assetIdInputTextId_input')]")
	public
	WebElement quick_search_textbox;

	@FindBy(xpath = "//label[text()='Quick Search']/../../td//button[contains(@id, 'j_idt') and contains(@id,':j_idt')]")
	public
	WebElement quick_search_button;

	@FindBy(xpath = "//input[contains(@id,'j_idt') and contains(@id,'deviceCodeTextId')]")
	public
	WebElement device_search_textbox;


	@FindBy(xpath = "//label[text()='Device Code']/../../td//button[contains(@id, 'j_idt') and contains(@id,':j_idt')]")
	public
	WebElement device_search_button;


	@FindBy(xpath ="//div[@id='outputPanel']//span[text()='0 records found.']")
	public WebElement messagePanel_zero_records_text;


	@FindBy(xpath ="//div[@id='outputPanel']//span[contains(text(),' records found.')]")
	public WebElement messagePanel_records_text;


	@FindBy(xpath ="//tbody[@id='tbl_data']//tr[contains(@class,'ui-widget-content ui')]")
	public WebElement no_record_table;

	@FindBy(xpath ="//tr[contains(@class,'ui-widget-content ui')]/../..//tbody[@id='tbl_data']")
	public WebElement record_table;


	@FindBy(xpath ="//tbody[@id='tbl_data']//tr[contains(@class,'ui-widget-content ui')]//td[text()='No Data Available']")
	public WebElement message_no_data_available;


	@FindBy(xpath ="//fieldset[contains(@id,'j_idt')]//select[contains(@name,'j_idt')]//option[text()='Store1']")
	public WebElement store;

	@FindBy(xpath ="//select[contains(@id,'j_idt') and contains(@id,'earchAssetTypeCombo1')]//option[text()='Antenna']")
	public WebElement asset_type;

	@FindBy(xpath ="//input[contains(@id,'assetNrTextId')]")
	public WebElement asset_number;

	@FindBy(xpath ="//input[contains(@id,'assetNameTextId')]")
	public WebElement asset_name;


	@FindBy(xpath ="//button[contains(@id,':findArticlesButtonId')]")
	public WebElement find_articles_button;

	public SearchDevices(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public String getSearchDevicesMenuTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchdevices_menu_title));		

		return searchdevices_menu_title.getText();

	}
	//Code related to Quick search
	public void text_in_quick_search_textbox(String text)
	{
		quick_search_textbox.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		quick_search_textbox.sendKeys(text);
		text=quick_search_textbox.getText();
		//return text;

	}

	public void quick_search(String text){
		this.text_in_quick_search_textbox(text);
		quick_search_button.click();	

	}	


	//Code related to Device code search
	public String text_in_device_search_textbox(String text)
	{
		device_search_textbox.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		device_search_textbox.sendKeys(text);
		text =device_search_textbox.getText();
		return text;

	}

	public void device_search(String text){
		this.text_in_device_search_textbox(text);
		device_search_button.click();	

	}	


	public int verify_results_for_no_search(){
		int count = 0;
		WebElement table = no_record_table;

		List<WebElement> allRows = table.findElements(By.tagName("td"));

		//		System.out.println("This is the total numbers of rows"
		//				+ (allRows.size()-1));


		if(message_no_data_available.getText().equals("No Data Available")){
			count = 0;

		}else{
			count = allRows.size();

		}
		return count;
	}



	public int verify_results_for_search(){
		int count = 0;
		WebElement table = record_table;

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

//		System.out.println("The total numbers of records returned = "
//				+ (allRows.size()));

		if((allRows.size())!=0){



			count = allRows.size();


			return count;
		}
		else if((allRows.size()-1)==0){
			System.out.println("No data returned");
			count = (allRows.size()-1);

		}
		return count;
	}

	public void generalSearch() {
		// TODO Auto-generated method stub

		store.click();
		asset_type.click();
		asset_name.sendKeys("Asset2");
		asset_number.sendKeys("102");
		find_articles_button.click();


	}

}



