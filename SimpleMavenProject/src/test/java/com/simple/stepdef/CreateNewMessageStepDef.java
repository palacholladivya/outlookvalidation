package com.simple.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.simple.pages.CreateNewContactPages;
import com.simple.pages.CreateNewEventPages;
import com.simple.pages.CreateNewMessagePages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewMessageStepDef {
	
	public static CreateNewMessagePages createNewMessagePages;
	public static WebDriver driver;
	public static CreateNewEventPages createNewEventPages;
	public static CreateNewContactPages createNewContactPages;
	
	
	@Given("^User Open the Chrome browser$")					
    public WebDriver user_open_the_chrome_browser() throws Throwable							
    {		
		String chromepath = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver\\chromedriver.exe";
		System.out.println(chromepath);
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://outlook.live.com/owa/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createNewMessagePages = new CreateNewMessagePages(driver);
		createNewEventPages = new CreateNewEventPages(driver);
		createNewContactPages = new CreateNewContactPages(driver);
		return driver;
    }		
	
	@Given("^User is logged in to the outlook account$")
	public void user_is_logged_in_to_the_outlook_account() throws Throwable {
		
		createNewMessagePages.logintoOutlook();
	}

	@When("^User Navigates to the Mail Module on the bottom left corner$")
	public void user_Navigates_to_the_Mail_Module_on_the_bottom_left_corner() throws Throwable {
		createNewMessagePages.navigateToMailModule();
	}

	@When("^User clicks on the new message option on the top left corner$")
	public void user_clicks_on_the_new_message_option_on_the_top_left_corner() throws Throwable {
		createNewMessagePages.navigatetoNewMessageOption();
	}

	@Then("^User should enter into the new message window$")
	public void user_should_enter_into_the_new_message_window() throws Throwable {
		createNewMessagePages.newMessgeWindowAvalaible();
	}

	@When("^User Navigate to the Calender Module on the bottom left corner$")
	public void user_Navigate_to_the_Calender_Module_on_the_bottom_left_corner() throws Throwable {
		createNewEventPages.navigateToNewEvenModule();
	}

	@When("^clicks the new Event option on the top left corner$")
	public void clicks_the_new_Event_option_on_the_top_left_corner() throws Throwable {
		createNewEventPages.navigateToAddNewEventOption();
	}

	@Then("^User should enter into the new Event window$")
	public void user_should_enter_into_the_new_Event_window() throws Throwable {
		createNewEventPages.userShouldNavigatetoNewEventWindow();
	}

	@When("^User Navigate to the Contact Module on the bottom left corner$")
	public void user_Navigate_to_the_Contact_Module_on_the_bottom_left_corner() throws Throwable {
		createNewContactPages.navigateToAddContactsModule();
	}

	@When("^clicks the new Contact option on the top left corner$")
	public void clicks_the_new_Contact_option_on_the_top_left_corner() throws Throwable {
		createNewContactPages.navigateToAddContactOption();
	}

	@Then("^User should enter into the Add Contacts window$")
	public void user_should_enter_into_the_Add_Contacts_window() throws Throwable {
		createNewContactPages.userShouldSeeAddNewContactWindow();
	}
}
