package LocatorPage;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class HomeLocatorPage extends BasePage {
    WebDriver driver;

    public HomeLocatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "temperature")
    public WebElement currentTemperatureBox;

    @FindBy(how = How.XPATH, using = "//span[@data-original-title='Your task']")
    public WebElement yourTaskIcon;

    @FindBy(how = How.XPATH, using = "//a[@href='/moisturizer']//button")
    public WebElement buyMoisturizerButton;

    @FindBy(how = How.XPATH, using = "//a[@href='/sunscreen']//button")
    public WebElement buySunscreenButton;

    @FindBy(how = How.XPATH, using = "//span[@class='popover-body']")
    public WebElement youTaskTextBox;
}
