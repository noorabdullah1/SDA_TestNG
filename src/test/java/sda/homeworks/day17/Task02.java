package sda.homeworks.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.utilities.TestBase;

public class Task02 extends TestBase {
//    Go to URL: http://crossbrowsertesting.github.io/todoapp.html
//    Checking Box todo-4 and Checking Box todo-5
//     If both clicks worked, then the following List should be have length 2.
//     Assert that this is correct
//    Assert that the todo we added is present in the list
//    Archiving old todos
//    If our archive link worked, then the following list should have length 4.
//    Assert that this is true as well
//    Doing Cross Browser Testing.

        @Test
        public void test01(){
            //    Go to URL: http://crossbrowsertesting.github.io/todoapp.html
            driver.get("https://crossbrowsertesting.github.io/todo-app.html");
            //    Checking Box todo-4 and Checking Box todo-5
            WebElement four =driver.findElement(By.xpath("//input[@name=\"todo-4\"]"));
            WebElement five =driver.findElement(By.xpath("//input[@name=\"todo-5\"]"));
            four.click();
            five.click();
           //     If both clicks worked, then the following List should be have length 2.
            Assert.assertEquals(driver.findElements(By.xpath("//span[@class=\"done-true\"]")).size(), 2);

            String asd = "sdfg";
            driver.findElement(By.id("todotext")).sendKeys(asd+ Keys.ENTER);
            Assert.assertFalse(driver.findElements(By.xpath("//*[contains(text(),'" + asd + "')]")).isEmpty());

            driver.findElement(By.xpath("//a[contains(text(),'archive')]")).click();

            // Assertion for length of list after archiving todos
            Assert.assertEquals(driver.findElements(By.xpath("//span[@class=\"done-true\"]")).size(), 0);


        }
    }
