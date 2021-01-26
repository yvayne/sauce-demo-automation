package sauce.demo.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sauce.demo.config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

/**
 * It is in charged to instantiate a Gecko Firefox web driver.
 */
public class FirefoxBrowser implements Browser {

    private final FirefoxOptions options;

    /**
     * Initializes and instance of {@link FirefoxBrowser}.
     */
    public FirefoxBrowser() {
        options = new FirefoxOptions(); // Set additional web driver options here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getDriver() {
        String version = Environment.config().getDriverVersion();
        if (Objects.isNull(version)) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            WebDriverManager.firefoxdriver().browserVersion(version).setup();
        }
        return new FirefoxDriver(options);
    }
}
