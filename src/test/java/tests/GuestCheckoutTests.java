package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Rus on 16.01.2017.
 */
public class GuestCheckoutTests extends Fixture {

    @Test
    public void guestCheckout_GroundShipping_VISA() {
        extentTest = extentReports
                .startTest("guestCheckout_GroundShipping_VISA")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open SiteGenesis Home Page");
        gnc.header.goToCLP();
        extentTest.log(LogStatus.INFO, "Switch to CLP");
        gnc.categoryLandingPage.goToStandardPDP();
        extentTest.log(LogStatus.INFO, "Switch to Standard PDP");
        gnc.standardPDP.addProductToCart();
        extentTest.log(LogStatus.INFO, "Add product to the mini cart");
        gnc.header.goToShoppingCartPage();
        extentTest.log(LogStatus.INFO, "Switching to the Shopping cart");
        gnc.shoppingCartPage.goToLoginCheckoutPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Checkout page");
        gnc.checkoutLoginPage.goToGuestShippingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Shipping page");
        gnc.shippingPage.fillEmailAddressField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email field on the Shipping page");
        gnc.shippingPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the  First Name field on the Shipping page");
        gnc.shippingPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field on the Shipping page");
        gnc.shippingPage.fillAddressLine_1_Field(ADDRESS_1);
        extentTest.log(LogStatus.INFO, "Fill in the address field #1");
        gnc.shippingPage.fillAddressLine_2_Field("");
        extentTest.log(LogStatus.INFO, "Leave the address field #2 empty");
        gnc.shippingPage.fillCityField(CITY);
        extentTest.log(LogStatus.INFO, "Fill in the city field");
        gnc.shippingPage.fillZipField(ZIP);
        extentTest.log(LogStatus.INFO, "Fill in the zip field");
        gnc.shippingPage.selectState(STATE);
        extentTest.log(LogStatus.INFO, "Select state from the drop down field");
        gnc.shippingPage.fillPhoneField(PHONE);
        extentTest.log(LogStatus.INFO, "Fill in the phone field");
        gnc.shippingPage.selectUseThisAddressForBillingCheckbox();
        extentTest.log(LogStatus.INFO, "Check the This is also my billing address checkbox");
        gnc.shippingPage.goToBillingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Billing page");
        gnc.billingPage.fillCardName(CARDNAME_VISA);
        extentTest.log(LogStatus.INFO, "Fill in the Card Name field");
        gnc.billingPage.fillCardNumber(CARDNUMBER_VISA);
        extentTest.log(LogStatus.INFO, "Fill in the Card Number field");
        gnc.billingPage.selectMonth(MONTH);
        extentTest.log(LogStatus.INFO, "Select month from the drop down field");
        gnc.billingPage.selectYear(YEAR);
        extentTest.log(LogStatus.INFO, "Select year from the drop down field");
        gnc.billingPage.fillSecurityCode(VISA_CVV);
        extentTest.log(LogStatus.INFO, "Fill in the CVV field with correct data");
        gnc.billingPage.goToReviewPage();
        extentTest.log(LogStatus.INFO, "Switching to the Review page");
        gnc.reviewPage.goToOrderReceiptPage();
        extentTest.log(LogStatus.INFO, "Switching to the Order Receipt page");
        Assert.assertTrue(gnc.orderReceiptPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        extentTest.log(LogStatus.INFO, "The order has been created successfully");
        gnc.header.goToHomePage();
        extentTest.log(LogStatus.INFO, "Switching to Home page");

    }

    @Test
    public void guestCheckout_2DayExpress_MasterCard() {
        extentTest = extentReports
                .startTest("guestCheckout_2DayExpress_MasterCard")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open SiteGenesis Home Page");
        gnc.header.goToCLP();
        extentTest.log(LogStatus.INFO, "Switch to CLP");
        gnc.categoryLandingPage.goToStandardPDP();
        extentTest.log(LogStatus.INFO, "Switch to Standard PDP");
        gnc.standardPDP.addProductToCart();
        extentTest.log(LogStatus.INFO, "Add product to the mini cart");
        gnc.header.goToShoppingCartPage();
        extentTest.log(LogStatus.INFO, "Switching to the Shopping cart");
        gnc.shoppingCartPage.goToLoginCheckoutPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Checkout page");
        gnc.checkoutLoginPage.goToGuestShippingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Shipping page");
        gnc.shippingPage.fillEmailAddressField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email field on the Shipping page");
        gnc.shippingPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the  First Name field on the Shipping page");
        gnc.shippingPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field on the Shipping page");
        gnc.shippingPage.fillAddressLine_1_Field(ADDRESS_1);
        extentTest.log(LogStatus.INFO, "Fill in the address field #1");
        gnc.shippingPage.fillAddressLine_2_Field("");
        extentTest.log(LogStatus.INFO, "Leave the address field #2 empty");
        gnc.shippingPage.fillCityField(CITY);
        extentTest.log(LogStatus.INFO, "Fill in the city field");
        gnc.shippingPage.fillZipField(ZIP);
        extentTest.log(LogStatus.INFO, "Fill in the zip field");
        gnc.shippingPage.selectState(STATE);
        extentTest.log(LogStatus.INFO, "Select state from the drop down field");
        gnc.shippingPage.fillPhoneField(PHONE);
        extentTest.log(LogStatus.INFO, "Fill in the phone field");
        gnc.shippingPage.selectUseThisAddressForBillingCheckbox();
        extentTest.log(LogStatus.INFO, "Check the This is also my billing address checkbox");
        gnc.shippingPage.select2DayExpressShipping();
        extentTest.log(LogStatus.INFO, "Select 2 Day Express Shipping");
        gnc.shippingPage.goToBillingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Billing page");
        gnc.billingPage.fillCardName(CARDNAME_MASTERCARD);
        extentTest.log(LogStatus.INFO, "Fill in the Card Number field");
        gnc.billingPage.fillCardNumber(CARDNUMBER_MASTERCARD);
        extentTest.log(LogStatus.INFO, "Fill in the Card Number field");
        gnc.billingPage.selectMonth(MONTH);
        extentTest.log(LogStatus.INFO, "Select month from the drop down field");
        gnc.billingPage.selectYear(YEAR);
        extentTest.log(LogStatus.INFO, "Select year from the drop down field");
        gnc.billingPage.fillSecurityCode(MASTERCARD_CVV);
        extentTest.log(LogStatus.INFO, "Fill in the CVV field with correct data");
        gnc.billingPage.goToReviewPage();
        extentTest.log(LogStatus.INFO, "Switching to the Review page");
        gnc.reviewPage.goToOrderReceiptPage();
        extentTest.log(LogStatus.INFO, "Switching to the Order Receipt page");
        Assert.assertTrue(gnc.orderReceiptPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        extentTest.log(LogStatus.INFO, "The order has been created successfully");
        gnc.header.goToHomePage();
        extentTest.log(LogStatus.INFO, "Switching to Home page");

    }


    @Test
    public void guestCheckout_Overnight_AmericanExpress() {
        extentTest = extentReports
                .startTest("guestCheckout_Overnight_AmericanExpress")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open SiteGenesis Home Page");
        gnc.header.goToCLP();
        extentTest.log(LogStatus.INFO, "Switch to CLP");
        gnc.categoryLandingPage.goToStandardPDP();
        extentTest.log(LogStatus.INFO, "Switch to Standard PDP");
        gnc.standardPDP.addProductToCart();
        extentTest.log(LogStatus.INFO, "Add product to the mini cart");
        gnc.header.goToShoppingCartPage();
        extentTest.log(LogStatus.INFO, "Switching to the Shopping cart");
        gnc.shoppingCartPage.goToLoginCheckoutPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Checkout page");
        gnc.checkoutLoginPage.goToGuestShippingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Shipping page");
        gnc.shippingPage.fillEmailAddressField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email field on the Shipping page");
        gnc.shippingPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the  First Name field on the Shipping page");
        gnc.shippingPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field on the Shipping page");
        gnc.shippingPage.fillAddressLine_1_Field(ADDRESS_1);
        extentTest.log(LogStatus.INFO, "Fill in the address field #1");
        gnc.shippingPage.fillAddressLine_2_Field("");
        extentTest.log(LogStatus.INFO, "Leave the address field #2 empty");
        gnc.shippingPage.fillCityField(CITY);
        extentTest.log(LogStatus.INFO, "Fill in the city field");
        gnc.shippingPage.fillZipField(ZIP);
        extentTest.log(LogStatus.INFO, "Fill in the zip field");
        gnc.shippingPage.selectState(STATE);
        extentTest.log(LogStatus.INFO, "Select state from the drop down field");
        gnc.shippingPage.fillPhoneField(PHONE);
        extentTest.log(LogStatus.INFO, "Fill in the phone field");
        gnc.shippingPage.selectUseThisAddressForBillingCheckbox();
        extentTest.log(LogStatus.INFO, "Check the This is also my billing address checkbox");
        gnc.shippingPage.selectOvernightShipping();
        extentTest.log(LogStatus.INFO, "Select Overnight Shipping");
        gnc.shippingPage.goToBillingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Billing page");
        gnc.billingPage.fillCardName(CARDNAME_AMEX);
        extentTest.log(LogStatus.INFO, "Fill in the Card Name field");
        gnc.billingPage.fillCardNumber(CARDNUMBER_AMEX);
        extentTest.log(LogStatus.INFO, "Fill in the Card Number field");
        gnc.billingPage.selectMonth(MONTH);
        extentTest.log(LogStatus.INFO, "Select month from the drop down field");
        gnc.billingPage.selectYear(YEAR);
        extentTest.log(LogStatus.INFO, "Select year from the drop down field");
        gnc.billingPage.fillSecurityCode(AMEX_CVV);
        extentTest.log(LogStatus.INFO, "Fill in the CVV field with correct data");
        gnc.billingPage.goToReviewPage();
        extentTest.log(LogStatus.INFO, "Switching to the Review page");
        gnc.reviewPage.goToOrderReceiptPage();
        extentTest.log(LogStatus.INFO, "Switching to the Order Receipt page");
        Assert.assertTrue(gnc.orderReceiptPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        extentTest.log(LogStatus.INFO, "The order has been created successfully");
        gnc.header.goToHomePage();
        extentTest.log(LogStatus.INFO, "Switching to Home page");

    }

    @Test
    public void guestCheckout_2DayExpress_Discover() {
        extentTest = extentReports
                .startTest("guestCheckout_2DayExpress_Discover")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open SiteGenesis Home Page");
        gnc.header.goToCLP();
        extentTest.log(LogStatus.INFO, "Switch to CLP");
        gnc.categoryLandingPage.goToStandardPDP();
        extentTest.log(LogStatus.INFO, "Switch to Standard PDP");
        gnc.standardPDP.addProductToCart();
        extentTest.log(LogStatus.INFO, "Add product to the mini cart");
        gnc.header.goToShoppingCartPage();
        extentTest.log(LogStatus.INFO, "Switching to the Shopping cart");
        gnc.shoppingCartPage.goToLoginCheckoutPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Checkout page");
        gnc.checkoutLoginPage.goToGuestShippingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Guest Shipping page");
        gnc.shippingPage.fillEmailAddressField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email field on the Shipping page");
        gnc.shippingPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the  First Name field on the Shipping page");
        gnc.shippingPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field on the Shipping page");
        gnc.shippingPage.fillAddressLine_1_Field(ADDRESS_1);
        extentTest.log(LogStatus.INFO, "Fill in the address field #1");
        gnc.shippingPage.fillAddressLine_2_Field("");
        extentTest.log(LogStatus.INFO, "Leave the address field #2 empty");
        gnc.shippingPage.fillCityField(CITY);
        extentTest.log(LogStatus.INFO, "Fill in the city field");
        gnc.shippingPage.fillZipField(ZIP);
        extentTest.log(LogStatus.INFO, "Fill in the zip field");
        gnc.shippingPage.selectState(STATE);
        extentTest.log(LogStatus.INFO, "Select state from the drop down field");
        gnc.shippingPage.fillPhoneField(PHONE);
        extentTest.log(LogStatus.INFO, "Fill in the phone field");
        gnc.shippingPage.selectUseThisAddressForBillingCheckbox();
        extentTest.log(LogStatus.INFO, "Check the This is also my billing address checkbox");
        gnc.shippingPage.select2DayExpressShipping();
        extentTest.log(LogStatus.INFO, "Select 2 Day Express Shipping");
        gnc.shippingPage.goToBillingPage();
        extentTest.log(LogStatus.INFO, "Switching to the Billing page");
        gnc.billingPage.fillCardName(CARDNAME_DISCOVER);
        extentTest.log(LogStatus.INFO, "Fill in the Card Name field");
        gnc.billingPage.fillCardNumber(CARDNUMBER_DISCOVER);
        extentTest.log(LogStatus.INFO, "Fill in the Card Number field");
        gnc.billingPage.selectMonth(MONTH);
        extentTest.log(LogStatus.INFO, "Select month from the drop down field");
        gnc.billingPage.selectYear(YEAR);
        extentTest.log(LogStatus.INFO, "Select year from the drop down field");
        gnc.billingPage.fillSecurityCode(DISCOVER_CVV);
        extentTest.log(LogStatus.INFO, "Fill in the CVV field with correct data");
        gnc.billingPage.goToReviewPage();
        extentTest.log(LogStatus.INFO, "Switching to the Review page");
        gnc.reviewPage.goToOrderReceiptPage();
        extentTest.log(LogStatus.INFO, "Switching to the Order Receipt page");
        Assert.assertTrue(gnc.orderReceiptPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        extentTest.log(LogStatus.INFO, "The order has been created successfully");
        gnc.header.goToHomePage();
        extentTest.log(LogStatus.INFO, "Switching to Home page");

    }

}
