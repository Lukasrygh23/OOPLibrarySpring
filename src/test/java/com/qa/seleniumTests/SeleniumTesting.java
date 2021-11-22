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
			WebElement getBookLink = driver.findElement(By.id("getBookLink"));
			
			getBookLink.click();
			
			Assertions.assertNotEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
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
			
			Assertions.assertEquals("", resultBox.getText());
		}
	 
		@Test
		public void testCreateBook() {
			driver.get("http://127.0.0.1:5500/createBook.html");

			Assertions.assertEquals(driver.getTitle(), "Create a Book!");
		}
		
		@Test
		public void testCreateLicense() {
			driver.get("http://127.0.0.1:5500/createLicense.html");
			
			WebElement homeButton = driver.findElement(By.id("homeButton"));
			
			homeButton.click();
			
			Assertions.assertEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
		}
		
		@Test
		public void testDeleteBook() {
			driver.get("http://127.0.0.1:5500/deleteBook.html");	
			
			WebElement button = driver.findElement(By.id("deleteBook"));
			
			button.click();
			
			WebElement resultBox = driver.findElement(By.id("confirm"));

			
			Assertions.assertEquals("Error status: 500", resultBox.getText());
		}
		
		@Test
		public void testDeleteLicense() {
			driver.get("http://127.0.0.1:5500/deleteLicense.html");	
			
			WebElement h2 = driver.findElement(By.tagName("h2"));
			
			Assertions.assertEquals("License Deletion", h2.getText());
		}
		
		@Test
		public void testUpdateBook() {
			driver.get("http://127.0.0.1:5500/updateBook.html");
			
			WebElement button = driver.findElement(By.id("updateBook"));
			WebElement result = driver.findElement(By.id("resultField"));
			
			button.click();
			
			Assertions.assertEquals("This cannot be null.", result.getText());
		}
		
		@Test
		public void testUpdateLicense() {
			driver.get("http://127.0.0.1:5500/updateLicense.html");	
			
			WebElement button = driver.findElement(By.id("updateLicense"));
			WebElement id = driver.findElement(By.id("licenseId"));
			
			id.sendKeys("1");
			button.click();
			
			WebElement result = driver.findElement(By.id("resultField"));

			
			Assertions.assertEquals("Status: 500", result.getText());
			
		}
		
		@Test
		public void testGetAllBooks() {
			driver.get("http://127.0.0.1:5500/getAllBooks.html");
			
			WebElement H2 = driver.findElement(By.tagName("H2"));
			
			Assertions.assertEquals("Books:", H2.getText());

		}
		
		@Test
		public void testGetAllLicenses() {
			driver.get("http://127.0.0.1:5500/getAllLicenses.html");
			
			WebElement H2 = driver.findElement(By.tagName("H2"));
			
			Assertions.assertEquals("Licenses:", H2.getText());
		}
		
		
		@AfterEach
		void teardown() {
			driver.close();
		}
}
