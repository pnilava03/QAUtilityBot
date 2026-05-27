package com.QaUtilityBot.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class ReusableMethods {

   public final WebDriver driver;
    public ReusableMethods(WebDriver driver){
        this.driver=driver;
    }

    public boolean waitForPageToLoad(String title){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public int getStatusCode(String url){
        try {
            HttpURLConnection connection= (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            return connection.getResponseCode();

        } catch (IOException e) {
            return 0;
        }
    }



}
