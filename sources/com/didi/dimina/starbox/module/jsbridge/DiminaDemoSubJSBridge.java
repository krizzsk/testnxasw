package com.didi.dimina.starbox.module.jsbridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.module.DiminaDemoActivity;

public class DiminaDemoSubJSBridge {

    /* renamed from: a */
    private final DMMina f19875a;

    DiminaDemoSubJSBridge(DMMina dMMina) {
        LogUtil.m16841i("DiminaDemoSubJSBridge init");
        this.f19875a = dMMina;
    }

    public void openDiminaDemo() {
        DiminaDemoActivity.startDiminaDemoActivity(this.f19875a.getActivity());
    }
}
