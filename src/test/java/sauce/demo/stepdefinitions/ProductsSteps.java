package sauce.demo.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sauce.demo.pages.products.ProductsPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Defines products page object step definitions.
 */
public class ProductsSteps {

    private final ProductsPage productsPage;

    /**
     * Initializes an instance of {@link ProductsSteps}.
     */
    public ProductsSteps() {
        productsPage = new ProductsPage();
    }

    /**
     * Clicks on add to cart button according to items names list.
     *
     * @param items items names list.
     */
    @Given("^the user adds to cart the following items:$")
    public void theUserAddsToCartTheFollowingItems(final List<String> items) {
        productsPage.clickOnAddToCartButton(items);
    }

    /**
     * Clicks on cart button.
     */
    @Given("^the user clicks cart button$")
    public void theUserClicksCartButton() {
        productsPage.getHeader().clickCartButton();
    }

    /**
     * Select product sort option.
     *
     * @param option select option.
     */
    @When("^the user selects \"([^\"]*)\" product sort option$")
    public void theUserSelectsOptionInProductSortSelect(final String option) {
        productsPage.selectProductSort(option);
    }

    /**
     * Verifies products page is displayed.
     */
    @Then("^verifies that products page is displayed$")
    public void verifiesThatProductsPageIsDisplayed() {
        assertTrue(productsPage.isDisplayed(), "The product page is not displayed");
    }

    /**
     * Verifies that lowest price item is displayed first in product page.
     */
    @Then("^verifies that the lowest price item is displayed first in the products list$")
    public void verifiesItemIsDisplayedFirstInTheProductsList() {
        assertTrue(productsPage.isLowestPriceItemDisplayedFirst(), "The lowest price item is not displayed first.");
    }
}
