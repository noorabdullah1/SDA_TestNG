package sda.homeworks.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sda.utilities.TestBase;

public class Task01 extends TestBase {
    @Test
    @Parameters("search1")
    public void test1(String search1) {
        driver.get("https://www.google.com");

        // Perform the search
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(search1);
        searchBox.submit();
    }
    @Test
    @Parameters("search2")
    public void test2(String search2) {
        driver.get("https://www.google.com");

        // Perform the search
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(search2);
        searchBox.submit();

    }
//@Test
//@Parameters("KeyWord")
//public void javaTest(String KeyWord){
//    //Go to URL: https://www.google.com
//    driver.get("https://www.google.com");
//
//    //Search words: Java
//    WebElement searchBox = driver.findElement(By.name("q"));
//    searchBox.sendKeys(KeyWord+ Keys.ENTER);
//
//    //Assert get text result est that the result text contains the searched Word.
//    WebElement searchResults = driver.findElement(By.id("search"));
//    String searchResultsText = searchResults.getText();
//    Assert.assertTrue(searchResultsText.contains(KeyWord), "Search results not contain "+KeyWord);
//}
}