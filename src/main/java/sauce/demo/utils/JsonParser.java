package sauce.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Parses json files.
 */
public final class JsonParser {

    /**
     * Private constructor for {@link JsonParser} utility class.
     */
    private JsonParser() {
        // Default constructor.
    }

    /**
     * Parses entity class from json String.
     *
     * @param json        json file path.
     * @param entityClass entity class.
     * @param <T>         generic type.
     * @return entity class instance.
     */
    public static <T> T fromJsonString(final String json, final Class<T> entityClass) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, entityClass);
    }
}
