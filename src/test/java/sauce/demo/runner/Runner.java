package sauce.demo.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import sauce.demo.webdriver.DriverManager;
import org.testng.annotations.AfterTest;

/**
 * Defines cucumber TestNG runner class.
 */
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"sauce.demo"},
        features = {"src/test/resources/features"}
)
public final class Runner extends AbstractTestNGCucumberTests {

    /**
     * Executes code after all scenarios.
     */
    @AfterTest
    public void afterAllScenarios() {
        DriverManager.getInstance().quitDriver();
    }
}
