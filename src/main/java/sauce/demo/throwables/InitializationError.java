package sauce.demo.throwables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Custom initialization error class.
 */
public class InitializationError extends ExceptionInInitializerError {

    private static final Logger LOGGER = LogManager.getLogger(InitializationError.class);
    private static final String DEFAULT_ERROR_MESSAGE = "Error when initializing automated tests execution.";
    private static final int UNSUCCESSFUL_EXIT_STATUS_CODE = -1;

    /**
     * Initializes instance for error throwing.
     */
    public InitializationError() {
        super(DEFAULT_ERROR_MESSAGE);
        LOGGER.error(DEFAULT_ERROR_MESSAGE);
        System.exit(UNSUCCESSFUL_EXIT_STATUS_CODE);
    }
}
