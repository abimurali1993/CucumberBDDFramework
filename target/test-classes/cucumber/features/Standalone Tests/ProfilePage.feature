Feature: Similac Profile feature

@Profile @SmokeTest @Regression @Sanity
Scenario Outline: To verify the my profile page in Similac application

Given User is in the homepage of similac.com application
When User clicks on the login button in the header section
And User provides email address "<emailAddress>" and password "<password>" and clicks on sign in button
Then Verify user is navigated to "<pageName>" page with URL "<URL>"
And Verify user name "<userName>" is displayed in the header
And Verify email address "<emailAddress>" is displayed in profile section
And Evaluate the validations

Examples:
|emailAddress						|password			|URL										|userName				|pageName				|
|abilash.c@getnada.com	|Test@1234		|account/profile.html		|Abilashc				|My Profile			|