package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAllTeamBoards extends TestBase{
    int count = 0;
    String selector = "[data-test-id='home-team-tab-name']";
    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        int before = app.getBoardHelper().getTeamBoardsCount();
        System.out.println("before => " + before);
        while (app.getHeaderHelper().isElementPresent(selector)) {
            System.out.println("Я зашёл в цикл " + (count + 1));
            deleteOneFirstTeamBoards();
            count++;
            System.out.println("count : -> " + count);
        }
        Assert.assertEquals(before, count);
    }
}
