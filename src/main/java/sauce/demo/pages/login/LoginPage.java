package sauce.demo.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauce.demo.pages.base.BaseComponent;
import sauce.demo.utils.WebElementActions;

/**
 * Defines SignIn page object model.
 */
public class LoginPage extends BaseComponent {

    @FindBy(id = "user-name")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Sets username text box.
     *
     * @param username email value.
     */
    public void setUsernameTextBox(final String username) {
        WebElementActions.setInputField(usernameTextBox, username);
    }

    /**
     * Sets password text box.
     *
     * @param pwd password value.
     */
    public void setPasswordTextBox(final String pwd) {
        WebElementActions.setInputField(passwordTextBox, pwd);
    }

    /**
     * Clicks sign in button.
     */
    public void clickSignInButton() {
        WebElementActions.clickElement(loginButton);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void waitToLoad() {
        WebElementActions.isDisplayed(usernameTextBox);
        WebElementActions.isDisplayed(passwordTextBox);
        WebElementActions.isDisplayed(loginButton);
    }
}
