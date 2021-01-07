package challenges.challenge5;

import challenges.challengeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class challenge5 extends challengeBase {
    @Test()
    public void porscheModels() {
        driver.get("https://www.copart.com");
        WebElement searchText = driver.findElement(By.id("input-search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-uname='homepageHeadersearchsubmit']"));

        searchText.sendKeys("porsche");
        searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='serverSideDataTable']//td")));

        Select tableLength = new Select (driver.findElement(By.name("serverSideDataTable_length")));
        tableLength.selectByValue("20");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='serverSideDataTable']//td")));

        countModels();
        System.out.println();
        countDamages();

    }
    public void countModels(){
        List<WebElement> porscheModelElements = driver.findElements(By.xpath("//td/span[@data-uname='lotsearchLotmodel']"));
        List<String> porscheModels = porscheModelElements.stream()
                .map(model -> new String(model.getAttribute("innerText"))).sorted().collect(Collectors.toList());

        HashMap<String, Integer> countedList = new HashMap<String, Integer>();
        for(String value : porscheModels) {
            addToCountedList(countedList, value);
        }
        for(Map.Entry<String, Integer> entry : countedList.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void countDamages() {
        List<WebElement> porscheModelElements = driver.findElements(By.xpath("//td/span[@data-uname='lotsearchLotdamagedescription']"));
        List<String> porscheDamages = porscheModelElements.stream()
                .map(model -> new String(model.getAttribute("innerText"))).sorted().collect(Collectors.toList());

        HashMap<String, Integer> countedList = new HashMap<String, Integer>();
        for(String value : porscheDamages) {
            switch(value){
                case "REAR END":
                    addToCountedList(countedList, "REAR END");
                    break;
                case "FRONT END":
                    addToCountedList(countedList, "FRONT END");
                    break;
                case "MINOR DENT/SCRATCHES":
                    addToCountedList(countedList, "MINOR DENT/SCRATCHES");
                    break;
                case "UNDERCARRIAGE":
                    addToCountedList(countedList, "UNDERCARRIAGE");
                    break;
                default:
                    addToCountedList(countedList, "MISC");
            }
        }
        for(Map.Entry<String, Integer> entry : countedList.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void addToCountedList(HashMap<String, Integer> countedList, String value){
        if(countedList.containsKey(value)){
            countedList.put(value, countedList.get(value) + 1);
        }else{
            countedList.put(value, 1);
        }
    }

}
