
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
    
  @ValidateTableHeaders
  Scenario: Validate data table headers in the User page
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin Should see the following column names
  
    |Column Name |
  	|ID          |
  	|Name        |
  	|Location    |
  	|Phone Number|
  	|Edit/Delete |
  	
  @ValidateDefaultDeleteButtonStatus
  Scenario: Valdiate the default state of delete button
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin should see a Delete button on the top left hand side as Disabled
  	
  @ValidateAddNewUserButton
  Scenario: Validate + Add New User button in User Page
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin should be able to see the + Add New User button above the data table
  	
  @ValidateAssignStudentButton
  Scenario: Validate + Assign Student button in User page
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin should be able to see the + Assign Student button above the data table
  	
  @ValidateAssignStaffButton
  Scenario: Validate + Assign Staff button in User page
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin should be able to see the + Assign Staff button above the data table
  	
  @ValidateSearchBox
  Scenario: Validate search box in User page
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin should be able to see the search text box above the data table
  	
  @ValidateDataRows
  Scenario: Validate number of data rows in the data table
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Admin should see five records displayed on the data table
  	
  @ValidateCheckBox
  Scenario: Verify Check box on the data table
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Each row in the data table should have a checkbox
  	
  @ValidateEditIcon
  Scenario: Verify edit icon on the data table
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Each row in the data table should have a edit icon that is enabled
  	
  @ValidateDeleteIcon
  Scenario: Verify  delete icon on the data table
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	Then Each row in the data table should have a delete icon that is enabled
  	
  @ValidatePaginationtext&Icons
  Scenario: Validate the text and pagination icon below the data table
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar 
  	Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.
  	
  	
  @ValidateSearchUserByName
  Scenario: Verify search user by name
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	When Admin enters user name into search box
  	Then Admin should see user displayed with the entered name
  	
  @SearchUnrelatedKeyword
  Scenario: Validating the Search with unrelated keyword
  	Given Admin is on dashboard page after Login
  	When Admin clicks User from navigation bar
  	When Admin enters the keywords not present in the data table on the Search box 
  	Then Admin should see zero entries on the data table
  	
  

  	
  	
 
  
  
    
 
  	
    

 
