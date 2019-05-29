package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOnePersonalBoard extends TestBase{
    @Test
    public void test() throws InterruptedException {
        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
        int before = app.getBoardHelper().getPersonalBoardsCount();

        deleteOneFirstPersonalBoards();

        int after = app.getBoardHelper().getPersonalBoardsCount();
        Assert.assertEquals(before,after+1);

    }



}
