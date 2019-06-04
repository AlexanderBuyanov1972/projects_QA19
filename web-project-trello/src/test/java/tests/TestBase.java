package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestBase{
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));
    @BeforeMethod
    public void logTestStart(Method method, Object[] obj){
        logger.info("Start test" + method.getName() + " with parameters "+ Arrays.asList(obj));
    }
    @AfterMethod
    public void logTestStop(Method method){
        logger.info("Stop test" + method.getName());
    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.start();
    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        app.stop();
    }
    public ApplicationManager getApp() {
        return app;
    }

    public void deleteOneFirstPersonalBoards() throws InterruptedException {
        app.getBoardHelper().clickOnFirstPersonalBoard();
        app.getBoardHelper().clickOnButtonMore();
        app.getBoardHelper().clickOnButtonCloseBoard();
        app.getBoardHelper().clickOnButtonClose();
        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
    }

    public void deleteOneFirstTeamBoards() {
        app.getBoardHelper().clickOnFirstTeamBoard();
        app.getBoardHelper().clickOnSettingTeamBoard();
        app.getBoardHelper().clickOnLinkDeleteThisTeamBoard();
        app.getBoardHelper().clickOnButtonDeleteForever();

    }

    public boolean isElementsPresent(String selectorString){
        return  findElements(selectorString).size()>0;
    }

    private List<WebElement> findElements(String selectorString) {
        return app.getHeaderHelper().findElements(selectorString);
    }


    public boolean isOnTheHomePage(String selectorString){
        return isElementsPresent(selectorString);
    }
}
