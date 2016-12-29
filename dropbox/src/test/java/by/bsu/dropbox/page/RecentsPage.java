package by.bsu.dropbox.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RecentsPage extends Page {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.dropbox.com/home";
	private final String XPATH = "/html/body/div[13]/div[1]/ul/li[1]/a/span/div/div[2]/div";

    public RecentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = XPATH)
    private WebElement recents;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Home page opened");
    }


	//checks if color of the Recents link changed to #3D464D
    public boolean isOnRecentsPage() {
        
        recents.click();
        logger.info("Url changed to https://www.dropbox.com/recents");
        if (driver.findElement(By.xpath(XPATH)).getCssValue("color") == "#3D464D") {
			return true;
		}
		else {
			return false;
		}
    }

}
