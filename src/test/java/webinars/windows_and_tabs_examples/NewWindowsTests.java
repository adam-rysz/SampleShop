package webinars.windows_and_tabs_examples;

import webinars.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowsTests extends BaseTest {
    String originalWindow;
    //    Deklaracja uchwytu pierwotnego okna. Dzięki wykorzystaniu pola
//    będzie do niego dostęp we wszystkich testach
    @Test
    public void openNewWindowAndCheckContent(){
        driver.get("http://the-internet.herokuapp.com/windows");
        originalWindow = driver.getWindowHandle();
//        Pobranie uchwytu pierwotnego okna

//        System.out.println("Wszystkie okna przed");
//        Set<String> windows = driver.getWindowHandles();
//        System.out.println(windows);
//        3 powyższe linie służą pokazaniu, że otwarte jest tylko jedno okno(zakładka)

        driver.findElement(By.linkText("Click Here")).click();

//        System.out.println("Wszystkie okna po");
        Set<String> windows = driver.getWindowHandles();
//        System.out.println(windows);
//        System.out.println("Aktualne okno");
//        Dwie powyższe linie służą celom prezentacji aktualnego stanu okien
        String currentWindow = driver.getWindowHandle();
//        System.out.println(currentWindow);
//        Powyższa linia służy pokazaniu, że aktywne jest nadal pierwotne okno

        for (String windowItem : windows
        ) {
            if(!windowItem.equalsIgnoreCase(currentWindow)){
                driver.switchTo().window(windowItem);
//                System.out.println("Przełączam do okna " + windowItem);
            }
//            Powyższa pętla służy do przełączenia na nowo otwarte okno
//            W teście można dodać jeszcze sprawdzenie, że otwarte są jedynie 2 okna

        }

        //        driver.switchTo().window();
        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
//        Sprawdzenie tekstu na nowootwartej stronie

        Assert.assertEquals(headerText, "New Window");
    }

    @Test(priority = 1)
    public void closeWindowAndCheckContent(){
        driver.close();
//        Zamknięcie aktywnego okna (otwartego w trakcie poprzedniego testu)
//        W praktyce takie zamknięcie powinno odbywać się w poprzednim teście
//        Również przełączenie na pierwotne okno powinno się odbywać w poprzednim teście
//        zgodnie z zasadą, że każdy test powinien być niezależny
//        W tym wypadku taki przebieg testów służy celom demonstracyjnym
        driver.switchTo().window(originalWindow);

        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();

        Assert.assertEquals(headerText, "Opening a new window");
    }
}