package abstractMethodsInFile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstarctcomponent {

	WebDriver driver;
	public Abstarctcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void waitMethod(By findby)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	
	public void waitMethodInvisible(WebElement ele)
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void waitMethodVisible(WebElement ele1)
	{
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w1.until(ExpectedConditions.visibilityOf(ele1));
	}
	
	public void waitMethodVisibilityAll(WebElement ele1)
	{
		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		w2.until(ExpectedConditions.visibilityOfAllElements(ele1));
	}
}
