package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDrop {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.cssSelector("div#column-a"));
        WebElement columnB = driver.findElement(By.cssSelector("div#column-b"));

        String headerA = columnA.findElement(By.tagName("header")).getText();
        String headerB = columnB.findElement(By.tagName("header")).getText();
        System.out.println("Column A has: " + headerA);
        System.out.println("Column B has: " + headerB);


        Actions action = new Actions(driver);
        action.dragAndDrop(columnA, columnB);

        // verify result
        String newHeaderA = columnA.findElement(By.tagName("header")).getText();
        String newHeaderB = columnB.findElement(By.tagName("header")).getText();
        System.out.println("Column A now has: " + newHeaderA);
        System.out.println("Column B now has: " + newHeaderB);

        driver.close();



    }
}
