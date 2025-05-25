package samreen.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import learningSelenium.SeleniumFrameworkDesign.Checkoutpage;
import learningSelenium.SeleniumFrameworkDesign.Confirmationpage;
import learningSelenium.SeleniumFrameworkDesign.LandingPage;
import learningSelenium.SeleniumFrameworkDesign.OrdersPage;
import learningSelenium.SeleniumFrameworkDesign.PlaceorderPage;
import learningSelenium.SeleniumFrameworkDesign.Productcatalogue;
import samreen.testcomponents.BaseTest;

public class Standalonetest extends BaseTest {

	String semail = "samreen@gmail.com";
	String spassword = "Allah@786";
	String productnamelist = "ZARA COAT 3";
	String ctr = "India";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String,String> input)
			throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.loginApp(input.get("semail"), input.get("spassword"));

		Productcatalogue pc = new Productcatalogue(driver);
		pc.getProductslist();
		pc.getProductname(input.get("productnamelist"));
		pc.addCart();

		Checkoutpage c = new Checkoutpage(driver);
		boolean val = c.checkoutPage(input.get("productnamelist"));
		Assert.assertTrue(val);
		c.finalCheckout();
		PlaceorderPage p = new PlaceorderPage(driver);
		List<WebElement> drpcountrylist = p.countryEnter();
		p.CountrySelection(drpcountrylist, ctr);
		p.clickonPlaceOrder();
		Confirmationpage con = new Confirmationpage(driver);
		String confirm = con.GetConfirmationMsg();
		Assert.assertEquals(confirm, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderPage() {
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.loginApp(semail, spassword);
		OrdersPage op = new OrdersPage(driver);
		op.clickOnOrders();
		boolean ValMatch = op.validateOrdersHistory(productnamelist);
		Assert.assertTrue(ValMatch);

	}
	
	

	@DataProvider()
	public Object[][] getData() throws IOException {

		/*HashMap<String,String> map = new HashMap<String,String>();
		map.put("semail", "samreen@gmail.com");
		map.put("spassword", "Allah@786");
		map.put("productnamelist", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("semail", "nowreen@gmail.com");
		map1.put("spassword", "Allah@786");
		map1.put("productnamelist", "ADIDAS ORIGINAL"); */
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\samreen\\data\\purchasefile.json");
		return new Object[][] { {data.get(0)},
				{data.get(1)} };
	}
}
