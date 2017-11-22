package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 18.01.2017.
 */
public class BillingPage extends Page{

    public BillingPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void fillEmailField(String email) {
        web.input("EmailFieldOfBillingPage", email);
    }

    public void fillCardName(String cardName) {
        web.input("CardNameField", cardName);
    }

    public void fillCardNumber(String cardNumber) {
        web.input("CardNumberField", cardNumber);

    }

    public void selectMonth(String month) {
        web.selectFromDropDownListByVisibleText("MonthDropDown", month);

    }

    public void selectYear(String year) {
        web.selectFromDropDownListByVisibleText("YearDropDown", year);

    }

    public void fillSecurityCode(String Cvv) {
        web.input("SecurityCodeField", Cvv);
    }

    public void goToReviewPage() {
        web.clickButton("ContinueToPlaceOrderButton");
        sleep(4000);
        web.waitForElementIsVisible("PlaceOrderButton");
        web.waitForElementIsClickable("PlaceOrderButton");

        if(web.isElementVisibleAndClickable("PlaceOrderButton")
                && web.isElementAvailable("PlaceOrderButton")){
            log.info("Switching to Place Order page was correct");
        } else {
            log.error("Switching to Place Order page was INCORRECT!");
            Assert.fail("Switching to Place Order page was INCORRECT!");
        }
    }

    public void selectCardType(String cardType) {
        web.selectFromDropDownListByVisibleText("CardTypeDropDown", cardType);
    }

    public void fillCardNumberRegisteredUser(String cardNumber) {
        web.input("CardNumberFieldRegisteredUser", cardNumber);
    }

    public void fillSecurityCodeRegisteredUser(String securityCode) {
        web.input("SecurityCodeFieldRegisteredUser", securityCode);
    }
}
