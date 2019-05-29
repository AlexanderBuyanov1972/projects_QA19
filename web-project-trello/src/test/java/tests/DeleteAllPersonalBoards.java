package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAllPersonalBoards extends TestBase {
    int count = 0;
    // String selector = "[class='compact-board-tile']";
    String selector = "[class='compact-board-tile']";


    @Test
    public void test() throws InterruptedException {
        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
        int before = app.getBoardHelper().getPersonalBoardsCount();
        System.out.println("before -> ; " + before);
        while (count < before) {
            System.out.println("Я зашёл в цикл " + (count + 1));
            //*******************************************************************************
            app.getHeaderHelper().refresh();
            app.getHeaderHelper().clickOnBoardsButtonOnHeader();
            //*******************************************************************************
            deleteOneFirstPersonalBoards();
            count++;
            System.out.println("count : -> " + count);
        }
        int after = app.getBoardHelper().getPersonalBoardsCount();
        System.out.println("before -> ; " + after);
        Assert.assertEquals(before, count);
        Assert.assertEquals(after, 0);


    }


}

//    @Test
//    public void test() throws InterruptedException {
//
//        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
//        int before = app.getBoardHelper().getPersonalBoardsCount();
//        try {
//            while (true) {
//                app.getBoardHelper().clickOnFirstPersonalBoard();
//                app.getBoardHelper().clickOnButtonMore();
//                app.getBoardHelper().clickOnButtonCloseBoard();
//                app.getBoardHelper().clickOnButtonClose();
//                count++;
//                app.getHeaderHelper().clickOnBoardsButtonOnHeader();
//            }
//        } catch (NoSuchElementException e) {
//            Assert.assertEquals(before,count);
//        }
//    }


// app.getHeaderHelper().isElementPresent(selector)