package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import ui_testing.chat.kaskus.pingandroiduitesting.GetUserUtil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AddMember extends BaseSetup {
    private static final String GROUPNAME = "test";

    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testAddMember_noConnectionshouldBeFailed() throws UiObjectNotFoundException {
        String username = GetUserUtil.getUser(mDevice);
        doActionClickByText("Pesan");
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        doActionClickByText("Info Grup");

        UiScrollable scroll = new UiScrollable(new UiSelector());
        UiObject textSearch = doActionFindByText("Tambahkan anggota grup");

        scroll.scrollIntoView(textSearch);
        textSearch.click();

        doActionSetTextById(PACKAGE + ":id/group_member_text_input", username);

        doActionFindById(PACKAGE + ":id/group_add_member_notice_text").longClick();

        doActionClickById(PACKAGE + ":id/action_next");

        UiObject checkUser = doActionFindByText(username);

        assertFalse(scroll.scrollIntoView(checkUser));
    }

    @Test
    public void testAddMember_shouldBeSuccessful() throws UiObjectNotFoundException {
        String username = GetUserUtil.getUser(mDevice);

        doActionClickByText("Pesan");

        doActionClickByText(GROUPNAME);

        doActionFindByDescription("More options").click();

        doActionClickByText("Info Grup");

        UiScrollable scroll = new UiScrollable(new UiSelector());
        UiObject textTarget = doActionFindByText("Tambahkan anggota grup");

        scroll.scrollIntoView(textTarget);
        textTarget.click();

        doActionSetTextById(PACKAGE + ":id/group_member_text_input", username);

        doActionFindById(PACKAGE + ":id/group_add_member_notice_text").longClick();

        doActionClickById(PACKAGE + ":id/action_next");

        UiObject checkUser = doActionFindByText(username);

        assertTrue(scroll.scrollIntoView(checkUser));
    }
}
