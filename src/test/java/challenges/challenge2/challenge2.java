package challenges.challenge2;

import challenges.challengeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class challenge2 extends challengeBase {
    @Test()
    public void porscheIsAnExoticCar() {
        driver.get("https://www.copart.com");
        WebElement searchText = driver.findElement(By.id("input-search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-uname='homepageHeadersearchsubmit']"));

        searchText.sendKeys("exotics");
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='serverSideDataTable']//td")));

        List<WebElement> porscheCells = driver.findElements(By.xpath("//span[@data-uname='lotsearchLotmake'][text()[contains(.,'PORSCHE')]]"));
        Assert.assertFalse(porscheCells.isEmpty(), "Searching for 'exotics' should have returned at least one porsche");
    }
}
