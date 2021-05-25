package webinars.ArtCategoryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
    @Test(groups = {"ui_tests"})
    public void searchBrownBear(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://sampleshop.inqa.pl/");
        driver.quit();

        Assert.assertEquals(driver.getTitle(), "xyz");
    }
}
