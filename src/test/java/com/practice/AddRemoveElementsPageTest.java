package com.practice;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.PageObjectManager;

import java.util.List;

public class AddRemoveElementsPageTest extends BaseTest {

    @Test
    @Description("Click on Add Elements and see if a new element has been created")
    public void clickAndVerifyAddElements(){
        softAssert = new SoftAssert();
        pageObjectManager = new PageObjectManager(driver);

        pageObjectManager.getHomePage().getAndClickAddRemoveElements();
        pageObjectManager.getAddRemoveElementsPage().clickAddElementButton();

        boolean deleteElement = wait.until(driver -> driver.findElement(By.cssSelector("button.added-manually"))).isDisplayed();

        softAssert.assertTrue(deleteElement,"A delete button should appear after clicking 'Add Element'");
        softAssert.assertAll();
    }

    @Test
    @Description("Click on Delete Button and see if the list of 'Delete Buttons' decreased by 1")
    public void clickDeleteButton(){
        softAssert = new SoftAssert();
        pageObjectManager = new PageObjectManager(driver);

        pageObjectManager.getHomePage().getAndClickAddRemoveElements();
        pageObjectManager.getAddRemoveElementsPage().clickAddElementButton();

        List<WebElement> deleteButtonsList = driver.findElements(By.cssSelector("button[class='added-manually']"));
        System.out.println(deleteButtonsList.size());

        pageObjectManager.getAddRemoveElementsPage().clickDeleteButton(deleteButtonsList, 0, driver);
        List<WebElement> updatedButtonsList = driver.findElements(By.cssSelector("button[class='added-manually']"));

        softAssert.assertEquals(deleteButtonsList.size(), updatedButtonsList.size() + 1, "A delete button should be deleted");
        softAssert.assertAll();
    }


}
