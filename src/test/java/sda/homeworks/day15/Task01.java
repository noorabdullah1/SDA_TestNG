package sda.homeworks.day15;

import sda.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task01 extends TestBase {

    @Test
    public void positiveLoginTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Step 2: Type the username and password
        String username = "student";
        String password = "Password123";
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Step 3: Click the submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Step 4: Verify the new page URL
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        softAssert.assertTrue(actualURL.contains(expectedURL), "New page URL does not contain the expected URL.");

        // Step 5: Verify the expected text on the new page
        String expectedText = "Congratulations";
        String actualText = driver.findElement(By.tagName("body")).getText();
        softAssert.assertTrue(actualText.contains(expectedText) || actualText.contains("successfully logged in"),
                "New page does not contain the expected text.");

//        // Step 6: Verify the presence of the logout button
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div"));
        softAssert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed");

        softAssert.assertAll();
    }

    @Test
    public void positiveLoginTestHardAss() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Step 2: Type the username and password
        String username = "student";
        String password = "Password123";
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Step 3: Click the submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Step 4: Verify the new page URL
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL), "New page URL does not contain the expected URL.");

        // Step 5: Verify the expected text on the new page
        String expectedText = "Congratulations";
        String actualText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(actualText.contains(expectedText) || actualText.contains("successfully logged in"),
                "New page does not contain the expected text.");

        // Step 6: Verify the presence of the logout button
        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed on the new page.");
    }
}