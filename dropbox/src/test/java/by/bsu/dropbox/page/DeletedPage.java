package by.bsu.dropbox.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class DeletedPage extends Page {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.dropbox.com/home";
	private final String DELETED_XPATH = "/html/body/div[13]/div[1]/ul/li[10]/a/span/div/div[2]/div";

    public DeletedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = DELETED_XPATH)
    private WebElement deletedLink;
	
	
	@FindBy(xpath = "/html/body/div[13]/div[2]/div[3]/div[1]/div[1]/table/tbody/tr/td[2]")
	private WebElement fileToRecover;
	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div[2]/button[2]")
	private WebElement recoverBtn;

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Home page opened");
    }

	
	//selects file to be recovered then click recover button
	public boolean isRecoveredFile() {
		deletedLink.click();
        logger.info("Url changed to https://www.dropbox.com/deleted_files");
		
		fileToRecover.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		recoverBtn.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		if (driver.getCurrentUrl() == "https://www.dropbox.com/home") {
			return true;
		}
		else {
			return false;
		}
	}

}
