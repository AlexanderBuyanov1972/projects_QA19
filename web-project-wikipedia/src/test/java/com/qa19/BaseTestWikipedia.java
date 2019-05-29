package com.qa19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestWikipedia {
    WebDriver wd = null;
    public static final String LOGIN = "Azef1972";
    public static final String PASSWORD = "com.12345";
    public static final String WIKIPEDIA_ORG = "https://www.wikipedia.org";

    By languageSelector = By.id("js-link-box-en");
    By goToLogIn = By.cssSelector("[accesskey='o']");
    By goToLogOut = By.cssSelector("a[title='Log out']");

    By userLoginSelector = By.id("wpName1");
    By userPasswordSelector = By.id("wpPassword1");
    By submitUserSelector = By.id("wpLoginAttempt");


    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to(WIKIPEDIA_ORG);
        clickElement(languageSelector);
        clickElement(goToLogIn);
    }

    @AfterClass
    public void tearDown() {
        clickElement(goToLogOut);
        wd.quit();
    }

    public void loginWikipedia() {
        fillField(userLoginSelector, LOGIN);
        fillField(userPasswordSelector, PASSWORD);
        clickElement(submitUserSelector);
    }

    public void fillField(By selector, String str) {
        clickElement(selector);
        clearElement(selector);
        sendKeysElement(selector, str);
    }

    public void sendKeysElement(By selector, String str) {

        wd.findElement(selector).sendKeys(str);
    }

    public void clearElement(By selector) {
        wd.findElement(selector).clear();
    }

    public void clickElement(By selector) {
        wd.findElement(selector).click();
    }

}
