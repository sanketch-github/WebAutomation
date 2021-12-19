package LocatorPage;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class CheckoutLocatorPage extends BasePage {
    WebDriver driver;

    public CheckoutLocatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "total")
    public WebElement totalAmount;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Pay with Card')]//parent::button")
    public WebElement payWithCardButton;

    @FindBy(how = How.CSS, using = ".emailInput")
    public WebElement paymentPopUpEmailField;

    @FindBy(how = How.ID, using = "email")
    public WebElement paymentPopUpEmailTextTestField;

    @FindBy(how = How.ID, using = "card_number")
    public WebElement paymentPopUpCardTextField;

    @FindBy(how = How.CSS, using = ".emailInput")
    public WebElement paymentPopUpCardField;

    @FindBy(how = How.ID, using = "cc-exp")
    public WebElement paymentPopUpDateTextField;

    @FindBy(how = How.CSS, using = ".emailInput")
    public WebElement paymentPopUpDateField;

    @FindBy(how = How.ID, using = "cc-csc")
    public WebElement paymentPopUpCVCTextField;

    @FindBy(how = How.CSS, using = ".emailInput")
    public WebElement paymentPopUpCVCField;

    @FindBy(how = How.ID, using = "billing-zip")
    public WebElement paymentPopUpZipCodeTextField;

    @FindBy(how = How.CSS, using = ".emailInput")
    public WebElement paymentPopUpZipCodeField;

    @FindBy(how = How.CLASS_NAME, using = "iconTick")
    public WebElement paymentButton;

    @FindBy(how = How.XPATH, using = "//td[1]")
    public List<WebElement> productNameList;

    @FindBy(how = How.XPATH, using = "//td[2]")
    public List<WebElement> productPrizeList;
}
