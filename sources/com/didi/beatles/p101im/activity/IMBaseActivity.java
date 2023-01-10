package com.didi.beatles.p101im.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.utils.IMLocaleUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.activity.IMBaseActivity */
public class IMBaseActivity extends TheOneBaseActivity {
    /* access modifiers changed from: protected */
    public boolean isUseTheme() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        try {
            m9311b();
            m9310a();
            super.onCreate(bundle);
            if (!m9312c()) {
                finish();
            } else {
                onActivityCreate(bundle);
            }
        } catch (Exception unused) {
            finish();
            IMLog.m10020d("IMBaseActivity", "IMBaseActivity Can't Parse Intent Exception");
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        super.onDestroy();
        onActivityDestroy();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        if (isUseTheme() && IMContextInfoHelper.getActivityTheme() != 0) {
            StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
        }
    }

    /* renamed from: a */
    private void m9310a() {
        try {
            if (IMContextInfoHelper.isPad()) {
                SystemUtils.hookSetRequestedOrientation(this, 6);
            }
        } catch (Exception e) {
            IMLog.m10021e("IM initScreenDirection error", e);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        try {
            context = IMLocaleUtil.attachBaseContext(context);
        } catch (Exception e) {
            IMLog.m10022e(e);
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initStatusBar();
    }

    /* renamed from: b */
    private void m9311b() {
        if (isUseTheme() && IMContextInfoHelper.getActivityTheme() != 0) {
            setTheme(IMContextInfoHelper.getActivityTheme());
        }
    }

    public void onBackPressed() {
        finish();
    }

    /* renamed from: c */
    private boolean m9312c() {
        if (!IMEngine.getInstance(this).hasInit()) {
            IMLog.m10021e("init IM failed!", new Object[0]);
            SystemUtils.showToast(Toast.makeText(this, getString(R.string.im_toast_error), 0));
            return false;
        } else if (IMContextInfoHelper.isLogingNow()) {
            return true;
        } else {
            IMLog.m10021e("user not login !", new Object[0]);
            SystemUtils.showToast(Toast.makeText(this, getString(R.string.im_toast_error), 0));
            return false;
        }
    }
}
