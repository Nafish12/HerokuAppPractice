package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InifiniteScroll {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        for(int i = 0; i < 5; i++){
            actions.scrollByAmount(0,10000).perform();
            Thread.sleep(1000);
        }


        driver.quit();
    }
}
