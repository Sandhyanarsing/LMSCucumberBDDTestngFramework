@Dashboard
Feature: Dashboard Page Verification

Background:
  Given Admin is on the Home Page
  And Admin has provided the correct LMS portal URL

@tag1
Scenario: Verify Admin lands on Manage Program Dashboard Page after login
  When Admin enters valid credentials and clicks login button
  Then Admin should see "Manage Program" as the header

@tag2
Scenario: Verify the response time after login
  When Admin enters valid credentials and clicks login button
  Then Admin should experience a maximum navigation time of 30 seconds

@tag3
Scenario: Verify broken link after login
  When Admin enters valid credentials and clicks login button
  Then If HTTP response code is >= 400, the link is broken

@tag4
Scenario:  Verify LMS title after login
  When Admin enters valid credentials and clicks login button
  Then Admin should see "LMS - Learning Management System" as the title

@tag5
Scenario: Verify LMS title alignment after login
  When Admin enters valid credentials and clicks login button
  Then LMS title should be aligned to the top left corner of the page

@tag6
Scenario: Validate navigation bar text after login
  When Admin enters valid credentials and clicks login button
  Then Admin should see correct spelling in the navigation bar text

#@tag7
#Scenario: Validate LMS title spelling and space after login
  #When Admin enters valid credentials and clicks login button
  #Then Admin should see correct spelling and space in the LMS title

@tag8
Scenario: Validate alignment for navigation bar after login
  When Admin enters valid credentials and clicks login button
  Then Admin should see the navigation bar text aligned to the top right side

#@tag9
#Scenario: Validate navigation bar order for Program after login
  #When Admin enters valid credentials and clicks login button
  #Then Admin should see "Program" in the 1st place in the navigation bar

#@tag10
#Scenario: Validate navigation bar order for Batch after login
  #When Admin enters valid credentials and clicks login button
  #Then Admin should see "Batch" in the 2nd place in the navigation bar
#
#@tag11
#Scenario: Validate navigation bar order for User after login
  #When Admin enters valid credentials and clicks login button
  #Then Admin should see "User" in the 3rd place in the navigation bar
#
#@tag12
#Scenario: Validate navigation bar order for Logout after login
  #When Admin enters valid credentials and clicks login button
  #Then Admin should see "Logout" in the 4th place in the navigation bar
