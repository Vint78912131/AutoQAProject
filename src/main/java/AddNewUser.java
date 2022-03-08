import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewUser {
    private static WebElement webElement;
    private User user;

    public AddNewUser(User user) {
        this.user = user;
    }

    public void addUser(WebDriver webDriver) {
        webDriver.get("https://demoqa.com/login");

        //NewUserButton
        setWebElement(webDriver.findElement(By.xpath("//*[contains(text(),'New User')]")));
        webElement.click();

        //FirstName field
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='firstname']")));
        webElement.sendKeys(user.getFirstName());

        //LastName field
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='lastname']")));
        webElement.sendKeys(user.getLastName());

        //UserName field
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='userName']")));
        webElement.sendKeys(user.getUserName());

        //password field
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='password']")));
        webElement.sendKeys(user.getPassword());

        //captcha check-box
        setWebElement(webDriver.findElement(By.xpath(".//*[@class='recaptcha-checkbox-checkmark']")));
//        Actions act = new Actions(webDriver);
//        act.moveToElement(getWebElement());
//        act.click(webElement);
        webElement.click();

        //register button
        setWebElement(webDriver.findElement(By.xpath(".//*[@id='register']")));
        webElement.click();

    }

    public static WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }
}
