package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Configuration;

import java.util.concurrent.TimeUnit;

public class BeforeAndAfterSteps {

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BeforeAndAfterSteps.driver = driver;
    }

    private static WebDriver driver;
    private static Configuration config = Configuration.getInstance();
    private static final int DEFAULT_WAIT = 10;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", config.getChromedriverPath());

        ChromeOptions options = new ChromeOptions();
        if(!config.isBrowserVisible()) {
            options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        }

        setDriver(new ChromeDriver(options));
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
