package webinars.ArtCategoryTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import sampleshop.Art.ArtCategory;

public class DisplayTest {
    @Test
    public void artCategoryIsDisplayed(){
        ArtCategory artCat = new ArtCategory();
        String result = artCat.displayArtCategory();

        Assert.assertEquals(result, "Art");
    }
//    Test weryfikujący działanie klasy aplikacji głównej
}