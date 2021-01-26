package sauce.demo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sauce.demo.throwables.InitializationError;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

/**
 * Reads configuration file.
 */
class PropReader {

    private static final Logger LOGGER = LogManager.getLogger(PropReader.class);
    private static final String SYSTEM_PROP_PREFIX = "systemProp.";

    private Properties properties;

    /**
     * Initializes an instance of {@link PropReader}.
     *
     * @param path configuration file path.
     */
    PropReader(final String path) {
        LOGGER.info(String.format("Reading config file from path: %s", path));
        this.init(path);
    }

    /**
     * Gets value from configuration file.
     *
     * @param propName property name.
     * @return value from configuration file.
     */
    public String getEnv(final String propName) {
        String property = System.getProperty(propName);
        if (Objects.isNull(property) || property.isEmpty()) {
            return properties.getProperty(SYSTEM_PROP_PREFIX.concat(propName));
        }
        return property;
    }

    /**
     * Reads configuration file.
     *
     * @param path configuration file path.
     */
    private void init(final String path) {
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            this.properties = new Properties();
            this.properties.load(inputFile);
        } catch (IOException e) {
            LOGGER.error(String.format("Error when reading '%s' properties file.", path));
            LOGGER.error(e.getMessage());
            throw new InitializationError();
        }
    }
}
