package com.didi.sdk.nation;

import com.didi.commoninterfacelib.ServiceProviderManager;

public class NationTypeUtil {

    /* renamed from: a */
    private static INationTypeComponent f39650a = ((INationTypeComponent) ServiceProviderManager.getInstance().getComponent(INationTypeComponent.class));

    public static NationComponentData getNationComponentData() {
        return f39650a.getNationComponentData();
    }

    public static void refreshPushConfig() {
        f39650a.refreshPushHost();
    }
}
