package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteProfilePicture extends BaseSetup {
    private static final String GROUPNAME = "test";
    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testDeleteProfPict_noConnectionShouldBeFailed() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        doActionClickById("com.kaskus.chat:id/profile_picture");

        doActionClickById(PACKAGE + ":id/action_delete_profpic");
        doActionClickByText("OK");

        UiObject Check = doActionFindById("com.kaskus.chat:id/iv_photo");
        assertTrue(Check.exists());
    }

    @Test
    public void testDeleteProfPict_shouldBeDeleted() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        doActionClickById("com.kaskus.chat:id/profile_picture");

        doActionClickById(PACKAGE + ":id/action_delete_profpic");
        doActionClickByText("OK");

        UiObject Check = doActionFindById("com.kaskus.chat:id/iv_photo");
        assertFalse(Check.exists());
    }
}
