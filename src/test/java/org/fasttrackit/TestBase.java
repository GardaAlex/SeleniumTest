package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    protected WebDriver driver = null;

    @Before
    public void setup(){
        String browser = System.getProperty("broser", "chrome");
        driver = DriverFactory.getDriver(browser);

    }

    @After
    public void tearDown(){

        driver.quit();
    }
}
