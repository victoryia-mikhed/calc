package by.bsu.dropbox.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Page {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.dropbox.com/home";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[14]/div[2]/div[7]/div/main/div[2]/div[1]/ul/li[1]")
    private WebElement fileLink;

    @FindBy(xpath = "/html/body/div[13]/div/div/ul/li[3]/div/button")
    private WebElement showLogin;

    @FindBy(xpath = "/html/body/div[13]/div/div/ul/li[3]/div/div/div[1]/ul/li[5]/a")
    private WebElement logOut;


    @FindBy(xpath = "/html/body/div[11]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[5]/button")
    private WebElement enterButton;


    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[1]")
    private WebElement noticeText;


    @FindBy(xpath = "/html/body/div[12]/div/div/ul/li[2]/div/div/div/button")
    private WebElement noticeButton;


    @FindBy(xpath = "/html/body/div[14]/div[1]/ul/li[1]/a/span/div/div[2]/div")
    private WebElement recentLink;


    @FindBy(xpath = "/html/body/div[12]/div[2]/div[3]/div[1]")
    private WebElement recent;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Home page opened");
    }


    public void logout() {
        showLogin.click();
        logOut.click();
        logger.info("Logout");

    }


    public void goToRecent() {
        recentLink.click();
        logger.info("Moved to Recent");

    }

    public void openNotice() {
        noticeButton.click();
        logger.info("Logout");
    }

    public boolean isOpenedNotice() throws InterruptedException {
        Thread.sleep(3000);
        return !noticeText.getText().isEmpty();
    }

    public boolean isLogOuted() {
        return !enterButton.getText().isEmpty();
    }

    public String isOnRecent() {
        return recent.getText();
    }

}
