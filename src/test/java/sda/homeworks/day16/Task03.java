package sda.homeworks.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utilities.TestBase;

public class Task03 extends TestBase {
    @Test
    @Parameters({"username1", "password1"})
    public void softAssert03(String username1, String password1) {
        SoftAssert sa = new SoftAssert();
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(username1);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(password1);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        //Assert part

        WebElement errorMessage = driver.findElement(By.xpath(" //*[@id=\"error\"]"));
        sa.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        String actualErrorMessageUser = errorMessage.getText();
        String expectedErrorMessageUser = "Your username is invalid!";
        sa.assertEquals(actualErrorMessageUser, expectedErrorMessageUser, "Error message text mismatch");

        String actualErrorMessagePassword = errorMessage.getText();
        String expectedErrorMessagePassword = "Your password is invalid!";
        sa.assertEquals(actualErrorMessagePassword, expectedErrorMessagePassword, "Error message text mismatch");


    }
}