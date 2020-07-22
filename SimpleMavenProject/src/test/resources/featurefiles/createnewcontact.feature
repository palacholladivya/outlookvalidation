@complete
Feature: Outlook Web Application New Contact Feature Verification
  User Verify all the possible scenario's for the Add Contact option
  
  Scenario: Verify the Add Contacts option with correct details
    Given User Open the Chrome browser
    Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the new Contact option on the top left corner
    Then User should enter into the Add Contacts window
    And User should create the New Contact with correct details
    
  Scenario: Verify the Create Contacts option without adding details
    #Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the new Contact option on the top left corner
    Then User should enter into the Add Contacts window
    When User should clicks the create option without adding details
    Then Create button should be disabled
    
  Scenario: Verify the Add More options button in the New Contact widow
    #Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the new Contact option on the top left corner
    Then User should enter into the Add Contacts window
    When User should clicks the Add More options
    Then User should see the Avalaible Options for Adding contact
    
  Scenario: Verify the Add More options button in the New Contact widow
    #Given User Open the Chrome browser
    #And User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the new Contact option on the top left corner
    Then User should enter into the Add Contacts window
    When User should clicks the Add More options
    Then User should see the Avalaible Options for Adding contact
    
    
  Scenario: Verify the DropDown Menu button in the New Contact
    #Given User Open the Chrome browser
    #And User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the New Contact dropdown on the top left corner
    Then User should see the Avlaible dropDown options
    When User clicks on the New Contact List option
    Then New Contact List window should appear on the screen
    
  Scenario: Verify the Add New Contact List Feature
    #Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the New Contact dropdown on the top left corner
    Then User should see the Avlaible dropDown options
    When User clicks on the New Contact List option
    Then New Contact List window should appear on the screen
    When User enter multiple emails using add option
    Then User can see the list of added mails down the email column
    
  Scenario: Verify the Add New Group Feature
    #Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the New Contact dropdown on the top left corner
    Then User should see the Avlaible dropDown options
    When User clicks on the New Group option
    Then New Group window should appear on the screen
    And User should create new Group
    
  Scenario: Verify the Create button for the New Group
    #Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the New Contact dropdown on the top left corner
    Then User should see the Avlaible dropDown options
    When User clicks on the New Group option
    Then New Group window should appear on the screen
    When User clicks the create button without giving details
    Then Create button should be disabled
    
  Scenario: Verify the New Group feature without adding contacts
    #Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigate to the Contact Module on the bottom left corner
    And clicks the New Contact dropdown on the top left corner
    Then User should see the Avlaible dropDown options
    When User clicks on the New Group option
    Then New Group window should appear on the screen
    And User should create new Group without adding contact