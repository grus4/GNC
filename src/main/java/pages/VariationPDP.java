package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 18.01.2017.
 */
public class VariationPDP extends Page {
    public VariationPDP(WebDriverWrapper dr) {
        super(dr);
    }

    public void addVariationProductToCart() {
        web.clickOnElement("SizeSwatch");
        web.waitForElementIsClickable("AddToCartButton");
        web.clickButton("AddToCartButton");
        web.waitForElementIsVisible("ViewCart");
        web.waitForElementIsClickable("ViewCart");

        if(web.isElementVisibleAndClickable("ViewCart")){
            log.info("The product has been successfully added to the cart");
        } else {
            log.error("The product has been INCORRECTLY ADDED TO THE CART!");
            Assert.fail("The product has been INCORRECTLY ADDED TO THE CART!");
        }
    }
}
