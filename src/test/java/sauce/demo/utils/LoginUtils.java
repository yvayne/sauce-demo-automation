package sauce.demo.utils;

import sauce.demo.config.Environment;
import sauce.demo.pages.base.components.MainMenu;
import sauce.demo.pages.login.LoginPage;
import sauce.demo.pages.products.ProductsPage;
import sauce.demo.webdriver.DriverManager;

/**
 * Defines utility methods for login actions.
 */
public final class LoginUtils {

    /**
     * Private constructor for {@link LoginUtils} utility class.
     */
    private LoginUtils() {

    }

    /**
     * Logins to shop page using credentials.
     *
     * @param context context utility class.
     */
    public static void loginWithValidCredentials(final Context context) {
        if (!context.isUserLogged()) {
            String loginPageUrl = Environment.config().getWebLoginUrl();
            DriverManager.getInstance().getWebDriver().get(loginPageUrl);
            String validUser = Environment.config().getWebUser();
            String validPwd = Environment.config().getWebPwd();
            LoginPage loginPage = new LoginPage();
            loginPage.setUsernameTextBox(validUser);
            loginPage.setPasswordTextBox(validPwd);
            loginPage.clickSignInButton();
            context.setLoginStatus(true);
        }
    }

    /**
     * Resets app state.
     *
     * @param context context utility class.
     */
    public static void resetAppState(final Context context) {
        if (context.isUserLogged()) {
            String homeUrl = Environment.config().getWebHomeUrl();
            ProductsPage productsPage = new ProductsPage();
            MainMenu mainMenu = productsPage.getHeader().clickMenuButton();
            mainMenu.clickResetAppStateButton();
            DriverManager.getInstance().getWebDriver().get(homeUrl);
        }
    }
}
