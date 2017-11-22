package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 18.01.2017.
 */
public class ReviewPage extends Page {

    public ReviewPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void goToOrderReceiptPage() {
        web.clickButton("PlaceOrderButton");

        if(web.isElementVisibleAndClickable("ThankYouMessage")
                && web.isElementAvailable("ThankYouMessage")) {
            log.info("Switching to Order Receipt page was correct");
        } else {
            log.error("Switching to Order Receipt page was INCORRECT!\n");
            Assert.fail("Switching to Order Receipt page was INCORRECT!");
        }
    }
}
