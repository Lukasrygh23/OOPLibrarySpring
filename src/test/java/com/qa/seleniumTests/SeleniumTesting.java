package com.qa.seleniumTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTesting {

		private WebDriver driver;
		
		@BeforeEach
		void setup() {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			//I'm using chrome, it has to be a CHROME driver.
			driver = new ChromeDriver(); 
			
			// Create a new browser window with these measurements
			driver.manage().window().setSize(new Dimension(1366, 768)); 
		}
		
		@Test
		public void testIndexPageOpening() {
			driver.get("http://127.0.0.1:5500/index.html");
			Assertions.assertEquals("Library Landing Spot", driver.getTitle() );
		}
		
		@Test
		public void testGetBookH2() {
			driver.get("http://127.0.0.1:5500/getBook.html");
			
			WebElement firstHeader = driver.findElement(By.id("toph2")); 
			
			Assertions.assertEquals("Check a book!", firstHeader.getText());
		}
		
		@Test
		public void testGetLicenseBottomP() {
			driver.get("http://127.0.0.1:5500/getLicense.html");
			
			WebElement resultBox = driver.findElement(By.id("resultBox"));
			
			Assertions.assertEquals("Json incoming!", resultBox.getText());
		}
		
		@Test
		public void testCreateBook() {
			driver.get("http://127.0.0.1:5500/createBook.html");
		}
		
		@Test
		public void testCreateLicense() {
			driver.get("http://127.0.0.1:5500/createLicense.html");
		}
		
		@Test
		public void testDeleteBook() {
			driver.get("http://127.0.0.1:5500/deleteBook.html");	
		}
		
		@Test
		public void testDeleteLicense() {
			driver.get("http://127.0.0.1:5500/deleteLicense.html");	
		}
		
		@Test
		public void testUpdateBook() {
			driver.get("http://127.0.0.1:5500/updateBook.html");
		}
		
		@Test
		public void testUpdateLicense() {
			driver.get("http://127.0.0.1:5500/updateLicense.html");	
		}
		
		
		
		
		
		@AfterEach
		void teardown() {
			driver.close();
		}
}
