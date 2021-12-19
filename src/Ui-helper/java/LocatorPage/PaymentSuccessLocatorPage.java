package LocatorPage;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class PaymentSuccessLocatorPage extends BasePage {

    WebDriver driver;

    public PaymentSuccessLocatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".justify-content-center h2")
    public WebElement paymentSuccessText;

    @FindBy(how = How.CSS, using = ".text-justify")
    public WebElement paymentSuccessMessageText;
}
