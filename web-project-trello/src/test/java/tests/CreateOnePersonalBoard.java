package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOnePersonalBoard extends TestBase {
    @Test
    public void test() throws InterruptedException {
        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
        int before = app.getBoardHelper().getPersonalBoardsCount();

        app.getHeaderHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm();
        app.getBoardHelper().submitBoardCreation();
        app.getHeaderHelper().clickOnBoardsButtonOnHeader();

        int after = app.getBoardHelper().getPersonalBoardsCount();
        Assert.assertEquals(after, before + 1);
    }
}

