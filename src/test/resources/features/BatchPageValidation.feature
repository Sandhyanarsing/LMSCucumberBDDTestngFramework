@Batch
Feature: Batch_Page_Validation

 Background: Logged on the LMS portal
     Given user is already on LMS app Login page 
    When User enters valid "sdetorganizers@gmail.com" and valid "UIHackathon@02"
    And user click on login button
    Then user should be redirected to LMS home page

  
@TC_Batch_Page_Validation_01  
Scenario: Validate landing in Batch page
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Admin should see the word "Batch" in the URL

@TC_Batch_Page_Validation_02	
Scenario: Validate header in the Batch Page	
When 	Admin clicks "Batch" from navigation bar in the Batch Page	
Then 	Admin should see the "Manage Batch" in the header

@TC_Batch_Page_Validation_03
Scenario: Validate pagination in the Batch Page	
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Admin should see the pagination controls under the data table

@TC_Batch_Page_Validation_04
Scenario: Validate data table headers in the Batch Page	
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Admin Should see the data table with headers in "batch" with Batch name, Batch Description,Batch Status,Number of classes, Program Name, EditDelete

@TC_Batch_Page_Validation_05
Scenario: Validate Delete button in Batch Page	
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Admin should be able to see the "Delete" icon button that is disabled

@TC_Batch_Page_Validation_06
Scenario: Validate +A New batch in Batch Page	
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Admin should be able to see the "+A New batch" button

@TC_Batch_Page_Validation_07
Scenario: Validate data rows	in Batch Page  to verify checkbox
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	every row in the data table should have a checkbox

@TC_Batch_Page_Validation_08
Scenario: Validate data rows	in Batch Page to verify edit icon
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Each row in the data table should have edit icon which is enabled

@TC_Batch_Page_Validation_09
Scenario: Validate data rows	in Batch Page to verify delete icon
When 	Admin clicks "Batch" from navigation bar in the Batch Page
Then 	Each row in the data table should have a delete icon which is enabled

@TC_Batch_Page_Validation_10
Scenario: Validate pop up for adding batch in Batch Page
When 	Admin clicks "+A New Batch" button in the Batch Page
Then 	A new pop up with Batch details appears
  

