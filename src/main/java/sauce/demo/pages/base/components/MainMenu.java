package sauce.demo.pages.base.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.BaseComponent;
import sauce.demo.utils.WebElementActions;

/**
 * Defines main menu base component.
 */
public class MainMenu extends BaseComponent {

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateButton;

    /**
     * Clicks all items button.
     */
    public void clickAllItemsButton() {
        WebElementActions.clickElement(allItemsButton);
    }

    /**
     * Clicks about button.
     */
    public void clickAboutButton() {
        WebElementActions.clickElement(aboutButton);
    }

    /**
     * Clicks logout button.
     */
    public void clickLogoutButton() {
        WebElementActions.clickElement(logoutButton);
    }

    /**
     * click reset app state button.
     */
    public void clickResetAppStateButton() {
        WebElementActions.clickElement(resetAppStateButton);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.isDisplayed(allItemsButton);
        WebElementActions.isDisplayed(aboutButton);
        WebElementActions.isDisplayed(logoutButton);
        WebElementActions.isDisplayed(resetAppStateButton);
    }
}
