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

public class StepDefFile {
	
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
	
	@Then("^User should send the message with valid subect and recipient$")
	public void user_should_send_the_message_with_valid_subect_and_recipient() throws Throwable {
		createNewMessagePages.entersthevalidrecipientandsubject();
	}

	@When("^User send the message without Subject line$")
	public void user_send_the_message_without_Subject_line() throws Throwable {
		createNewMessagePages.sendingMessageWithoutSubjectLine();
	}

	@Then("^Popup message should appear on the window$")
	public void popup_message_should_appear_on_the_window() throws Throwable {
		createNewMessagePages.poupmessageForTheEmptySubjectLine();
	}

	@When("^User send the message without recipient$")
	public void user_send_the_message_without_recipient() throws Throwable {
		createNewMessagePages.sendingMessgeWithoutRecipient();
	}

	@Then("^message should appear on the top of the message$")
	public void message_should_appear_on_the_top_of_the_message() throws Throwable {
		createNewMessagePages.popupMessageforTheemptyRecipient();
	}

	@When("^User send the message to outside outlook recipient$")
	public void user_send_the_message_to_outside_outlook_recipient() throws Throwable {
		createNewMessagePages.sendingMessagetoOutsideOutllookRecipient();
	}

	@Then("^message should send to the outside recipient$")
	public void message_should_send_to_the_outside_recipient() throws Throwable {
		createNewMessagePages.messageSendingtoOutsideRecipient();
	}

	@When("^User send the attachment mail message without attachment$")
	public void user_send_the_attachment_mail_message_without_attachment() throws Throwable {
		createNewMessagePages.sendingMessagewithoutAttachement();
	}

	@Then("^popup message should display with attachment reminder$")
	public void popup_message_should_display_with_attachment_reminder() throws Throwable {
		createNewMessagePages.popUpMessagefortheattachmentoption();
	}
	@When("^User Navigate to the Calender Module on the bottom left corner$")
	public void user_Navigate_to_the_Calender_Module_on_the_bottom_left_corner() throws Throwable {
		createNewEventPages = new CreateNewEventPages(driver);
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
	
	@Then("^User should create an New Event with Valid Title and Location$")
	public void user_should_create_an_New_Event_with_Valid_Title_and_Location() throws Throwable {
		createNewEventPages.createNewEventWithValidDetails();
	}

	@When("^User click on the create option without adding Title$")
	public void user_click_on_the_create_option_without_adding_Title() throws Throwable {
		createNewEventPages.clickonCreateOptionWithoutAddingTitle();
	}

	@Then("^User Should see a popup message to add the Title$")
	public void user_Should_see_a_popup_message_to_add_the_Title() throws Throwable {
		createNewEventPages.popUpMessageToAddTitle();
	}

	@When("^User click on the more options link on the bottom of the New Event window$")
	public void user_click_on_the_more_options_link_on_the_bottom_of_the_New_Event_window() throws Throwable {
		createNewEventPages.navigateToMoreOptionsForTheEvent();
	}

	@Then("^User Should see a avalaible options to add more options to the Event$")
	public void user_Should_see_a_avalaible_options_to_add_more_options_to_the_Event() throws Throwable {
		createNewEventPages.displayMoreOptionsforTheEvent();
	}

	@When("^User enters the recipients in the invite attendees column$")
	public void user_enters_the_recipients_in_the_invite_attendees_column() throws Throwable {
	   createNewEventPages.enterTheRecipientsForTheEvent();
	}

	@Then("^Send Option should display instead Save option$")
	public void send_Option_should_display_instead_Save_option() throws Throwable {
		createNewEventPages.verifySendOptionforEvent();
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
	
	@Then("^User should create the New Contact with correct details$")
	public void user_should_create_the_New_Contact_with_correct_details() throws Throwable {
		createNewContactPages.createNewContact();
	}

	@When("^User should clicks the create option without adding details$")
	public void user_should_clicks_the_create_option_without_adding_details() throws Throwable {
		createNewContactPages.clickOnCreateContactOption();
	}

	@Then("^Create button should be disabled$")
	public void create_button_should_be_disabled() throws Throwable {
		createNewContactPages.veriyingTheCreateButton();
	}

	@When("^User should clicks the Add More options$")
	public void user_should_clicks_the_Add_More_options() throws Throwable {
		createNewContactPages.navigateToAddMoreOptions();
	}

	@Then("^User should see the Avalaible Options for Adding contact$")
	public void user_should_see_the_Avalaible_Options_for_Adding_contact() throws Throwable {
		createNewContactPages.verifyingTheOptionsforAddMore();
	}

	@When("^clicks the New Contact dropdown on the top left corner$")
	public void clicks_the_New_Contact_dropdown_on_the_top_left_corner() throws Throwable {
		createNewContactPages.navigateToNewContactDropDown();
	}

	@Then("^User should see the Avlaible dropDown options$")
	public void user_should_see_the_Avlaible_dropDown_options() throws Throwable {
		createNewContactPages.verifyingThedropdownOptions();
	}

	@When("^User clicks on the New Contact List option$")
	public void user_clicks_on_the_New_Contact_List_option() throws Throwable {
	    createNewContactPages.navigateToNewContactListOption();
	}

	@Then("^New Contact List window should appear on the screen$")
	public void new_Contact_List_window_should_appear_on_the_screen() throws Throwable {
		createNewContactPages.verifyNewContactListWindow();
	}

	@When("^User enter multiple emails using add option$")
	public void user_enter_multiple_emails_using_add_option() throws Throwable {
		createNewContactPages.enterTheListOfMailsToAdd();
	}

	@Then("^User can see the list of added mails down the email column$")
	public void user_can_see_the_list_of_added_mails_down_the_email_column() throws Throwable {
		createNewContactPages.verifyTheDisplayedMailList();
	}

	@When("^User clicks on the New Group option$")
	public void user_clicks_on_the_New_Group_option() throws Throwable {
		createNewContactPages.navigateToNewGroupDropdown();
	}

	@Then("^New Group window should appear on the screen$")
	public void new_Group_window_should_appear_on_the_screen() throws Throwable {
		createNewContactPages.verifyNewGroupWindow();
	}

	@Then("^User should create new Group$")
	public void user_should_create_new_Group() throws Throwable {
		createNewContactPages.createNewGroup();
	}
	
	@Then("^User should create new Group without adding contact$")
	public void user_should_create_new_Group_without_adding_contact() throws Throwable {
		createNewContactPages.createNewGroupwithoutaddingContact();
	}

	@When("^User clicks the create button without giving details$")
	public void user_clicks_the_create_button_without_giving_details() throws Throwable {
		createNewContactPages.clickOnCreateButton();
	}
}
