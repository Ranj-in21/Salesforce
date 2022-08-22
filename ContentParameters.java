package salesForceParameters;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class ContentParameters extends ParentClass{
		
		@BeforeTest
	public void setup() {
			
			excelFile = "SalesforceContent";
		}
		
				@Test(dataProvider = "TestData")	
		public void ContentSalesforce(String SearchBox, String Questions, String Details ) throws InterruptedException {
					
				/*Type 'Content' on Search box*/
			driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys(SearchBox);
			Thread.sleep(2000);
			
				/*Click Content link*/
			driver.findElement(By.xpath("//span//p[@class='slds-truncate']")).click();
	
				/*Click Chatter tab*/
			WebElement chatter = driver.findElement(By.xpath("(//a/span[@class='slds-truncate'])[2]"));
			driver.executeScript("arguments[0].click();", chatter);
	
				/*Verify Chatter title on the page*/
			Thread.sleep(2000);
			String title = driver.getTitle();
			System.out.println(title);
	
			if(title.equalsIgnoreCase("Chatter Home | Salesforce")) {
		
				System.out.println("Title Verified");
		
			} else {
		
				System.out.println("Title Mismatch");
		
			}

	
				/*Click Question tab*/
			driver.findElement(By.xpath("(//li//a[@class='tabHeader'])[3]")).click();
	
				/*Type Question*/
			driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(Questions);
	
				/*Type Details*/
			driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(Details);
	
				/*Click Ask*/
			driver.findElement(By.xpath("//div//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']")).click();
	
				/*Confirm the question appears*/
			String text = driver.findElement(By.xpath("//div/span[@class='uiOutputText']")).getText();
			System.out.println(text);
	
			if(text.equalsIgnoreCase("Can I filter the Chatter feed to show only questions?")) {
		
				System.out.println("Question Appeared");
		
			}else {
		
				System.out.println("Question not Appeared");
		
			}
	
	}
	
				/*
				 * @DataProvider(name = "TestData") public String[][] fetchData() throws
				 * IOException {
				 * 
				 * String[][] readData = ExcelData.readData("SalesforceContent"); return
				 * readData;
				 * 
				 * }
				 */

}
