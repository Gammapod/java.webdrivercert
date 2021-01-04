package challenges.challenge2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class challenge2 {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void startClass() {
        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
        driver =  new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void stopClass(){
        driver.quit();
    }

    @Test()
    public void porscheIsAnExoticCar() throws Exception {
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
