package tests;

import Models.UserProfile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserProfileModification extends TestBase {
    @DataProvider
    public Iterator<Object[]> testProfileModificationDataProvider(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new UserProfile().withFullName("name1").withUserName("sssqsqq").withInitials("i1").withBio("Very good man name1")});
        list.add(new Object[]{new UserProfile().withFullName("name2").withUserName("sqssswq").withInitials("i2").withBio("Very good name2")});
        list.add(new Object[]{new UserProfile().withFullName("name3").withUserName("sssssqr3").withInitials("i3").withBio("Very good name3")});
        list.add(new Object[]{new UserProfile().withFullName("name4").withUserName("sssassr4").withInitials("i4").withBio("Very good name4")});
        list.add(new Object[]{new UserProfile().withFullName("name5").withUserName("ssssser5").withInitials("i5").withBio("Very good name5")});


        return list.iterator();
    }
    @Test(dataProvider = "testProfileModificationDataProvider")
    public void testProfileModification(UserProfile user) throws InterruptedException {
        app.getHeaderHelper().clickOnABButtonOnHeader();
        app.getUserHelper().clickProfileFromDropDown();
        app.getUserHelper().initProfileModification();
        app.getUserHelper().fillProfileForm(user);
        app.getUserHelper().submitModification();
    }

//    @Test
//    public void testProfileModification() throws InterruptedException {
//        app.getHeaderHelper().clickOnABButtonOnHeader();
//        app.getUserHelper().clickProfileFromDropDown();
//        app.getUserHelper().initProfileModification();
//        app.getUserHelper().fillProfileForm(new UserProfile()
//                .withFullName("Ivanov Sidor Petrovich").withUserName("Sidor")
//                .withInitials("ISP").withBio("Very good man!!!"));
//        app.getUserHelper().submitModification();
//    }


}
