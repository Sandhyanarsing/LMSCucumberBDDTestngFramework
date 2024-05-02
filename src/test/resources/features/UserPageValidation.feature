@UserPageValidation
Feature: Validate User Page
Background:
    Given user is already on LMS app Login page
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page
  @ValidateLanding
  Scenario: Validate landing in User page
    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page











