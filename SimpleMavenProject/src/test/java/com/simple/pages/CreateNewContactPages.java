package com.simple.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		wait = new WebDriverWait(driver, 40);
		ele= driver.findElement(By.xpath("//button[@title='Create new contact']//span[contains(@id,'id')]"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public void userShouldSeeAddNewContactWindow() {
		try {
			ele= driver.findElement(By.id("GivenName"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			boolean flag =  ele.isDisplayed();
			Assert.assertTrue(flag);
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

	public void createNewContact() {
		driver.findElement(By.id("GivenName")).sendKeys("Divya");
		driver.findElement(By.id("Surname")).sendKeys("Palacholla");
		driver.findElement(By.id("PersonaEmails1-0")).sendKeys("divyaunicorn@outlook.com");
		driver.findElement(By.id("PersonaMobilePhones-0")).sendKeys("5698745232");
		driver.findElement(By.id("PersonaCompanyNames-0")).sendKeys("Accenture");
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		driver.switchTo().defaultContent();
	}

	public void clickOnCreateContactOption() {
		driver.findElement(By.xpath("//span[text()='Create']")).click();
	}

	public void veriyingTheCreateButton() {
		ele = driver.findElement(By.xpath("//span[text()='Create']"));
		boolean flag = ele.isEnabled();
		Assert.assertFalse(flag);
	}

	public void navigateToAddMoreOptions() {
		ele = driver.findElement(By.xpath("//button[@data-log-name='ContactEditorAdd']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	public void verifyingTheOptionsforAddMore() {
		ele = driver.findElement(By.xpath("//span[text()='Email address']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		driver.findElement(By.xpath("//button[@title='Close']//i[@data-icon-name='Cancel']")).click();
	}

	public void navigateToNewContactDropDown() {
		ele = driver.findElement(By.xpath("//button[@aria-label='Create new contact or contact list']//i"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void verifyingThedropdownOptions() {
		ele = driver.findElement(By.xpath("//button[@name='New contact list']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag = ele.isDisplayed();
		Assert.assertTrue(flag);
	}

	public void navigateToNewContactListOption() {
		ele = driver.findElement(By.xpath("//button[@name='New contact list']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	public void verifyNewContactListWindow() {
		ele = driver.findElement(By.xpath("//input[@aria-label='Type a name or an email address']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag = ele.isDisplayed();
		Assert.assertTrue(flag);
	}

	public void enterTheListOfMailsToAdd() {
		ele = driver.findElement(By.xpath("//input[@aria-label='Type a name or an email address']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("divyaunicorn@outlook.com");
		ele = driver.findElement(By.xpath("//span[text()='Add']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		ele = driver.findElement(By.xpath("//input[@aria-label='Type a name or an email address']"));
		ele.sendKeys("suman@outlook.com");
		driver.findElement(By.xpath("//span[text()='Add']")).click();
	}

	public void verifyTheDisplayedMailList() {
		ele = driver.findElement(By.xpath("//div[text()='suman@outlook.com']"));
		driver.findElement(By.xpath("//button[@title='Close']//i[@data-icon-name='Cancel']")).click();
	}

	public void navigateToNewGroupDropdown() {
		ele = driver.findElement(By.xpath("//button[@name='New group']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	public void verifyNewGroupWindow() {
		ele = driver.findElement(By.xpath("//textarea[@aria-label='DescriptionTell people the purpose of your group']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag = ele.isDisplayed();
		Assert.assertTrue(flag);
	}

	public void createNewGroup() {
		ele = driver.findElement(By.xpath("//textarea[@aria-label='DescriptionTell people the purpose of your group']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("new test group");
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		
		ele = driver.findElement(By.xpath("//input[@placeholder='Enter a name or email address']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("divyaunicorn@outlook.com");
		ele.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='Add']")).click();
		
	}

	public void createNewGroupwithoutaddingContact() {
		try {
		ele = driver.findElement(By.xpath("//textarea[@aria-label='DescriptionTell people the purpose of your group']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys("new test group");
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		ele = driver.findElement(By.xpath("//input[@placeholder='Enter a name or email address']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		driver.findElement(By.xpath("/span[text()='Not now']")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
		
	}

	public void clickOnCreateButton() {
		ele = driver.findElement(By.xpath("//span[text()='Create']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}
}
