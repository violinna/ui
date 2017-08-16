package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;


public class ViewMember extends BaseSetup {
    private static final String GROUPNAME = "test";

    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testView_shouldBeSuccessfully() throws UiObjectNotFoundException {
        doActionClickByText(GROUPNAME);

        mDevice.waitForIdle(TIMEOUT);
        doActionFindByDescription("More options").click();

        mDevice.waitForIdle(TIMEOUT);
        doActionClickByText("Info Grup");

        UiScrollable listView = new UiScrollable(new UiSelector());
        listView.flingToEnd(2);
    }
}
