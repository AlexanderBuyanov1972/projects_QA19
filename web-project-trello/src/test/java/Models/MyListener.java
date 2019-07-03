package Models;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.TestBase;

public class MyListener  extends AbstractWebDriverEventListener {
    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));

    private Logger logger = LoggerFactory.getLogger(TestBase.class);


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Start to search element "+by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        app.screenShot();
        logger.error("!!!!!!!------------------------ERROR---------------------------!!!!!!!" + throwable);
    }
}
