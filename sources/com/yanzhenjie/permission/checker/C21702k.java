package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* renamed from: com.yanzhenjie.permission.checker.k */
/* compiled from: PhoneStateReadTest */
class C21702k implements PermissionTest {

    /* renamed from: a */
    private Context f58957a;

    C21702k(Context context) {
        this.f58957a = context;
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        if (!this.f58957a.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f58957a.getSystemService("phone");
        if (telephonyManager.getPhoneType() == 0 || !TextUtils.isEmpty(telephonyManager.getDeviceId()) || !TextUtils.isEmpty(telephonyManager.getSubscriberId())) {
            return true;
        }
        return false;
    }
}
