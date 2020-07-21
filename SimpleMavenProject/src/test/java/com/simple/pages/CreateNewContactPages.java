package com.simple.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewContactPages {

	private WebDriver driver;
	public WebDriverWait wait;
	public WebElement ele;

	public CreateNewContactPages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToAddContactsModule() {
		wait = new WebDriverWait(driver, 40);
		ele= driver.findElement(By.xpath("//a[@title='People']//i[@data-icon-name='People']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
	
	public void navigateToAddContactOption() {
		driver.findElement(By.xpath("//button[@title='Create new contact']//span[text()='New contact']")).click();
	
	}
	
	public void userShouldSeeAddNewContactWindow() {
		try {
		ele= driver.findElement(By.id("GivenName"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag =  ele.isDisplayed();
		Assert.assertTrue(flag);
		driver.findElement(By.id("GivenName")).sendKeys("Divya");
		driver.findElement(By.id("Surname")).sendKeys("Palacholla");
		driver.findElement(By.id("PersonaEmails1-0")).sendKeys("divyaunicorn@outlook.com");
		driver.findElement(By.id("PersonaMobilePhones-0")).sendKeys("5698745232");
		driver.findElement(By.id("PersonaCompanyNames-0")).sendKeys("Accenture");
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		driver.switchTo().defaultContent();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		finally {
			driver.findElement(By.xpath("//div[@id='meInitialsButton']/following-sibling::div/img")).click();
			ele= driver.findElement(By.id("meControlSignoutLink"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}
		
	}
}
