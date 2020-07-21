package com.simple.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewEventPages{

	
	private WebDriver driver;
	public WebDriverWait wait;
	public WebElement ele;
	Actions action;
	
	public CreateNewEventPages(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToNewEvenModule() {
		wait  = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Calendar']//i[@data-icon-name='Calendar']"))));
		driver.findElement(By.xpath("//a[@title='Calendar']//i[@data-icon-name='Calendar']")).click();
	}

	public void navigateToAddNewEventOption() {
		ele= driver.findElement(By.xpath("//button[@id='NewEventButtonAnchor']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		action = new Actions(driver);
		action.moveToElement(ele).click(ele);
		ele.click();
	}
	
	public void userShouldNavigatetoNewEventWindow() {
		try {
		wait  = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'TextField') and @placeholder='Add a title']"))));
		boolean flag = driver.findElement(By.xpath("//input[contains(@id,'TextField') and @placeholder='Add a title']")).isDisplayed();
		Assert.assertTrue(flag);
		driver.findElement(By.xpath("//input[contains(@id,'TextField') and @placeholder='Add a title']")).sendKeys("Test Event Mail");
		//driver.findElement(By.xpath("//input[@placeholder='Invite attendees']")).sendKeys("divyaunicorn@outlook.com");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
	
	
}
