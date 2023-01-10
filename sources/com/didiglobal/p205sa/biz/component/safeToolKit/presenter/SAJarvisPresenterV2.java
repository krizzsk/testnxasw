package com.didiglobal.p205sa.biz.component.safeToolKit.presenter;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.sdk.util.UiThreadHandler;

/* renamed from: com.didiglobal.sa.biz.component.safeToolKit.presenter.SAJarvisPresenterV2 */
public class SAJarvisPresenterV2 extends SAIJarvisPresenterV2 {
    /* access modifiers changed from: protected */
    public String getPage() {
        return "super_app_home";
    }

    public SAJarvisPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                SAJarvisPresenterV2.this.requestJarvisStatus();
            }
        }, 500);
    }
}
