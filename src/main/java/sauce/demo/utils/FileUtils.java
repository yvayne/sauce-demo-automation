package sauce.demo.utils;

import org.apache.commons.io.input.NullReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Defines utility methods for file management.
 */
public final class FileUtils {

    private static final Logger LOGGER = LogManager.getLogger(FileUtils.class);
    private static final int NULL_READER_SIZE = 0;

    /**
     * Private constructor for {@link FileUtils} utility class.
     */
    private FileUtils() {

    }

    /**
     * Gets absolute path from file.
     *
     * @param path file path.
     * @return absolute path.
     */
    public static String getAbsolutePath(final String path) {
        File file = new File(path);
        return file.getAbsolutePath();
    }


    /**
     * Gets file object from file.
     *
     * @param filePath file absolute path.
     * @return reader object.
     */
    public static File getFile(final String filePath) {
        return new File(getAbsolutePath(filePath));
    }

    /**
     * Gets reader object from file.
     *
     * @param filePath file absolute path.
     * @return reader object.
     */
    public static Reader getReader(final String filePath) {
        try {
            return new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Error in file reading");
            LOGGER.error(e.getMessage());
        }
        return new NullReader(NULL_READER_SIZE);
    }
}
