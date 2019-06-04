package tests;

import Models.Board;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateOnePersonalBoard extends TestBase {

    @DataProvider
    public Iterator<Object[]> boards() throws Exception {
        File file = new File("src/test/resources/boards.csv");
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            Object[] objs = new Object[1];
            Board brd = new Board();
            brd.withBoardName(split[0]);
            objs[0] = brd;
            list.add(objs);
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "boards")
    public void createOnePersonalBoard(Board board) throws InterruptedException {
        Thread.sleep(10000);
        app.getHeaderHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().submitBoardCreation();
        app.screenShot();
        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
    }

    //**************************** without data provider**********************************
//    @Test
//    public void test() throws InterruptedException {
//
//        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
//        int before = app.getBoardHelper().getPersonalBoardsCount();
//
//        app.getHeaderHelper().clickOnPlusButtonOnHeader();
//        app.getBoardHelper().selectCreateBoardFromDropDown();
//        app.getBoardHelper().fillBoardCreationForm();
//        app.getBoardHelper().submitBoardCreation();
//        app.getHeaderHelper().clickOnBoardsButtonOnHeader();
//
//        int after = app.getBoardHelper().getPersonalBoardsCount();
//        Assert.assertEquals(after, before + 1);
//    }
}

