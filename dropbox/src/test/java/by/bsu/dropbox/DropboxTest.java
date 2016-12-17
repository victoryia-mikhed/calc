package by.bsu.dropbox;

import by.bsu.dropbox.step.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DropboxTest {
    private Step step;

    private final String USERNAME = "vika_mikhed@mail.ru";
    private final String PASSWORD = "111111qwe";

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

}
