import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogInDemoQA {

    private static WebElement webElement;

    void logIn(WebDriver webDriver, String userName, String password){
//        WebElement bookStore = webDriver.findElement(By.cssSelector(".category-cards > div:nth-child(6)"));
//        wait.until(ExpectedConditions.visibilityOf(bookStore));
//        System.out.println("book store is visible");
//        bookStore.click();

        //loginButton1
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='login']")));
        new WebDriverWait(webDriver,3000).until(ExpectedConditions.visibilityOf(webElement));
        System.out.println("loginButton1 is visible");
        webElement.click();

        //userName
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='userName']")));
        System.out.println("userName is written");
        webElement.sendKeys(userName);

        //password
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='password']")));
        System.out.println("password is written");
        webElement.sendKeys(password);

        //loginButton2
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='login']")));
        new WebDriverWait(webDriver,3000).until(ExpectedConditions.visibilityOf(webElement));
        System.out.println("loginButton2 is visible");
        webElement.click();

//        if (webDriver.findElement(By.xpath("//*[@class='mb-1']")).isEnabled())
//            System.out.println("Invalid username or password!");
//        else
//            System.out.println("Logging in user \'" + userName + "\' has been done!");
    }

    public LogInDemoQA() {
    }

    public WebElement getWebElement() {
        return webElement;
    }
    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

}
