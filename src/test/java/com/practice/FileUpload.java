package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload through "Choose File" button
        WebElement fileUploadButton = driver.findElement(By.cssSelector("#file-upload"));

        String filePath = "/Users/md.nafisali/Desktop/naf.txt";
        fileUploadButton.sendKeys(filePath);

        driver.findElement(By.cssSelector("#file-submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='File Uploaded!']")));
        System.out.println("File Uploaded Successfully");

        driver.quit();
    }
}
