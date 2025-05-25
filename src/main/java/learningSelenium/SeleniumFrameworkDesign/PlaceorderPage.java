package learningSelenium.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractMethodsInFile.Abstarctcomponent;

public class PlaceorderPage extends Abstarctcomponent{

	WebDriver driver;
	public PlaceorderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement cntry;
	
	@FindBy(css="section[class*='list-group']")
	WebElement Visibility;
	
	
	@FindBy(css="section[class*='list-group']")
	List<WebElement> dropdownLists;
	
	@FindBy(css="a[class*='btnn']")
	WebElement placingOrder;
	
	public List<WebElement> countryEnter()
	{
		cntry.sendKeys("India");
		waitMethodVisibilityAll(Visibility);
		return dropdownLists;
		
	}
	
	public void CountrySelection(List<WebElement> dropdownLists, String ctr ) throws InterruptedException
	{
		for (WebElement dropdownList : dropdownLists) {
			dropdownList.getText();
			System.out.println(dropdownList.getText());

			if (dropdownList.getText().equalsIgnoreCase(ctr))
			
			Thread.sleep(3000);
			dropdownList.click();

		}
	}
		
		public void clickonPlaceOrder()
		{
			placingOrder.click();
		}
	}
	


