@sampleTest
Feature: Test1
  First API TESTS

  Scenario: FIRST SCENARIO
    Given Get the list of users for page "1"
    When Status code is 200
    Then Verify if there are only 7 responses
    And Verify if page is "1" as speciifed earlier
    And Verify the response schema to code "ListUsers1.1"