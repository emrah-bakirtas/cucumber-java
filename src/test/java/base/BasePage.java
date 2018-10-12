package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Configuration;

import static steps.BeforeAndAfterSteps.getDriver;

public class BasePage {

    protected WebDriver driver;
    protected Configuration config;
    protected WebDriverWait wait;

    public BasePage() {

        this.driver = getDriver();
        this.config = Configuration.getInstance();
        this.wait = new WebDriverWait(getDriver(), 10);
    }

    /**
     * navigate to url
     */
    public void navigateTo() {

        try {

            driver.get(config.getAppUrl());
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    /**
     * Use this method to find element by By
     * @param by
     * @param index
     * @return A WebElement, or an empty if nothing matches
     */
    protected WebElement findElement(By by, int ... index) {

        WebElement element = null;

        try{

            if (index.length == 0) {

                element = driver.findElement(by);
            }

            else {

                element = driver.findElements(by).get(index[0]);
            }
        } catch(Exception e){

            throw new RuntimeException(e);
        }

        return element;
    }

    /**
     * Use this method to find elements by By
     * @param by
     * @return A list of WebElements, or an empty if nothing matches
     */
    protected List<WebElement> findElements(By by){

        List<WebElement> webElements = null;

        try {

            webElements = driver.findElements(by);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return webElements;
    }

    /**
     * Use this method click to element
     * @param by
     * @param index
     */
    protected void clickElement(By by, int ... index) {

        WebElement element;

        untilElementAppear(by);

        try {

            if (index.length == 0) {

                element = findElement(by);
            }

            else {

                element = findElement(by, index[0]);
            }

            element.click();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

    }

    /**
     * Use this method to simulate typing into an element if it is enable.
     * Send enter if pressEnter is true, do nothing otherwise.
     * Note : Before sending operation, element is cleared.
     * @param by
     * @param text
     * @param pressEnter
     */
    protected void fillInputField(By by, String text, boolean pressEnter) {

        untilElementAppear(by);

        WebElement element = findElement(by);

        try {

            if(element.isEnabled()) {

                element.clear();

                element.sendKeys(text);

                if(pressEnter) {

                    element.sendKeys(Keys.ENTER);
                }
            }
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element.
     * @param by
     * @param index
     * @return The innerText of this element.
     */
    protected String getTextOfElement(By by, int ... index){

        String text = null;

        untilElementAppear(by);

        try {

            if (index.length == 0) {

                text = findElement(by).getText();
            }

            else {

                text = findElement(by, index[0]).getText();
            }
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return text;
    }

    /**
     * Wait until element appears
     * @param by
     */
    protected void untilElementAppear(By by) {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    /**
     * Wait until element disappears
     * @param by
     */
    protected void untilElementDisappear(By by) {

        try {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

    }

    /**
     * Return true if element exist, false otherwise.
     * @param by
     * @return True if element exists, false otherwise.
     */
    protected boolean isElementExist(By by){

        boolean isExist = findElements(by).size() > 0;

        return isExist;
    }
}
