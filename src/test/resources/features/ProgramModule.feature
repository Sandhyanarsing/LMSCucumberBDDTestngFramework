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
  Scenario: UI verification of Add New Program 
     Given admin is on program page after Login
     When admin clicks on A New Program button
     Then a popup with title as Program details should get opened along with empty name and description input boxes 
     When admin verifies program details pop up UI
     Then program details pop up should contains Close(X) Icon ,SAVE, CANCEL button and Active,Inactive Status radio buttons 


@AddNewProgramWithValidInput



@AddNewProgramInValidInputVerification



  @ManageProgramPaginationValidation
  Scenario: Pagination below data table validation for Manage Program module 
    Given admin is on program page after Login
    When validate the text and pagination icon below the data table of program page 
    Then admin should see the text as Showing x to y of z entries along with pagination icon below the table 
    And x as starting record number on that page
    And y as ending record number on that page
    And z as Total number of records
    
    
  @ManageProgramSortingValidation
  Scenario: Sorting below data table validation for Manage Program module 
    Given admin is on program page after Login
    When verify Sort arrow icon on the program page data table
    Then admin should see the sort arrow icon beside each column header except Edit and Delete 
      
    
  @ManageProgramFooterValidation
  Scenario: Footer validation for Manage Program module 
   Given admin is on program page after Login
   When admin validates the footer
   Then admin should see the footer as In total there are z programs
   And z as Total number of records
  
    
    
  