package sauce.demo.utils;

/**
 * Strategy Retrievable Step functional interface to get values.
 */
public interface Retrievable {

    /**
     * Executes step for lambda expression and return value.
     *
     * @return object from lambda expression.
     */
    Object execute();
}
