import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BuyBook {
    private static WebElement webElement;

    public BuyBook() {
        //new BuyBook("https://demoqa.com/books");
    }

//    public BuyBook(String resource) {
//        setWebDriver(resource);
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//    }
//
//    public void setWebDriver(String resourse) {
//        webDriver.get(resourse);
//    }

    void searchBook(WebDriver webDriver, String bookName){
//        WebElement bookStore = webDriver.findElement(By.cssSelector(".category-cards > div:nth-child(6)"));
//        bookStore.click();

        //searchBox element
        setWebElement(webDriver.findElement(By.xpath("//*[@id='searchBox']")));
        webElement.sendKeys(bookName);

        //basic-addon2 element
        setWebElement(webDriver.findElement(By.xpath("//*[@id='basic-addon2']")));
        webElement.click();

        //action-buttons element
        setWebElement(webDriver.findElement(By.cssSelector(".action-buttons")));
        //wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public static WebElement getWebElement() {
        return webElement;
    }

    public static void setWebElement(WebElement webElement) {
        BuyBook.webElement = webElement;
    }
}
