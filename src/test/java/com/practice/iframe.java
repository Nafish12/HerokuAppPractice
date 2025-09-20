package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class iframe {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        WebElement iframe = driver.findElement(By.cssSelector("iframe#mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement editorBody = driver.findElement(By.cssSelector("#tinymce"));
        System.out.println(editorBody.getText());

        Thread.sleep(2000);

        driver.quit();
    }
}
