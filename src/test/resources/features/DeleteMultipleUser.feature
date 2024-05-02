Feature: DeleteMultipleUser

Background:
    Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page

    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
     
Scenario: Validate multiple program deletion by selecting multiple checkbox
Given Admin click mutiple checkboxes then admin is on Confirm Deletion alert
When Admin clicks <NO> button on the alert
Then Admin should land on Manage User page and can see the selected users are not deleted from the data table

Scenario: Validate multiple program deletion by selecting Multiple checkbox
Given Admin click mutiple checkboxes then admin is on Confirm Deletion alert
When Admin clicks <YES> button on the alert
Then Admin should land on Manage User page and can see the selected users are deleted from the data table