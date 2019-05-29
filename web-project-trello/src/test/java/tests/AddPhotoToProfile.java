package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class AddPhotoToProfile {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getHeaderHelper().isElementPresent("[id='notification']")) {
            app.getHeaderHelper().clickOnHomeButtonOnHeader();
        }
    }

    @Test
    public void test() throws InterruptedException {
        //clicl on AB
        app.getHeaderHelper().clickOnABButtonOnHeader();
        //click profile
        app.getHeaderHelper().click("[class='js-profile']");
        //click change AB
        app.getHeaderHelper().click("[class='profile-image-initials']");
        //uploadPicture
        app.getUserHelper().clickChangePhoto();

    }
}
