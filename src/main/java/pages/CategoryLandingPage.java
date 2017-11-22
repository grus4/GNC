package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 16.01.2017.
 */
public class CategoryLandingPage extends Page{

    public CategoryLandingPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void goToStandardPDP() {
        web.clickOnElement("FirstProductInGrid");
        web.waitForElementIsVisible("AddToCartButton");
        web.waitForElementIsClickable("AddToCartButton");

        if(web.isElementVisibleAndClickable("AddToCartButton")
                && web.isElementAvailable("AddToCartButton")){
            log.info("Switching to PDP was correct");
        } else {
            log.info("Switching to PDP was INCORRECT!");
            Assert.fail("Switching to PDP was INCORRECT!");
        }
    }

    public void switchToVariationPDP() {
        web.clickOnElement("SecondProductInGrid");
        web.waitForElementIsVisible("SizeSwatch");
        web.waitForElementIsClickable("SizeSwatch");

        if( web.isElementAvailable("SizeSwatch")
                && web.isElementAvailable("SizeSwatch")){
            log.info("Switching to PDP was correct");
        } else {
            log.info("Switching to PDP was INCORRECT!");
            Assert.fail("Switching to PDP was INCORRECT!");
        }
    }
}
