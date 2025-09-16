package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxesPage {

    private WebDriver driver;

    private By firstCheckBox = By.cssSelector("input[type='checkbox']:nth-child(1)");
    private By secondCheckBox = By.cssSelector("input[type='checkbox']:nth-child(2)");

    public CheckBoxesPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickFirstCheckBox(){
        driver.findElement(firstCheckBox).click();
    }

    public void clickSecondCheckBox(){
        driver.findElement(secondCheckBox).click();
    }
}
