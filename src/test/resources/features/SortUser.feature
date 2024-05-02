Feature: Admin is on dashboard page after Login 
and clicks User on the navigation bar

Background: User is already on LMS application Login page
		 Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page
    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
 
 Scenario: Sort user by id
 Given Admin is on Manage User Page
 When Admin clicks on ID sort icon
 Then Admin should see User details are sorted by id
 
 Scenario: Sort user by name
 Given Admin is on Manage User Page
 When Admin clicks on name sort icon
 Then Admin should see User details are sorted by name
 
 Scenario: Sort user by Location
 Given Admin is on Manage User Page
 When Admin clicks on Location sort icon
 Then Admin should see User details are sorted by Location
 
 Scenario: Sort user by Phone number
 Given Admin is on Manage User Page
 When Admin clicks on Phone number sort icon
 Then Admin should see User details are sorted by Phone number
 
 
    