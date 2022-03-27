package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends BasePage{
    public WebTablesPage (WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://demoqa.com/webtables");
    }

    public void clickAddButton() {
        webDriver.findElement(By.id("addNewRecordButton")).click();
        webDriver.switchTo().activeElement();
    }

    public void sentFirstName(String firstName) {
        webDriver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    public void sentLastName(String lastName) {
        webDriver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    public void sentUserEmail(String userEmail) {
        webDriver.findElement(By.id("userEmail")).sendKeys(userEmail);
    }

    public void sentAge(String age) {
        webDriver.findElement(By.id("age")).sendKeys(age);
    }

    public void sentSalary(String salary) {
        webDriver.findElement(By.id("salary")).sendKeys(salary);
    }

    public void sentDepartment(String department) {
        webDriver.findElement(By.id("department")).sendKeys(department);
    }

    public void clickSubmitButton() {
        webDriver.findElement(By.id("submit")).click();
    }

}
