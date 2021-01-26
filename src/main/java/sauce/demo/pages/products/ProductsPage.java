package sauce.demo.pages.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.SwagLabsBasePage;
import sauce.demo.utils.WebElementActions;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines product page object model.
 */
public class ProductsPage extends SwagLabsBasePage {

    private static final Logger LOGGER = LogManager.getLogger(ProductsPage.class);
    private static final String PRICE_REGEX = "(\\d+(?:\\.\\d+)?)";
    private static final int PRICE_GROUP = 1;
    private static final int FIRST_ITEM_INDEX = 0;

    @FindBy(css = ".product_sort_container")
    private WebElement productSortSelect;

    @FindBy(css = ".product_label")
    private WebElement productLabel;

    @FindBy(css = ".inventory_item")
    private List<WebElement> productItems;

    /**
     * Clicks on add to cart button according to item's name.
     *
     * @param itemName item's name.
     */
    public void clickOnAddToCartButton(final String itemName) {
        WebElement item = searchItem(itemName);
        clickOnAddToCartButton(item);
    }

    /**
     * Clicks on add to cart button according to items names list.
     *
     * @param itemsNames items names.
     */
    public void clickOnAddToCartButton(final List<String> itemsNames) {
        itemsNames.forEach(this::clickOnAddToCartButton);
    }

    /**
     * Selects option from product sort select.
     *
     * @param option select option.
     */
    public void selectProductSort(final String option) {
        WebElementActions.setSelectByText(productSortSelect, option);
    }

    /**
     * Checks if the lowest price item is displayed first in products list.
     *
     * @return true if condition is accomplished, false otherwise.
     */
    public boolean isLowestPriceItemDisplayedFirst() {
        if (!productItems.isEmpty()) {
            float firstItemPrice = getPriceFromItem(productItems.get(FIRST_ITEM_INDEX));
            float minimumPrice = productItems.stream().map(this::getPriceFromItem)
                    .min(Comparator.naturalOrder()).get();
            return firstItemPrice == minimumPrice;
        }
        return false;
    }

    /**
     * Checks if page is displayed.
     *
     * @return true if all elements are displayed, false otherwise.
     */
    public boolean isDisplayed() {
        return WebElementActions.isDisplayed(productSortSelect)
                && WebElementActions.isDisplayed(productLabel)
                && getHeader().isDisplayed()
                && getFooter().isDisplayed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.isDisplayed(productSortSelect);
        WebElementActions.isDisplayed(productLabel);
    }

    /**
     * Searches for an item according to it's name.
     *
     * @param itemName item's name.
     * @return item component.
     */
    private WebElement searchItem(final String itemName) {
        for (WebElement item : productItems) {
            String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
            if (itemName.equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Clicks on add to cart button from an item component.
     *
     * @param item item component.
     */
    private void clickOnAddToCartButton(final WebElement item) {
        if (Objects.nonNull(item)) {
            WebElement cartButton = item.findElement(By.cssSelector(".btn_inventory"));
            WebElementActions.clickElement(cartButton);
            return;
        }
        LOGGER.info("Item was not found in product list.");
    }

    /**
     * Gets price from item.
     *
     * @param item item element.
     * @return price number.
     */
    private float getPriceFromItem(final WebElement item) {
        String priceText = item.findElement(By.cssSelector(".inventory_item_price")).getText();
        Pattern regex = Pattern.compile(PRICE_REGEX);
        Matcher matcher = regex.matcher(priceText);
        if (matcher.find()) {
            return Float.parseFloat(matcher.group(PRICE_GROUP));
        }
        return 0;
    }
}
