package sauce.demo.stepdefinitions;

import cucumber.api.java.en.Given;
import sauce.demo.config.Environment;
import sauce.demo.utils.Context;
import sauce.demo.utils.LoginUtils;
import sauce.demo.webdriver.DriverManager;

/**
 * Defines common step definitions.
 */
public class CommonSteps {

    private final Context context;

    /**
     * Initializes an instance of {@link CommonSteps}.
     *
     * @param context {@link Context}.
     */
    public CommonSteps(final Context context) {
        this.context = context;
    }

    /**
     * Navigates to login page.
     */
    @Given("^the user goes to login page$")
    public void goesToLoginPage() {
        String loginPageUrl = Environment.config().getWebLoginUrl();
        DriverManager.getInstance().getWebDriver().get(loginPageUrl);
    }

    /**
     * Logins with valid credentials and reset app state.
     */
    @Given("^the user logins with valid credentials resetting app state$")
    public void theUserLoginsWithValidCredentialsResettingAppState() {
        LoginUtils.loginWithValidCredentials(context);
        LoginUtils.resetAppState(context);
    }
}
