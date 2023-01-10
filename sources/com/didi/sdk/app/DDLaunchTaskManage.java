package com.didi.sdk.app;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class DDLaunchTaskManage {

    /* renamed from: a */
    private static DDLaunchTaskManage f37920a;

    /* renamed from: c */
    private static Boolean f37921c;

    /* renamed from: b */
    private ApplicationDelegateManager f37922b;

    public static DDLaunchTaskManage getInstance() {
        if (f37920a == null) {
            f37920a = new DDLaunchTaskManage();
        }
        return f37920a;
    }

    public void setDelegateMge(ApplicationDelegateManager applicationDelegateManager) {
        this.f37922b = applicationDelegateManager;
    }

    public void notifyLoadForground() {
        SystemUtils.log(4, "DDTaskManage", "notifyLoadForground: " + this.f37922b, (Throwable) null, "com.didi.sdk.app.DDLaunchTaskManage", 25);
        ApplicationDelegateManager applicationDelegateManager = this.f37922b;
        if (applicationDelegateManager != null) {
            applicationDelegateManager.notifyLoadForground();
        }
    }

    public static boolean isAllowed() {
        Boolean bool = f37921c;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("psg_anr_fresco_task_init_at_activity");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f37921c = valueOf;
        return valueOf.booleanValue();
    }
}
