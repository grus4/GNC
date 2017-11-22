package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 25.11.2016.
 */
public class LoginPage extends Page{
    public LoginPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void fillEmailField(String email) {
        web.input("EmailAddressField", email);
    }

    public void fillPasswordField(String password) {
        web.input("PasswordField", password);
    }

    public void goToMyAccount() {
        web.clickButton("LoginButton");
        web.clickButton("MyAccountIcon");
        web.waitForElementIsVisible("LogoutLinkInMyAccount");
        web.waitForElementIsClickable("LogoutLinkInMyAccount");

        if (web.isElementVisibleAndClickable("LogoutLinkInMyAccount")) {
                log.info("Switching to My Account was correct");
            } else {
                log.error("Switching to My Account was INCORRECT!\n");
                Assert.fail("Switching to My Account was INCORRECT!\n");
            }

    }

    public void clickLoginButton() {
        web.clickOnElement("LoginButton");
    }

    public void checkValidationForEmailAddressEmptyField() {
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyEmailField")
                && web.getElementText("ErrorMessageForEmptyEmailField").equals("This field is required.")){
            log.info("Email Address Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Email Address Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is EmailAddressErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyEmailField") + "\n"
                    + "EmailAddressErrorMessage - " + web.getElementText("ErrorMessageForEmptyEmailField"));
            Assert.fail("Email Address Error Message is displayed INCORRECTLY" + "\n"
                    + "is EmailAddressErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyEmailField") + "\n"
                    + "EmailAddressErrorMessage - " + web.getElementText("ErrorMessageForEmptyEmailField"));

        }
    }

    public void checkValidationForPasswordEmptyField() {
        if(web.isElementVisibleAndClickable("ErrorMessageForPasswordField")
                && web.getElementText("ErrorMessageForPasswordField").equals("This field is required.")){
            log.info("Password Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Password Error Message for empty field is displayed INCORRECTLY!" + "\n"
            + "is PasswordErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForPasswordField") + "\n"
            + "PasswordErrorMessage - " + web.getElementText("ErrorMessageForPasswordField"));
            Assert.fail("Password Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is PasswordErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForPasswordField") + "\n"
                    + "PasswordErrorMessage - " + web.getElementText("ErrorMessageForPasswordField"));
        }
    }

    public void assertValidationForAllEptyFields() {
        checkValidationForEmailAddressEmptyField();
        checkValidationForPasswordEmptyField();
    }

    public void assertValidationForInvalidData() {
        if(web.isElementVisibleAndClickable("ErrorMessageForInvalidData")
                && web.getElementText("ErrorMessageForInvalidData").equals("Sorry, this does not match our records. Check your spelling and try again.")){
            log.info("Error message for Invalid Data in Email field is displayed correctly above the Login Form");
        } else {
            log.error("Error message for Invalid Data in Email field is displayed INCORRETLY!" + "\n"
            + "is ErrorMessageForInvalidData in Email Field present - " + web.isElementVisibleAndClickable("ErrorMessageForInvalidData") + "\n"
            + "ErrorMessageForInvalidData in Email Field - " + web.getElementText("ErrorMessageForInvalidData"));
            Assert.fail("Error message for Invalid Data in Email field is displayed INCORRETLY!" + "\n"
                    + "is ErrorMessageForInvalidData in Email Field present - " + web.isElementVisibleAndClickable("ErrorMessageForInvalidData") + "\n"
                    + "ErrorMessageForInvalidData in Email Field - " + web.getElementText("ErrorMessageForInvalidData"));
        }
    }


}
