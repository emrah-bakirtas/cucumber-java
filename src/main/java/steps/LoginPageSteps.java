package steps;

import base.BasePage;
import cucumber.api.java.en.*;

import static constant.LoginPageConstant.SI_INPUT_PSWD_CSS_SELECTOR;
import static constant.LoginPageConstant.SI_INPUT_UNAME_CSS_SELECTOR;

public class LoginPageSteps extends BasePage {

    @Then("^I login with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iLoginWithUsernameAsAndPasswordAs(String username, String password) {

        fillInputField(SI_INPUT_UNAME_CSS_SELECTOR, username, false);
        fillInputField(SI_INPUT_PSWD_CSS_SELECTOR, password, true);
    }
}
