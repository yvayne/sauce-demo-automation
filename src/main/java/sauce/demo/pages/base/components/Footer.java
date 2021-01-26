package sauce.demo.pages.base.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.BaseComponent;
import sauce.demo.utils.WebElementActions;


/**
 * Defines Swag Labs footer base component.
 */
public class Footer extends BaseComponent {

    @FindBy(css = ".footer_robot")
    private WebElement footerImage;

    /**
     * Checks if footer is displayed.
     *
     * @return true if footer is displayed, false otherwise.
     */
    public boolean isDisplayed() {
        return WebElementActions.isDisplayed(footerImage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        isDisplayed();
    }
}
