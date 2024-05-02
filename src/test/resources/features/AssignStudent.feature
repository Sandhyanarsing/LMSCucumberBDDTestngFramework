
Feature: Assign Student

Background: User is already on LMS application Login page
		 Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page
    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page
    
 Scenario: Validate Assign Student Popup window
 Given Admin is in manage user page
 When Admin clicks Assign Student button
 Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button
 
Scenario: Validate input fields and their text boxes in Assign Student form 
	Given Admin is in manage user page
	When Admin clicks Assign Student button
	Then Admin should see User Role as R03,StudentEmailId,ProgramName,BatchName and Status with respective input boxes.
  
 Scenario: Validate Dropdown in Assign Student Form
	Given Admin is in manage user page
	When Admin clicks Assign Student button
	Then Admin should see drop down boxes with valid data for Student Email id,Program Name and Batch Name

Scenario: Validate radio button in Assign Student Form
	Given Admin is in manage user page
	When Admin clicks Assign Student button
 Then admin should see two radio button for Status
  
Scenario: Empty Form Submission
	Given Admin is in Assign Student details pop up page
 	When Admin clicks "Save" button with entering any data
  Then Admin gets a Error message alert 
  
Scenario: Validate the Assign Student form page without giving Student Email id
Given Admin is in Assign Student details pop up page
When Admin clicks "Save" button without entering Student Email id
Then Admin gets a Error message alert as "Student Email id is required"

Scenario: Validate the Assign Student form page without selecting Program
Given Admin is in Assign Student details pop up page
When Admin clicks "Save" button without selecting program  
Then Admin gets a Error message alert as Program is required.

Scenario: Validate the Assign Student form page without selecting batch
Given Admin is in Assign Student details pop up page
When Admin clicks "Save" button without selecting batch
Then Admin gets a Error message alert as Batch is required

Scenario: Validate the Assign Student form page without giving Status
Given Admin is in Assign Student details pop up page
When Admin clicks "Save" button without giving status
Then Admin gets a Error message alert as Status is required

Scenario: Validate Cancel/Close(X) icon on Assign Student form
Given Admin is in Assign Student details pop up page
When Admin clicks Cancel/Close(X) Icon on Assign Student form 
Then Assign Student popup window should be closed without saving

Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
Given Admin is on  User details pop up
When Admin enters mandatory fields with User role status R03  "<First name>","<Middle name>","<Last name>","<Location>","<Phone no>","<Linkedin Url>","<User Role>","<User Role Status>","<User Visa Status>","<Email address>""<Under Graduate>","<Post Graduate>","<Time Zone>","<User Comments>"
And Admin clicks on Submit button 



Examples: 
      | First name   | Middle name   | Last name  | Location   | Phone no   | Email address   | Linkedin Url                    | User Role   |User Role Status   | User Visa Status   | Under Graduate  | Post Graduate  | Time Zone  | User Comments |  
      #| Sweth        | k              | k        |  usa       | 9256789000  | swe@gmail.com   | https://www.linkedin.com/in/Numpy| R03        | Active             | H4                | b.tec           | Msc           | PST       | No Comments  |
			| Manu				 | m              |  m        |USA        |7094561238   | Man23@gmail.com   |https://www.linkedin.com/in/Numpy | R03        | Active             | H4                | Bsc             | Msc            | Pst       | nothing     |

Scenario Outline: Validate Save button on Assign Student form
Given Admin is in Assign Student details pop up page 
When Enter all the required fields with valid values and  click Save button "<Program Name>","<Batch Name>"
Then Admin gets a message Successfully Student Assigned alert 

Examples: 
  | Program Name | Batch Name|
  | SDET         | 208       |
  
