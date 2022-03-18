package ru.gb.lessons.lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //logOut
        webDriver.findElement(By.xpath(".//*[contains(text(),'Log out')]")).click();


    }

    @Test
    @DisplayName("Find books by word 'java'")
    void findBookDemoQATest() {
        webDriver.get("https://demoqa.com/books");
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.findElement(By.id("searchBox")).sendKeys("java");

        //basic-addon2 element
        webDriver.findElement(By.xpath(".//*[@id='basic-addon2']")).click();

        List <WebElement> books = new ArrayList<>();
        books = webDriver.findElements(By.className("mr-2"));
        if (books.size() != 0) {
            System.out.println("All books by word 'java':");
            for (WebElement we : books) {
                System.out.println(we.getText());
            }
            books.get(0).click();
            webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            webDriver.findElement(By.xpath(".//*[contains(text(),'Back To Book Store')]")).click();
            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
    }

    @Test
    @DisplayName("Select all elements")
    void selectElementsDemoQATest() {
        webDriver.get("https://demoqa.com/selectable");
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List <WebElement> elements = new ArrayList<>();
        elements = webDriver.findElements(By.className("mt-2 list-group-item active list-group-item-action"));
        if (elements.size() != 0) {
            for (WebElement we : elements) {
                we.click();
            }
        }
    }



    @Test
    @DisplayName("Send keys test")
    void sendKeysDemoQATest() {
        webDriver.get("https://demoqa.com/text-box");
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.findElement(By.id("userName")).sendKeys("Feodor Alibabaevich");
        webDriver.findElement(By.id("userEmail")).sendKeys("gentlemensOfGoodLuck@gmail.com");
        webDriver.findElement(By.id("currentAddress")).sendKeys("г. Москва, ул. Тверская, д.1, кв.1");
        webDriver.findElement(By.id("permanentAddress")).sendKeys("г. Тверь, ул. Московская, д.1, кв.1");
        webDriver.findElement(By.id("submit")).click();
    }



    @Test
    @DisplayName("Radio button test")
    void radioButtonDemoQATest() {
        webDriver.get("https://demoqa.com/radio-button");
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath(".//*[@for='yesRadio']")).click();
        webDriver.findElement(By.xpath(".//*[@for='impressiveRadio']")).click();
        webDriver.findElement(By.xpath(".//*[@for='yesRadio']")).click();
        webDriver.findElement(By.xpath(".//*[@for='impressiveRadio']")).click();
    }


    @Test
    @DisplayName("Web table test")
    void webTableDemoQATest() {
        webDriver.get("https://demoqa.com/webtables");
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.findElement(By.id("addNewRecordButton")).click();

        webDriver.switchTo().activeElement();
        webDriver.findElement(By.id("firstName")).sendKeys("Pavlik");
        webDriver.findElement(By.id("lastName")).sendKeys("Morozov");
        webDriver.findElement(By.id("userEmail")).sendKeys("funnyStories@gmail.com");
        webDriver.findElement(By.id("age")).sendKeys("21");
        webDriver.findElement(By.id("salary")).sendKeys("3000");
        webDriver.findElement(By.id("department")).sendKeys("QA department");
        webDriver.findElement(By.id("submit")).click();

        webDriver.switchTo().activeElement();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
