package by.bsu.dropbox.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Page {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.dropbox.com/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[11]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input")
    private WebElement inputLogin;

    @FindBy(xpath = "/html/body/div[11]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[2]/div[2]/input")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[11]/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/form[1]/div[1]/div[5]/button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "/html/body/div[13]/div/div/ul/li[3]/div/button")
    private WebElement linkLoggedInUser;


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }


    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();

        logger.info("Login performed");
    }

    public String getLoggedInUserName() {
        return linkLoggedInUser.getText();
    }
}
