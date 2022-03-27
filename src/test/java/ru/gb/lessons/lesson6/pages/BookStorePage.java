package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends BasePage {

    public BookStorePage (WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://demoqa.com/books");
    }

    public void goToLogin() {
        webDriver.findElement(By.id("login")).click();
        webDriver.switchTo().activeElement();
    }

    public void sentUserName(String userName) {
        webDriver.findElement(By.xpath(".//*[@id='userName']")).sendKeys(userName);
    }

    public void sentPassword(String password) {
        webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
    }

    public void logIn() {
        webDriver.findElement(By.xpath(".//*[@id='login']")).click();
    }

    public void logOut() {
        webDriver.findElement(By.xpath(".//*[contains(text(),'Log out')]")).click();
    }

    public void findBook(String book) {
        WebElement searchBox = webDriver.findElement(By.id("searchBox"));
        searchBox.clear();
        searchBox.sendKeys(book);
        webDriver.findElement(By.xpath(".//*[@id='basic-addon2']")).click();
    }

}
