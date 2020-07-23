  @complete
Feature: Outlook Web Application New Event Feature Verification
  User Verify all the possible scenario's for the New Event option
   

  Scenario: User create an New Event with Adding the Title and Location
  	Given User Open the Chrome browser
    Given User is logged in to the outlook account
    When User Navigate to the Calender Module on the bottom left corner
    And clicks the new Event option on the top left corner
    Then User should enter into the new Event window
    And User should create an New Event with Valid Title and Location
    
  Scenario: User create an New Event without adding the Title
  #	Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Calender Module on the bottom left corner
    And  clicks the new Event option on the top left corner
    Then User should enter into the new Event window
    When User click on the create option without adding Title
    Then User Should see a popup message to add the Title
    
  Scenario: User create an New Event with More options
  #	Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Calender Module on the bottom left corner
    And  clicks the new Event option on the top left corner
    Then User should enter into the new Event window
    When User click on the more options link on the bottom of the New Event window
    Then User Should see a avalaible options to add more options to the Event
    
  Scenario: User create an New Event and send Invite to Others
  #	Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Calender Module on the bottom left corner
    And  clicks the new Event option on the top left corner
    Then User should enter into the new Event window
    When User click on the more options link on the bottom of the New Event window
    Then User Should see a avalaible options to add more options to the Event
    When User enters the recipients in the invite attendees column
    Then Send Option should display instead Save option
