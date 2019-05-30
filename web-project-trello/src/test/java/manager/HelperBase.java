package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    //method find element
    public WebElement findElement(String selectorString) {
        return wd.findElement(By.cssSelector(selectorString));
    }

    //method find all elements
    public List<WebElement> findAllElements(String selectorString) {
        return wd.findElements(By.cssSelector(selectorString));
    }

    // method click
    public void click(String selectorString) {
        findElement(selectorString).click();
    }

    // method clear
    public void clear(String selectorString) {
        findElement(selectorString).clear();
    }

    // method type
    public void type(String selectorString, String text) {

        click(selectorString);
        clear(selectorString);
        findElement(selectorString).sendKeys(text);

    }

    //прикрепить какой-нибудь файл
    public void attach(String selectorString, File photo) {
        if (photo != null) {
            findElement(selectorString).sendKeys(photo.getAbsolutePath());
        }
    }

    // method isElementPresent
    public boolean isElementPresent(String selectorString) throws InterruptedException {
        return findAllElements(selectorString).size() > 0;
    }

    // method wail for element
    public void waitForElement(long timeout, String selectorString) {
        WebDriverWait wait = new WebDriverWait(wd, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectorString)));
    }

    public void refresh() {
        wd.navigate().refresh();
    }
}
