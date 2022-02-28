import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BuyBook {
    ChromeOptions chromeOptions = new ChromeOptions().addArguments("--blink-settings=imagesEnabled=false");
    WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    WebDriverWait wait = new WebDriverWait(webDriver,3000);

    public BuyBook(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BuyBook() {
        setWebDriver("https://demoqa.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public BuyBook(String resource) {
        setWebDriver(resource);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void setWebDriver(String resource) {
        webDriver.get(resource);;
    }

    void buyBook(String bookName){
        WebElement bookStore = webDriver.findElement(By.cssSelector(".category-cards > div:nth-child(6)"));
        bookStore.click();

        WebElement searchBox = webDriver.findElement(By.xpath("//*[@id='searchBox']"));
        searchBox.sendKeys(bookName);

        WebElement searchButton = webDriver.findElement(By.xpath("//*[@id='basic-addon2']"));
        searchButton.click();

        WebElement actionButton = webDriver.findElement(By.cssSelector(".action-buttons"));
        actionButton.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }
}
