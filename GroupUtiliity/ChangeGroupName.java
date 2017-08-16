package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChangeGroupName extends BaseSetup {
    private static final String GROUPNAME = "test";
    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testChangeGroupName_noConnectionshouldBeFailed() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        mDevice.waitForIdle(TIMEOUT);
        doActionClickById(PACKAGE + ":id/edit_icon");

        mDevice.waitForIdle(TIMEOUT);
        doActionFindById(PACKAGE + ":id/value_text").setText("ganti");
        doActionClickByText("OK");

        UiObject groupNameFail = doActionFindByText(GROUPNAME);
        assertTrue(groupNameFail.exists());
    }

    @Test
    public void testChangeGroupName_shouldBeChanged() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        mDevice.waitForIdle(TIMEOUT);
        doActionClickById(PACKAGE + ":id/edit_icon");

        mDevice.waitForIdle(TIMEOUT);
        doActionFindById(PACKAGE + ":id/value_text").setText("ganti");
        doActionClickByText("OK");

        UiObject groupName = doActionFindByText(GROUPNAME);
        assertFalse(groupName.exists());
    }
}
