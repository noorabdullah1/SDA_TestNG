package sda.homeworks.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class Task03 extends TestBase {
    @Test
    public void negativePasswordTest() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Step 2: Type the username and password
        String username = "student";
        String password = "Passwor";
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Step 3: Click the submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Step 4: Verify the error message
        WebElement errorMessage = driver.findElement(By.id("error"));
        softAssert.assertTrue(errorMessage.isDisplayed());

        softAssert.assertAll();
    }
}