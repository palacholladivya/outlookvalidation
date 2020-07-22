package com.simple.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewEventPages {
	
	public static WebDriver driver;
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
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'TextField') and @placeholder='Add a title']"))));
			boolean flag = driver.findElement(By.xpath("//input[contains(@id,'TextField') and @placeholder='Add a title']")).isDisplayed();
			Assert.assertTrue(flag);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void createNewEventWithValidDetails() {
		driver.findElement(By.xpath("//input[contains(@id,'TextField') and @placeholder='Add a title']")).sendKeys("Test Event Mail");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
	}

	public void clickonCreateOptionWithoutAddingTitle() {
		driver.findElement(By.xpath("//span[text()='Save']")).click();
	}

	public void popUpMessageToAddTitle() {
			ele = driver.findElement(By.xpath("//div[text()='Missing title']"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			boolean flag = ele.isDisplayed();
			Assert.assertTrue(flag);
			driver.findElement(By.xpath("//div[@id='cancel-0']")).click();
	}
	
	public void navigateToMoreOptionsForTheEvent() {
		ele = driver.findElement(By.xpath("//button[text()='More options']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
	
	public void displayMoreOptionsforTheEvent() {
		ele = driver.findElement(By.xpath("//input[@aria-label='Invite attendees']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag = ele.isDisplayed();
		Assert.assertTrue(flag);
		ele = driver.findElement(By.xpath("//span[text()='Discard']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
	
	public void enterTheRecipientsForTheEvent() {
		ele = driver.findElement(By.xpath("//input[@aria-label='Invite attendees']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("divyaunicorn@outlook.com");
	}
	
	public void verifySendOptionforEvent() {
		try {
		ele = driver.findElement(By.xpath("//button[@name='Send']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag = ele.isDisplayed();
		ele.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
	}
}
