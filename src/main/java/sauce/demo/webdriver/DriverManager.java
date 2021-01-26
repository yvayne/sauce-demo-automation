package sauce.demo.webdriver;

import sauce.demo.config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * It is in charged to manage and perform actions with the Web Driver.
 */
public final class DriverManager {

    private static DriverManager instance;

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Initializes an instance of {@link DriverManager}.
     */
    private DriverManager() {
        initializeDriver();
    }

    /**
     * Initializes the Singleton Driver Manager instance.
     *
     * @return singleton instance.
     */
    public static DriverManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DriverManager();
        }
        return instance;
    }


    /**
     * Initializes the Web Driver instance.
     */
    public void initializeDriver() {
        this.webDriver = DriverFactory.getDriver(Environment.config().getBrowser());
        this.webDriver.manage().window().maximize();
        setDefaultTimeWaits();
    }

    /**
     * Quits the Web Driver instance.
     */
    public void quitDriver() {
        this.webDriver.quit();
        this.webDriver = null;
    }

    /**
     * Gets the Web Driver instance.
     *
     * @return Web Driver instance.
     */
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    /**
     * Gets the Web Driver Wait instance.
     *
     * @return Web Driver Wait instance.
     */
    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }

    /**
     * Sets the default time waits from environment configuration file.
     */
    public void setDefaultTimeWaits() {
        int implicitTimeWait = Environment.config().getImplicitTimeWait();
        int explicitTimeWait = Environment.config().getExplicitTimeWait();
        setImplicitTimeWait(implicitTimeWait);
        setExplicitTimeWait(explicitTimeWait);
    }

    /**
     * Sets implicit time wait.
     *
     * @param implicitTimeWait implicit time wait in seconds.
     */
    public void setImplicitTimeWait(final int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.MILLISECONDS);
    }

    /**
     * Sets explicit time wait.
     *
     * @param explicitTimeWait explicit time wait in seconds.
     */
    public void setExplicitTimeWait(final int explicitTimeWait) {
        webDriverWait = new WebDriverWait(webDriver, TimeUnit.MILLISECONDS.toSeconds(explicitTimeWait));
    }
}
