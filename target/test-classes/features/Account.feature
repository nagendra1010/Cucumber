Feature: Application login
@RegTest
Scenario: Home page default login
Given User is on Netbanking landing page
When User log into application with "John" and "12345"
Then Home page is populated
And Cards are displayed
