package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 27.11.2016.
 */
public class CreateAccountPage extends Page{

    public CreateAccountPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void fillFirstNameField(String firstName) {
        web.input("FirstName", firstName);
    }

    public void fillLastNameField(String lastName) {
        web.input("LastName", lastName);
    }

    public void fillEmailAndConfirmEmailFields(String email) {
        String newEmail = web.generateRandomEmail(email);
        web.input("EmailField", newEmail);
        web.input("ConfirmEmailField", newEmail);
    }

    public void fillPasswordField(String password) {
        web.input("Password", password);
    }

    public void fillConfirmPasswordField(String password) {
        web.input("ConfirmPassword", password);
    }

    public void clickSaveButton() {
        web.clickButton("SaveButton");
        web.waitForElementIsVisible("MyAccountIcon");
        web.waitForElementIsClickable("MyAccountIcon");
        web.clickButton("MyAccountIcon");


        web.waitForElementIsVisible("LogoutLinkInMyAccount");
        web.waitForElementIsClickable("LogoutLinkInMyAccount");

        if (web.isElementVisibleAndClickable("LogoutLinkInMyAccount")
                && web.isElementVisibleAndClickable("LogoutLinkInMyAccount")) {
            log.info("Switching to My Account was correct");
        } else {
            log.error("Switching to My Account was INCORRECT!\n");
            Assert.fail("Switching to My Account was INCORRECT!\n");
        }
    }

    public void assertValidationForAllEmptyFields() {
        checkValidationForEmptyFirstNameField();
        checkValidationForEmptyLastNameField();
        checkValidationForEmptyEmailField();
        checkValidationForEmptyConfirmEmailField();
        checkValidationForEmptyPasswordField();
        checkValidationForEmptyConfirmPasswordField();

    }

