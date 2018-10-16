package util;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Configuration instance = new Configuration();

    private Properties configProps = new Properties();

    private String appUrl;
    private String chromedriverPath;

    public static Configuration getInstance() {
        return instance;
    }

    private Configuration() {

        try (InputStream is = ClassLoader.getSystemResourceAsStream("config.properties")) {
            configProps.load(is);

            this.appUrl = configProps.getProperty("app.url");
            this.chromedriverPath = configProps.getProperty("chromedriver.path");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppUrl() {

        return appUrl;
    }

    public String getChromedriverPath() {
        return chromedriverPath;
    }

    public boolean isBrowserVisible(){
        String isVisible = configProps.getProperty("browser.visible","false");
        return Boolean.valueOf(isVisible);
    }
}
