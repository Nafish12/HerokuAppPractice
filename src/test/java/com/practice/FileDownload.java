package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FileDownload {

    public static void main (String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/download");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='example']//a)[1]")));

        List<WebElement> fileList = driver.findElements(By.cssSelector(".example a"));
        System.out.println(fileList.size());

        for(WebElement file: fileList){
            System.out.println(file.getText());
        }

        Thread.sleep(2000);
        fileList.get(0).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
