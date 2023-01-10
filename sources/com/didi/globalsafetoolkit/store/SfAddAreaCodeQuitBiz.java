package com.didi.globalsafetoolkit.store;

import android.app.Activity;
import com.didi.globalsafetoolkit.business.contacts.SfContactsManageActivity;

public class SfAddAreaCodeQuitBiz {
    public static void onAddAreaCodeQuit(Activity activity) {
        SfContactsManageActivity.startSfManageActivity(activity);
    }
}
