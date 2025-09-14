package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected PageObjectManager pageObjectManager;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.close();
        }
    }
}
