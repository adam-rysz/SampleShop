package webinars.radio_buttons_examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webinars.BaseTest;

import java.util.List;

public class RadioButtonsExamples extends BaseTest {
    WebElement cookieConsent;
    @BeforeClass
    public void openPage(){
        driver.get("http://testuj.pl");
    }

    @Test
    public void cookieConsentIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By cookieConsentBy = By.id("cookieConsent");
        cookieConsent = wait.until(ExpectedConditions.visibilityOfElementLocated(cookieConsentBy));

        Assert.assertTrue(cookieConsent.isDisplayed());
        //Sprawdzenie czy wyświetlany jest box dotyczący polityki cookies
    }

    @Test(dependsOnMethods = {"cookieConsentIsDisplayed"})
    public void checkConfigurationButton(){
        WebElement configButton = cookieConsent.findElement(By.cssSelector(".config"));
        String configButtonText = configButton.getText();

        Assert.assertEquals(configButtonText, "Ustawienia");
        configButton.click();
        //Przejście do ustawień
    }

    @Test(dependsOnMethods = {"checkConfigurationButton"})
    public void checkRadioButtons(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[input[@type=\"radio\"]]"));

        Assert.assertEquals(radioButtons.size(), 2);
        //Sprawdzenie czy dostępne są dokładnie dwie opcje

        WebElement firstRadioButton = radioButtons.get(0).findElement(By.tagName("input"));
        String firstRadioButtonText = radioButtons.get(0).getText();
        Assert.assertEquals(firstRadioButtonText, "Zgadzam się");
        //Sprawdzenie tekstu opcji pierwszej
        Assert.assertFalse(firstRadioButton.isSelected());
        //Sprawdzenie czy domyślnie opcja pierwsza nie jest zaznaczona

        WebElement secondRadioButton = radioButtons.get(1).findElement(By.tagName("input"));
        String secondRadioButtonText = radioButtons.get(1).getText();
        Assert.assertEquals(secondRadioButtonText, "Nie zgadzam się");
        //Sprawdzenie tekstu opcji pierwszej
        Assert.assertFalse(secondRadioButton.isSelected());
        //Sprawdzenie czy domyślnie opcja druga nie jest zaznaczona
    }

    @Test(dependsOnMethods = "checkRadioButtons")
    public void checkRadioButtonsSelection(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[input[@type=\"radio\"]]"));

        WebElement firstRadioButton = radioButtons.get(0).findElement(By.tagName("input"));
        //Web element pierwszego radio buttona
        WebElement secondRadioButton = radioButtons.get(1).findElement(By.tagName("input"));
        //Web element drugiego radio buttona

        firstRadioButton.click();
        //Kliknięcie w pierwszy radio button
        Assert.assertTrue(firstRadioButton.isSelected());
        Assert.assertFalse(secondRadioButton.isSelected());
        //Sprawdzenie czy pierwszy jest zaznaczony a drugi odznaczony

        secondRadioButton.click();
        Assert.assertFalse(firstRadioButton.isSelected());
        Assert.assertTrue(secondRadioButton.isSelected());
        //Sprawdzenie czy pierwszy jest odznaczony a drugi zaznaczony

        firstRadioButton.click();
        Assert.assertTrue(firstRadioButton.isSelected());
        Assert.assertFalse(secondRadioButton.isSelected());
        //Sprawdzenie czy pierwszy jest zaznaczony a drugi odznaczony
    }
}