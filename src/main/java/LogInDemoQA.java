import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogInDemoQA {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

        webDriver.get("https://demoqa.com/");
        webDriver.manage().window().setSize(new Dimension(1100, 1000));
//      webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //site https://demoqa.com/
        //banner //*[@class='home-banner']

//        WebElement banner = webDriver.findElement(By.xpath("//*[@class='home-banner']"));
//
//        Actions act = new Actions(webDriver);
//        act.moveToElement(banner).click();


//        webDriver.findElement(By.xpath("//*[@class='home-banner']/a")).click();

        WebElement bookStore = webDriver.findElement(By.xpath("//*[contains(text(),'Book Store Application')]/.."));
        WebElement elements = webDriver.findElement(By.xpath("//*[contains(text(),'Elements')]/.."));
        WebElement forms = webDriver.findElement(By.xpath("//*[contains(text(),'Forms')]/../.."));

        Actions act = new Actions(webDriver);
        act.moveToElement(forms).click(forms);
//        act.build();
//        act.release(forms);

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }

//        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(authPopupLocator));

//        WebElement authPopup = webDriver.findElement(By.xpath("//div[@class='popup-login__tab is-active']"));
//        authPopup.findElement(By.name("USER_LOGIN")).sendKeys("autosupertravel@yandex.ru");
//        authPopup.findElement(By.name("USER_PASSWORD")).sendKeys("12345678");
//        authPopup.findElement(By.xpath(".//button[span[text()='Войти']]")).click();
//        webDriver.findElement(By.cssSelector("div.header__user")).click();
//        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//a[text()='Выйти']"))))
//                .click();
//        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header__links']//a[div[text()='Войти']]")));
//

        webDriver.quit();

        System.out.println("Done!");
    }
}
