package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.cssSelector("select#dropdown"));
        Select select = new Select(dropdown);

        WebElement option1 = driver.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = driver.findElement(By.cssSelector("option[value='2']"));

        select.selectByVisibleText("Option 1");
        System.out.println(option1.isSelected());

        Thread.sleep(2000);


        driver.close();
    }


}
