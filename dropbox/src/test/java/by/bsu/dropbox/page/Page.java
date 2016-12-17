package by.bsu.dropbox.page;

import org.openqa.selenium.WebDriver;


public abstract class Page {


    protected WebDriver driver;

    public abstract void openPage();

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
