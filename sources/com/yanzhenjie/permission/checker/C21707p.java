package com.yanzhenjie.permission.checker;

import android.os.Environment;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;

/* renamed from: com.yanzhenjie.permission.checker.p */
/* compiled from: StorageReadTest */
class C21707p implements PermissionTest {
    C21707p() {
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        if (!TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            return true;
        }
        File externalStorageDirectory = SystemUtils.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists()) {
            return true;
        }
        long lastModified = externalStorageDirectory.lastModified();
        String[] list = externalStorageDirectory.list();
        if (lastModified <= 0 || list == null) {
            return false;
        }
        return true;
    }
}
