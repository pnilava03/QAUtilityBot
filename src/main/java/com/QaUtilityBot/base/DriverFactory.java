package com.QaUtilityBot.base;

import com.QaUtilityBot.exceptions.BrowserNotSupportException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
    private static volatile DriverFactory instance;

    private DriverFactory() {

    }

    private void init_Driver(String browser) {
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                tldriver.set(new ChromeDriver());
                break;
            case "firefox":
                tldriver.set(new FirefoxDriver());
                break;
            case "edge":
                tldriver.set(new EdgeDriver());
                break;
            case "safari":
                tldriver.set(new SafariDriver());
                break;

            default:
                throw new BrowserNotSupportException("Please specify correct browser: " + browser);

        }

        tldriver.get().manage().window().maximize();
        tldriver.get().manage().deleteAllCookies();
    }


    public static DriverFactory getInstance(String browser) {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }

        if (tldriver.get() == null) {
            instance.init_Driver(browser);
        }

        return instance;
    }

    //creating get driver
    public WebDriver getDriver() {
        return tldriver.get();
    }

    public static void quitDriver(){
        tldriver.get().quit();
            tldriver.remove();

    }

}
