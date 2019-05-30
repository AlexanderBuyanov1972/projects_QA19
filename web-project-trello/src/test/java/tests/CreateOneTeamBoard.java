package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOneTeamBoard extends TestBase {
    @Test
    public void createTeamTest() throws InterruptedException {
        app.getHeaderHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreateForm();
        Assert.assertEquals(app.getTeamHelper().getTeamName(), "MyTeamName");
    }



}
