package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoardHelper extends HelperBase {


    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void submitBoardCreation() {
        click("[class='primary']");
    }

    public void fillBoardCreationForm() {
        type("[class='subtle-input']", "My board");
    }

    public void selectCreateBoardFromDropDown() {
        click("[class='quiet-button js-add-board']");
    }

    public int getPersonalBoardsCount() {
       // List<WebElement> elements = wd.findElements(By.cssSelector("[class='js-all-boards'] div [class='js-section-content'] [class='sidebar-boards-list js-board-list'] [class='compact-board-tile']"));
        List<WebElement> elements = wd.findElements(By.cssSelector("[class='compact-board-tile']"));
        return elements.size();
    }

    public int getTeamBoardsCount() {
        List<WebElement> elements = wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']"));
        return elements.size();
    }
    //*****************************delete first personal board ************************************

    public void clickOnButtonMore() {
        click("[class='board-menu-navigation-item-link js-open-more']");
    }

    public void clickOnButtonCloseBoard() {
        click("[class='board-menu-navigation-item-link js-close-board']");
    }

    public void clickOnButtonClose() {
        click("[class='js-confirm full negate']");
    }

    public void clickOnFirstPersonalBoard() { click("[class='compact-board-tile']");
    }
//*****************************delete first team board ************************************

    public void clickOnSettingTeamBoard() { click("[class='icon-gear icon-sm jlnEovPXgyz1K5']"); }

    public void clickOnFirstTeamBoard() { click("[data-test-id='home-team-tab-name']"); }

    public void clickOnLinkDeleteThisTeamBoard() {
        click("[class='quiet-button']");
    }

    public void clickOnButtonDeleteForever() {
        click("[class='js-confirm full negate']");
    }
}

