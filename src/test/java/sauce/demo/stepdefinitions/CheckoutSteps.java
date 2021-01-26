package sauce.demo.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sauce.demo.pages.checkout.CheckoutPage;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Defines checkout page object step definitions.
 */
public class CheckoutSteps {

    private final CheckoutPage checkoutPage;

    /**
     * Initializes an instance of {@link CheckoutSteps}.
     */
    public CheckoutSteps() {
        checkoutPage = new CheckoutPage();
    }

    /**
     * Fills checkout form.
     *
     * @param data checkout form data.
     */
    @When("^the user fills the checkout form with:$")
    public void theUserFillsTheCheckoutFormWith(final Map<String, String> data) {
        checkoutPage.fillForm(data);
    }

    /**
     * Clicks on continue button.
     */
    @When("^the user clicks continue button$")
    public void theUserClicksContinueButton() {
        checkoutPage.clickContinueButton();
    }

    /**
     * Verifies error message.
     *
     * @param message expected error message.
     */
    @Then("^verifies that the following error message is displayed in checkout form:$")
    public void verifiesThatTheFollowingErrorMessageIsDisplayedInCheckoutForm(final String message) {
        assertEquals(checkoutPage.getErrorText(), message, "Error message does not match.");
    }
}
