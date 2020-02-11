package com.standard.factory;


import com.standard.constant.ConstantsPropertiesFile;
import com.standard.pages.marca.Marca;
import com.standard.utils.ReadConfigFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";


    public static WebDriver driver;
    public static Marca marca;

    public WebDriver getDriver() {
        try {
            // Read Config
            ReadConfigFile file = new ReadConfigFile();
            String browserName = file.getBrowser();

            switch (browserName) {

                case FIREFOX:
                    System.setProperty(WEBDRIVER_GECKO_DRIVER, ConstantsPropertiesFile.GECKO_DRIVER_DIRECTORY);
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                    break;

                case CHROME:
                    System.setProperty(WEBDRIVER_CHROME_DRIVER, ConstantsPropertiesFile.CHROME_DRIVER_DIRECTORY);
                    // CHROME OPTIONS
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unable to load browser: " + e.getMessage());
        } finally {
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            marca = PageFactory.initElements(driver, Marca.class);
        }
        return driver;
    }
}
