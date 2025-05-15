@Reg
Feature: verify flipkart add to cart functionality
  Scenario: verifying flipkar functionality
    Given user open flipkart webpage
    When user click on global search
    Then user search with the keyword mobile
    And user verify search result for mobile
    And user clicks compare checkbox for tenth and eleventh mobile
    And user verify item is added to compare tray
    And user clicks and opened tenth phone
    And user clicks on add to cart button and verify going to cart text visibility
    And user verify item is added to cart
    And user verify total amount is same
    And user increase product qty by one and verify pop up message displayed
    And user removed product and verified empty screen
