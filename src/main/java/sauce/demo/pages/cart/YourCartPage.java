package sauce.demo.pages.cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.SwagLabsBasePage;
import sauce.demo.utils.WebElementActions;

public class YourCartPage extends SwagLabsBasePage {

    @FindBy(css = ".checkout_button")
    private WebElement checkoutButton;

    @FindBy(css = ".btn_secondary")
    private WebElement continueShoppingButton;

    /**
     * Clicks checkout button.
     */
    public void clickCheckoutButton() {
        WebElementActions.clickElement(checkoutButton);
    }

    /**
     * Clicks continue shopping button.
     */
    public void clickContinueShoppingButton() {
        WebElementActions.clickElement(checkoutButton);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.isDisplayed(checkoutButton);
        WebElementActions.isDisplayed(continueShoppingButton);
    }
}
