package manager;

import Models.MyListener;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    TeamHelper teamHelper;
    BoardHelper boardHelper;
    HeaderHelper headerHelper;
    UserHelper userHelper;
    String browser = null;
    EventFiringWebDriver ewd = null;
    MyListener eventListener;

    WebDriver wd;
    String username = "globalist72@gmail.com";
    String password = "com.12345";
    String urlSite = "https://trello.com/";

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }
        ewd = new EventFiringWebDriver(wd);
        eventListener = new MyListener();
        ewd.register(eventListener);


        ewd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ewd.manage().window().maximize();
        ewd.get(urlSite);
        login();
        boardHelper = new BoardHelper(wd);
        teamHelper = new TeamHelper(wd);
        headerHelper = new HeaderHelper(wd);
        userHelper = new UserHelper(wd);


    }

    public void stop() throws InterruptedException {
        logout();
        //wd.quit();
    }

    public void click(String selectorString) {
        wd.findElement(By.cssSelector(selectorString)).click();
    }

    public void clear(String selectorString) {
        wd.findElement(By.cssSelector(selectorString)).clear();
    }

    public void type(String selectorString, String string) {
        click(selectorString);
        clear(selectorString);
        wd.findElement(By.cssSelector(selectorString)).sendKeys(string);
    }

    public void login() {
        click("[href='/login']");
        type("[name='user']", username);
        type("[name='password']", password);
        click("[id='login']");
    }

    public void logout() throws InterruptedException {
        headerHelper.clickOnABButtonOnHeader();
        headerHelper.clickOnLinkLogOut();
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public HeaderHelper getHeaderHelper() {
        return headerHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void screenShot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
            System.out.println(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//    WebDriverWait wait2 = new WebDriverWait(driver, 10);
//wait2.until(ExpectedConditions.elementToBeClickable(By.id("navigationPageButton")));

