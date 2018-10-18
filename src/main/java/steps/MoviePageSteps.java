package steps;

import base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MoviePageSteps extends BasePage {

    private static final By FI_EDITSCORE_LINK_CSS_SELECTOR = By.cssSelector("#fi_editscore_link");
    private static final By FI_RATING_INPUT_CSS_SELECTOR = By.cssSelector("#fi_rating_div input");
    private static final By FI_SUBMIT_LINK_CSS_SELECTOR = By.cssSelector("#fi_submit_link");
    private static final By MOVIE_TITLE_CSS_SELECTOR = By.cssSelector("#left_container > h1 > span");

    @Then("^I should see movie page that includes the ([^\"]*)$")
    public void iShouldSeeMoviePageThatIncludesTheMovieName(String movieName) {

        Assert.assertEquals(movieName.toLowerCase(), getTextOfElement(MOVIE_TITLE_CSS_SELECTOR).toLowerCase());
    }

    @And("^I vote for the movie with ([^\"]*)$")
    public void iVoteForTheMovieWithScore(String movieScore) {

        if (isElementExist(FI_EDITSCORE_LINK_CSS_SELECTOR)) {

            clickElement(FI_EDITSCORE_LINK_CSS_SELECTOR);
        }

        clickElement(FI_RATING_INPUT_CSS_SELECTOR);
        fillInputField(FI_RATING_INPUT_CSS_SELECTOR, movieScore, false);
        clickElement(FI_SUBMIT_LINK_CSS_SELECTOR);
    }
}
