package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import static org.junit.Assert.assertTrue;


public class ViewEditProfilePicture extends BaseSetup {
    private static final String GROUPNAME = "test";
    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testViewAndEditProfilePicture_shouldBeCanceled() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();
        doActionClickByText("Info Grup");

        doActionClickById("com.kaskus.chat:id/profile_picture");

        doActionClickById(PACKAGE + ":id/action_edit");

        doActionClickByText("Galeri");

        UiObject opsi = doActionFindByText("Choose an action");
        assertTrue(opsi.exists()); //Stop here, because this case depends on the device.
    }
}
