package utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;


public class WebElementsActions {

    private WebDriverWrapper webDriverWrapper;
    private static WebDriverWait waitForElement;
    private Random random;

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String EXPLICIT_WAIT = PropertyLoader.loadProperty("selenium.explicit.timeout");

    /**
     *
     * @param driver
     */
    public WebElementsActions(WebDriverWrapper driver) {
        this.webDriverWrapper = driver;
        waitForElement = new WebDriverWait(driver, Long.parseLong(EXPLICIT_WAIT));
        random = new Random();
    }


    /**
     * Method that finds element by locator and clicks on it.
     *
     * @param elementLocator
     *        String descriptive name of the element.
     */
    public void clickOnElement(String elementLocator) {
        isElementVisibleAndClickable(elementLocator);
        webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator)).click();
        log.info("Click on Element : " + elementLocator);
    }

    public void clickElementAndWait(String elementLocator, String expectedElementLocator, int timeOutInS) {
        isElementVisibleAndClickable(elementLocator);
        webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator)).click();
        log.info("Click on Element " + elementLocator);
        WebDriverWait wait = new WebDriverWait(webDriverWrapper , timeOutInS);
        wait.until(ExpectedConditions.elementToBeClickable(UIMappingSingleton.ui(expectedElementLocator)));
        log.info("WaitForElement _" + elementLocator + "_is clickable");

    }
    /**
     * Method that finds button by locator and clicks on it.
     *
     * @param buttonLocator
     *        String descriptive name of the element.
     */
    public void clickButton(String buttonLocator) {
        isElementVisibleAndClickable(buttonLocator);
        webDriverWrapper.findElement(UIMappingSingleton.ui(buttonLocator)).click();
        log.info("Click on Button " + buttonLocator);
    }

    /**
     * Method that finds link by locator and clicks on it.
     *
     * @param linkLocator
     *        String descriptive name of the element.
     */
    public void clickLink(String linkLocator) {
        isElementVisibleAndClickable(linkLocator);
        webDriverWrapper.findElement(UIMappingSingleton.ui(linkLocator)).click();
        log.info("Click on Link " + linkLocator);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData)  {
        isElementVisibleAndClickable(inputLocator);
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * This method is used input value into text input field and Click ENTER for Field which used "Value" in the xpath expression
     *
     * @param inputLocator
     *        String descriptive name of the element
     *
     * @param inputData
     *
     */
    public void inputAndClickEnter(String inputLocator, String inputData) {
        isElementVisibleAndClickable(inputLocator);
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("Input in " + inputLocator + ", value -" + inputData + "and click <Enter> button");
    }


    /**
     * Method is used to check that element is present on page.
     *
     * @param elementLocator
     *        String descriptive name of the element
     *
     * @return Boolean
     */
    public boolean isElementVisibleAndClickable(String elementLocator) {
        List<WebElement> list = webDriverWrapper.findElements(UIMappingSingleton.ui(elementLocator));

        if (list.size() == 0) {
            log.warn("Element _" + elementLocator + "_is NOT Present in DOM!");
            return false;
        }

        if (list.get(0).isDisplayed()&&!list.get(0).isEnabled()) {
            log.info("Element " + elementLocator + " is DISABLED");
            return true;
        }

        if (list.get(0).isDisplayed()) {
            log.info("Element " + elementLocator + " is DISPLAYED");
            return true;
        }
        else {
            log.error("Element " + elementLocator + " is NOT DISPLAYED");
            return false;
        }
    }

    /**
     * Method is used to check that element is present in the DOM.
     *
     * @param elementLocator
     *        String descriptive name of the element
     *
     * @return Boolean
     */
    public boolean isElementAvailable(String elementLocator) {
        if(!webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator)).isEnabled()) {
            log.info("Element is not found");
            return false;
        }
        log.info("Element is available in the DOM");
        return  true;
    }

    /**
     * This method checks the alert presence and accepts agree message on alert window
     *
     * @return Boolean
     *
     */
    public boolean isAlertPresent() {
        boolean alertPresence = false;
        try {
            Alert alert = webDriverWrapper.switchTo().alert();
            alertPresence = true;
            alert.accept();
            log.info("Alert is present");
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            log.info("Alert is not found");
            return alertPresence;
        }
        return alertPresence;
    }

    /**
     * This method is used to get text from pop-up windows
     *
     * @return
     *        Text from the alert
     */
    public String getAlertText() {
        String alertText;
        try {
            Alert alert = webDriverWrapper.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            log.error("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }

    /**
     * This method is used to move to an element(menu) and click on the element(item)
     *
     * @param moveToLocator
     *        String descriptive name of the element
     *
     * @param clickToElement
     *        String descriptive name of the element
     */
    public void moveToElementAndClick(String moveToLocator, String clickToElement) {
        WebElement webElement = webDriverWrapper.findElement(UIMappingSingleton.ui(moveToLocator));
        Actions actions = new Actions(webDriverWrapper.getOriginalDriver());
        actions.moveToElement(webElement);
        actions.perform();  //!!! always need
        clickButton(clickToElement);
        log.info("moved To Element " + moveToLocator + " and clicked on " + clickToElement);
    }

    /**
     *  This method is used to refresh the page
     */
    public void refreshPage() {
        webDriverWrapper.navigate().refresh();
        log.info("Page is refreshed");
    }

    /**
     *  This method is used to refresh the page by pressing combination CTRL+F5 on the keyboard
     */
    public void refreshPage2() {
        Actions actions = new Actions(webDriverWrapper.getOriginalDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
        log.info("Page is refreshed");
    }

    /**
     * This method is used to emulate pressing on the Space key on the keyboard
     *
     * @param inputLocator
     *        String descriptive name of the element
     */
    public void pressSpaceKey(String inputLocator) {

        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.SPACE);
        log.info("input <space> into " + inputLocator + "by pressing the space button on the keypad");
    }

    /**
     * This method is used to emulate pressing on the ENTER key on the keyboard
     *
     * @param inputLocator
     *        String descriptive name of the element
     */
    public void pressEnterKey(String inputLocator) {

        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("input <ENTER> into " + inputLocator + "by pressing the space button on the keypad");
    }

    /**
     * This method is used to emulate pressing on the ESCAPE key on the keyboard
     *
     * @param inputLocator
     *        String descriptive name of the element
     */
    public void pressESCAPEKey(String inputLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ESCAPE);
    }

    /**
     * This method is used to emulate pressing on the PageUp key on the keyboard
     *
     * @param inputLocator
     *        String descriptive name of the element
     */
    public void pressPageUp(String inputLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.PAGE_UP);
    }

    /**
     * This method is used to emulate pressing on the TAB key on the keyboard
     *
     * @param locator
     *        String descriptive name of the element
     */
    public void pressTAB(String locator) {

        WebElement webElement = webDriverWrapper.findElement(UIMappingSingleton.ui((locator)));
        webElement.sendKeys(Keys.TAB);
        log.info(String.format("press TAB"));

    }

    /**
     *  This method is used to click on something and open window in New Tab
     *  Use Actions class
     *
     * @param elementLocator
     *        String descriptive name of the element
     *
     */
    public void clickOnSomethingAndOpenNewTab(String elementLocator) {
        Set<String> oldWindowsSet = webDriverWrapper.getWindowHandles();
        clickButton(elementLocator);
        Set<String> newWindowsSet = webDriverWrapper.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);

        String newWindowHandle = newWindowsSet.iterator().next();
        webDriverWrapper.switchTo().window(newWindowHandle);
    }

    /**
     * This method is used to switch to iframe by name
     *
     * @param iFrameName
     *        String descriptive name of the iFrame element
     *
     */
    public void swithcToIframeByName(String iFrameName){
        webDriverWrapper.switchTo().frame(iFrameName);
        log.info("Switching to iFrame - " + iFrameName + " was correct");
    }

    /**
     *  This method is used to switch to exit the frame
     */
    public void exitFromFrame(){
        webDriverWrapper.switchTo().defaultContent();
    }

    /**
     *  This method is used to scroll the page to the appropriate element
     *
     * @param elementLocator
     *        String descriptive name of the element
     */
    public void scrollPageToElement(String elementLocator) {
        Actions actions = new Actions(webDriverWrapper.getOriginalDriver());
        actions.moveToElement(getElement(elementLocator)).build();
        actions.perform();
        log.info("Scroll to the element - " + elementLocator);
    }

    /**
     * This method is used to wait the text in the element value specified time
     *
     * @param elementLocator
     *        String descriptive name of the element
     * @param text
     *        The innerText of this element.
     */
    public void waitTextPresent(WebElement elementLocator, String text) {
        waitForElement.until(ExpectedConditions.textToBePresentInElement(elementLocator, text));
        log.info("*Start TO* Wait For Element " + elementLocator + " Present");
    }


    public WebElement getElement(String elementLocator) {
        return webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) {
        return webDriverWrapper.findElements(UIMappingSingleton.ui(elementsLocator));
    }


    public String getElementText(String elementsLocator) {
        return webDriverWrapper.findElement(UIMappingSingleton.ui(elementsLocator)).getText();
    }

    /**
     * The method inserts value into text input HTML field without Clean
     *
     * @param inputLocator
     *        String descriptive name of the element
     *
     * @param inputData
     *        String value that fills into the input.
     */
    public void inputWithoutClean(String inputLocator, String inputData)  {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * This method selects value from drop down list by value
     *
     * @param listLocator
     *        String descriptive name of the element(drop-down menu).
     *
     * @param listValue
     *        String value of the item in the drop down list.
     */
    public void selectFromDropDownListByValue(String listLocator, String listValue) {
        new Select(webDriverWrapper.findElement(UIMappingSingleton.ui(listLocator))).selectByValue(listValue);
    }

    /**
     * This method selects value from drop down list by visible text
     *
     * @param listLocator
     *        String descriptive name of the element(drop-down menu).
     *
     * @param visibleTextOfTheItem
     *        String visible text of the item in the drop down list.
     */
    public void selectFromDropDownListByVisibleText(String listLocator, String visibleTextOfTheItem) {
        new Select(webDriverWrapper.findElement(UIMappingSingleton.ui(listLocator))).selectByVisibleText(visibleTextOfTheItem);
    }

    /**
     * Waiting during specified time till the element will be invisible for user.
     *
     * @param elementLocator
     *        String descriptive name of the element.
     *
     * @param timeoutInS
     *        Time for waiting of the element
     */
    public void waitElementNotVisible(String elementLocator, int timeoutInS) {
        WebDriverWait wait = new WebDriverWait(webDriverWrapper, timeoutInS);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * The method is used for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementVisibleAndClickable(By elementLocator); is that it expects the appearance of an element.
     *
     * @param elementLocator
     *        String descriptive name of the element.
     */
    public void waitForElementIsVisible(String elementLocator) {
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
        log.info("WaitForElement _" + elementLocator + "_ Present");
    }

    /**
     *  Waiting during specified time till the element will be clickable for user.
     *
     * @param elementLocator
     *        String descriptive name of the element.
     */
    public void waitForElementIsClickable(String elementLocator) {
        waitForElement.until(ExpectedConditions.elementToBeClickable(UIMappingSingleton.ui(elementLocator)));
        log.info("WaitForElement _" + elementLocator + "_is clickable");
    }

    /**
     * Waiting during specified time till the element will be clickable for user.
     *
     * @param elementLocator
     *        Locator of the element on page, which have type String.
     *
     * @param timeOutInS
     *        int Time(seconds) for waiting of the element.
     */
    public void waitForElementIsClickable(String elementLocator, int timeOutInS) {
        WebDriverWait wait = new WebDriverWait(webDriverWrapper , timeOutInS);
        wait.until(ExpectedConditions.elementToBeClickable(UIMappingSingleton.ui(elementLocator)));
        log.info("WaitForElement _" + elementLocator + "_is clickable");
    }

    /**
     * This method is used to scroll a window down
     *
     * @see {@link JavascriptExecutor} and {@link JavascriptExecutor#executeScript(String, Object...)}
     */
    public void windowScroll() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriverWrapper;
        // Vertical scroll - down by 100  pixels
        javascriptExecutor.executeScript("window.scrollBy(0,100)", "");
    }

    /**
     *  This method is used to select/deselect the checkbox, the second parameter should be "Y" or "N".
     *
     * @param checkboxLocator
     *        String descriptive name of the element.
     *
     * @param isSet
     *        This parameter should be "Y" or "N depends of the select/deselect status of the checkbox.
     */
    public void selectCheckbox(String checkboxLocator, String isSet) {
        if (webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() && isSet.equals("N")) {
            webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
        if (!webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() && isSet.equals("Y")) {
            webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
    }

    /**
     *  The method which generates a random number
     *
     * @return
     *        int random number
     *
     */
    public int getRandom() {
        return (int) (Math.random() * 100000000);
    }

    /**
     *  The method which generates a random email
     *
     * @param inputEmail
     *        The email which was inputted
     * @return
     *        String email
     */
    public String generateRandomEmail(String inputEmail) {
        String newEmail = "Test_" + getRandom() + inputEmail;

        return newEmail;
    }


}
