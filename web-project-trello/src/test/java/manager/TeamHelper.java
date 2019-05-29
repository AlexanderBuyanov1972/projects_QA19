package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCreateTeamFromDropDown() {
        click("[class='js-new-org']");
    }

    public String getTeamName() {
        return wd.findElement(By.cssSelector("[class='u-inline']")).getText();
    }

    public void fillTeamCreateForm() {
        type("[id='org-display-name']", "MyTeamName");
        type("[name='desc']", "MyTeamDescription");
        click("[class='primary wide js-save']");
    }

}
