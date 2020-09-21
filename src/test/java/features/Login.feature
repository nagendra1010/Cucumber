Feature: Application login


@RegTest
Scenario: Home page default login
Given User is on Netbanking landing page
When User log into application with "John" and "12345"
Then Home page is populated
And Cards are displayed
@SmokeTest1
Scenario: Home page default login
Given User is on Netbanking landing page
When User log into application with "Jin" and "4321"
Then Home page is populated
And Cards are displayed
@MobileTest
Scenario: Home page default login
Given User is on Netbanking landing page
When User sign up with following details
| Jenny | abcd | john@abcd.com | Australia | 12345678 |
Then Home page is populated
And Cards are displayed
@SanityTest
Scenario Outline: Home page default login
Given User is on Netbanking landing page
When User login into application with <Username> and <Password>
Then Home page is populated
And Cards are displayed
 
Examples:
|Username |Password|
|user1    |pass1   |
|user2    |pass2   |
|user3    |pass3   |
|user4    |pass4   |
