package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlerts {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        WebElement jsConfirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        WebElement jsPromptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));

        jsAlertButton.click();
        Alert jsAlert = driver.switchTo().alert();
        System.out.println("JS Alert text: " + jsAlert.getText());
        jsAlert.accept();
        System.out.println("Result after JS Alert: " + driver.findElement(By.cssSelector("#result")).getText());

        jsConfirmButton.click();
        Alert jsConfirmAlert = driver.switchTo().alert();
        System.out.println("JS Confirm Alert text: " + jsConfirmAlert.getText());
        jsConfirmAlert.accept();
        System.out.println("Results after JS Confirm Alert: " + driver.findElement(By.cssSelector("#result")).getText());

        jsPromptButton.click();
        Alert jsPromptAlert = driver.switchTo().alert();
        System.out.println("Js Prompt Alert text: " + jsPromptAlert.getText());
        jsPromptAlert.sendKeys("Hello Nafis");
        jsPromptAlert.accept();
        System.out.println("Results after JS Prompt Alert: " + driver.findElement(By.cssSelector("#result")).getText());

        jsPromptButton.click();
        jsPromptAlert = driver.switchTo().alert();
        jsPromptAlert.sendKeys("Dismiss this Alert");
        jsPromptAlert.dismiss();
        System.out.println("Results after dismissing JS Prompt Alert: " + driver.findElement(By.cssSelector("#result")).getText());

        driver.quit();
    }

}
