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
Scenario Outline: Facebook login
Given User is on Facebook login page
When User logins with <Username> and <Password>
And User proceeds to Home page <Name>
Then User logsout

Examples:
|Username 					|Password	|Name			|
|nagendra1010@gmail.com    	|Kora*1990  |Nagendra Sahoo	|


