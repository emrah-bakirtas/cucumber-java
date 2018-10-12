package steps;

import base.BasePage;
import cucumber.api.java.en.*;
import org.junit.Assert;

import static constant.ProfilePageConstant.*;
import static constant.ProfilePageConstant.UP_INPUT_PSWD2_CSS_SELECTOR;
import static constant.ProfilePageConstant.UP_PSWDUPDATE_SUBMIT_CSS_SELECTOR;

public class ProfilePageSteps extends BasePage {

    @And("^I click update personal information link$")
    public void iClickUpdatePersonalInformationLink() {

        clickElement(UP_INFOUPDATELINK_CSS_SELECTOR);
    }

    @And("^I click update password link$")
    public void iClickUpdatePasswordLink() {

        clickElement(UP_PSWUPDATELINK_SUBMIT_CSS_SELECTOR);
    }

    @And("^I enter oldPassword as \"([^\"]*)\" and newPassword as \"([^\"]*)\"$")
    public void iEnterOldPasswordAsAndNewPasswordAs(String oldPassword, String newPassword) {

        fillInputField(UP_INPUT_OLDPSWD_CSS_SELECTOR, oldPassword, false);
        fillInputField(UP_INPUT_PSWD1_CSS_SELECTOR, newPassword, false);
        fillInputField(UP_INPUT_PSWD2_CSS_SELECTOR, newPassword, false);
        clickElement(UP_PSWDUPDATE_SUBMIT_CSS_SELECTOR);
    }

    @And("^I enter name as \"([^\"]*)\" and surname as \"([^\"]*)\" and email as \"([^\"]*)\" and city as \"([^\"]*)\"$")
    public void iEnterNameAsAndSurnameAsAndEmailAsAndCityAs(String name, String surname, String email, String city) {

        fillInputField(UP_INPUT_FNAME_CSS_SELECTOR, name, false);
        fillInputField(UP_INPUT_LNAME_CSS_SELECTOR, surname , false);
        fillInputField(UP_INPUT_EMAIL_CSS_SELECTOR, email, false);
        fillInputField(UP_INPUT_CITY_CSS_SELECTOR, city, false);
        clickElement(UP_UPDATE_SUBMIT_CSS_SELECTOR);
    }

    @Then("^I should see username as \"([^\"]*)\" on the profile page$")
    public void iShouldSeeUsernameAsOnTheProfilePage(String username){

        Assert.assertEquals(username, getTextOfElement(UP_USERNAME_ID_CSS_SELECTOR));
    }
}
