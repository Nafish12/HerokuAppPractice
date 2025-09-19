package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ExitIntent {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/exit_intent");

        Actions actions = new Actions(driver);

        driver.manage().window().maximize();

//        int windowWidth = driver.manage().window().getSize().getWidth();
//        int windowHeight = driver.manage().window().getSize().getHeight();
//
//        int centerX = windowWidth/2;
//        int centerY = windowHeight/2;
//
//         actions.moveByOffset(centerX,centerY).perform();
//
//         actions.moveByOffset(0,-400).perform();
//
//         Thread.sleep(2000);
//
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
        System.out.println("Modal appeared? " + modal.isDisplayed());

        WebElement closeBtn = modal.findElement(By.cssSelector(".modal-footer p"));
        closeBtn.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
