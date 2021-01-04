package challenges.challenge2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class challenge2 {

    public WebDriver driver;

    @BeforeClass
    public void startClass() {
        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
        driver =  new ChromeDriver();
    }

    @AfterClass
    public void stopClass(){
        driver.quit();
    }

    @Test()
    public void porscheIsAnExoticCar() {
//      todo: go to copart.com
//      todo: search for exotics
//      todo: verify porsche is in the list of cars
    }
}
