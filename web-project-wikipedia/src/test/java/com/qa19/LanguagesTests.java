package com.qa19;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LanguagesTests {
    WebDriver wd = null;
    String[] strs = {"English", "Español", "日本語", "Deutsch",
            "Русский", "Français", "Italiano", "中文", "Português", "Polski"};
    List<String> listExpected = Arrays.asList(strs);
    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.wikipedia.org");
    }
    @Test
    public void testsLanguages() {
        List<WebElement> elements = wd.findElements(By.cssSelector("[data-el-section='primary links'] [lang] a strong"));
        Assert.assertNotNull(elements);
        Assert.assertEquals(elements.size(), listExpected.size());
        elements.forEach(webElement -> {
            Assert.assertTrue(listExpected.contains(webElement.getText()));
        });
        elements.forEach(webElement -> System.out.println(webElement.getText()));
    }
    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
