package manager;

import Models.UserProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void clickChangePhoto() {
//        if(isThereAnAvatar()){
//            WebElement profileAvatar = wd.findElement(By.cssSelector("[class='profile-image-image']"));
//            WebElement changePic = wd.findElement(By.cssSelector("[class='profile-image-change-text']"));
//            new Actions(wd).moveToElement(profileAvatar).pause(5).click(changePic).perform();
//            click("[class='js-no-avatar']");
//            waitForElement(10,"[class='profile-image-initial']");
//
//            WebElement profileAvatarIn = findElement("[class='profile-image-initial']");
//            WebElement changePicIn = findElement("[class='profile-image-change-text']");
//            new Actions(wd).moveToElement(profileAvatar).pause(5).click(changePic).perform();
//        }
//        waitForElement(10,"[class='profile-image-initial']");
//        WebElement profileAvatar = wd.findElement(By.cssSelector("[class='profile-image-image']"));
//        WebElement changePic = wd.findElement(By.cssSelector("[class='profile-image-change-text']"));
//        new Actions(wd).moveToElement(profileAvatar).pause(5).click(changePic).perform();

    }

    public void clickProfileFromDropDown() {
        click("[data-test-id='header-member-menu-profile']");

    }

    //*********************************************
    public void initProfileModification(int time, String selectorEditProfile) {
        waitForElementAndClick(time, selectorEditProfile);

    }

    public void initProfileModification() throws InterruptedException {
        Thread.sleep(5000);
       // click("[class='button-link tabbed-pane-header-details-edit js-edit-profile']");
        click("[class='icon-sm icon-edit']");

    }

    public void waitForElementAndClick(int time, String selector) {
        WebDriverWait wait = new WebDriverWait(wd, time);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public void fillProfileForm(UserProfile userProfile){
        type("[name='fullName']", userProfile.getFullName());
        type("[name='username']", userProfile.getUserName());
        type("[name='initials']", userProfile.getInitials());
        type("[name='bio']", userProfile.getBio());


    }

    public void submitModification() {
        click("[class='primary wide js-submit-profile']");
    }


//    // ...............
//    public void attachPicture(File file) {
//        waitForElement(10, "[class='js-upload-avatar']");
//        attach("[class='js-upload-avatar']", file);
//    }
}
