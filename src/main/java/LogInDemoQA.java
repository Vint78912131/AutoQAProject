import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogInDemoQA {
    ChromeOptions chromeOptions = new ChromeOptions().addArguments("--blink-settings=imagesEnabled=false");
    WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
    WebDriverWait wait = new WebDriverWait(webDriver,3000);

    void logIn(String userName, String password){
        WebElement bookStore = webDriver.findElement(By.cssSelector(".category-cards > div:nth-child(6)"));
        bookStore.click();

        WebElement loginButton1 = webDriver.findElement(By.xpath(".//*[@id='login']"));
        wait.until(ExpectedConditions.visibilityOf(loginButton1));
        loginButton1.click();

        WebElement uN = webDriver.findElement(By.xpath(".//*[@id='userName']"));
        uN.sendKeys(userName);

        WebElement pW = webDriver.findElement(By.xpath(".//*[@id='password']"));
        pW.sendKeys(password);

        WebElement loginButton2 = webDriver.findElement(By.xpath(".//*[@id='login']"));
        wait.until(ExpectedConditions.visibilityOf(loginButton2));
        loginButton2.click();

//        if (webDriver.findElement(By.xpath("//*[@class='mb-1']")).isEnabled())
//            System.out.println("Invalid username or password!");
//        else
//            System.out.println("Logging in user \'" + userName + "\' has been done!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    public LogInDemoQA() {
        setWebDriver("https://demoqa.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public LogInDemoQA(String resource) {
        setWebDriver(resource);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void setWebDriver(String resource) {
        webDriver.get(resource);;
    }

}
