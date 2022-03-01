import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Tests {
    static ChromeOptions chromeOptions = new ChromeOptions().addArguments("--blink-settings=imagesEnabled=false");
    private static WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

    public static void main(String[] args) {
        webDriver.get("https://demoqa.com/books");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //UserName:Ivan
        //Passord:P@$$w0rd

       LogInDemoQA test1;
       test1 = new LogInDemoQA();
       test1.logIn(webDriver,"Ivan","P@$$w0rd");
       BuyBook test2 = new BuyBook();
       test2.searchBook(webDriver,"Programming");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.quit();
        System.out.println("Testing is finished.");
    }
}
