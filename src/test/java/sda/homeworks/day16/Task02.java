package sda.homeworks.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class Task02 extends TestBase {
    @Test
    @Parameters({"username1","password1"})
    public void softAssert03(String username1 ,String password1){
        SoftAssert sa =new SoftAssert();
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username =driver.findElement(By.id("username"));
        username.sendKeys(username1);

        WebElement password =driver.findElement(By.id("password"));
        password.sendKeys(password1);

        WebElement submit =driver.findElement(By.id("submit"));
        submit.click();

        sa.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"),
                "URL doesn't contain the expected text");

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();

        //soft assert
        sa.assertTrue(pageSource.contains("Congratulations") || pageSource.contains("successfully logged in"),
                "Expected text not found on the page");

        //Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));

        //soft assert
        sa.assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed");
        sa.assertAll();


    }
}