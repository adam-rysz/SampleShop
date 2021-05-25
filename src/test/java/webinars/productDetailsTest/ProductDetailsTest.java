package webinars.productDetailsTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webinars.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.List;



public class ProductDetailsTest extends BaseTest{

    @BeforeClass
    public void openPage(){
        driver.get("http://sampleshop.inqa.pl/men/1-1-hummingbird-printed-t-shirt.html#/1-rozmiar-s/8-kolor-bialy");
    }

    @Test
    public void addTobasketColour(){

        WebElement addButton = driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"));

        String buttonColor = addButton.getCssValue("background-color");

        String addButtonfontColorHex = Color.fromString(buttonColor).asHex();

        Assert.assertEquals(addButtonfontColorHex, "#2fb5d2");
        System.out.println("Sprawdzenie poprawne.");

    }

    @Test
    public void headCapital(){

        WebElement header = driver.findElement(By.tagName("h1"));
        String fontCapital = header.getCssValue("text-transform");

        Assert.assertEquals(fontCapital, "uppercase");
        System.out.println("Sprawdzenie poprawne.");
    }
    @Test
    public void CheckColours() {


    }

    @Test
    public void takeScreenShotTest() throws IOException, InterruptedException {

        WebElement black = driver.findElement(By.xpath("//input[@title='czarny']"));

        File scrWhite = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrWhite, new File("./target/screenshot1.png"));

        black.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'selected')]")));

        File scrBlck = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrBlck, new File("./target/screenshot2.png"));

    }


}
