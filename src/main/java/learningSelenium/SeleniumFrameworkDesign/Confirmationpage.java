package learningSelenium.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractMethodsInFile.Abstarctcomponent;

	
	public class Confirmationpage extends Abstarctcomponent{
		WebDriver driver;
		
			
			public Confirmationpage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}




		@FindBy(className="hero-primary")
		WebElement confirmText;
		
		public String GetConfirmationMsg()
		{
			String value =confirmText.getText().trim();
			System.out.println(value);
			return value;
		}
		
		
		
}
	