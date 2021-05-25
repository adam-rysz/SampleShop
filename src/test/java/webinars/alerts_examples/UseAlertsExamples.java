package webinars.alerts_examples;

import webinars.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UseAlertsExamples extends BaseTest {
    @BeforeClass
    public void openPage(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void alertTest(){
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[contains(., \"JS Alert\")]"));
//        lokalizacja przycisku do uruchamiania zwykłego alerta
        jsAlertButton.click();
//        kliknięcie na przycisk

        Alert jsAlert = driver.switchTo().alert();
//        Wykorzystanie klasy służącej do obsługi alertów
//        obiekt typu Alert jest zwracany z .switchTo().alert()
        String alertText = jsAlert.getText();
//        pobranie tekstu z alertu
        jsAlert.accept();
//        ackeptacja(kliknięcie przycisku 'Ok') alertu
        WebElement confirmationElement = driver.findElement(By.cssSelector("p#result"));
        String confirmationText = confirmationElement.getText();
//        Pobranie tekstu wyświetlanego na stronie, zawierającego rezultat alertu

        Assert.assertEquals(alertText,"I am a JS Alert");
        Assert.assertEquals(confirmationText, "You successfully clicked an alert");
    }

//    Dodaj testy do obsług alertu typu Confirmation oraz Prompt
//    Sprawdź teksty w alertach, wykorzystanie przycisków oraz wprowadzanie tekstu
//    za każdym razem sprawdzaj tekst na stronie
}
