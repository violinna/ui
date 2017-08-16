package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import static org.junit.Assert.assertTrue;

public class MentionUser extends BaseSetup {
    private static final String GROUPNAME = "test";
    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testMentionAndClickMention_shouldBeSuccess() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        doActionClickByText("Info Grup");

        UiScrollable scroll = new UiScrollable(new UiSelector());

        UiObject list = doActionFindById("com.kaskus.chat:id/recycler_member_list").getChild(
                new UiSelector().className("android.widget.LinearLayout").index(1));

        scroll.scrollIntoView(list);

        UiObject textuser = list.getChild(new UiSelector()
                .resourceId("com.kaskus.chat:id/sender"));
        String tmp = textuser.getText();

        mDevice.pressBack();

        doActionSetTextById(PACKAGE + ":id/textinput", "@" + tmp);

        doActionClickById(PACKAGE + ":id/textSendButton");

        doActionFindByText("@" + tmp).click();

        doActionClickByText("Lihat profil " + tmp);

        UiObject check = doActionFindById("com.kaskus.chat:id/appbar");
        assertTrue(check.exists());
    }
}
