Feature: Manage Program page validatation and verification

Background: User is already on LMS application Login page
    
    Given user is already on LMS app Login page 
    When user enters valid admin username as "sdetorganizers@gmail.com" and valid password as "UIHackathon@02"
    And admin user click on login button
    Then user should be login as admin and redirected to admin LMS dashboard page
    
 
  @ManageProgramUIValidation
  Scenario: UI validation for Manage Program module 
    Given admin is on dashboard page after Login
    When admin clicks Program on the navigation bar
    Then admin should see URL with Manage Program
    And admin should see a heading with text Manage Program on program page    
    When admin validating the default state of Delete button
    Then admin should see a Delete button on the top left hand side as Disabled    
    When admin user Validates Add New Program button 
    Then admin should see a +A New Program button as enabled on the program page above the data table    
    When admin verifyes Search bar on the Program page above data table
    Then admin should see Search bar with text as Search...    
    
  @ManageProgramDataTableValidation
  Scenario: DataTable validation for Manage Program module 
    Given admin is on program page after Login
    When verify data table on the Program page
    Then admin should see data table on Manage Program Page with following column headers as Program Name, Program Description, Program Status, Edit,Delete
    When validate that number of records or rows of data displayed  in the table
    Then admin should see total number of records on default page as 5 in the table
    When verify check box for rows on the data table
    Then admin should see check box on the left side in all rows of the data table 
    When verify Edit and Delete buttons for data table 
    Then admin should see the Edit and Delete buttons on each row of the data table

   @AddNewProgramUIVerification
     Scenario Outline: UI verification of Add New Program 
     Given admin is on program page after Login
     When admin clicks on A New Program button
     Then a popup with title as Program details should get opened along with empty name and description input boxes 
     When admin verifies program details pop up UI
     Then admin should see Close Icon ,SAVE, CANCEL button and Active,Inactive Status radio buttons on popup
     When admin select program status as "<ProgStatus>" on pop window
     And click on Save button on program pop window
     Then admin gets messages alert for Name as "<NameAlertMsg>" and Desc as "<DescAlertMsg>"
    
      Examples: 
            | ProgStatus | NameAlertMsg | DescAlertMsg |
            |   Active   |Program name is required.|Description is required.|
            |   Inactive |Program name is required.|Description is required.|
	
	  @NameOnlyNumbersInputValidation     
     Scenario Outline: Validating nagative flow entering only numbers for new program pop up window
      Given admin is on program page after Login
      When admin clicks on A New Program button
      And admin enters New Program details Name as "<Name>" and Description as "<Description>" on pop up window   
      And admin select program status as "<ProgStatus>" on pop window
      And click on Save button on program pop window
      Then admin gets messages alert for Name field as "<numberOnlyAlertMsg>" 
     
     Examples: 
      |   Name  |Description| ProgStatus | numberOnlyAlertMsg | 
      |  12     | Prgm Desc |   Active   |This field should start with an alphabet, no special char and min 2 char.|
                
     
	@DescOnlyNumbersInputValidation     
     Scenario Outline: Validating nagative flow entering only numbers for new program pop up window
      Given admin is on program page after Login
      When admin clicks on A New Program button
      And admin enters New Program details Name as "<Name>" and Description as "<Description>" on pop up window   
      And admin select program status as "<ProgStatus>" on pop window
      And click on Save button on program pop window
      Then admin gets messages alert for Desc field as "<numberOnlyAlertMsg>" 
     
     Examples: 
      |   Name  |Description| ProgStatus | numberOnlyAlertMsg | 
      |  test   | 34        |   Inactive |This field should start with an alphabet and min 2 char.|               
     
	
   
   @CancelNCloseButtonsValidation    
    Scenario Outline: Validating cancel and close btn flow for New program 
      Given admin is on program page after Login
      When admin clicks on A New Program button
      Then a popup with title as Program details should get opened along with empty name and description input boxes 
      When admin enters New Program details Name as "<Name>" and Description as "<Description>" on pop up window   
      And admin select program status as "<ProgStatus>" on pop window
      And click on Cancel button on program pop window
      Then program popup window should disappears
      When admin clicks on A New Program button
      Then a popup with title as Program details should get opened along with empty name and description input boxes 
      When admin enters New Program details Name as "<Name>" and Description as "<Description>" on pop up window   
      And admin select program status as "<ProgStatus>" on pop window      
      And click on Close icon on program pop window
      Then program popup window should disappears
      
       Examples: 
      | Name         |Description| ProgStatus |
      |LearningFirst | Prgm Desc |   Active   |     
      | restassurd   | Prgm Desc |   Inactive |                     
 
   @NewProgramCreationValidation   
     Scenario Outline: Create New program for active status 
     
      Given admin is on program page after Login
      When admin clicks on A New Program button
      Then a popup with title as Program details should get opened along with empty name and description input boxes 
      When admin enters New Program details Name as "<Name>" and Description as "<Description>" on pop up window   
      And admin select program status as "<ProgStatus>" on pop window
      And click on Save button on program pop window      
      Then admin should see a successfully message alert for created new program
      And New program "<Name>" should get created in program data table
          
     Examples: 
      |     Name |Description| ProgStatus |
      |   First34 | Prgm Desc |   Active   |     
                     
                     
   @AddExistingProgramFailedValidation   
     Scenario Outline: admin should see failed alret msg while adding existing program
     
      Given admin is on program page after Login
      When admin clicks on A New Program button
      Then a popup with title as Program details should get opened along with empty name and description input boxes 
      When admin enters existing Program details Name as "<Name>" and Description as "<Description>" on pop up window   
      And admin select program status as "<ProgStatus>" on pop window
      And click on Save button on program pop window                
      Then admin should see a message alert for duplicate prgm as "Program name is already exist." 
      
     Examples: 
      |     Name |Description| ProgStatus |
      |   First33 | Prgm Desc |   Active   |     
                     
     
      
    @AddNewProgramInValidInputVerification     
     Scenario Outline: Validating nagative flow for new program pop up window
     
      Given admin is on program page after Login
      When admin clicks on A New Program button
      Then a popup with title as Program details should get opened along with empty name and description input boxes
      When admin enters New Program details on pop up window from test data sheet "<ProTestDataSheet>" and row number <RowNumber>
      And click on Save button on program pop window
      Then admin should see alert message under respective field as per sheet "<ProTestDataSheet>" and row number <RowNumber>
  
     Examples: 
      | ProTestDataSheet  | RowNumber | 
      | ProgramTestData   |    0      |
      | ProgramTestData   |    1      |
      | ProgramTestData   |    2      |
      | ProgramTestData   |    3      |
      | ProgramTestData   |    4      |
      | ProgramTestData   |    5      |
      | ProgramTestData   |    6      |
      | ProgramTestData   |    7      |
     
   
   
   @EditProgramNameValidation
   Scenario: Edit existing program Name flow 
      Given admin is on program page after Login     
      When admin select first program from datatable 
      And click on edit button for selected program
      Then edit program pop up window should appears with program details
      When admin changes only program name 
      And click on Save button on program pop window
      Then admin should see a alert message for program updated successfull
      And admin can see that program name should get updated in datatable
      
    @EditProgramDescValidation
     Scenario: Edit existing program Description flow 
      Given admin is on program page after Login
      When admin select first program from datatable 
      And click on edit button for selected program
      Then edit program pop up window should appears with program details
      When admin changes only program description
      And click on Cancel button on program pop window
      Then program popup window should disappears
      When click on edit button for selected program
      And admin changes only program description
      And click on Save button on program pop window
      Then admin should see a alert message for program updated successfull
      And admin can see that program desc should get updated in datatable
   
    @EditProgramStatusValidation
    Scenario: Edit existing program status flow 
     
      Given admin is on program page after Login
      When admin select first program from datatable 
      And click on edit button for selected program
      Then edit program pop up window should appears with program details
      When admin edit only program status 
      And click on Save button on program pop window
      Then admin should see a alert message for successfull program updated
      And admin can see that program status should get updated in datatable
   
   
  @EditProgramInvalidNameVerification     
     Scenario Outline: Validating nagative flow for edit program name pop up window
     
      Given admin is on program page after Login
      When admin select first program from datatable 
      And click on edit button for selected program
      Then edit program pop up window should appears with program details
      When admin updates exiting program details Name as "<Name>", Description as "<Description>" and status as "<ProgStatus>" on pop up window
      And click on Save button on program pop window
      Then admin gets messages alert for Name field as "This field should start with an alphabet, no special char and min 2 char." 
     
     Examples: 
      |   Name  |Description| ProgStatus |  
      |  12     | Prgm Desc |   Active   |
     
      
     @EditProgramInvalidDescVerification     
     Scenario Outline: Validating nagative flow for edit program Desc pop up window
     
      Given admin is on program page after Login
      When admin select first program from datatable 
      And click on edit button for selected program
      Then edit program pop up window should appears with program details
      When admin updates exiting program details Name as "<Name>", Description as "<Description>" and status as "<ProgStatus>" on pop up window
      And click on Save button on program pop window
      Then admin gets messages alert for Desc field as "This field should start with an alphabet and min 2 char." 
     
     Examples: 
      |   Name  |Description| ProgStatus |  
      |  numpy  | 34        |   Active   |
      
      
   @DeleteYesButtonValidation
   Scenario: yes button on delete alert box should delete selected program 
   
      Given admin is on program page after Login     
      When admin verifys programs present in datatable 
      And click on delete button for first program
      Then delete alert pop up window should appears with YES and NO buttons
      When admin verifys Confirm Deletion text on delete alert 
      And admin click on YES button on delete alert
      Then admin should see successfull alert message for program deletation
      And admin can see that program should get deleted from datatable   
      
      
   @DeleteNoCloseButtonValidation
   Scenario: No and close button on delete alert box should not delete selected program 
   
      Given admin is on program page after Login     
      When admin verifys programs present in datatable 
      And click on delete button for first program
      Then delete alert pop up window should appears with YES and NO buttons
      When admin verifys Confirm Deletion text on delete alert 
      And admin click on NO button on delete alert
      Then delete alert should disappears
      And admin can see that program should not get deleted from datatable
      When admin verifys programs present in datatable 
      And click on delete button for first program 
      Then delete alert pop up window should appears with YES and NO buttons
      When admin click on close icon on delete alert 
      Then delete alert should disappears 
      And admin can see that program should not get deleted from datatable
      
  @SingleCommonDeleteYesButtonValidation
   Scenario: validate common delete YES button deletes program for single checkbox selection
   
      Given admin is on program page after Login     
      When admin verifys programs present in datatable
      And admin verifys common delete button is disabled by default 
      And admin select only one program checkbox
      Then common delete button should be enabled      
      When admin click on common delete button above header for selection
      Then delete alert pop up window should appears with YES and NO buttons
      When admin verifys Confirm Deletion text on common delete alert pop up
      And admin click on YES button on delete alert
      Then admin should see successfull alert message for program deletation
      And admin can see that program should get deleted from datatable   
    
   @SingleCommonDeleteNoButtonValidation
     Scenario: validate common delete No button should not deletes program for single checkbox selection
     
     Given admin is on program page after Login     
      When admin verifys programs present in datatable
      And admin verifys common delete button is disabled by default 
      And admin select only one program checkbox
      Then common delete button should be enabled      
      When admin click on common delete button above header for selection
      Then delete alert pop up window should appears with YES and NO buttons
      When admin verifys Confirm Deletion text on common delete alert pop up
      And admin click on NO button on delete alert
      Then delete alert should disappears
      And admin can see that program should not get deleted from datatable
      
   @MultipleCommonDeleteYesButtonValidation 
    Scenario: validate common delete YES button should deletes program for multiple checkbox selection
    
      Given admin is on program page after Login     
      When admin verifys programs present in datatable
      And admin verifys common delete button is disabled by default 
      And admin select multiple program checkboxes
      Then common delete button should be enabled      
      When admin click on common delete button above header for selection
      Then delete alert pop up window should appears with YES and NO buttons
      When admin verifys Confirm Deletion text on common delete alert pop up
      And admin click on YES button on delete alert
      Then admin should see successfull alert message for multiple program deletation
      And admin can see those programs should get deleted from datatable   
    
   @MultipleCommonDeleteNoButtonValidation     
    Scenario: validate common delete No button should not deletes program for multiple checkbox selection
      
      Given admin is on program page after Login     
      When admin verifys programs present in datatable
      And admin verifys common delete button is disabled by default 
      And admin select multiple program checkboxes
      Then common delete button should be enabled      
      When admin click on common delete button above header for selection
      Then delete alert pop up window should appears with YES and NO buttons
      When admin verifys Confirm Deletion text on common delete alert pop up
      And admin click on NO button on delete alert
      Then delete alert should disappears
      And admin can see those programs should not get deleted from datatable
      
      
  @ManageProgramNavigationValidation
  Scenario: navigation bar validation for Manage Program module 
    Given admin is on program page after Login
    When admin click on Batch link on navigation bar  
    Then Admin is re-directed to Batch page 
    When admin click on User link on navigation bar  
    Then Admin is re-directed to User page 
    When admin click on Logout link on navigation bar  
    Then Admin is re-directed to Login page 
  
  
  
          
  @ManageProgramPaginationValidation
  
  Scenario: Pagination below data table validation for Manage Program module 
    Given admin is on program page after Login
    When admin validates the pagination icon below the data table
    Then admin should see all the pagination controls under the data table
    When admin verifys Next page link status for more than 5 record on table
    Then admin should see Next page link should be active on pagination
    When admin click on active Next link on pagination
    Then Start and First page link should be active
    When admin clicks on active Last page link on pagination
    Then admin should see the last page record on the table with Next page link are disabled
    When admin clicks active First page link on pagination
    Then admin should see the previous page record on the table with pagination has previous page link
    When admin clicks active Start page link on pagination
    Then admin should see the very first page record on the table with Previous and start page link are disabled
    
    
    
  @ManageProgramSortingValidation
  Scenario: Sorting below data table validation for Manage Program module 
    Given admin is on program page after Login
    When admin clicks the sort icon of program name column
    Then table data should get sorted based upon the program name column values in ascending order
    When admin clicks the sort icon of program name column
    Then table data should get sorted based upon the program name column values in descending order
    When admin clicks the sort icon of program description column
    Then table data should get sorted based upon the program description column values in ascending order
    When admin clicks the sort icon of program description column
    Then table data should get sorted based upon the program description column values in descending order
     When admin clicks the sort icon of program status column
    Then table data should get sorted based upon the program status column values in ascending order
     When admin clicks the sort icon of program status column
    Then table data should get sorted based upon the program status column values in descending order
    
      
    
  