package samreen.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import learningSelenium.SeleniumFrameworkDesign.Checkoutpage;
import learningSelenium.SeleniumFrameworkDesign.Confirmationpage;
import learningSelenium.SeleniumFrameworkDesign.LandingPage;
import learningSelenium.SeleniumFrameworkDesign.PlaceorderPage;
import learningSelenium.SeleniumFrameworkDesign.Productcatalogue;
import samreen.testcomponents.BaseTest;

public class Errorvalidations extends BaseTest {
	
	@Test(groups= {"error"})
	
	public void GetGerror() throws IOException
	{
	
	String eemail = "sam@gmail.com";
	String epass = "123";	
	LandingPage l = new LandingPage(driver);
	l.goTo();
	String err = l.errorMesageValidation(eemail, epass);
	Assert.assertEquals("Incorrect email or password.", err);
	
	}
	
	public void sysout() {
		// TODO Auto-generated method stub
		System.out.println("love");
		System.out.println("hate");
	}
	
}
