package by.bsu.dropbox.step;


import by.bsu.dropbox.driver.Driver;
import by.bsu.dropbox.page.HomePage;
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

    public boolean isLogOuted() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        return (homePage.isLogOuted());
    }

    public boolean isOpenedNotice() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        return (homePage.isOpenedNotice());
    }

    public void openNotice() {
        HomePage homePage = new HomePage(driver);
        homePage.openNotice();
    }

    public void goToRecent() {
        HomePage homePage = new HomePage(driver);
        homePage.goToRecent();
    }

    public boolean isOnRecent(String result) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        System.out.println("homePage.isOnRecent().trim()="+homePage.isOnRecent().trim());
        System.out.println("result="+result);
        return (homePage.isOnRecent().trim().equals(result));
    }

    public void logout() {
        HomePage homePage = new HomePage(driver);
        homePage.logout();

    }

}
