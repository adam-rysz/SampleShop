package webinars.screenshot_util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webinars.BaseTest;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotExample extends BaseTest {
    @BeforeClass
    public void openPage(){
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void takeScreenShotTest() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./target/screenshot1.png"));
        //Pobieramy zrzut ekranu oraz zapisujemy go do pliku 'screenshot1.png' w katalogu 'target'
        //Ważne jest aby nie zapisywać bezpośrednio w katalogu roboczym, aby uniknąć przypadkowego
        //commitu zrzutów ekranu do repozytorium

        driver.findElement(By.linkText("Checkboxes")).click();
        //Przejście na podstronę 'Checkboxes'
        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()=\"Checkboxes\"]")));
        //W trakcie webianra pojawił się problem ze zbieraniem zrzutu ekranu
        //Początkowo myślałem, że wynika ze zbyt szybkiego zebrania zrzutu stąd wait
        //jednak okazało sie to omyłkowym zapisem pierwszego zrzutu jako drugi plik 'scrFile' zamiast 'scrFile2'
        File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("./target/screenshot2.png"));
        //Zapis drugiego zrzutu w celu pokazania ziberania zrzutów w różnych miejscach w trakcie testów
    }
}