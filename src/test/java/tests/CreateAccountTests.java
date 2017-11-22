package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Rus on 27.11.2016.
 */
public class CreateAccountTests extends Fixture {


    @Test
    public void createAccountWithValidData() {
        extentTest = extentReports
                .startTest("createAccountWithValidData")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open Site Genesis Home Page");
        gnc.header.goToCreateAccountPage();
        extentTest.log(LogStatus.INFO, "Switching to Create Account page");
        gnc.createAccountPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the First Name field");
        gnc.createAccountPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field");
        gnc.createAccountPage.fillEmailAndConfirmEmailFields(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email and Confirm Email fields");
        gnc.createAccountPage.fillPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Password field");
        gnc.createAccountPage.fillConfirmPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Confirm Password field");
        gnc.createAccountPage.fillAddress_1_Field(ADDRESS_1);
        extentTest.log(LogStatus.INFO, "Fill in the address field #1");
        gnc.createAccountPage.fillCityField(CITY);
        extentTest.log(LogStatus.INFO, "Fill in the city field");
        gnc.createAccountPage.selectState(STATE);
        extentTest.log(LogStatus.INFO, "Select state from the drop down field");
        gnc.createAccountPage.fillZipField(ZIP);
        extentTest.log(LogStatus.INFO, "Fill in the zip field");
        gnc.createAccountPage.fillPhoneField(PHONE);
        extentTest.log(LogStatus.INFO, "Fill in the phone field");
        gnc.createAccountPage.selectBirthdayMonth(BIRTHDAY_MONTH);
        extentTest.log(LogStatus.INFO, "Select a month from the drop down field");
        gnc.createAccountPage.selectBirthDay(DAY);
        extentTest.log(LogStatus.INFO, "Select a day from the drop down field");
        gnc.createAccountPage.selectBirthdayYear(BIRTHDAY_YEAR);
        extentTest.log(LogStatus.INFO, "Select a year from the drop down field");
        gnc.createAccountPage.selectGander(GENDER);
        extentTest.log(LogStatus.INFO, "Select gender from the drop down field");
        gnc.createAccountPage.clickSaveButton();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        Assert.assertTrue(gnc.myAccountPage.isLogoutButtonAvailable(), "New account is not created");
        extentTest.log(LogStatus.INFO, "A new Account has been created successfully");
        gnc.header.logout();
        extentTest.log(LogStatus.INFO, "Log out");

    }

    @Test
    public void createAccountFormValidation_EmptyFields() {
        extentTest = extentReports
                .startTest("createAccountFormValidation_EmptyFields")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open Site Genesis Home Page");
        gnc.header.goToCreateAccountPage();
        extentTest.log(LogStatus.INFO, "Switching to Create Account page");
        gnc.createAccountPage.clickSaveButton();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        gnc.createAccountPage.assertValidationForAllEmptyFields();
        extentTest.log(LogStatus.INFO, "Error message is displayed under each empty field");
        gnc.createAccountPage.deleteAllCookies();
    }


    @Test
    public void createAccountFormValidation_Re_RegisterTheSameUser() {
        extentTest = extentReports
                .startTest("createAccountFormValidation_Re_RegisterTheSameUser")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open Site Genesis Home Page");
        gnc.header.goToCreateAccountPage();
        extentTest.log(LogStatus.INFO, "Switching to Create Account page");
        gnc.createAccountPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the First Name field");
        gnc.createAccountPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field");
        gnc.createAccountPage.fillEmailField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the existing email in the Email field");
        gnc.createAccountPage.fillConfirmEmailField(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the existing email in the Confirm Email field");
        gnc.createAccountPage.fillPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Password field with valid data");
        gnc.createAccountPage.fillConfirmPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Confirm password field with valid data");
        gnc.createAccountPage.clickSaveButton();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        gnc.createAccountPage.assertFormValidation_Re_registerTheSameUser();
        extentTest.log(LogStatus.INFO, "Username already taken message is displayed correctly");
        gnc.createAccountPage.deleteAllCookies();
    }

    @Test
    public void createAccountFormValidation_With_DifferentEmail_In_Email_And_ConfirmEmail_Fields() {
        extentTest = extentReports
                .startTest("createAccountFormValidation_With_DifferentEmail_In_Email_And_ConfirmEmail_Fields")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open Site Genesis Home Page");
        gnc.header.goToCreateAccountPage();
        extentTest.log(LogStatus.INFO, "Switching to Create Account page");
        gnc.createAccountPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the First Name field");
        gnc.createAccountPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field");
        gnc.createAccountPage.fillEmailField(PAYPAL_EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email field with valid data");
        gnc.createAccountPage.fillConfirmEmailField(EMAILFORREGISTEREDUSER);
        extentTest.log(LogStatus.INFO, "Enter a password that differs from the password entered in the Email field");
        gnc.createAccountPage.fillPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Password field with valid data");
        gnc.createAccountPage.fillConfirmPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Confirm password field with valid data");
        gnc.createAccountPage.clickSaveButton();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        gnc.createAccountPage.assertFormValidation_with_DifferentEmail_in_Email__and_ConfirmEmail_Fields();
        extentTest.log(LogStatus.INFO, "Mismatching passwords message is displayed correctly");
        gnc.createAccountPage.deleteAllCookies();

    }

    @Test
    public void createAccountFormValidation_With_DifferentPassword_And_ConfirmPassword() {
        extentTest = extentReports
                .startTest("createAccountFormValidation_With_DifferentPassword_And_ConfirmPassword")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open Site Genesis Home Page");
        gnc.header.goToCreateAccountPage();
        extentTest.log(LogStatus.INFO, "Switching to Create Account page");
        gnc.createAccountPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the First Name field");
        gnc.createAccountPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field");
        gnc.createAccountPage.fillEmailAndConfirmEmailFields(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email and Confirm Email fields");
        gnc.createAccountPage.fillPasswordField(PASSWORD);
        extentTest.log(LogStatus.INFO, "Fill in the Password field with valid data");
        gnc.createAccountPage.fillConfirmPasswordField(INVALID_PASSWORD);
        extentTest.log(LogStatus.INFO, "Enter a password that differs from the password entered in the Email field");
        gnc.createAccountPage.clickSaveButton();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        gnc.createAccountPage.assertFormValidation_with_DifferentPassword_And_ConfirmPassword();
        extentTest.log(LogStatus.INFO, "Mismatching passwords message is displayed correctly");
        gnc.createAccountPage.deleteAllCookies();
    }

    @Test
    public void createAccountFormValidation_PasswordLength() {
        extentTest = extentReports
                .startTest("createAccountFormValidation_PasswordLength")
                .assignCategory("Smoke Testing");
        gnc.homePage.openPage(SITE_URL);
        extentTest.log(LogStatus.INFO, "Open Site Genesis Home Page");
        gnc.header.goToCreateAccountPage();
        extentTest.log(LogStatus.INFO, "Switching to Create Account page");
        gnc.createAccountPage.fillFirstNameField(FIRSTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the First Name field");
        gnc.createAccountPage.fillLastNameField(LASTNAME);
        extentTest.log(LogStatus.INFO, "Fill in the Last Name field");
        gnc.createAccountPage.fillEmailAndConfirmEmailFields(EMAIL);
        extentTest.log(LogStatus.INFO, "Fill in the Email and Confirm Email fields");
        gnc.createAccountPage.fillPasswordField(INVALID_PASSWORD_LENGTH);
        extentTest.log(LogStatus.INFO, "Enter an invalid password length in the Password field");
        gnc.createAccountPage.fillConfirmPasswordField(INVALID_PASSWORD_LENGTH);
        extentTest.log(LogStatus.INFO, "Enter an invalid password length in the Confirm Password field");
        gnc.createAccountPage.clickSaveButton();
        extentTest.log(LogStatus.INFO, "Click on the Apply button");
        gnc.createAccountPage.assertFormValidation_with_IncorrectPasswordLength();
        extentTest.log(LogStatus.INFO, "Error message for incorrect Password length is displayed correctly");
        gnc.createAccountPage.deleteAllCookies();
    }
}
