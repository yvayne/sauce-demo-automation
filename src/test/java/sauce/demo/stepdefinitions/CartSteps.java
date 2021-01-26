package sauce.demo.stepdefinitions;

import cucumber.api.java.en.Given;
import sauce.demo.pages.cart.YourCartPage;

/**
 * Defines cart page object steps.
 */
public class CartSteps {

    private final YourCartPage yourCartPage;

    /**
     * Initializes an instance of {@link CartSteps}.
     */
    public CartSteps() {
        yourCartPage = new YourCartPage();
    }

    /**
     * Clicks on checkout button.
     */
    @Given("^the user clicks checkout button$")
    public void theUserClicksCheckoutButton() {
        yourCartPage.clickCheckoutButton();
    }
}
