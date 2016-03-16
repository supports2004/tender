package com.lazerycode.selenium.tests;

import java.util.List;
import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

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

        driver.get("http://test.tender.pro");

        // Find the text input element by its name

        driver.findElement(By.name(
                "usetenderlogin"
            )).sendKeys("login259");

        driver.findElement(By.name(
                "usetenderpassword"
            )).sendKeys("BU8YGU6");

        driver.findElement(By.name(
                "submit")).click();

        List<WebElement> logoutElements = driver.findElements(By.xpath(
                ".//*[@class='logout']"
        ));

        assertEquals(logoutElements.size(), 1);
        System.out.println(logoutElements);
    }
}
