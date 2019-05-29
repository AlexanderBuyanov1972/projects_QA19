package com.qa19;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddArticleGameOfThrones extends BaseTestWikipedia {
    // ***************************************************
    By inputSelector = By.id("searchInput");
    By searchSubmitSelector = By.id("searchButton");
    By favoritesSelector = By.cssSelector("[data-mw='interface'][accesskey='w']");
    By watchlistSelector = By.cssSelector("li[id='pt-watchlist'] a");
    By favoritesMyPage = By.xpath("//a[@title='Game of Thrones'][contains(text(),'Game of Thrones')]");
    By titleOfArticle = By.id("firstHeading");

    public static final String SEARCH_TEXT = "game of thrones";
    public static final String TITLE_EXPECTED = "Game of Thrones";


    @Test
    public void addArticleGameOfThrones() {
        //login
        loginWikipedia();
        //search page "Game of Thrones"
        goToPageGameOfThrones();
        //adding page "Game of Thrones" to my favorites
        clickElement(favoritesSelector);
        //check that article added
        clickElement(watchlistSelector);
        //check that these pages are identical
        clickElement(favoritesMyPage);
        String actual = wd.findElement(titleOfArticle).getText();
        Assert.assertEquals(actual, TITLE_EXPECTED);

    }

    public void goToPageGameOfThrones() {
        clickElement(inputSelector);
        clearElement(inputSelector);
        sendKeysElement(inputSelector, SEARCH_TEXT);
        clickElement(searchSubmitSelector);
    }
}
