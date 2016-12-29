package by.bsu.dropbox.step;


import by.bsu.dropbox.driver.Driver;
import by.bsu.dropbox.page.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Step {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = Driver.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }

    public void loginDropbox(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        return (!loginPage.getLoggedInUserName().trim().toLowerCase().isEmpty());
    }

    public boolean isFailedLoggedIn(String username) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        return (!loginPage.getFailLoggedInUserName().trim().toLowerCase().isEmpty());
    }

    public boolean selectFile() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        return homePage.isSelectedSuccessfully();
    }

    public boolean deleteFile() throws InterruptedException {
        DeletedPage deletedPage = new DeletedPage(driver);
        deletedPage.openPage();
        
        return deletedPage.isRecoveredFile();
    }

    public boolean goToRecents() throws InterruptedException {
        RecentsPage recentsPage = new RecentsPage(driver);
        recentsPage.openPage()

        return recentsPage.isOnRecentsPage();
    }



}
