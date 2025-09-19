package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicContent {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/dynamic_content");

        //Content
        String pageSourceBeforeRefresh = driver.getPageSource();

        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);

        String pageSourceAfterRefresh = driver.getPageSource();


        if(pageSourceBeforeRefresh.equals(pageSourceAfterRefresh)){
            System.out.println("Content did not change");
        }
        else{
            System.out.println("Content changed");
        }


        //Images
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='large-2 columns']//img"));

        for(WebElement img : images){
            String src = img.getAttribute("src");
            if(src != null){
                System.out.println("Image has loaded: " + src);
            }
            else{
                System.out.println("Image has not loaded");
            }
        }


        //Click Here
        WebElement clickHereButton = driver.findElement(By.cssSelector("a[href='/dynamic_content?with_content=static']"));

        String currentURLBefore = driver.getCurrentUrl();

        Thread.sleep(1000);
        clickHereButton.click();
        Thread.sleep(1000);

        String currentURLAfter = driver.getCurrentUrl();

        if(currentURLBefore.equals(currentURLAfter)){
            System.out.println("URL did not change after clicking the link");
        }else{
            System.out.println("URL did change after clicking the link");
        }





        driver.close();
    }
}
