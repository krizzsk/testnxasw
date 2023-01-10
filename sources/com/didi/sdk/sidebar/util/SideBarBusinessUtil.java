package com.didi.sdk.sidebar.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.webview.WebActivity;

public class SideBarBusinessUtil {

    /* renamed from: a */
    private static final int f40179a = 101;

    /* renamed from: b */
    private static boolean f40180b = false;

    public static boolean isRedirectToLogin(Context context, BaseObject baseObject) {
        if (baseObject == null || baseObject.errno != 101 || context == null) {
            return false;
        }
        if (!(context instanceof FragmentActivity) && !(context instanceof Activity)) {
            return false;
        }
        NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
        return true;
    }

    public static void gotoWeb(Context context, String str) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static boolean isPriceFix() {
        return f40180b;
    }

    public static void setPriceFix(boolean z) {
        f40180b = z;
    }
}
