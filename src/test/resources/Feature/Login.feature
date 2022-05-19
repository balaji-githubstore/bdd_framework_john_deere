Feature: Login
  In order to manage the health records 
  As a user
  I want to access the openemr dashboard

  Scenario: Valid Credential
    Given I have browser with OpenEMR pages
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select the language 'English (Indian)'
    And I click on login
    Then I should get access to the dashboard with title as 'OpenEMR'
