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
	private final String XPATH = "/html/body/div[14]/div[2]/div[7]/div/main/div[1]";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/div[14]/div[2]/div[7]/div/main/div[2]/div[1]/ul/li[1]")
    private WebElement fileLink;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Home page opened");
    }


    public void select() {
        fileLink.click();

        logger.info("File selected");
    }

	//checks if element with buttons exists
    public String isSelectedSuccessfully(Webdriver driver) {
        if (!driver.findElement(By.xpath(XPATH)).isEmpty()) {
			return true;
		}
		else {
			return false;
		}
    }

}
