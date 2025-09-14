package utils;

import com.practice.AddRemoveElementsPage;
import com.practice.BrokenImagesPage;
import com.practice.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v137.page.Page;

public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;
    private AddRemoveElementsPage addRemoveElementsPage;
    private BrokenImagesPage brokenImagesPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        if(homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public AddRemoveElementsPage getAddRemoveElementsPage(){
        if (addRemoveElementsPage == null){
            addRemoveElementsPage = new AddRemoveElementsPage(driver);
        }
        return addRemoveElementsPage;
    }

    public BrokenImagesPage getBrokenImagesPage(){
        if(brokenImagesPage == null){
            brokenImagesPage = new BrokenImagesPage(driver);
        }
        return brokenImagesPage;
    }
}
