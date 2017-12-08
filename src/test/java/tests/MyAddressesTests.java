package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAddressesTests extends Fixture {

    @Test
    public void addNewAddress() {
        extentTest = extentReports
                .startTest("Add a new address on the Addresses Page")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open SiteGenesis Home Page");
        gnc.header.goToLoginPage();
        extentTest.log(LogStatus.INFO, "Switching to Login page");
        gnc.loginPage.fillEmailField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill Email field");
        gnc.loginPage.fillPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill Password Field");
        gnc.loginPage.goToMyAccount();
        extentTest.log(LogStatus.INFO, "Switch to My Account page");
        gnc.myAccountPage.goToMyAddressesPage();
        extentTest.log(LogStatus.INFO, "Switch to My Addresses page");
        gnc.myAddressesPage.goToAddNewAddressForm();
        extentTest.log(LogStatus.INFO, "Switch to Add a New Address form");
        gnc.myAddressesPage.fillAddressNameField(ADDRESS_NAME);
        extentTest.log(LogStatus.INFO, "Fill the Address Name field");
        gnc.myAddressesPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill the First Name field");
        gnc.myAddressesPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill the Last Name field");
        gnc.myAddressesPage.fillAddress_1_Field(ADDRESS_1);
        extentTest.log(LogStatus.INFO, "Fill the Address 1 field");
        gnc.myAddressesPage.fillCityField(CITY);
        extentTest.log(LogStatus.INFO, "Fill the City field");
        gnc.myAddressesPage.selectStateFromDropDownField(STATE);
        extentTest.log(LogStatus.INFO, "Select the State from the drop down field");
        gnc.myAddressesPage.fillZipField(ZIP);
        extentTest.log(LogStatus.INFO, "Fill the Zip field");
        gnc.myAddressesPage.fillPhoneField(PHONE);
        extentTest.log(LogStatus.INFO, "Fill the Phone field");
        gnc.myAddressesPage.saveNewAddress();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        gnc.myAddressesPage.assertAddedAddress();
        extentTest.log(LogStatus.INFO, "The new address was saved correctly.");
        gnc.myAddressesPage.deleteAddress();
        extentTest.log(LogStatus.INFO, "Delete address from Ny Addresses page");
        //Assert.assertTrue(gnc.myAddressesPage.isAddressDeleted, "The address wasn't deleted from the My Addresses page");
    }
}
