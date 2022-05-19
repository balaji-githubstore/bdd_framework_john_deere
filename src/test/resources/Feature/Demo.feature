@demo
Feature: Patient
  In order to manage the health records 
  As a admin
  I want to add,delete,edit the patient details

  @addpatient @high
  Scenario: Add Patient
    Given I have browser
    When I fill the data
      | firstname | lastname | dob        | gender |
      | John      | Wick     | 2022-05-18 | Male   |
		Then I should see output