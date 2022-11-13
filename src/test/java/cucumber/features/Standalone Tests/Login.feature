Feature: Similac login feature


@Login @SmokeTest @Regression @Login_positive
Scenario Outline: To verify the login feature in Similac application
Given User is in the homepage of similac.com application
Then Verify login button is displayed in the header section
When User clicks on the login button in the header section
Then Verify the login popup window is displayed
When User provides email address "<emailAddress>" and password "<password>" and clicks on sign in button
Then Verify user is navigated to "<pageName>" page with URL "<URL>"
And Verify user name "<userName>" is displayed in the header
And Evaluate the validations

Examples:
|emailAddress						|password			|URL										|userName				|pageName				|
|abilash.c@getnada.com	|Test@1234		|account/profile.html		|Abilash				|My Profile			|


@Login @SmokeTest @Regression @Login_negative
Scenario Outline: To verify the error message in the login pop in Similac application
Given User is in the homepage of similac.com application
When User clicks on the login button in the header section
When User provides email address "<emailAddress>" and password "<password>" and clicks on sign in button
But Verify appropriate error message is displayed for "<fieldName>" field

Examples:
|emailAddress						|password			|fieldName			|
|abilash.c@getnada			|Test@1234		|emailAddress		|
|abilash.c@getnada.com	|Test@12345		|password				|