package sauce.demo.stepdefinitions;

import cucumber.api.java.en.Given;
import sauce.demo.config.Environment;
import sauce.demo.pages.login.LoginPage;

/**
 * Defines login step definitions.
 */
public class LoginSteps {

    private final LoginPage loginPage;

    /**
     * Initializes an instance of {@link LoginSteps}.
     */
    public LoginSteps() {
        loginPage = new LoginPage();
    }

    /**
     * Enters valid credentials.
     */
    @Given("^the user enters valid credentials$")
    public void loginWithValidCredentials() {
        String validUser = Environment.config().getWebUser();
        String validPwd = Environment.config().getWebPwd();
        loginPage.setUsernameTextBox(validUser);
        loginPage.setPasswordTextBox(validPwd);
    }

    /**
     * Clicks login button.
     */
    @Given("^the users clicks login button$")
    public void theUsersClicksLoginButton() {
        loginPage.clickSignInButton();
    }
}
