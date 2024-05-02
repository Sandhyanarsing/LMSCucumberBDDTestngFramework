@Home
Feature: Home Page Verification

Background: Navigate to Home page
Given: Admin launch the browser

@tag1
Scenario: Verify admin is able to land on home page

     When Admin gives the correct LMS portal URL
     Then Admin should land on the home page
     
@tag2
Scenario: Validating invalid url flow for login
Given user opens browser
When admin enters invalid app url
Then LMS app throws 404 error 


@tag3     
 Scenario: Verify for broken link
 
     When Admin gives the correct LMS portal URL
     Then HTTP response >= 400. then the link is broken
     
 @tag4    
 Scenario: Verify the text spelling in the page  

     When Admin gives the correct LMS portal URL
     Then Admin should see correct spellings in all fields
     
@tag5 
 Scenario: Verify the Company logo

     When Admin gives the correct LMS portal URL
     Then Admin Should see logo on the left side
     
 @tag6    
 Scenario: Verify application name

     When Admin gives the correct LMS portal URL
     Then Admin Should see LMS-Learning Management System
     
 @tag7    
  Scenario: Verify Company name

     When Admin gives the correct LMS portal URL
     Then Admin Should see company name below the app name
     
@tag8     
  Scenario: Verify Sign in content

     When Admin gives the correct LMS portal URL
     Then Admin should see "Please login to LMS application"
     
@tag9     
  Scenario: Verify text field is present
 
     When Admin gives the correct LMS portal URL
     Then Admin should see two text field
     
@tag10     
 Scenario: Verify text on the first text field

     When Admin gives the correct LMS portal URL
     Then Admin should "User" in the first text field 
     
@tag11     
 Scenario: Verify asterik next to user text

     When Admin gives the correct LMS portal URL
     Then Admin should see * symbol next to user text
     
@tag12     
  Scenario: Verify text on the second text field

     When Admin gives the correct LMS portal URL
     Then Admin should "Password" in the second text field  
      
@tag13     
  Scenario: Verify asterik next to password text

     When Admin gives the correct LMS portal URL
     Then Admin should see * symbol next to password text
       
 @tag14    
  Scenario: Verify the alignment input field for the login

     When Admin gives the correct LMS portal URL
     Then Admin should see input field on the center of the page
     
@tag15     
  Scenario: verify Login is present

     When Admin gives the correct LMS portal URL
     Then Admin should see login button
     
 @tag16    
  Scenario: Verify the alignment of the login button

     When Admin gives the correct LMS portal URL
     Then Admin should see login button on the centre of the page
     
@tag17     
   Scenario: Verify input descriptive test in user field

     When Admin gives the correct LMS portal URL
     Then Admin should see user in gray color
       
@tag18     
  Scenario: Verify input descriptive test in password field

     When Admin gives the correct LMS portal URL
     Then Admin should see password in gray color   
        
     
        
     
        
     
        
     
           
        
     
        
     
         
     
     
     
