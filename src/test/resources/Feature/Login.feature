#login related scenarios
@login
Feature: Login
  In order to manage the health records 
  As a user
  I want to access the openemr dashboard

  Background: 
    Given I have browser with OpenEMR page

  @high @invalid
  Scenario: Invalid Credential
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select the language 'English (Indian)'
    And I click on login
    Then I should get the error message as 'Invalid username or password'

  @low @valid
  Scenario Outline: Valid Credential
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select the language '<language>'
    And I click on login
    Then I should get access to the dashboard with title as 'OpenEMR'

    Examples: 
      | username  | password  | language         |
      | admin     | pass      | English (Indian) |
      | physician | physician | English (Indian) |
