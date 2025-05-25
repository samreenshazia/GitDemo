package learningSelenium.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractMethodsInFile.Abstarctcomponent;

public class Productcatalogue extends Abstarctcomponent{
 WebDriver driver;
	public Productcatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	@FindBy(xpath="//div[contains(@class,'offset-sm-1')]")
	List<WebElement> Items;
	
		
	@FindBy(className="ng-animating")
	WebElement load;
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement finalAdd;
	
	By toastText=By.id("toast-container");
	By addto=By.xpath("//button[text()=' Add To Cart']");

	
	public List<WebElement> getProductslist()
	{
		
		return Items;
	}
	
	public void getProductname(String productnamelist) {
		// TODO Auto-generated method stub
        List<WebElement> Items = driver.findElements(By.xpath("//div[contains(@class,'offset-sm-1')]//b"));
		
		WebElement addToCart = driver.findElement(By.xpath("(//b[text()='" + productnamelist + "']//following::button/i[@class='fa fa-shopping-cart'])[1]"));
        
        for (WebElement item : Items) {
            if (item.getText().equals(productnamelist)) {
                addToCart.click();
                break; // Exit the loop after clicking the matching item
            }
        }

	}
	
	public void addCart()
	{
		
		waitMethod(toastText);
		waitMethodInvisible(load);
		finalAdd.click();
		finalAdd.click();
		

	}
}

