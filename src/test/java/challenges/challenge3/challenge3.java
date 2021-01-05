package challenges.challenge3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class challenge3 {

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
        List<WebElement> makes = driver.findElements(By.xpath("//div[@id='tabMakes']//a"));
        for (WebElement make : makes) {
            System.out.println(make.getAttribute("innerText") + "- " + make.getAttribute("href"));
        }

    }
}
