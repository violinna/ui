package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class KickMember extends BaseSetup {
    private static final String GROUPNAME = "test";
    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testKickMember_noConnectionshouldBeFailed() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        doActionClickByText("Info Grup");

        UiScrollable scrollScreen = new UiScrollable(new UiSelector());

        UiObject list = doActionFindById("com.kaskus.chat:id/recycler_member_list").getChild(
                new UiSelector().className("android.widget.LinearLayout").index(1));
        scrollScreen.scrollIntoView(list);

        UiObject textUser = list.getChild(new UiSelector()
                .resourceId("com.kaskus.chat:id/sender"));
        String tmp = textUser.getText();
        textUser.click();

        doActionClickByText("Keluarkan " + tmp);
        doActionClickByText("OK");
        UiObject checkUser = doActionFindByText(tmp);
        assertTrue(checkUser.exists());
    }

    @Test
    public void testKickMember_shouldBeSuccess() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        doActionClickByText("Info Grup");

        UiScrollable scrollScreen = new UiScrollable(new UiSelector());

        UiObject list = doActionFindById("com.kaskus.chat:id/recycler_member_list").getChild(
                new UiSelector().className("android.widget.LinearLayout").index(1));
        scrollScreen.scrollIntoView(list);

        UiObject textUser = list.getChild(new UiSelector()
                .resourceId("com.kaskus.chat:id/sender"));
        String tmp = textUser.getText();
        textUser.click();

        doActionClickByText("Keluarkan " + tmp);
        doActionClickByText("OK");
        UiObject checkUser = doActionFindByText(tmp);
        assertFalse(checkUser.exists());
    }
}
