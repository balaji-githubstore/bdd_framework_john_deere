Feature: Login
  In order to manage the health records 
  As a user
  I want to access the openemr dashboard

  Scenario: Invalid Credential
    Given I have browser with OpenEMR page
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select the language 'English (Indian)'
    And I click on login
    Then I should get the error message as 'Invalid username or password'

  Scenario: Valid Credential1
    Given I have browser with OpenEMR page
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select the language 'English (Indian)'
    And I click on login
    Then I should get access to the dashboard with title as 'OpenEMR'

    