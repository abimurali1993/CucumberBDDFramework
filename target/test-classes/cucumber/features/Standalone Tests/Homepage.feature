Feature: Similac Homepage feature


@Homepage @SmokeTest @Regression @Sanity
Scenario Outline: To verify the Homepage in Similac application

Given User is in the homepage of similac.com application
Then Verify user is navigated to "<pageName>" page with URL "<URL>"
And  Verify homepage banner is displayed


Examples:
|URL										|pageName				|
|home.html							|Home						|