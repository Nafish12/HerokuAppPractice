package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Login {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        //Incognito Mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/login");

        //Successful Login
        WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("i[class='fa fa-2x fa-sign-in']"));

        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();

        boolean successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.flash.success"))).isDisplayed();
        if(successMessage){
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Login Unsuccessful");
        }

        WebElement logoutButton = driver.findElement(By.cssSelector("a.button.secondary.radius"));
        logoutButton.click();

        System.out.println("Logout Successful");

        //Fail Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
        WebElement usernameInputFail = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordInputFail = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement loginButtonFail = driver.findElement(By.cssSelector("i[class='fa fa-2x fa-sign-in']"));

        usernameInputFail.sendKeys("blabla");
        passwordInputFail.sendKeys("blabla");
        loginButtonFail.click();

        boolean errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.flash.error"))).isDisplayed();
        if(errorMessage){
            System.out.println("Error Message is Present");
        }
        else{
            System.out.println("Error Message is NOT Present");
        }

        driver.quit();
    }
}
