package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAd {
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/entry_ad");

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
        Thread.sleep(2000);
        WebElement closeAd = modal.findElement(By.xpath("//p[text()='Close']"));
        closeAd.click();

        Thread.sleep(2000);

        WebElement clickHere = driver.findElement(By.cssSelector("a#restart-ad"));
        clickHere.click();
        System.out.println("Click here has been clicked");


        Thread.sleep(5000);
        driver.quit();
    }
}
