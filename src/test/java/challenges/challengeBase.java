package challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class challengeBase {

    public WebDriver driver;
    public WebDriverWait wait;

    @AfterSuite
    public void stopSuite() {
        System.out.println("All done!!!");
    }

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
}
