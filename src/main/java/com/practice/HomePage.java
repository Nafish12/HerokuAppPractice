package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebDriver driver;

    private By abTestingLink = By.cssSelector("a[href='/abtest']");
    private By addRemoveElementsLink = By.cssSelector("a[href='/add_remove_elements/']");
    private By brokenImagesLink = By.cssSelector("a[href='/broken_images']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getABTestingLink(){
        return driver.findElement(abTestingLink);
    }

    public void clickABTestingLink(){
        getABTestingLink().click();
    }

    public void getAndClickAddRemoveElements(){
        driver.findElement(addRemoveElementsLink).click();
    }

    public void getAndClickBrokenImagesLink(){
        driver.findElement(brokenImagesLink).click();
    }










}
