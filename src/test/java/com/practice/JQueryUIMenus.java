package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryUIMenus {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

        WebElement enabledButton = driver.findElement(By.cssSelector("li#ui-id-3"));
        actions.moveToElement(enabledButton).perform();

        WebElement downloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#ui-id-4")));
        actions.moveToElement(downloadButton).perform();

        WebElement pdfButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li#ui-id-5")));
        actions.moveToElement(pdfButton).click().perform();

        System.out.println("PDF option clicked and downloaded");

        driver.quit();
    }
}
