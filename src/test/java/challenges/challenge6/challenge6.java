package challenges.challenge6;

import challenges.challengeBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class challenge6 extends challengeBase {
    @Test()
    public void porscheModels() throws IOException {
        driver.get("https://www.copart.com");
        WebElement searchText = driver.findElement(By.id("input-search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-uname='homepageHeadersearchsubmit']"));

        searchText.sendKeys("nissan");
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='serverSideDataTable']//td")));

        WebElement searchModelExpand = driver.findElement(By.xpath("//a[@data-uname='ModelFilter']"));
        searchModelExpand.click();

        WebElement searchModelFilter = driver.findElement(By.xpath("//a[@data-uname='ModelFilter']/ancestor::li//form//input"));
        searchModelFilter.sendKeys("skyline");
        WebElement skylineCheckbox;
        try {
            skylineCheckbox = driver.findElement(By.xpath("//a[@data-uname='ModelFilter']/ancestor::li//ul//input"));
            skylineCheckbox.click();
        }catch(NoSuchElementException e){
            takeScreenshot(driver, "./screenshots/challenge6.png");
            throw e;
        }

    }
    public void takeScreenshot(WebDriver driver, String filepath) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(filepath);
        FileUtils.copyFile(image, destination);
    }

}
