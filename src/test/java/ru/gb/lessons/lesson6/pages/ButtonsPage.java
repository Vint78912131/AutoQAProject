package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ButtonsPage extends BasePage{
    Actions act;

    public ButtonsPage (WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://demoqa.com/buttons");
        act = new Actions(webDriver);
    }

    public void clickDoubleClickButton() {
        act.doubleClick(webDriver.findElement(By.id("doubleClickBtn"))).perform();
    }

    public void clickRightClickBtn() {
        act.contextClick(webDriver.findElement(By.id("rightClickBtn"))).perform();
    }

    public void clickSimpleClickBtn() {
        List<WebElement> buttons = webDriver.findElements(By.xpath(".//*[@class='btn btn-primary']"));
        act.click(buttons.get(2));
    }

}
