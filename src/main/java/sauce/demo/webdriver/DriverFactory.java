package sauce.demo.webdriver;

import sauce.demo.utils.Retrievable;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;

/**
 * It is in charged to create the instance of a Web Driver.
 */
public final class DriverFactory {

    /**
     * Private constructor for {@link DriverFactory} utility class.
     */
    private DriverFactory() {
        //Default constructor.
    }

    /**
     * Gets a Web Driver instances based in a Driver Type parameter.
     *
     * @param type Driver Type enum value.
     * @return Web Driver instance.
     */
    public static WebDriver getDriver(final DriverTypes type) {
        EnumMap<DriverTypes, Retrievable> drivers = new EnumMap<>(DriverTypes.class);
        drivers.put(DriverTypes.CHROME, ChromeBrowser::new);
        drivers.put(DriverTypes.FIREFOX, FirefoxBrowser::new);
        return ((Browser) drivers.get(type).execute()).getDriver();
    }
}
