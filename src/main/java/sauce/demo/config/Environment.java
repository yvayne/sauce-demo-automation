package sauce.demo.config;

import sauce.demo.webdriver.DriverTypes;

import java.util.Objects;

/**
 * Groups methods to read environment config variables.
 */
public final class Environment {

    private static final String PROP_FILE = "gradle.properties";
    private static final String BROWSER = "browser";
    private static final String DRIVER_VERSION = "driverVersion";
    private static final String IMPLICIT_TIME_WAIT = "implicitTimeWait";
    private static final String EXPLICIT_TIME_WAIT = "explicitTimeWait";
    private static final String WEB_LOGIN_URL = "webLoginUrl";
    private static final String WEB_HOME_URL = "webHomeUrl";
    private static final String WEB_USER = "webUser";
    private static final String WEB_PASS = "webPass";
    private static Environment instance;

    private final PropReader propReader;

    /**
     * Private constructor for {@link Environment} utility class.
     */
    private Environment() {
        propReader = new PropReader(PROP_FILE);
    }

    /**
     * Initializes singleton instance of {@link Environment}.
     *
     * @return singleton instance.
     */
    public static synchronized Environment config() {
        if (Objects.isNull(instance)) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Gets browser configuration value.
     *
     * @return browser configuration value.
     */
    public DriverTypes getBrowser() {
        return DriverTypes.valueOf(propReader.getEnv(BROWSER).toUpperCase());
    }

    /**
     * Gets driver version value.
     *
     * @return driver version.
     */
    public String getDriverVersion() {
        return propReader.getEnv(DRIVER_VERSION);
    }

    /**
     * Gets login url for portal.
     *
     * @return login url.
     */
    public String getWebLoginUrl() {
        return propReader.getEnv(WEB_LOGIN_URL);
    }

    /**
     * Gets home url for portal.
     *
     * @return home url.
     */
    public String getWebHomeUrl() {
        return propReader.getEnv(WEB_HOME_URL);
    }

    /**
     * Gets implicit time wait configuration value.
     *
     * @return implicit time wait value.
     */
    public int getImplicitTimeWait() {
        return Integer.parseInt(propReader.getEnv(IMPLICIT_TIME_WAIT));
    }

    /**
     * Gets explicit  time wait configuration value.
     *
     * @return explicit time wait.
     */
    public int getExplicitTimeWait() {
        return Integer.parseInt(propReader.getEnv(EXPLICIT_TIME_WAIT));
    }

    /**
     * Gets web user.
     *
     * @return web user.
     */
    public String getWebUser() {
        return propReader.getEnv(WEB_USER);
    }

    /**
     * Gets web user password.
     *
     * @return web user password.
     */
    public String getWebPwd() {
        return propReader.getEnv(WEB_PASS);
    }
}
