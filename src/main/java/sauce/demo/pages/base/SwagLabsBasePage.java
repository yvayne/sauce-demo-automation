package sauce.demo.pages.base;

import sauce.demo.pages.base.components.Footer;
import sauce.demo.pages.base.components.Header;

/**
 * Defines Swag Labs base page and its common components.
 */
public abstract class SwagLabsBasePage extends BaseComponent {

    private final Header header;
    private final Footer footer;

    public SwagLabsBasePage() {
        header = new Header();
        footer = new Footer();
    }

    /**
     * Gets header component.
     *
     * @return header component.
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Gets footer component.
     *
     * @return footer component.
     */
    public Footer getFooter() {
        return footer;
    }

    /**
     * Abstract method to wait to load page.
     */
    protected abstract void waitToLoad();
}
