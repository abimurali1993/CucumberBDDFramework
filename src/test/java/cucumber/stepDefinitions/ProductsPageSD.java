package cucumber.stepDefinitions;

import cucumber.globals.Globals;
import cucumber.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPageSD {

	public Globals global;

	public ProductsPageSD(Globals global) {

		this.global = global;

	}

	@When("User enters {string} keyword in search and clicks on search button")
	public void user_enters_keyword_in_search_and_clicks_on_search_button(String keyword) {
		new ProductsPage(global.driver).user_enters_keyword_in_search_and_clicks_on_search_button(keyword);
		global.takeScreenshot=true;

	}

	@Then("Verify user is able to add {string} products to the cart")
	public void verify_user_is_able_to_add_products_to_the_cart(String product) {
		new ProductsPage(global.driver).verify_user_is_able_to_add_products_to_the_cart(product);
		global.takeScreenshot=true;

	}
}
