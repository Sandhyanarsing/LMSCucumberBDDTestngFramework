Feature: AddNewUser

Background:
    Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page

    Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should see a heading with text Manage User on the page

Scenario: Validate User Details Popup window
When Admin clicks "+ A New User" button
Then Admin should see pop up open for user details with First name, Middle name, Last name, Location, Phone no, email, Linkedn Url, User Role, User Role status, User Visa Status, Under Graduate, Post Graduate, Time Zone, User Comments along with Cancel, Submit and close buttons
     
Scenario: Validate input fields and text boxes in user details form
Given Admin is on Manage User Page window
When Admin clicks "+ A New User" button
Then Admin should see  text boxes for the fields First name, Middle name, Last Name, Location, phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments

Scenario: Validate drop downs in new user form
Given Admin is on Manage User Page window
When Admin clicks "+ A New User" button
Then Admin should see drop downs for the fields User Role, Role status, visa status on user details pop up

Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
Given Admin is on  User details pop up window
When Admin enters mandatory fields "<First name>","<Middle name>","<Last name>","<Location>","<Phone no>","<Linkedin Url>","<User Role>","<User Role Status>","<User Visa Status>","<Email address>""<Under Graduate>","<Post Graduate>","<Time Zone>","<User Comments>"
And clicks on Submit button 
Then Admin gets message "User added Successfully"
Then The newly added user should be present in the data table in Manage User page
Examples: 
      | First name   | Middle name   | Last name  | Location   | Phone no   | Email address   | Linkedin Url                    | User Role   |User Role Status   | User Visa Status   | Under Graduate  | Post Graduate  | Time Zone  | User Comments |  
      | Swath        | sdet          | Nin        |  usa       | 5601630915  | nut2@gmail.com   | https://www.linkedin.com/in/Numpy| R01        | Active             | H4                | b.tec           | MBA           | PST       | No Comments  |  
                    


Scenario Outline: check if user is created when invalid data is entered in all of the fields
Given Admin is on  User details pop up
When Admin enters invalid data in all of the  fields in the form "<First name>","<Middle name>","<Last name>","<Location>","<Phone no>","<Linkedin Url>","<User Role>","<User Role Status>","<User Visa Status>","<Email address>""<Under Graduate>","<Post Graduate>","<Time Zone>","<User Comments>" and clicks on submit button
Then Admin gets error message and user is not created

Examples: 
      | First name   | Middle name   | Last name  | Location   | Phone no   | Email address   | Linkedin Url                    | User Role   |User Role Status   | User Visa Status   | Under Graduate  | Post Graduate  | Time Zone  | User Comments |  
      | 123          |       43        | Nin        | gdhs       | 910284 | nu127@gmail.com   | https://www.linkedin.com/in/Numpy| R01        | Active             | H4                | b.tec           | MBA            | gdhs       | No Comments  |  
                    

Scenario: Empty form submission
Given Admin is on  User details pop up
When Admin clicks on submit button without entering data
Then user wont be created and Admin gets error message

Scenario: Validate Cancel button on User Details form
Given Admin is on  User details pop up
When Admin clicks Cancel button
Then User Details popup window should be closed without saving
Then Admin can see the User details popup disappears without adding any user

 #EditUser
 Scenario: Validate row level edit icon and fields are updated with valid data
Given Admin is on Manage User Page
When Admin clicks on the edit icon 
Then A new pop up with User details appears

Scenario: Check if the fields are updated with valid data
Given Admin is on Manage User Page window
When Update the fields with valid data and click submit
Then Admin gets message "User updated Successfully " and see the updated values in data table 

Scenario: Check if the fields are updated with invalid values
Given Admin is on Manage User Page window
When Update the fields with invalid values and click submit
Then Admin should get Error message

Scenario: Validate invalid values in the text fields
Given Admin is on Manage User Page window
When Admin enters only numbers or special char in the text fields
Then Admin should get Failed message

#DeleteUser

Scenario: Validate row level delete icon 
Given Admin is on Manage User Page window
When Admin clicks on the delete icon 
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
When Admin clicks No option
Then Admin can see the deletion alert disappears without deleting

Scenario: Validate Close(X) icon on Confirm Deletion alert
Given Admin is on Manage User Page window
When Admin clicks on close button
Then Admin can see the deletion alert disappears without deleting

Scenario: Click Yes on deletion window
Given Admin is on Manage User Page window
When Admin clicks yes option
Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table

Scenario: Validate Common Delete button enabled after clicking on any checkbox 
Given Admin is on Manage User Page window
When Admin clicks any checkbox in the data table
Then Admin should see common delete option enabled under header Manage Program
Then Admin clicks the Delete button    