package learningSelenium.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import abstractMethodsInFile.Abstarctcomponent;

public class LandingPage extends Abstarctcomponent {
 WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	WebElement username;
	
	
	@FindBy(css="input[type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorm;
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loginApp(String semail, String spassword)
	{
		username.sendKeys(semail);
		password.sendKeys(spassword);
		login.click();
	}
	
	public String errorMesageValidation(String eemail, String epass)
	{
		username.sendKeys(eemail);
		password.sendKeys(epass);
		login.click();
		waitMethodVisible(errorm);
		String err = errorm.getText();
		return err;
		
	}

}
