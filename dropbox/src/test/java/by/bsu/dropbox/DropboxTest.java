package by.bsu.dropbox;

import by.bsu.dropbox.step.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DropboxTest {
    private Step step;

    private final String USERNAME = "vika_mikhed@mail.ru";
    private final String PASSWORD = "111111qwe";
    private final String FAKE_USERNAME = "unreal@mail.ru";
    private final String LAST_USED_FILE = "Последние";


    @BeforeMethod(description = "Init browser")
    public void setUp() {
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "Login to Dropbox")
    public void oneCanLoginDropbox() throws InterruptedException {
        step.loginDropbox(USERNAME, PASSWORD);
        Assert.assertTrue(step.isLoggedIn(USERNAME));
    }

    @Test(description = "Bad Login to Dropbox")
    public void oneCantLoginDropbox() throws InterruptedException {
        step.loginDropbox(FAKE_USERNAME, PASSWORD);
        Assert.assertTrue(step.isFailedLoggedIn(FAKE_USERNAME));
    }


    @Test(description = "Logout")
    public void oneCanLogout() throws InterruptedException {
        oneCanLoginDropbox();
        step.logout();
        Assert.assertTrue(step.isLogOuted());
    }


    @Test(description = "Open notice")
    public void oneCanOpenNotice() throws InterruptedException {
        oneCanLoginDropbox();
        Thread.sleep(2000);
        step.openNotice();
        Assert.assertTrue(step.isOpenedNotice());

    }

    @Test(description = "Open notice")
    public void oneCanGoToRecent() throws InterruptedException {
        oneCanLoginDropbox();
        Thread.sleep(2000);
        step.goToRecent();
        Thread.sleep(2000);

        Assert.assertTrue(step.isOnRecent(LAST_USED_FILE));

    }

}
