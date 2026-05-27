package com.QAUtilityBot.Tests;

import com.QaUtilityBot.base.DriverFactory;
import com.QaUtilityBot.utils.PropertiesFile;
import com.QaUtilityBot.utils.ReusableMethods;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrawlerBot {

    public PropertiesFile propertiesFile;
    public ReusableMethods reusableMethods;
    public static WebDriver driver;
    public FileWriter writer;
    public CSVPrinter csvPrinter;


    @BeforeTest
    public void setUp() {
        propertiesFile = new PropertiesFile();
        driver = DriverFactory.getInstance(propertiesFile.getPropertyValue("Browser")).getDriver();
    }

    @Test
    public void simpleCrawlerTest()  {
        propertiesFile = new PropertiesFile();

        try {
             writer = new FileWriter("./src/main/resources/crawler-report/crawler-report.csv");
             csvPrinter=new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("URL","statusCode","Ttile","Status"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
                int statusCode = reusableMethods.getStatusCode(url);

                driver.get(url);
                String title = driver.getTitle();


                String status = statusCode >= 200 && statusCode < 400
                        && title != null
                        && !title.trim().isEmpty()
                        ? "PASSED"
                        : "FAILED";
                csvPrinter.printRecord(url, statusCode, title, status);


                if (title.trim().isBlank()) {
                    csvPrinter.printRecord(url,statusCode,"No Title","FAILED");
                } else {
                    csvPrinter.printRecord(url,statusCode, title ,"PASSED");
                }
            } catch (Exception e) {
                try {
                    csvPrinter.printRecord(  url, "ERROR: "+e.getMessage(),"FAILED");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                csvPrinter.flush();
                System.out.println("Crawler report generated successfully.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @AfterTest
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
