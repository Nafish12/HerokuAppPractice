package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagesPage {

    private WebDriver driver;

    private By images = By.xpath("//div[@class='example']/img");

    public BrokenImagesPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getImages(){
        return driver.findElements(images);
    }


}
