package learningSelenium.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import abstractMethodsInFile.Abstarctcomponent;

public class OrdersPage extends Abstarctcomponent{
WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement Orders;
	
	@FindBy(tagName="h1")
	WebElement yourOrders;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrderNames;

	
	@Test
	public void clickOnOrders()
	{
		Orders.click();
	}
	
	@Test
	public boolean validateOrdersHistory(String productnamelist)
	{
		waitMethodVisible(yourOrders);
		boolean desiredProd= OrderNames.stream().anyMatch(OrderName->OrderName.getText().equalsIgnoreCase(productnamelist));
		return desiredProd;
	}
	

}
