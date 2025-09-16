package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DisappearingElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/disappearing_elements");

        try{
            WebElement gallery = driver.findElement(By.cssSelector("a[href='/gallery/]"));
            System.out.println("Gallery link is NOT present on this page load");

        }catch(NoSuchElementException e){
            System.out.println("Gallery link is NOT present on this page load");
        }finally {
            driver.close();
        }


    }
}
