package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @CacheLookup
    @FindBy(how = How.XPATH, using = ("(//*[contains(text(),' My account')])[2]"))
    public WebElement myAccount;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//*[@class='icon-left both dropdown-item active']"))
    public WebElement login;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-email"))
    public WebElement email;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-password"))
    public WebElement password;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//input[@type='submit']"))
    public WebElement submit;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickMyAccount() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        Actions action = new Actions(driver);
        action.moveToElement(myAccount).perform();
        myAccount.click();
//        wait.until(ExpectedConditions.elementToBeClickable(login));
//        login.click();
        wait.until(ExpectedConditions.visibilityOf(email));
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.sendKeys("nidamaqsood553@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(password));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("testola");
        wait.until(ExpectedConditions.visibilityOf(submit));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        Thread.sleep(5000);
    }

}
