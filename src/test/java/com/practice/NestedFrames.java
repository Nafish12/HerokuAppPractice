package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NestedFrames {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement topMiddleFrame = driver.findElement(By.cssSelector("#content"));

        System.out.println(topMiddleFrame.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-left");
        WebElement leftFrame = driver.findElement(By.cssSelector("body"));
        System.out.println(leftFrame.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        WebElement bottomFrame = driver.findElement(By.cssSelector("body"));
        System.out.println(bottomFrame.getText());

        driver.quit();
    }
}
