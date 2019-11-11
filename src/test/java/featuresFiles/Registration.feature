Feature: Registration
  As a new user I should be able to register myself on the Pony Club website
 Scenario: Create a New User account
   Given I am on home page
   And I go to login page
   And I should be able to see Login page with link to Create an account
   And I will click on <Crate an account> button in login page
   And I should see Registration form page
   And I enter the following details personal details
     | Title     		 | FirstName 		 |	LastName 		  |	TelephoneNumber |
     |Random Selection   |Automated FirstName|	Automated LastName|	01234567890 	|
   And I enter the following details address details
     | PostCode | Address 1 	  |	Address 2 		|	Town    | County           |   Country	         |
     |  SE1 9HF | London Address 1|	London Address 2|	London 	| Auto Selected |	Auto Selected |
   And I enter the following details account details
     | eMail     		     | ConfirmEmail 		 |	Password  |	ConfirmPassword |
     |  automated@test.com   |automated@test.com     |	Password1 |	Password1   	|
   And I accept Terms & Conditions
   And I click <Create account> button to submit the form
   Then I should see "Thank you" and activate yor account message


