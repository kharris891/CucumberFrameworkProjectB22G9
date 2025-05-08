package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Assert.assertTrue(isElementDisplayed(loginPage.usernameField));
    }

    @When("I enter empty username and valid password")
    public void i_enter_empty_username_and_valid_password() {
        sendText(loginPage.usernameField, "");
        sendText(loginPage.passwordField, "Hum@nhrm123");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        click(loginPage.loginButton);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedText) {
        String actualText = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("I enter valid username and empty password")
    public void i_enter_valid_username_and_empty_password() {
        sendText(loginPage.usernameField, "admin");
        sendText(loginPage.passwordField, "");
    }

    @When("I enter invalid username and invalid password")
    public void i_enter_invalid_username_and_invalid_password() {
        sendText(loginPage.usernameField, "abc");
        sendText(loginPage.passwordField, "def");

    }

}
