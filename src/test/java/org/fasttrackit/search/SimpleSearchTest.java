package org.fasttrackit.search;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest extends TestBase {

    @Test
    public void simpleSearchWithOneKeyWord(){

        driver.get(AppConfig.getSiteUrl());

        String searchKeyword = "Vase";
        driver.findElement(By.id("search")).sendKeys(searchKeyword + Keys.ENTER);

        System.out.println("Presed enter.");
        //driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()='Herald Glass Vase']]//button[@title='Add to Cart']")).click();

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));
        System.out.println("Stored " + productNames.size() + " product names.");

        for (WebElement productName:productNames
             ) {
            assertThat("Some of the produts name does not contain the serched keyword.",
                    productName.getText(), containsString(searchKeyword.toUpperCase()));
        }
    }
}
