package ru.gb.lessons.lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoQABookStoreApplicationTest extends BaseTest{

    @Test
    @DisplayName("LogIn user:ivan password:P@$$w0rd")
    void logInDemoQATest() {
        webDriver.get("https://demoqa.com/login");
        //loginButton1
        webDriver.findElement(By.xpath(".//*[@id='login']")).click();

        //userName
        webDriver.findElement(By.xpath(".//*[@id='userName']")).sendKeys("ivan");

        //password
        webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys("P@$$w0rd");

        //loginButton2
        webDriver.findElement(By.xpath(".//*[@id='login']")).click();

    }

    @Test
    @DisplayName("Find books by word 'java'")
    void findBookDemoQATest() {
        webDriver.get("https://demoqa.com/books");
        webDriver.findElement(By.id("searchBox")).sendKeys("java");
        //.sendKeys("java");

        //basic-addon2 element
        //webDriver.findElement(By.xpath("//*[@id='basic-addon2']")).click();

//        List <WebElement> books = new ArrayList<>();
//        books = webDriver.findElements(By.className("mr-2"));
//        if (books.size() != 0) {
//            books.get(0).click();
//            webDriver.findElement(By.xpath(".//*[contains(text(),'Back To Book Store')]")).click();
//        }
    }

}
