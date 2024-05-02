
@ValidateAssignStaffPage
Feature: Assign Staff
  
  Background: 
 		Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page

  @ValidatePopupWindow
  Scenario: Validate Assign Staff Popup window
    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
    When Admin clicks Assign Staff button
    Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window

 @ValidateInputTextFields
 Scenario: Validate input fields and their text boxes in Assign Staff form 
 	  Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
    When Admin clicks Assign Staff button
    Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
    
  @ValidateDropdown
  Scenario: Validate Dropdown in Assign Staff Form
  	Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
    When Admin clicks Assign Staff button
    Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
    
    @ValidateRadioButton
    Scenario: Validate radio button in Assign Staff Form
    	Given Admin is on dashboard page after Login	
    	When Admin clicks User from navigation bar
    	Then Admin should see a heading with text Manage User on the page
    	When Admin clicks Assign Staff button
    	Then Admin should see two radio button for Status
    	
    @ValidateEmptyFormSubmission
    Scenario: Empty Form Submission
    	Given Admin is on dashboard page after Login	
    	When Admin clicks User from navigation bar
    	Then Admin should see a heading with text Manage User on the page
    	When Admin clicks Assign Staff button
    	When Admin clicks Save button without entering any data
    	Then Admin gets a Error message alert 
    	
    	@ValidateWithoutEmailId
    	Scenario: Validate the Assign Staff form page without giving Student Email id
    		Given Admin is on dashboard page after Login	
    		When Admin clicks User from navigation bar
    		Then Admin should see a heading with text Manage User on the page
    		When Admin clicks Assign Staff button
    		When Admin clicks Save button without entering Student Email id
    		Then Admin gets a Error message alert as Student Email id is required
    		
    	@ValidateSuccessulAssignStaff
    	Scenario: Validate Successfull Assign Staff
    	  Given Admin is on dashboard page after Login	
    		When Admin clicks User from navigation bar
    		Then Admin should see a heading with text Manage User on the page
    		When Admin clicks Assign Staff button
    		When Admin enters all the required fields with valid values and click Save button
    		Then Admin gets a message "Successfully Staff Assigned" alert 
    		
    		@ValidateCancelIcon
    		Scenario: Validate Cancel/Close(X) icon on Assign Staff form
    			Given Admin is on dashboard page after Login	
    			When Admin clicks User from navigation bar
    			Then Admin should see a heading with text Manage User on the page
    			When Admin clicks Assign Staff button
    			When Admin clicks Close Icon on Assign Staff  form
    			Then Assign Staff popup window should be closed without saving
    			
    		
    		
