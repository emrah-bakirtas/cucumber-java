package steps;

import base.BasePage;
import cucumber.api.java.en.*;

import static constant.SearchResultsPageConstant.SR_RESULT_IMG_CSS_SELECTOR;

public class SearchResultsPageSteps extends BasePage {

    @When("^I click on movie$")
    public void iClickOnMovie() {

        clickElement(SR_RESULT_IMG_CSS_SELECTOR, 0);
    }
}
