package com.practice;

import jdk.jfr.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.PageObjectManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenImagesPageTest extends BaseTest {

    @Test
    @Description("Verify if all images are valid")
    public void allImagesValid(){
        softAssert = new SoftAssert();
        pageObjectManager = new PageObjectManager(driver);
        int statusCode = 0;

        pageObjectManager.getHomePage().getAndClickBrokenImagesLink();

        List<WebElement> images = pageObjectManager.getBrokenImagesPage().getImages();

        for(WebElement image: images){
            String imgURL = image.getAttribute("src");

            if(imgURL != null && imgURL != ""){
                try{
                    URL url = new URL(imgURL);
                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                    httpConn.setRequestMethod("HEAD");
                    httpConn.setConnectTimeout(5000);
                    httpConn.setReadTimeout(5000);
                    statusCode = httpConn.getResponseCode();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            softAssert.assertTrue(statusCode < 400, "Image " + imgURL + " should not be broken");
        }
        softAssert.assertAll();
    }
}
