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

@MyTest
Scenario: Facebook login
Given User is on Facebook login page
When User types "Username" in the field "username"
|PageName|
|Login|
And User types "Password" in the field "password"
|PageName|
|Login|
And User clicks on "login"
|PageName|
|Login|
And User validates "homeElement"
|PageName|
|Login|
And User clicks on "arrowButton"
|PageName|
|Login|
Then User clicks on "logOut"
|PageName|
|Login|


