package learningSelenium.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractMethodsInFile.Abstarctcomponent;


public class Checkoutpage extends Abstarctcomponent{

	WebDriver driver;
	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cartSection'] //h3")
     List<WebElement> cartlists;
	
	@FindBy(xpath="//button[text()='Checkout']")
    WebElement checkout;
	

	public boolean checkoutPage(String productnamelist)
	{
		boolean val = cartlists.stream().anyMatch(cartlist -> cartlist.getText().equalsIgnoreCase(productnamelist));
		return val;
		
	}
	
	public void finalCheckout()
	{
		checkout.click();
	}

}




