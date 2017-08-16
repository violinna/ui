package ui_testing.chat.kaskus.pingandroiduitesting.GroupUtiliity;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.Test;
import ui_testing.chat.kaskus.pingandroiduitesting.BaseSetup;
import ui_testing.chat.kaskus.pingandroiduitesting.GetUserUtil;


public class CreateGroup extends BaseSetup {
    private static final String GROUPNAME = "test";

    @Before
    public void init() throws RemoteException, UiObjectNotFoundException {
        super.setup();
    }

    @Test
    public void testCreateGroup_shouldBeSuccess() throws UiObjectNotFoundException {
        String username = GetUserUtil.getUser(mDevice);
        doActionClickByDescription("More options");

        doActionClickByText("Buat Grup");

        doActionSetTextByText("Masukin nama grup, Gan", GROUPNAME);

        doActionClickById(PACKAGE + ":id/action_next");

        doActionSetTextByText("Tambahkan anggota grup", username);

        doActionFindById(PACKAGE + ":id/group_add_member_notice_text").longClick();

        doActionClickById(PACKAGE + ":id/action_next");
    }
}
