import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindBook {
    private static WebElement webElement;
    private static List<WebElement> books;

    public FindBook() {
    }

    void searchBook(WebDriver webDriver, String bookName){
        webDriver.get("https://demoqa.com/books");
        setWebElement(webDriver.findElement(By.xpath("//*[@id='searchBox']")));
        webElement.clear();
        webElement.sendKeys(bookName);

        //basic-addon2 element
        setWebElement(webDriver.findElement(By.xpath("//*[@id='basic-addon2']")));
        webElement.click();


        books = webDriver.findElements(By.className("mr-2"));
        if (books.size() != 0) {
            System.out.println("Book list by \'" + bookName + "\':\n");
            for (WebElement we:books) {
                System.out.println("\'" + we.getText() + "\'");
            }
        } else
            System.out.println("\nNo results by \'" + bookName + "\'");
    }

    public static WebElement getWebElement() {
        return webElement;
    }

    public static void setWebElement(WebElement webElement) {
        FindBook.webElement = webElement;
    }
}
