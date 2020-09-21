Feature: Search and place order for vegetable

@SmokeTest
Scenario: Search for items and validate results  
Given User is on Greencart landing page
When User search for Cucumber Vegetable
Then "Cucumber" results are displayed

@RegressionTest
Scenario Outline: Search for items and move to checkout page 
Given User is on Greencart landing page
When User search for <Name> Vegetable
And added items to cart
And user proceeded to Checkout page for purchase
Then verify selected <Name> items are dispalyed in checkout page

Examples:
|Name	 |
|Brinjal |
|Beetroot|