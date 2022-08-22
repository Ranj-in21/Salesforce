package salesForceParameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndivParameters extends ParentClass {
	
		@BeforeTest
			public void setup() {
		
				excelFile = "SalesforceIndividual";
		
			}
					@Test(dataProvider = "TestData")
				
		public void individualSalesforce(String SearchBox1, String Name, String SearchBox2, String LastName) throws InterruptedException  {
										
				/*Type 'Individuals' on Search box*/
			driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys(SearchBox1);
			Thread.sleep(2000);
			
				/*Click Individuals link*/
			driver.findElement(By.xpath("//span//p[@class='slds-truncate']")).click();

				/*Click New*/
			driver.findElement(By.xpath("//a/div[text()='New']")).click();

				/*Select Salutation*/
			driver.findElement(By.xpath("(//div/a[text()='--None--'])[1]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//div/a[@class='select'])[1]")).click();
			WebElement dropdown = driver.findElement(By.xpath("//a[@title='Ms.']"));
			driver.executeScript("arguments[0].click();", dropdown);

				/*Type Last Name*/
			driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys(Name);

				/*Click Save*/
			driver.findElement(By.xpath("(//button/span[@class=' label bBody'])[5]")).click();

			Thread.sleep(2000);

				/*Click on App Launcher*/
			WebElement dots = driver.findElement(By.xpath("//button//div[@class='slds-icon-waffle']"));
			driver.executeScript("arguments[0].click();", dots);

				/*Click View All*/
			driver.findElement(By.xpath("//button[@class='slds-button']")).click();

			Thread.sleep(2000);

				/*Type Customers on Search box*/
			driver.findElement(By.xpath("(//div/input[@class='slds-input'])[2]")).sendKeys(SearchBox2);

				/*Click Customers Link*/
			driver.findElement(By.xpath("//span//p[@class='slds-truncate']")).click();

				/*Click New*/
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a/div[@title='New'])[1]")).click();

				/*Type the name already provided*/
			driver.findElement(By.xpath("//div/input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")).sendKeys(LastName);

				/*Name confirmation*/
			String text = driver.findElement(By.xpath("(//div[@title='Ranjini'])[1]")).getText();
			System.out.println("Name Displayed: " +text);

			if(text.equalsIgnoreCase("Ranjini")) {
	
				System.out.println("Same name displayed");
			
			}else {
	
				System.out.println("Different name displayed");
	
			}
					
		}
					/*
					 * @DataProvider(name = "TestData") public String[][] fetchData() throws
					 * IOException {
					 * 
					 * String[][] readData = ExcelData.readData("SalesforceIndividual"); return
					 * readData;
					 * 
					 * }
					 */
	

}
