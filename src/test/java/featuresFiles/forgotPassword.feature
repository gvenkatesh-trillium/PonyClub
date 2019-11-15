Feature: Forgotten Password
  In order to gain access to the site as existing user
  I would like to be able to get a reset password link to reset my password if I forget my password
  Scenario: As a PonyClub existing user I want reset my password if I forget my password
    Given I am on home page
    And I go to login page
    And I should see Login page
    And I should see the "Forgot your password?" link
    And I click on "forgot password" link
    And I should see the "Forgotten Password" page
    And I enter valid username as "TrilliumEmailTest@protonmail.com" and I click <Submit> button
    Then I should see eMail sent message
    And I go to my inbox and click on reset password link
    And I should see reset password page
    And I enter new password and click <Submit>
    Then I should see message "Thank You" and "Your password has been successfully changed."
