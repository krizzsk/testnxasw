package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.apollo.ApolloDelegate;

/* renamed from: com.dmap.navigation.engine.a.q */
/* compiled from: ApolloUtil */
public final class C18186q {

    /* renamed from: a */
    private static final ApolloDelegate f54388a = new ApolloDelegate();

    public static boolean isTrackInLoadLib() {
        return f54388a.getToggleCache("hawaii_android_track_load_lib").allow();
    }

    /* renamed from: h */
    public static boolean m40471h() {
        return f54388a.getToggleCache("hawaii_use_statistic_malloc").allow();
    }

    /* renamed from: i */
    public static int m40472i() {
        IToggle toggleCache = f54388a.getToggleCache("hawaii_use_statistic_malloc");
        if (toggleCache.allow()) {
            return ((Integer) toggleCache.getExperiment().getParam("isUseDLMallocApollo", 0)).intValue();
        }
        return 0;
    }

    /* renamed from: j */
    public static int m40473j() {
        IToggle toggleCache = f54388a.getToggleCache("hawaii_use_statistic_malloc");
        if (toggleCache.allow()) {
            return ((Integer) toggleCache.getExperiment().getParam("initSpaceSizeApollo", 50)).intValue();
        }
        return 50;
    }
}
