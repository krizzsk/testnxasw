package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.core.ComponentParams;

public class WaitRspJarvisPresenterv2 extends AbsJarvisPresenterV2 {
    /* access modifiers changed from: protected */
    public String getPage() {
        return "wait";
    }

    public WaitRspJarvisPresenterv2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        requestJarvisStatus();
    }
}
