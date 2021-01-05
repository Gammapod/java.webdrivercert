package challenges.challenge3;

import challenges.challengeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class challenge3 extends challengeBase {
    @Test()
    public void porscheIsAnExoticCar() {
        driver.get("https://www.copart.com");
//            todo: make sure this is the correct section for this challenge
        List<WebElement> makes = driver.findElements(By.xpath("//div[@id='tabMakes']//a"));
        for (WebElement make : makes) {
            System.out.println(make.getAttribute("innerText") + "- " + make.getAttribute("href"));
        }
    }
}
