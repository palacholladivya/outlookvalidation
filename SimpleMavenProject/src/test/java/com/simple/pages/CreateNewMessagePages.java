package com.simple.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simple.base.EncodingDecoding;

public class CreateNewMessagePages{

	private WebDriver driver;
	public WebDriverWait wait;
	public WebElement ele;
	public Properties properties;
	
	public CreateNewMessagePages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how=How.LINK_TEXT, using="Sign in")
	private WebElement sign_in_page;

	public void logintoOutlook() throws IOException {
		wait  = new WebDriverWait(driver, 40);
		//Using for Password encryption and decryption
		EncodingDecoding encodeDecode = new EncodingDecoding();
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\propertyfiles\\logindetails.properties";
		FileReader fileStream = new FileReader(new File(filePath));
		properties = new Properties();
		
		//Loading the Properties files
		properties.load(fileStream);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Sign in"))));
		driver.findElement(By.linkText("Sign in")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("loginfmt"))));
		driver.findElement(By.name("loginfmt")).sendKeys(properties.getProperty("username"));
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		driver.findElement(By.name("passwd")).sendKeys(encodeDecode.decodeString(properties.getProperty("password")));
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	}

	public void navigateToMailModule() {
		ele = driver.findElement(By.xpath("//div[contains(@class ,'ms-OverflowSet-item')]//button//i[@data-icon-name='Mail']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	public void navigatetoNewMessageOption() {
		ele = driver.findElement(By.xpath("//span[text()='New message']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public void newMessgeWindowAvalaible() {
		try {
		ele = driver.findElement(By.xpath("//div[contains(@class,'RecipientWellLabelWithContactPicker')]/following-sibling::input"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag = ele.isDisplayed();
		Assert.assertTrue(flag);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	public void entersthevalidrecipientandsubject() {
		
		ele = driver.findElement(By.xpath("//div[contains(@class,'RecipientWellLabelWithContactPicker')]/following-sibling::input"));
		
		ele.sendKeys("divyaunicorn@outlook.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Add a subject']")).sendKeys("Test Mail");
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Hi,This is a test mail.");
		
		driver.findElement(By.xpath("//button[@title='Send (Ctrl+Enter)']")).click();
		
	}

	public void sendingMessageWithoutSubjectLine() {
		
		ele = driver.findElement(By.xpath("//div[contains(@class,'RecipientWellLabelWithContactPicker')]/following-sibling::input"));
		
		ele.sendKeys("divyaunicorn@outlook.com");
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Hi,This is a test mail.");
		
		driver.findElement(By.xpath("//button[@title='Send (Ctrl+Enter)']")).click();
		
	}

	public void poupmessageForTheEmptySubjectLine() {
		ele = driver.findElement(By.xpath("//div[text()='Missing subject']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag =  ele.isDisplayed();
		Assert.assertTrue(flag);
		ele = driver.findElement(By.xpath("//button[@id='cancel-0']"));
		ele.click();
	}

	public void popupMessageforTheemptyRecipient() {
		ele = driver.findElement(By.xpath("//span[text()='This message must have at least one recipient.']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag =  ele.isDisplayed();
		Assert.assertTrue(flag);
		ele = driver.findElement(By.xpath("//button[@id='cancel-0']"));
		ele.click();
		
	}

	public void sendingMessgeWithoutRecipient() {
		
		driver.findElement(By.xpath("//input[@placeholder='Add a subject']")).sendKeys("Test Mail");
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Hi,This is a test mail.");
		
		driver.findElement(By.xpath("//button[@title='Send (Ctrl+Enter)']")).click();
		
	}

	public void sendingMessagetoOutsideOutllookRecipient() {
		
		ele = driver.findElement(By.xpath("//div[contains(@class,'RecipientWellLabelWithContactPicker')]/following-sibling::input"));
		
		ele.sendKeys("divya.palachollaunicorn@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Add a subject']")).sendKeys("Test Mail");
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Hi,This is a test mail for outside outlook recipient.");
		
		driver.findElement(By.xpath("//button[@title='Send (Ctrl+Enter)']")).click();
		
	}

	public void messageSendingtoOutsideRecipient() {
		System.out.println("Message sent to outside recipient");
	}

	public void sendingMessagewithoutAttachement() {
		ele = driver.findElement(By.xpath("//div[contains(@class,'RecipientWellLabelWithContactPicker')]/following-sibling::input"));
		
		ele.sendKeys("divya.palachollaunicorn@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Add a subject']")).sendKeys("Test Mail");
		
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Hi, please find the aatachment for the test document.");
		
		driver.findElement(By.xpath("//button[@title='Send (Ctrl+Enter)']")).click();
		
	}

	public void popUpMessagefortheattachmentoption() {
		try {
		ele = driver.findElement(By.xpath("//div[text()='Attachment reminder']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		boolean flag =  ele.isDisplayed();
		Assert.assertTrue(flag);
		ele = driver.findElement(By.xpath("//button[@id='cancel-0']"));
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
