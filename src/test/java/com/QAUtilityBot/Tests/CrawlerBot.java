package com.QaUtilityBot.bot;

import com.QaUtilityBot.base.DriverFactory;
import com.QaUtilityBot.utils.PropertiesFile;
import com.QaUtilityBot.utils.ReusableMethods;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrawlerBot {

    public PropertiesFile propertiesFile;
    public ReusableMethods reusableMethods;
    public static WebDriver driver;


    @BeforeTest
    public void setUp() {
        propertiesFile = new PropertiesFile();
        driver = DriverFactory.getInstance(propertiesFile.getPropertyValue("Browser")).getDriver();
    }

    @Test
    public void simpleCrawlerTest() {
        propertiesFile = new PropertiesFile();

        //URL fetching from testConfig.properties file.
        String baseURL = propertiesFile.getPropertyValue("URL");
        System.out.println("Base URL is ::" + baseURL);
        //launch the URL
        driver.get(baseURL);

        reusableMethods = new ReusableMethods(driver);
        boolean page_Title = reusableMethods.waitForPageToLoad(propertiesFile.getPropertyValue("PageTitle"));
        System.out.println("Is page title visible:: " + page_Title);

        // all linkTest by using tagName a
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Set<String> uniqueLinks = new HashSet<String>();
        for (WebElement link : links) {
            String href = link.getAttribute("href");

            if (href != null && href.startsWith("http")) {
                uniqueLinks.add(href);
            }
        }

        System.out.println("Total links found: " + uniqueLinks.size());

        for (String url : uniqueLinks) {
            try {
                driver.get(url);
                String title = driver.getTitle();

                if (title.trim().isBlank()) {
                    System.out.println("FAILED: Empty Title ::" + title);
                } else {
                    System.out.println("PASSED: " + title + " -> " + url);
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + url + " | " + e.getMessage());
            }
        }


    }

    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
