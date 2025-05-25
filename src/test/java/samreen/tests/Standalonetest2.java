package samreen.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import learningSelenium.SeleniumFrameworkDesign.LandingPage;

public class Standalonetest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String username = "samreen@gmail.com";
		String password = "Allah@786";
		String productnamelist = "ADIDAS ORIGINAL";
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		LandingPage lp = new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		List<WebElement> Items = driver.findElements(By.xpath("//div[contains(@class,'offset-sm-1')]//b"));
		
		WebElement addToCart = driver.findElement(By.xpath("(//b[text()='" + productnamelist + "']//following::button/i[@class='fa fa-shopping-cart'])[1]"));
        
        for (WebElement item : Items) {
            if (item.getText().equals(productnamelist)) {
                addToCart.click();
                break; // Exit the loop after clicking the matching item
            }
        }


		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> cartlists = driver.findElements(By.xpath("//div[@class='cartSection'] //h3"));
		boolean val = cartlists.stream().anyMatch(cartlist -> cartlist.getText().equalsIgnoreCase(productnamelist));
		Assert.assertTrue(val);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		w.until(ExpectedConditions
				.visibilityOfAllElements(driver.findElements(By.cssSelector("section[class*='list-group']"))));

		List<WebElement> results = driver.findElements(By.cssSelector("section[class*='list-group']"));
		for (WebElement result : results) {
			result.getText();
			System.out.println(result.getText());
	
			if (result.getText().equalsIgnoreCase("India"))
			
			Thread.sleep(3000);
				result.click();

		}
		
		driver.findElement(By.cssSelector("a[class*='btnn']")).click();
		String value = driver.findElement(By.className("hero-primary")).getText().trim();
		System.out.println(value);
		Assert.assertEquals(value,"THANKYOU FOR THE ORDER.");
		

	}
	
}
