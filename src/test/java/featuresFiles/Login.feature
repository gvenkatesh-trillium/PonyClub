Feature: Login
  PonyClub user login
  Scenario: As a PonyClub user I want to Login successfully
    Given I am on home page
    And I go to login page
    And I should see Login page
    And I enter valid username as "gvenkatesh@trillium.net" and password as "Password1"
    And I click <Submit> button
    Then I Should be redirected "Connected family" page.
