package com.practice;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.ConfigReader;
import utils.PageObjectManager;

public class HomePageTest extends BaseTest {

    @Test
    @Description("Verify you can access A/B Testing Page")
    public void clickABTesting(){
        softAssert = new SoftAssert();
        pageObjectManager = new PageObjectManager(driver);
        pageObjectManager.getHomePage().clickABTestingLink();
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL, ConfigReader.get("ABTestingLink"), "Links should match");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify you can access Add/Remove Elements Page")
    public void clickAddRemoveElements(){
        softAssert = new SoftAssert();
        pageObjectManager = new PageObjectManager(driver);
        pageObjectManager.getHomePage().getAndClickAddRemoveElements();
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL, ConfigReader.get("AddRemoveElementsLink"), "Links shoudl match");
        softAssert.assertAll();
    }
}
