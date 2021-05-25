package webinars.css_atributes_examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webinars.BaseTest;

import java.util.Arrays;

public class CssAtributesExamples extends BaseTest {
    @BeforeClass
    public void openPage(){
        driver.get("http://the-internet.herokuapp.com/");
    }
    @Test
    public void checkFontFace(){
        WebElement header = driver.findElement(By.tagName("h1"));
        String fontFamily = header.getCssValue("font-family");
        //Pobranie kroju czcionki dla nagłówka głównego 'h1'
        String[] fontFaces = fontFamily.split(",");
        //Ponieważ atrybut posiada kilka wartości, potrzebna jest konwersja
        //zmiana na tablicę stringów zawierających nazwy czcionek

        System.out.println(fontFamily);
        System.out.println(Arrays.toString(fontFaces));

        Assert.assertEquals(fontFaces[0], "\"Helvetica Neue\"");
        //Sprawdzenie czy podstawowa czcionka ma poprawną wartość
    }

    @Test
    public void checkFontSize(){
        WebElement linkText = driver.findElement(By.cssSelector("a"));
        String fontSize = linkText.getCssValue("font-size");
        //Pobranie rozmiaru czcionki dla odnośnika - wszytkie są identyczne
        //możemy pobrać pierwszy, na który trafi webdriver
        System.out.println(fontSize);
        //Zwróć uwagę na różnicę w wyświetlaniu rozmiaru w developer tools i w testach

        Assert.assertEquals(fontSize, "16px");
        //Sprawdzenie poprawności rozmiaru czcionki
    }

    @Test
    public void checkFontColor(){
        WebElement linkText = driver.findElement(By.xpath("//a[text()='Checkboxes']"));
        //W tym teście sprawdzimy kolor wybranego linka. Ponieważ wszytkie mają ten sam kolor
        //moglibyśmy postąpić podobnie jak w poprzednim teście (pobrać dowolny link)
        String linkColor = linkText.getCssValue("color");
        //Pobranie koloru tekstu dla odnalezionego elementu
        System.out.println(linkColor);
        //Zwróć uwagę na format pobranego koloru
        String fontColorHex = Color.fromString(linkColor).asHex();
        //Konwersja pobranego koloru do zapisu szesnastkowego (takiego jak w developer tools)
        System.out.println(fontColorHex);

        Assert.assertEquals(fontColorHex, "#2ba6cb");
        //Weryfikacja koloru
    }
}