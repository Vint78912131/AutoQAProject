import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class bookStore {
    private static WebElement webElement;
    private static List<WebElement> books;

    public bookStore() {
    }

    void searchBook(WebDriver webDriver, String bookName){
        setWebElement(webDriver.findElement(By.xpath("//*[@id='searchBox']")));
        webElement.sendKeys(bookName);

        //basic-addon2 element
        setWebElement(webDriver.findElement(By.xpath("//*[@id='basic-addon2']")));
        webElement.click();


        books = webDriver.findElements(By.className("mr-2"));
        if (books.size() != 0) {
            //action-buttons element
            setWebElement(books.get(0));
            //setWebElement(webDriver.findElement(By.cssSelector(".action-buttons")));
            webElement.click();
        }

    }

    public static WebElement getWebElement() {
        return webElement;
    }

    public static void setWebElement(WebElement webElement) {
        bookStore.webElement = webElement;
    }
}
