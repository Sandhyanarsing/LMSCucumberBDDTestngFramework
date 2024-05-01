Feature: Login into application
    
 
 @InvalidUrl   
 Scenario: Validating invalid url flow for login  
    Given user is opening browser
    When admin enters inValid app url
    Then LMS app should throw 404 error
    
    
 @Login 
 Scenario: Validating valid url flow for login  
   
    Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page

 