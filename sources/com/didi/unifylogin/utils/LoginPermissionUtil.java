package com.didi.unifylogin.utils;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.unifylogin.listener.ListenerManager;
import java.util.ArrayList;
import java.util.List;

public class LoginPermissionUtil {
    public static final int MY_REQUEST_PERMISSION = 1001;

    /* renamed from: a */
    private static List<String> f47596a;

    public static void requestPermissions(FragmentActivity fragmentActivity) {
        ArrayList arrayList = new ArrayList();
        for (String next : m35707a()) {
            if (ContextCompat.checkSelfPermission(fragmentActivity, next) != 0) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            ActivityCompat.requestPermissions(fragmentActivity, (String[]) arrayList.toArray(new String[0]), 1001);
            new LoginOmegaUtil(LoginOmegaUtil.PAS_LOGIN_AUTHORITY_SW).send();
        }
    }

    public static void handlePermissionsResult(FragmentActivity fragmentActivity, int i, String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        if (i == 1001 && iArr.length > 0) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] != 0 && i2 < strArr.length) {
                    arrayList.add(strArr[i2]);
                }
            }
            if (ListenerManager.getGuidePermissionsDelegate() != null && arrayList.size() > 0) {
                ListenerManager.getGuidePermissionsDelegate().guidePermissions(fragmentActivity, arrayList);
            }
        }
    }

    /* renamed from: a */
    private static List<String> m35707a() {
        if (f47596a == null) {
            f47596a = new ArrayList();
        }
        return f47596a;
    }
}
