package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }
    public void clickOnHomeButtonOnHeader() {

        click("[class='header-btn js-back-menu']");
    }
    public void clickOnBoardsButtonOnHeader() throws InterruptedException {
        Thread.sleep(5000);
        click("[class='header-btn header-boards js-boards-menu']");
    }
    public void clickOnSearchButtonOnHeader() {
        click("[name='search']");

    }
    public void clickOnTrelloLinkOnHeader() {
        click("[href='/']");
    }
    public void clickOnPlusButtonOnHeader() throws InterruptedException {
        Thread.sleep(5000);
        click("[class='header-btn-icon icon-lg icon-add light']");
    }
    public void clickOnInformationButtonOnHeader() {
        click("[name='information']");
    }
    public void clickOnNotificationButtonOnHeader() {
        click("[name='notification']");
    }

    public void clickOnABButtonOnHeader() throws InterruptedException {
        Thread.sleep(5000);
        click("[class='header-btn header-avatar js-open-header-member-menu']");
    }

    public void clickOnLinkLogOut() {
        click("[class='js-logout']");
    }

    public boolean isElementPresent(String selectorString) throws InterruptedException {
        WebElement element = findElement(selectorString);
        if(element != null){
            return true;
        }
        return false;
    }
//    public boolean isElementPresent(String selectorString) throws InterruptedException {
//        try {
//            findElement(selectorString);
//            return true;
//        } catch (NoSuchElementException err) {
//            return false;
//        }
//    }


    public List<WebElement> findElements(String selectorString) {
        return wd.findElements(By.cssSelector(selectorString));
    }
}
