package com.spurqlabs;

import com.spurqlabs.pages.BasicCalculatorPage;
import com.spurqlabs.pages.CalculatorPage;
import com.spurqlabs.utils.WebUtil;
import io.opentelemetry.api.internal.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.opentelemetry.api.internal.ConfigUtil.*;

public class SeleniumTest {
        WebDriver driver;

        @BeforeTest
        public  void beforeTest() throws IOException {
            driver = WebUtil.initDriver();
        }

        @AfterTest
        public void afterTest() throws InterruptedException {
            Thread.sleep(2000);
            WebUtil.closeDriver();
        }
    @Test
    public void SeleniumTest() throws InterruptedException {
        BasicCalculatorPage basicCalculatorPage = new BasicCalculatorPage(driver);
        basicCalculatorPage.calculate("2","+","3");
        Assert.assertEquals(basicCalculatorPage.getResults(),"5");
    }

    @Test
    public void PageObJectTest() throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.calculate();
        Assert.assertEquals(calculatorPage.getResults(),"3");
    }

    @Test
    public void TestConfig(){
        ConfigUtil.getValue("App_URL");
    }

}