    public void checkValidationForEmptyFirstNameField(){
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyFirstNameField")
                && web.getElementText("ErrorMessageForEmptyFirstNameField").equals("This field is required.")){
            log.info("First Name Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("First Name Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is FirstNameErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyFirstNameField") + "\n"
                    + "FirstNameErrorMessage - " + web.getElementText("ErrorMessageForEmptyFirstNameField"));
            Assert.fail("First Name Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is FirstNameErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyFirstNameField") + "\n"
                    + "FirstNameErrorMessage - " + web.getElementText("ErrorMessageForEmptyFirstNameField"));

        }
    }

    public void checkValidationForEmptyLastNameField(){
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyLastNameField")
                && web.getElementText("ErrorMessageForEmptyLastNameField").equals("This field is required.")){
            log.info("Last Name Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Last Name Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is LastNameErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyLastNameField") + "\n"
                    + "LastNameErrorMessage - " + web.getElementText("ErrorMessageForEmptyLastNameField"));
            Assert.fail("Last Name Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is LastNameErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyLastNameField") + "\n"
                    + "LastNameErrorMessage - " + web.getElementText("ErrorMessageForEmptyLastNameField"));

        }
    }

    public void checkValidationForEmptyEmailField(){
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyEmail")
                && web.getElementText("ErrorMessageForEmptyEmail").equals("This field is required.")){
            log.info("Email Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Email Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is EmailNameErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyEmail") + "\n"
                    + "EmailNameErrorMessage - " + web.getElementText("ErrorMessageForEmptyEmail"));
            Assert.fail("Email Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is EmailNameErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyEmail") + "\n"
                    + "EmailNameErrorMessage - " + web.getElementText("ErrorMessageForEmptyEmail"));

        }
    }

    public void checkValidationForEmptyConfirmEmailField(){
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyConfirmEmail")
                && web.getElementText("ErrorMessageForEmptyConfirmEmail").equals("This field is required.")){
            log.info("Confirm Email Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Confirm Email Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is ConfirmEmailErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyConfirmEmail") + "\n"
                    + "ConfirmEmailErrorMessage - " + web.getElementText("ErrorMessageForEmptyConfirmEmail"));
            Assert.fail("Confirm Email Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is ConfirmEmailErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyConfirmEmail") + "\n"
                    + "ConfirmEmailErrorMessage - " + web.getElementText("ErrorMessageForEmptyConfirmEmail"));

        }
    }

    public void checkValidationForEmptyPasswordField(){
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyPassword")
                && web.getElementText("ErrorMessageForEmptyPassword").equals("This field is required.")){
            log.info("Password Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Password Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is PasswordErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyPassword") + "\n"
                    + "PasswordErrorMessage - " + web.getElementText("ErrorMessageForEmptyPassword"));
            Assert.fail("Password Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is PasswordErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyPassword") + "\n"
                    + "PasswordErrorMessage - " + web.getElementText("ErrorMessageForEmptyPassword"));

        }
    }

    public void checkValidationForEmptyConfirmPasswordField(){
        if(web.isElementVisibleAndClickable("ErrorMessageForEmptyConfirmPassword")
                && web.getElementText("ErrorMessageForEmptyConfirmPassword").equals("This field is required.")){
            log.info("Confirm Password Error Message for empty field is displayed correctly under the field");
        } else {
            log.error("Confirm Password Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is ConfirmPasswordErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyConfirmPassword") + "\n"
                    + "ConfirmPasswordErrorMessage - " + web.getElementText("ErrorMessageForEmptyConfirmPassword"));
            Assert.fail("Confirm Password Error Message for empty field is displayed INCORRECTLY!" + "\n"
                    + "is ConfirmPasswordErrorMessage present - " + web.isElementVisibleAndClickable("ErrorMessageForEmptyConfirmPassword") + "\n"
                    + "ConfirmPasswordErrorMessage - " + web.getElementText("ErrorMessageForEmptyConfirmPassword"));

        }
    }


    public void fillEmailField(String email) {
        web.input("EmailField", email);
    }

    public void fillConfirmEmailField(String confirmEmail) {
        web.input("ConfirmEmailField", confirmEmail);
    }

    public void assertFormValidation_Re_registerTheSameUser() {
        if(web.isElementVisibleAndClickable("ErrorMessageForTakenUserName")
                && web.getElementText("ErrorMessageForTakenUserName").equals("Username already taken.")) {
            log.info("Username already taken message is displayed correctly");
        } else  {
            log.error("Username already taken message is displayed INCORRECTLY!" + "\n"
            + "is ErrorMessageForTakenUserName present - " + web.isElementVisibleAndClickable("ErrorMessageForTakenUserName") + "\n"
            + "ErrorMessageForTakenUserName - " + web.getElementText("ErrorMessageForTakenUserName"));
            Assert.fail("Username already taken message is displayed INCORRECTLY!" + "\n"
                    + "is ErrorMessageForTakenUserName present - " + web.isElementVisibleAndClickable("ErrorMessageForTakenUserName") + "\n"
                    + "ErrorMessageForTakenUserName - " + web.getElementText("ErrorMessageForTakenUserName"));
        }
    }

    public void assertFormValidation_with_DifferentEmail_in_Email__and_ConfirmEmail_Fields() {
        if(web.isElementVisibleAndClickable("ErrorMessageMismatchingEmails")
                && web.getElementText("ErrorMessageMismatchingEmails").equals("Please enter the same value again.")){
            log.info("Error Message for Mismatching emails is displayed correctly");
        } else {
            log.error("Error Message for Mismatching emails is displayed INCORRECTLY!" + "\n"
            + "is Error Message for Mismatching emails present - " + web.isElementVisibleAndClickable("ErrorMessageMismatchingEmails") + "\n"
            + "Error Message for Mismatching emails - " + web.getElementText("ErrorMessageMismatchingEmails"));
            Assert.fail("Error Message for Mismatching emails is displayed INCORRECTLY!" + "\n"
                    + "is Error Message for Mismatching emails present - " + web.isElementVisibleAndClickable("ErrorMessageMismatchingEmails") + "\n"
                    + "Error Message for Mismatching emails - " + web.getElementText("ErrorMessageMismatchingEmails"));
        }

    }

    public void assertFormValidation_with_DifferentPassword_And_ConfirmPassword() {
        if(web.isElementVisibleAndClickable("ErrorMessageMismatchingPasswordAndConfirmPassword")
                && web.getElementText("ErrorMessageMismatchingPasswordAndConfirmPassword").equals("Does not match password")){
            log.info("Error message for mismatching passwords in the Password and Confirm Password fields is displayed");
        } else {
            log.error("Error message for mismatching passwords in the Password and Confirm Password fields is displayed INCORRECTLY!" + "\n"
            + "is Error message for mismatching passwords present - " + web.isElementVisibleAndClickable("ErrorMessageMismatchingPasswordAndConfirmPassword") + "\n"
            + "Error message for mismatching passwords - " + web.getElementText("ErrorMessageMismatchingPasswordAndConfirmPassword"));
            Assert.fail("Error message for mismatching passwords in the Password and Confirm Password fields is displayed INCORRECTLY!" + "\n"
                    + "is Error message for mismatching passwords present - " + web.isElementVisibleAndClickable("ErrorMessageMismatchingPasswordAndConfirmPassword") + "\n"
                    + "Error message for mismatching passwords - " + web.getElementText("ErrorMessageMismatchingPasswordAndConfirmPassword"));
        }
    }

    public void assertFormValidation_with_IncorrectPasswordLength() {
        if(web.isElementVisibleAndClickable("ErrorMessageForIncorrectPasswordLength")
                && web.getElementText("ErrorMessageForIncorrectPasswordLength").equals("8 - 255 characters")){
            log.info("Error message for incorrect Password length is displayed");
        } else {
            log.error("Error message for incorrect Password length is displayed INCORRECTLY!" + "\n"
            + "is Error message for incorrect Password length present - " + web.isElementVisibleAndClickable("ErrorMessageForIncorrectPasswordLength") + "\n"
            + "Error message for incorrect Password length - " + web.getElementText("ErrorMessageForIncorrectPasswordLength"));
            Assert.fail("Error message for incorrect Password length is displayed INCORRECTLY!" + "\n"
                    + "is Error message for incorrect Password length present - " + web.isElementVisibleAndClickable("ErrorMessageForIncorrectPasswordLength") + "\n"
                    + "Error message for incorrect Password length - " + web.getElementText("ErrorMessageForIncorrectPasswordLength"));
        }
    }

    public void fillAddress_1_Field(String address1) {
        web.input("Address_1_Field_on_Create_Account_Page", address1);
    }

    public void fillCityField(String city) {
        web.input("CityField_on_Create_Account_Page", city);
    }

    public void selectState(String state) {
        web.selectFromDropDownListByVisibleText("StateDropDownField_Create_Account_Page", state);
    }

    public void fillZipField(String zip) {
        web.input("ZipFIeld_on_Create_Account_Page", zip);
    }

    public void fillPhoneField(String phone) {
        web.input("PhoneField_on_Create_Account_Page", phone);
    }

    public void selectBirthdayMonth(String month) {
        web.selectFromDropDownListByVisibleText("BirthdayMonthDropDownField_on_Create_Account_Page", month);
    }

    public void selectBirthDay(String day) {
        web.selectFromDropDownListByVisibleText("BirthdayDayDropDownField_on_Create_Account_Page", day);
    }

    public void selectBirthdayYear(String birthdayYear) {
        web.selectFromDropDownListByVisibleText("BirthdayYearDropDownField_on_Create_Account_Page", birthdayYear);
    }

    public void selectGander(String gender) {
        web.selectFromDropDownListByVisibleText("GenderDropDownField_on_Create_Account_Page", gender);
    }
}
