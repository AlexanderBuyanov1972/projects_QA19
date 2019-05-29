package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOneTeamBoard extends TestBase{
    @Test
    public void deleteOneTeamBoard() throws InterruptedException {
        Thread.sleep(5000);
        int before = app.getBoardHelper().getTeamBoardsCount();
        System.out.println("before => " + before);
        deleteOneFirstTeamBoards();
        int after = app.getBoardHelper().getTeamBoardsCount();
        System.out.println("after => " + after);
        Assert.assertEquals(before,after+1);

    }



}
