package samreen.testcomponents;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	
	public WebDriver driverInitialisation() throws IOException
	{
		
		Properties p = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//samreen//resources//GlobalData.properties");
		p.load(fis);
		String mydrowser= System.getProperty("browser")!=null ? System.getProperty("browser") :p.getProperty("browser");
		p.getProperty("browser");
		if(mydrowser.contains("edge"))
		{
			EdgeOptions options = new EdgeOptions();
		WebDriverManager.edgedriver().setup();
		if(mydrowser.contains("headless")) {
		options.addArguments("headless");
		 driver = new EdgeDriver(options);	
		}
		}
		
		if(mydrowser.equalsIgnoreCase("chrome"))
		{
		
		 driver = new ChromeDriver();	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	@AfterMethod(alwaysRun=true)
	public void closebrowser()
	{
		driver.quit();
	}
	
	public List<HashMap<String, String>> getJsonData(String FilePath) throws IOException
	{
		String newdata = FileUtils.readFileToString(new File(FilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(newdata, new TypeReference<List<HashMap<String,String>>>() {
	});
	
		return data;
	}
	
	public String getScreenshot(String testCaseName) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.div") + "//reports//" + testCaseName + ".png"));
		return System.getProperty("user.div") + "//reports//" + testCaseName + ".png";
	}
	
	}
	


