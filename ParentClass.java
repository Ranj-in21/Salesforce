package salesForceParameters;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass {
	
	public RemoteWebDriver driver;
	public String excelFile;
			@Parameters({"browserName", "URL", "UserName", "PassWord"})
			@BeforeMethod

		public void preCondition(String browserName, String url, String Username, String Password) throws InterruptedException {

			if(browserName.equalsIgnoreCase("Chrome")) {
				
				/*Browser Setup*/
				WebDriverManager.chromedriver().setup();

				/*Allow Browser Notification*/
				HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
				HashMap<String, Object> profile = new HashMap<String, Object>();
				HashMap<String, Object> prefs = new HashMap<String, Object>();
				contentSettings.put("notifications", 1);
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);	
				driver = new ChromeDriver(options);
			}
			else if(browserName.equalsIgnoreCase("Edge")) {
				
				WebDriverManager.edgedriver().setup();

				/*Allow Browser Notification*/
				HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
				HashMap<String, Object> profile = new HashMap<String, Object>();
				HashMap<String, Object> prefs = new HashMap<String, Object>();
				contentSettings.put("notifications", 1);
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				
				EdgeOptions options = new EdgeOptions();
				options.setExperimentalOption("prefs", prefs);	
				driver = new EdgeDriver(options);
				
				
			}

					/*Launch URL*/
				driver.get(url);
					/*Maximize Window*/
				driver.manage().window().maximize();
					/*Set Implicitly Wait*/
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					/*Login using username & password*/
				driver.findElement(By.id("username")).sendKeys(Username);
				driver.findElement(By.id("password")).sendKeys(Password);
				driver.findElement(By.id("Login")).click();

	//			driver.findElement(By.xpath("//p/a[text()='Remind Me Later']")).click();

				Thread.sleep(2000);

					/*Click on App launcher*/
				driver.findElement(By.xpath("//button//div[@class='slds-icon-waffle']")).click();

				Thread.sleep(2000);	
					/*Click View All*/
				driver.findElement(By.xpath("//button[@class='slds-button']")).click();


			}
	
				@AfterMethod
	
			public void postCondition() {
		
					/*Close browser*/
				driver.close();
		

				}
				
				@DataProvider(name = "TestData")
			public String[][] fetchData() throws IOException {
					
				String[][] readData = ExcelData.readData(excelFile);
				return readData;

				}

}
