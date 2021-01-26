package sauce.demo.pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.SwagLabsBasePage;
import sauce.demo.utils.Actionable;
import sauce.demo.utils.WebElementActions;
import sauce.demo.webdriver.DriverManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines checkout page object model.
 */
public class CheckoutPage extends SwagLabsBasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameTextBox;

    @FindBy(id = "last-name")
    private WebElement lastNameTextBox;

    @FindBy(id = "postal-code")
    private WebElement postalCodeTextBox;

    @FindBy(css = ".cart_button")
    private WebElement continueButton;

    @FindBy(css = ".cart_cancel_link")
    private WebElement cancelButton;

    /**
     * Sets first name.
     *
     * @param firstName checkout first name.
     */
    public void setFirstNameTextBox(final String firstName) {
        WebElementActions.setInputField(firstNameTextBox, firstName);
    }

    /**
     * Sets last name.
     *
     * @param lastName checkout last name.
     */
    public void setLastNameTextBox(final String lastName) {
        WebElementActions.setInputField(lastNameTextBox, lastName);
    }

    /**
     * Sets postal code.
     *
     * @param postalCode checkout postal code.
     */
    public void setPostalCodeTextBox(final String postalCode) {
        WebElementActions.setInputField(postalCodeTextBox, postalCode);
    }

    /**
     * Clicks on continue button.
     */
    public void clickContinueButton() {
        WebElementActions.clickElement(continueButton);
    }

    /**
     * Clicks on cancel button.
     */
    public void clickCancelButton() {
        WebElementActions.clickElement(cancelButton);
    }

    /**
     * Gets error label text.
     *
     * @return error label text.
     */
    public String getErrorText() {
        WebElement errorLabel = DriverManager.getInstance()
                .getWebDriver()
                .findElement(By.cssSelector("[data-test='error']"));
        return errorLabel.getText();
    }

    /**
     * Fills checkout form.
     *
     * @param data checkout form data.
     */
    public void fillForm(final Map<String, String> data) {
        Map<String, Actionable> strategyMap = buildStrategyMap(data);
        data.keySet().forEach(key -> strategyMap.get(key).execute());
    }

    /**
     * Builds strategy map to fill form.
     *
     * @param data checkout form data.
     * @return strategy map with lambda functions.
     */
    private Map<String, Actionable> buildStrategyMap(final Map<String, String> data) {
        Map<String, Actionable> strategyMap = new HashMap<>();
        strategyMap.put("First Name", () -> setFirstNameTextBox(data.get("First Name")));
        strategyMap.put("Last Name", () -> setLastNameTextBox(data.get("Last Name")));
        strategyMap.put("Zip Postal Code", () -> setPostalCodeTextBox(data.get("Zip Postal Code")));
        return strategyMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.isDisplayed(continueButton);
        WebElementActions.isDisplayed(cancelButton);
    }
}
