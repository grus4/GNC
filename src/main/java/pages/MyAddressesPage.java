package pages;

import org.testng.Assert;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

public class MyAddressesPage extends Page {
    public MyAddressesPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void goToAddNewAddressForm() {
        web.clickOnElement("CreateNewAddressButton");
        web.waitForElementIsVisible("AddressNameField", 30);
        web.waitForElementIsClickable("AddressNameField", 30);

        if (web.isElementVisibleAndClickable("AddressNameField")) {
            log.info("Add a new Address form was opened correctly");
        } else {
            log.info("Add a new Address form wasn't opened correctly!\n");
            Assert.fail("Add a new Address form wasn't opened correctly!");
        }
    }

    public void fillAddressNameField(String addressName) {
        web.input("AddressNameField", addressName);
    }

    public void fillFirstNameField(String firstname) {
        web.input("FirstNameFieldOnCreateAddressForm", firstname);
    }

    public void fillLastNameField(String lastname) {
        web.input("LastNameFieldOnCreateAddressForm", lastname);
    }

    public void fillAddress_1_Field(String address1) {
        web.input("AddressField_1_OnCreateAddressForm", address1);
    }

    public void fillCityField(String city) {
        web.input("CityFieldOnCreateAddressForm", city);
    }

    public void selectStateFromDropDownField(String state) {
        web.selectFromDropDownListByVisibleText("StateDropDownFieldOnCreateAddressForm", state);
    }

    public void fillZipField(String zip) {
        web.input("ZipFieldOnCreateAddressForm", zip);
    }

    public void fillPhoneField(String phone) {
        web.input("PhoneFieldOnCreateAddressForm", phone);
    }

    public void saveNewAddress() {
        web.clickOnElement("ApplyButtonOnCreateAddressForm");
        web.waitForElementIsVisible("EditAddressLink", 10);
        web.waitForElementIsVisible("DeleteLink", 10);
    }

    public void  assertAddedAddress() {
        if(web.getElementText("AddressTitle").equals(PropertyLoader.loadProperty("address.name"))&&
                web.getElementText("FirstNameLastName").equals(PropertyLoader.loadProperty("first.name") + " " + PropertyLoader.loadProperty("last.name"))
           ){
            log.info("The new address was saved correctly.");
        } else {
            log.info("The new address was saved incorrectly!\n");
            log.info("Address Title: " + web.getElementText("AddressTitle") + "\n" +
            "First  Name and Last Name: " + web.getElementText("FirstNameLastName") + "\n" +
            "Address: " + web.getElementText("Address"));
            Assert.fail("The new address was saved incorrectly!\n" + "Address Title: " + web.getElementText("AddressTitle") + "\n" +
                    "First  Name and Last Name: " + web.getElementText("FirstNameLastName") + "\n" +
                    "Address: " + web.getElementText("Address"));
        }
    }

    public void deleteAddress() {
        web.clickEachRemoveLink("DeleteLink");
    }

    /*public boolean isAddressDeleted() {
        web.isElementVisibleAndClickable("")
    }*/
}
