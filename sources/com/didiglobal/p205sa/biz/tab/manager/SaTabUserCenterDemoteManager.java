package com.didiglobal.p205sa.biz.tab.manager;

import com.didi.sdk.util.SaApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabUserCenterDemoteManager;", "", "()V", "hideUserCenter", "", "isFirstLoad", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabUserCenterDemoteManager */
/* compiled from: SaTabUserCenterDemoteManager.kt */
public final class SaTabUserCenterDemoteManager {
    public static final SaTabUserCenterDemoteManager INSTANCE = new SaTabUserCenterDemoteManager();

    /* renamed from: a */
    private static boolean f53782a = true;

    /* renamed from: b */
    private static boolean f53783b;

    private SaTabUserCenterDemoteManager() {
    }

    public final boolean hideUserCenter() {
        if (f53782a) {
            f53783b = Apollo.getToggle("sa_usercenter_demote").allow();
            f53782a = false;
        }
        SaApolloUtil.INSTANCE.setShowSaUserTab(!f53783b);
        return f53783b;
    }
}
