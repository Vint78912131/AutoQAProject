package ru.gb.lessons.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginAndLogoutTest extends BaseTest {

    @Test
    void loginAndLogout() {
        webDriver.get("https://pop-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")).click();

//        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(authPopupLocator));

        WebElement authPopup = webDriver.findElement(By.xpath("//div[@class='popup-login__tab is-active']"));
        authPopup.findElement(By.name("USER_LOGIN")).sendKeys("autosupertravel@yandex.ru");
        authPopup.findElement(By.name("USER_PASSWORD")).sendKeys("12345678");
        authPopup.findElement(By.xpath(".//button[span[text()='Войти']]")).click();
        webDriver.findElement(By.cssSelector("div.header__user")).click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()='Выйти']"))))
                .click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")));
    }

    @Test
    void incorrectPasswordTest() {
        webDriver.get("https://pop-music.ru/");
        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")).click();

        WebElement authPopup = webDriver.findElement(By.xpath("//div[@class='popup-login__tab is-active']"));
        authPopup.findElement(By.name("USER_LOGIN")).sendKeys("autosupertravel@yandex.ru");
        authPopup.findElement(By.name("USER_PASSWORD")).sendKeys("incorrect_password");
        authPopup.findElement(By.xpath(".//button[span[text()='Войти']]")).click();
        assertThat(new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='errortext']")))
                .getText()).as("Был указан некорректный пароль").isEqualTo("Неверный логин или пароль.");
    }
}
