package ru.gb.lessons.lesson5;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UploadFileTest extends BaseTest {

    @SneakyThrows
    @Test
    void uploadFileTest() throws InterruptedException {
        webDriver.get("http://the-internet.herokuapp.com/upload");
        webDriver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("/Users/sotnikov/IdeaProjects/AutoQAProject/src/test/resources/logback.xml");
        Thread.sleep(5000);
    }
}
