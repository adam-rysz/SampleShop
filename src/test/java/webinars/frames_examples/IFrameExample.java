package webinars.frames_examples;

import webinars.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameExample extends BaseTest {
    @Test
    public void navigateInFrame(){
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
//        Przełączenie ramki z wykorzystaniem jej id
//        Spróbuj bez wyłączania ramki
//        WebElement frameElement = driver.findElement(By.id("mce_0_ifr"));
//        driver.switchTo().frame(frameElement);
//        Powyższe 2 linie przełączają ramkę z wykorzystaniem WebElementu zamiast id
        WebElement textElement = driver.findElement(By.cssSelector("#tinymce p"));
        String actualText = textElement.getText();
//        Sprawdzenie czy widoczny jest tekst wewnatrz ramki
        driver.switchTo().parentFrame();
//        Powrót do ramki bazowej

        Assert.assertEquals(actualText, "Your content goes here.");
    }

    @Test(priority = 1)
    public void checkHeaderValue(){
//        Test służący sprawdzeniu czy przełączyliśmy się do ramki bazowej
//        spróbuj go uruchomić z zakomentowaną linią 23.
        WebElement header = driver.findElement(By.tagName("h3"));
        String headText = header.getText();

        Assert.assertEquals(headText, "An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}