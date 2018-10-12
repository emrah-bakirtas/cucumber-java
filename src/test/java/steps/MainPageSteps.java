package steps;

import base.BasePage;
import cucumber.api.java.en.*;

import static constant.MainPageConstant.*;

public class MainPageSteps extends BasePage {

    @When("^I click username link$")
    public void iClickUsernameLink() {

        clickElement(I_USERNAME_LINK_CSS_SELECTOR);
    }

    @Given("^I click login link$")
    public void iClickLoginLink(){

        clickElement(I_SIGNIN_LINK_CSS_SELECTOR);
    }

    @Given("^I navigate to the app$")
    public void iNavigateToTheApp(){

        navigateTo();
    }

    @And("^I log out$")
    public void iLogOut(){

        clickElement(I_SIGNOUT_LINK_CSS_SELECTOR);
    }

    @And("^I search a ([^\"]*)$")
    public void iSearchAMovie(String movieName){

        fillInputField(I_SEARCHBOX_CSS_SELECTOR, movieName, true);
    }
}
