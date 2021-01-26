package sauce.demo.pages.base;

import org.openqa.selenium.support.PageFactory;
import sauce.demo.webdriver.DriverManager;

/**
 * Defines the page object model and components base abstraction.
 */
public abstract class BaseComponent {

    /**
     * Initializes an instance of {@link BaseComponent}.
     */
    public BaseComponent() {
        PageFactory.initElements(DriverManager.getInstance().getWebDriver(), this);
        waitToLoad();
    }

    /**
     * Gets page title.
     *
     * @return page title.
     */
    public String getTitle() {
        return DriverManager.getInstance().getWebDriver().getTitle();
    }

    /**
     * Abstract method to wait to load component.
     */
    protected abstract void waitToLoad();
}
