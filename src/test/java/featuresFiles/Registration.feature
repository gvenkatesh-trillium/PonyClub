Feature: Registration
  As a new user I should be able to register myself on the Pony Club website
 Scenario: As New user I want to create a new user account on Pony Club website
   Given I am on home page
   And I go to login page
   And I should be able to see Login page with link to Create an account
   And I will click on <Crate an account> button in login page
   And I should see Registration form page
   And I enter the following personal details
     | Title | FirstName           | LastName           | TelephoneNumber |
     | Miss  | Automated FirstName | Automated LastName | 01234567890     |
   And I select following address from dropdown or enter the address manually if loqate service is not available
     | PostCode | Address 1 | Address 2             | Town      | County         | Country        |
     | WR5 3DA  | Loqate    | Waterside, Basin Road | Worcester | Worcestershire | United Kingdom |
   And I enter the following details account details
     | eMail                     | ConfirmEmail              | Password  | ConfirmPassword |
     | randomGenerated@email.com | randomGenerated@email.com | Password1 | Password1       |
#   random email generated every time.
   And I accept Terms & Conditions
   And I click <Create account> button to submit the form
   Then I should see "Thank you" and activate yor account message
   Then I should be redirected to login page automatically


