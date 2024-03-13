package sda.homeworks.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class Task02 extends TestBase {
    /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!
     */

    @Test
    public void test0(){
        driver.get("https://practicetestautomation.com/practice-test-login/");

    }
    @Test
    public void NegativeUsernameTest(){
        SoftAssert sa = new SoftAssert();

        // Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username incorrectUser into Username field.
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("incorrectUser");

        // Type password Password123 into Password field.
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Password123");

        // Click Submit button.
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

        submitButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']"));
        sa.assertEquals(errorMessage,"Error message is not displayed.");

        // Verify error message text is Your username is invalid!
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();
        sa.assertEquals(actualErrorMessage,expectedErrorMessage);

        sa.assertAll();
    }


}

