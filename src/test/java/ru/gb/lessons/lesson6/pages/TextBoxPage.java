package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TextBoxPage extends BasePage{

    public TextBoxPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://demoqa.com/text-box");
    }


    public void sentUserName(String userName) {
        webDriver.findElement(By.id("userName")).sendKeys(userName);
    }

    public void sentUserEmail(String userEmail) {
        webDriver.findElement(By.id("userEmail")).sendKeys(userEmail);
    }

    public void sentCurrentAddress(String currentAddress) {
        webDriver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
    }

    public void sentPermanentAddress(String permanentAddress) {
        webDriver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
    }

    public void clickSubmitButton() {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                ,webDriver.findElement(By.id("submit")));
        webDriver.findElement(By.id("submit")).click();
    }
}
