package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectablePage extends BasePage {

    public SelectablePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://demoqa.com/sortable");
    }

    public void goToList() {
        webDriver.findElement(By.id("demo-tab-list")).click();
    }

    public void goToGrid() {
        webDriver.findElement(By.id("demo-tab-grid")).click();
    }

    public void clickAllElements() {
        List<WebElement> elements = new ArrayList<>();
            elements = webDriver.findElements(By.className("mt-2 list-group-item active list-group-item-action"));
        if (elements.size() == 0)
            elements = webDriver.findElements(By.className("list-group-item list-group-item-action"));
        if (elements.size() != 0)
        for (WebElement we : elements) {
                we.click();
            }
        }

}
