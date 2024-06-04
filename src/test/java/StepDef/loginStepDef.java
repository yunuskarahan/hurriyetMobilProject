package StepDef;

import Pages.LoginPage;
import Utils.AppUtils;
import Utils.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginStepDef {

    LoginPage loginPage = new LoginPage();


    @When("User can click profile icon.")
    public void userCanClickProfileIcon() {
        AppUtils.waitForClick(loginPage.allowButton, 30);
        loginPage.allowButton.click();
        AppUtils.waitForClick(loginPage.profileIcon, 15);
        loginPage.profileIcon.click();

    }

    @Then("Verify that the user should be see {string} text.")
    public void verifyThatTheUserShouldBeSeeText(String expectedText) {

        loginPage.verifyText(loginPage.profileHeader, expectedText);
    }

    @When("User can click login button.")
    public void userCanClickLoginButton() {
        AppUtils.waitForClick(loginPage.loginButton, 15);
        loginPage.loginButton.click();
    }

    @Then("Verify that the user should be see {string} text.\\(signInPage)")
    public void verifyThatTheUserShouldBeSeeTextSignInPage(String expectedText) {
        loginPage.verifyText(loginPage.signInAndRegisterText, expectedText);
    }

    @When("User can login.")
    public void userCanLogin() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username, password);
    }

    @Then("Verify that the user should be see username text.")
    public void verifyThatTheUserShouldBeSeeUsernameText() {
        loginPage.verifyText(loginPage.usernameText, ConfigurationReader.get("username"));
    }
}
