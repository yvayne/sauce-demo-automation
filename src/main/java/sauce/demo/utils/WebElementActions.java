package sauce.demo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sauce.demo.webdriver.DriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * It is in charged to manage the common Web Elements actions.
 */
public final class WebElementActions {

    private static final Logger LOGGER = LogManager.getLogger(WebElementActions.class);
    private static final String WEB_ELEMENT_NOT_FOUND_MSG = "Web element is not found in current page";
    private static final int DISPLAY_WAIT_TIME = 5;

    /**
     * Private constructor for {@link WebElementActions} utility class.
     */
    private WebElementActions() {
        // Default constructor.
    }

    /**
     * Sets a Input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void setInputField(final WebElement webElement, final String text) {
        webElement.sendKeys(text);
    }

    /**
     * Waits and clicks on a webElement.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElement(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Waits and gets the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public static String getTextElement(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Verifies if Web element is Displayed.
     *
     * @param webElement WebElement.
     * @return True if the element is Displayed.
     */
    public static boolean isDisplayed(final WebElement webElement) {
        try {
            DriverManager.getInstance().setImplicitTimeWait(DISPLAY_WAIT_TIME);
            DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
            DriverManager.getInstance().setDefaultTimeWaits();
            return true;
        } catch (TimeoutException e) {
            LOGGER.info(WEB_ELEMENT_NOT_FOUND_MSG);
            return false;
        }
    }

    /**
     * Selects an item by value in select element.
     *
     * @param webElement select element.
     * @param value      value to be selected.
     */
    public static void setSelectByText(final WebElement webElement, final String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }
}
