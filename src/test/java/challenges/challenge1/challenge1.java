package challenges.challenge1;

import challenges.challengeBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class challenge1 extends challengeBase {
    @Test()
    public void goToGoogle() {
        driver.get("https://www.google.com");
    }

    @Test()
    public void verifyGoogleTitle() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
