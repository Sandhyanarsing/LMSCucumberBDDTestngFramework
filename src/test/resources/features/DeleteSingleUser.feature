Feature: DeleteSingleUser

Background:
    Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page

    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
 
   Given Admin is on Manage User Page
   When Admin clicks any checkbox in the data table
   Then Admin clicks the Delete button
   
Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert
When Admin clicks <NO> button on the alert
Then Admin should land on Manage User page and can see the selected user is not deleted from the data table

Scenario: Validate multiple program deletion by selecting Single checkbox
Given Admin is on Confirm Deletion alert
When Admin clicks <YES> button on the alert
Then Admin should land on Manage User page and can see the selected user is deleted from the data table