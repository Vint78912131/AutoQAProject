import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Tests {
    static ChromeOptions chromeOptions = new ChromeOptions().addArguments("--blink-settings=imagesEnabled=false");
    private static WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

    public static void main(String[] args) {
       webDriver.get("https://demoqa.com/");
       webDriver.manage().window().maximize();
       webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       User ivan = new User("Ivan","Ivanov","Ivan","P@$$w0rd");
       LogInDemoQA test1;
       test1 = new LogInDemoQA();
       test1.logIn(webDriver,ivan.getUserName(),ivan.getPassword());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       test1.logOut(webDriver);

//       User newUser = new User("Pasha","Pavlov","pavlik","P@$$w0rd");
//
//       AddNewUser test2 = new AddNewUser(newUser);
//       test2.addUser(webDriver);

       FindBook test3 = new FindBook();
       test3.searchBook(webDriver,"Java");
       try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       test3.searchBook(webDriver,"book");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        webDriver.quit();
        System.out.println("\nTesting is finished.");
    }
}
