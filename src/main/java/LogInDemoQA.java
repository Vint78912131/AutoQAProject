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
        //loginButton1
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='login']")));
        webElement.click();

        //userName
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='userName']")));
        webElement.sendKeys(userName);

        //password
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='password']")));
        webElement.sendKeys(password);

        //loginButton2
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='login']")));
        webElement.click();
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
