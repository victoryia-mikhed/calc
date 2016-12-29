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

    @Test(description = "Login to Dropbox")
    public void oneCantLoginDropbox() throws InterruptedException {
        step.loginDropbox(FAKE_USERNAME, PASSWORD);
        Assert.assertTrue(step.isFailedLoggedIn(FAKE_USERNAME));
    }
    
    @Test(description = "Select file")
    public void oneCanSelectFile() throws InterruptedException {
        Assert.assertTrue(step.selectFile());
    }

    @Test(description = "Delete file")
    public void oneCanDeleteFile() throws InterruptedException {
        Assert.assertTrue(step.deleteFile());
    }

    @Test(description = "Navigate to recents page")
    public void oneCanGoToRecentsPage() throws InterruptedException {
        Assert.assertTrue(step.goToRecents());
    }
}
