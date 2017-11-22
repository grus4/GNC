package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 17.01.2017.
 */
public class CheckoutLoginPage extends Page{
    public CheckoutLoginPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void goToGuestShippingPage() {
        web.clickButton("CheckoutAsGuest");
        web.waitForElementIsVisible("FirstNameField");
        web.waitForElementIsClickable("FirstNameField");

        if(web.isElementVisibleAndClickable("FirstNameField")
                && web.isElementAvailable("FirstNameField")) {
            log.info("Switching to the Shipping page was correct");
        } else {
            log.error("Switching to the Shipping page was INCORRECT!\n");
            Assert.fail("Switching to the Shipping page was INCORRECT!");
        }
    }

    public void switchToRegisteredUserShippingPage() {

    }

    public void fillEmailField(String email) {
        web.input("EmailFieldOnLoginCheckoutPage", email);
    }

    public void fillPasswordField(String password) {
        web.input("PasswordFieldOnLoginCheckoutPage", password);
    }

    public void logInAsRegisteredUser() {
        web.clickButton("LoginButtonOnLoginCheckoutPage");
    }
}
