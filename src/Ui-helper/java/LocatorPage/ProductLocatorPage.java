package LocatorPage;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class ProductLocatorPage extends BasePage {
    WebDriver driver;

    public ProductLocatorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']//p[1]")
    public List<WebElement> productName;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']//p[2]")
    public List<WebElement> productValue;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Cart')]")
    public WebElement cartButton;

    @FindBy(how = How.ID, using = "cart")
    public WebElement cartNumberOfAddedItem;

    public By productButtonByName(String productName){
        return By.xpath("//p[contains(text(),'"+productName+"')]//parent::div//button");
    }


}
