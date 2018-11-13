package steps;

import base.BasePage;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;

public class SearchResultsPageSteps extends BasePage {

    private static final By SR_RESULT_FILMINFO94851_CSS_SELECTOR = By.cssSelector("#sr_result_filminfo94851");
    private static final By SR_RESULT_IMG_CSS_SELECTOR = By.cssSelector(".sr_result_img");

    @When("^I click on movie$")
    public void iClickOnMovie() {

        clickElement(SR_RESULT_IMG_CSS_SELECTOR, 0);
    }
}
