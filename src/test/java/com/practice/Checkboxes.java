package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkboxes {
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).click();
        driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(2)")).click();

        driver.close();
    }
}

