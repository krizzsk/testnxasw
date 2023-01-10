package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;

public class CapsuleButtonSubJSBridge {

    /* renamed from: a */
    private final DMMina f18447a;

    public CapsuleButtonSubJSBridge(DMMina dMMina) {
        this.f18447a = dMMina;
        LogUtil.m16841i("LoadSubPackageSubJSBridge init");
    }

    public void setCapsuleButtonVisible(boolean z, CallbackFunction callbackFunction) {
        DMPage curPage = NavigateUtil.getCurPage(this.f18447a);
        if (curPage != null) {
            curPage.setCapsuleButtonVisibility(z);
        }
        CallBackUtil.onSuccess(callbackFunction);
    }
}
