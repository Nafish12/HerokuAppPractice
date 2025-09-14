package com.practice;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {

    private WebDriver driver;

    private By addElementButton = By.cssSelector("button[onclick='addElement()']");

    public AddRemoveElementsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddElementButton(){
        driver.findElement(addElementButton).click();
    }

    public void clickDeleteButton(List<WebElement> elements, int n, WebDriver driver){
        elements.get(n).click();
        System.out.println("The delete button of index " + n + " has been clicked on");
    }

    public void clickAddElement(int n, WebDriver driver){
        for(int i = 0; i < n; i++){
            WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
            addElementButton.click();
        }
        System.out.println("Add Element has been clicked " + n + " times!");
    }

}
