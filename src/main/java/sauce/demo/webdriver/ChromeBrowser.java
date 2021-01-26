package sauce.demo.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sauce.demo.config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

/**
 * It is in charged to instantiate a Chrome web driver.
 */
public class ChromeBrowser implements Browser {

    private final ChromeOptions options;

    /**
     * Initializes an instance of {@link ChromeBrowser}.
     */
    public ChromeBrowser() {
        options = new ChromeOptions(); // Set additional web driver options here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getDriver() {
        String version = Environment.config().getDriverVersion();
        if (Objects.isNull(version)) {
            WebDriverManager.chromedriver().setup();
        } else {
            WebDriverManager.chromedriver().browserVersion(version).setup();
        }
        return new ChromeDriver(options);
    }
}
