package BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,60);
        this.actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollDown(){
        javascriptExecutor.executeScript("window.scrollBy(0,250)", "");
    }

    public void moveToElement(WebElement element){
        actions.moveToElement(element);
    }

    public WebElement waitForElementToBeVisible(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForElementToBeVisible(List<WebElement> element) {

        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(By element) {

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForPresenceOfElement(By element) {

        return  wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForTestToBePresent(WebElement element,String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void sleep(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
