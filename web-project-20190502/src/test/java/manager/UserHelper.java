package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;

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


//    // ...............
//    public void attachPicture(File file) {
//        waitForElement(10, "[class='js-upload-avatar']");
//        attach("[class='js-upload-avatar']", file);
//    }
}
