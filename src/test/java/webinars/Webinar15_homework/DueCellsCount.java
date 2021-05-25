package webinars.Webinar15_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import webinars.BaseTest;

import java.util.List;

public class DueCellsCount extends BaseTest {

    @Test
    public void countDueLowerThan50(){
        List<WebElement> dueCells = driver.findElements(By.xpath("//table[@id='table1']//td[starts-with(.,'$')]"));
//        Pobranie wszystkich komórek w tabeli 1. zawierających znak '$'
        int result = 0;
        for(WebElement cell : dueCells){
//            Iteracja po wszystkich komórkach w celu przetworzenia tekstu i sprawdzenia wartości liczbowej
            String cellValue = cell.getText();
//            System.out.println(cellValue);
            String numValue = cellValue.substring(1);
//            Usunięcie znaku '$' z początku zawartości komórki
//            System.out.println(numValue);
            float floatValue = Float.parseFloat(numValue);
//            Konwersja pozostałej części wartości komórki do typu float
            if(floatValue <= 50){
//                Sprawdzenie czy liczbowa wartość komórki jest mniejsza lub równa 50 (zgodnie z zadaniem)
                result++;
            }
        }

        Assert.assertEquals(result, 2);
    }


}