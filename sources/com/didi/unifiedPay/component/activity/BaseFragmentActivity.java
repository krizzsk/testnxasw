package com.didi.unifiedPay.component.activity;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;

public class BaseFragmentActivity extends FragmentActivity {

    /* renamed from: a */
    private boolean f47022a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f47022a = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f47022a = true;
    }

    /* access modifiers changed from: protected */
    public boolean isActivityDestroyed() {
        return this.f47022a;
    }
}
