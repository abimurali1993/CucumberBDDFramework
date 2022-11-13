Feature: Similac Products-Add to cart feature

@Products @SmokeTest @Regression @Products-searchAddtoCart
Scenario Outline: To verify the add to cart feature by searching for products in Similac application

Given User is in the homepage of similac.com application
When User clicks on the login button in the header section
And User provides email address "<emailAddress>" and password "<password>" and clicks on sign in button
Then Verify user name "<userName>" is displayed in the header
When User clicks on products link from the header section
Then Verify user is navigated to "<pageName>" page with URL "<URL>"
When User enters "<searchKeyword>" keyword in search and clicks on search button
Then Verify user is able to add "<product>" products to the cart
Examples:
|emailAddress						|password			|URL										|searchKeyword	|product				|
|abilash.c@getnada.com	|Test@1234		|products.html					|infant					|Advance				|