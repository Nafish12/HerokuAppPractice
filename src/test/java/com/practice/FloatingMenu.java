package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FloatingMenu {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/floating_menu#about");

        boolean homeButton = driver.findElement(By.cssSelector("a[href='#home']")).isDisplayed();

//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.END).perform();

        WebElement body = driver.findElement(By.cssSelector("body"));
        body.sendKeys(Keys.END);

        Thread.sleep(2000);

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
