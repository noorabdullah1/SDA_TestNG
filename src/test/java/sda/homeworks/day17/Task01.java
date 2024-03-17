package sda.homeworks.day17;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sda.utilities.TestBase;


public class Task01 extends TestBase {
//    Open the site: http://opencart.abstracta.us/index.php?route=account/login
//    Login with that credentials
//    Email: clarusway@gmail.com
//    Password: 123456789
//    Using the Search function do it with Data Provider for Mac, iPad and Samsung

        @Test(dataProvider = "searchQueries")
        public void searchProduct(String searchQuery) {
            //Open the site: http://opencart.abstracta.us/index.php?route=account/login
            driver.get("http://opencart.abstracta.us/index.php?route=account/login");

            //Login with that credentials
            //Email: clarusway@gmail.com , Password: 123456789
            driver.findElement(By.id("input-email")).sendKeys("clarusway@gmail.com");
            driver.findElement(By.id("input-password")).sendKeys("123456789");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            // Search for the product
            driver.findElement(By.name("search")).sendKeys(searchQuery);
            driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']")).click();

        }
        @DataProvider(name = "searchQueries")
        public Object[][] searchQueriesProvider() {
            return new Object[][]{
                    {"Mac"},
                    {"iPad"},
                    {"Samsung"}
            };
        }
    }

