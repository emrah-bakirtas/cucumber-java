package steps;

import base.BasePage;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;

public class LoginPageSteps extends BasePage {

    private static final By SI_INPUT_UNAME_CSS_SELECTOR = By.xpath("//*[@id=\"si_username\"]");
    private static final By SI_INPUT_PSWD_CSS_SELECTOR = By.xpath("//*[@id=\"si_password\"]");

    @Then("^I login with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iLoginWithUsernameAsAndPasswordAs(String username, String password) {

        fillInputField(SI_INPUT_UNAME_CSS_SELECTOR, username, false);
        fillInputField(SI_INPUT_PSWD_CSS_SELECTOR, password, true);
    }
}
