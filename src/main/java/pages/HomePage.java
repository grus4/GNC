package pages;

import utils.PropertyLoader;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 24.11.2016.
 */
public class HomePage extends Page {

    public HomePage(WebDriverWrapper dr) {
        super(dr);
    }

    public void openLoginPage(){
        webDriverWrapper.get(PropertyLoader.loadProperty("LoginPage"));
    }

    public void refreshPage() {
        web.refreshPage();
        sleep(5000);
    }


}
