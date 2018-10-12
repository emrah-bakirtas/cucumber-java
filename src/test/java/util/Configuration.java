package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;

    private Properties configProps = new Properties();

    private String appUrl;
    private String chromedriverPath;

    public static Configuration getInstance() {

        if (instance == null) {

            createInstance();
        }

        return instance;
    }

    private static synchronized void createInstance() {

        if (instance == null) {

            instance = new Configuration();
        }
    }

    private Configuration() {

        InputStream is = null;
        try {

            is = ClassLoader.getSystemResourceAsStream("config.properties");
            configProps.load(is);

            this.appUrl = configProps.getProperty("app.url");
            this.chromedriverPath = configProps.getProperty("chromedriver.path");

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public String getAppUrl() {

        return appUrl;
    }

    public String getChromedriverPath() {
        return chromedriverPath;
    }
}
