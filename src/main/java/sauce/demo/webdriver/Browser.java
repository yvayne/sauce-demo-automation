package sauce.demo.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * Browser interface for supported web browsers.
 */
public interface Browser {

    /**
     * Gets a Web Driver instance of a specific browser.
     *
     * @return Web Driver instance.
     */
    WebDriver getDriver();
}
