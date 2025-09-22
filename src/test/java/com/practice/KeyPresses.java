package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyPresses {
    public static void main (String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement inputField = driver.findElement(By.cssSelector("#target"));
        inputField.sendKeys(Keys.chord("A"));
        System.out.println("Results from input: " + driver.findElement(By.cssSelector("#result")).getText());

        WebElement body = driver.findElement(By.cssSelector("body"));
        body.sendKeys(Keys.BACK_SPACE);
        System.out.println("Results from input: " + driver.findElement(By.cssSelector("#result")).getText());

        driver.quit();
    }
}
