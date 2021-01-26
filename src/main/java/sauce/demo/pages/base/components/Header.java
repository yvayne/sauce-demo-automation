package sauce.demo.pages.base.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.BaseComponent;
import sauce.demo.utils.WebElementActions;

/**
 * Defines Swag Labs header base component.
 */
public class Header extends BaseComponent {

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    @FindBy(css = ".bm-burger-button")
    private WebElement menuButton;

    /**
     * Clicks on cart button.
     */
    public void clickCartButton() {
        WebElementActions.clickElement(cartButton);
    }

    /**
     * Clicks on menu button.
     *
     * @return Main menu component.
     */
    public MainMenu clickMenuButton() {
        WebElementActions.clickElement(menuButton);
        return new MainMenu();
    }

    /**
     * Checks if header is displayed.
     *
     * @return true if header is displayed, false otherwise.
     */
    public boolean isDisplayed() {
        return WebElementActions.isDisplayed(cartButton) && WebElementActions.isDisplayed(menuButton);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        isDisplayed();
    }
}
