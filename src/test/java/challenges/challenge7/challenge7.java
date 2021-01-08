package challenges.challenge7;

import challenges.challengeBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class challenge7 extends challengeBase {
    @Test()
    public void makeLinksAreCorrect() {
        driver.get("https://www.copart.com");
        List<WebElement> makeElements = driver.findElements(By.xpath("//div[@id='tabMakes']//a"));
        Map<String, String> makeAndLink = new HashMap<>();
        for (WebElement make : makeElements) {
            if(!make.getAttribute("title").isEmpty()){
                makeAndLink.put(make.getAttribute("title"), make.getAttribute("href"));
            }
        }

        for(Map.Entry<String, String> entry : makeAndLink.entrySet()){
            System.out.println("Make: " + entry.getKey() + ", Link: " + entry.getValue());
            Assert.assertTrue(entry.getValue().contains(entry.getKey().replaceAll(" ", "%20")));
        }
    }
}
