package com.lazerycode.selenium.tests;

import java.util.List;
import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;




public class AuthenticationIT extends DriverBase {

    @Test(enabled = false)
    public void registration() throws Exception {

        WebDriver driver = getDriver();

        driver.get("http://test.tender.pro");

        driver.findElement(By.xpath(
                        ".//a[text()='Регистрация']"
                )
        ).click();
    }

    @Test
    public void login() throws Exception {
        WebDriver driver = getDriver();

        driver.get(System.getProperty("host"));

        driver.findElement(By.name(
                "usetenderlogin"
            )).sendKeys(System.getProperty("login"));

        driver.findElement(By.name(
                "usetenderpassword"
            )).sendKeys(System.getProperty("password"));

        driver.findElement(By.name(
                "submit")).click();

        List<WebElement> logoutElements = driver.findElements(By.xpath(
                ".//*[@class='logout']"
        ));

        assertEquals(logoutElements.size(), 1, "There is no logout button, seems we are failed to login!");
        System.out.println(logoutElements);
    }
}
