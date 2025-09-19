package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FloatingMenu {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/floating_menu#about");

        boolean homeButton = driver.findElement(By.cssSelector("a[href='#home']")).isDisplayed();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        boolean homeButtonStillDisplay = driver.findElement(By.cssSelector("a[href='#home']")).isDisplayed();

        if(homeButton == homeButtonStillDisplay){
            System.out.println("Menu floating");
        }
        else{
            System.out.println("Menu is not floating");
        }
        driver.quit();
    }
}
