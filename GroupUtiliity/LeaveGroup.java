package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeaveGroup extends BaseSetup {
    private static final String GROUPNAME = "test";
    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testLeaveGroup_noConnectionshouldBeFailed() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").longClick();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").longClick();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Keluar Grup");
        doActionClickByText("OK");

        UiObject leave = doActionFindByText("Ulangi");
        assertTrue(leave.exists());
    }

    @Test
    public void testLeaveGroup_shouldBeSuccessfully() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").longClick();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").longClick();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Keluar Grup");
        doActionClickByText("OK");

        UiObject checkGroup = doActionFindByText(GROUPNAME);
        assertFalse(checkGroup.exists());
    }
}
