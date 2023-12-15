package com.spurqlabs.utils;

import com.spurqlabs.core.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class WebUtil extends TestContext {
    public static WebDriver initDriver() throws IOException {
        if(ConfiUtil.getValue("Browser").equals("Chrome")){
        driver = new ChromeDriver();
        }else if(ConfiUtil.getValue("Browser").equals("Edge")){
            driver = new EdgeDriver();}
        return driver;
    }

    public static void closeDriver()
    {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
