package cucumber.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.commons.BaseActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPage extends BaseActions {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "react-form-field-search")
	WebElement searchBox;

	@FindBy(css = ".clickable")
	WebElement searchBtn;

	@FindBy(className = "product-card")
	List<WebElement> productsCard;

	@FindBy(css = "li[class*='next'] a")
	WebElement nextBtn;

	By productName = By.className("figure-caption");
	By products = By.className("products__card--figure");
	By addToCartBtn = By.className("btn-primary");

	public void user_enters_keyword_in_search_and_clicks_on_search_button(String keyword) {
		sendText(searchBox, keyword);
		normalClick(searchBtn);
	}

	public void verify_user_is_able_to_add_products_to_the_cart(String product) {

		waitForAllElementPresence(10, products);

		do {
			productsCard.stream().filter(temp -> temp.findElement(productName).getText().contains(product))
					.filter(temp -> temp.findElements(addToCartBtn).size() > 0)
					.forEach(temp -> temp.findElement(addToCartBtn).click());

			normalClick(nextBtn);
			waitForAllElementPresence(10, products);
		} while (nextBtn.getAttribute("aria-disabled").equals("false"));
	}
}
