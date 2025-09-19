package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControls {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//        WebElement removeButton = driver.findElement(By.xpath("(//button[@onclick='swapCheckbox()'])[1]"));
//        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
//
//        boolean checkboxDisplayed = checkbox.isDisplayed();
//        System.out.println("Checkbox displayed? " + checkboxDisplayed);
//        removeButton.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
//        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
//        addButton.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='checkbox']")));
//        boolean newCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']")).isDisplayed();
//        System.out.println("Checkbox displayed again? " + newCheckbox);

        WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Enable']")));
        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));

        System.out.println("Input field enabled? " + inputField.isEnabled());

        enableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        WebElement inputFieldAfterEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='text']")));
        inputFieldAfterEnabled.sendKeys("Hello World");

        Thread.sleep(2000);

        String inputValue = inputFieldAfterEnabled.getAttribute("value");
        System.out.println("Value of Input Field: " + inputValue);

        WebElement disableButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Disable']")));
        disableButton.click();


        WebElement disabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));
        System.out.println(disabledMessage.getText());

        driver.quit();
    }
}
