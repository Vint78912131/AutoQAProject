package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {

    public RadioButtonPage (WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://demoqa.com/radio-button");
    }

    public void clickYesButton() {
        webDriver.findElement(By.xpath(".//*[@for='yesRadio']")).click();
    }

    public void clickImpressiveButton() {
        webDriver.findElement(By.xpath(".//*[@for='impressiveRadio']")).click();
    }
}
