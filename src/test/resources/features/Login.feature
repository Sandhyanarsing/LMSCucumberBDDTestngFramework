@Login
Feature: Login into application
  
 Scenario: User is already on LMS application Login page
   
    Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page
    
 