package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 24.11.2016.
 */
public class Header extends Page {
    public Header(WebDriverWrapper dr) {
        super(dr);
    }

    public void goToLoginPage() {
        web.clickOnElement("MyAccountIcon");
        web.waitForElementIsClickable("LoginLink");
        web.clickOnElement("LoginLink");
        web.waitForElementIsVisible("LoginButton");

        if(web.isElementVisibleAndClickable("LoginButton")
                && web.isElementAvailable("LoginButton")){
            log.info("Switching to Login page was correct");
        } else {
            log.error("Switching to Login page was INCORRECT!!\n");
            Assert.fail("Switching to Login page was INCORRECT!!");
        }
    }

    public void logout() {
        if(web.isElementAvailable("LogOutButton")){
            web.clickOnElement("LogOutButton");

        } else {
            web.clickOnElement("MyAccountIcon");
            web.clickOnElement("LogOutButton");
        }

    }

    public void goToCreateAccountPage() {
        web.clickOnElement("MyAccountIcon");
        web.waitForElementIsClickable("RegisterLink");
        web.clickLink("RegisterLink");

        if(web.isElementVisibleAndClickable("SaveButton")
                && web.isElementAvailable("SaveButton")) {
            log.info("Switching to Create Account page was correct");
        } else {
            log.error("Switching to Create Account page was INCORRECT!\n");
            Assert.fail("Switching to Create Account page was INCORRECT!");
        }
    }

    public void goToCLP() {
        web.moveToElementAndClick("Vitamins&Supplements", "MultivitaminsForMen");
        web.waitForElementIsVisible("SortingDropDown");
        web.waitForElementIsClickable("SortingDropDown");

        if(web.isElementVisibleAndClickable("SortingDropDown")
                && web.isElementAvailable("SortingDropDown")){
            log.info("Switching to CLP was correct");
        } else {
            log.info("Switching to CLP was INCORRECT!");
            Assert.fail("Switching to CLP was INCORRECT!");
        }
    }

    public void goToShoppingCartPage() {
        web.moveToElementAndClick("CartIcon", "ViewCart");
        web.waitForElementIsVisible("BottomCheckoutButton");
        web.waitForElementIsClickable("BottomCheckoutButton");

        if(web.isElementVisibleAndClickable("BottomCheckoutButton")
                && web.isElementAvailable("BottomCheckoutButton")){
            log.info("Switching to the Shopping Cart was correct");
        } else {
            log.error("Switching to the Shopping Cart was INCORRECT!\n");
            Assert.fail("Switching to the Shopping Cart was INCORRECT!");
        }
    }

    public void goToHomePage() {
        web.clickOnElement("Logo");
    }
}
