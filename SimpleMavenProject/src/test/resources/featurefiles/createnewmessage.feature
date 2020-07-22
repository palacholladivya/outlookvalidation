@dryrun
Feature: Outlook Web Application New Message Feature Verification
  User Verify all the possible scenario's for the New Message option

  Scenario: User send the New Message with valid subject and valid recipient
  	Given User Open the Chrome browser
    Given User is logged in to the outlook account
    When User Navigates to the Mail Module on the bottom left corner
    When User clicks on the new message option on the top left corner
    Then User should enter into the new message window
    And User should send the message with valid subect and recipient
    
  Scenario: User send the New Message without subjectline
  	#Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigates to the Mail Module on the bottom left corner
    When User clicks on the new message option on the top left corner
    Then User should enter into the new message window
    When User send the message without Subject line 
    Then Popup message should appear on the window
    
     
  Scenario: User send the New Message without recipient
  	#Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigates to the Mail Module on the bottom left corner
    When User clicks on the new message option on the top left corner
    Then User should enter into the new message window
    When User send the message without recipient 
    Then message should appear on the top of the message
    
      
  Scenario: User send the New Message with outside outllook profile
  	#Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigates to the Mail Module on the bottom left corner
    When User clicks on the new message option on the top left corner
    Then User should enter into the new message window
    When User send the message to outside outlook recipient 
    Then message should send to the outside recipient
    
    
  Scenario: User send the New Message without attachment
  	#Given User Open the Chrome browser
    #Given User is logged in to the outlook account
    When User Navigates to the Mail Module on the bottom left corner
    When User clicks on the new message option on the top left corner
    Then User should enter into the new message window
    When User send the attachment mail message without attachment
    Then popup message should display with attachment reminder
    