package com.map.sdk.nav.hawaii;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0011\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, mo148868d2 = {"Lcom/map/sdk/nav/hawaii/ApolloUtils;", "", "()V", "hawaiiToggle", "Lcom/didichuxing/apollo/sdk/IToggle;", "getHawaiiToggle", "()Lcom/didichuxing/apollo/sdk/IToggle;", "hawaiiToggle$delegate", "Lkotlin/Lazy;", "mHawaiiYawAllow", "", "getMHawaiiYawAllow", "()Z", "mHawaiiYawAllow$delegate", "mPasHawaiiYawAllow", "getMPasHawaiiYawAllow", "mPasHawaiiYawAllow$delegate", "pasHawaiiToggle", "getPasHawaiiToggle", "pasHawaiiToggle$delegate", "isNeedUseHawaiiMatcher", "isPasNeedUseHawaiiMatcher", "navbaselibc_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ApolloUtils.kt */
public final class ApolloUtils {
    public static final ApolloUtils INSTANCE = new ApolloUtils();

    /* renamed from: a */
    private static final Lazy f58564a = LazyKt.lazy(ApolloUtils$hawaiiToggle$2.INSTANCE);

    /* renamed from: b */
    private static final Lazy f58565b = LazyKt.lazy(ApolloUtils$mHawaiiYawAllow$2.INSTANCE);

    /* renamed from: c */
    private static final Lazy f58566c = LazyKt.lazy(ApolloUtils$pasHawaiiToggle$2.INSTANCE);

    /* renamed from: d */
    private static final Lazy f58567d = LazyKt.lazy(ApolloUtils$mPasHawaiiYawAllow$2.INSTANCE);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final IToggle m44329a() {
        return (IToggle) f58564a.getValue();
    }

    /* renamed from: b */
    private final boolean m44330b() {
        return ((Boolean) f58565b.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final IToggle m44331c() {
        return (IToggle) f58566c.getValue();
    }

    /* renamed from: d */
    private final boolean m44332d() {
        return ((Boolean) f58567d.getValue()).booleanValue();
    }

    private ApolloUtils() {
    }

    public final boolean isNeedUseHawaiiMatcher() {
        try {
            if (m44330b()) {
                Object param = m44329a().getExperiment().getParam("useHawiiYaw", 0);
                Intrinsics.checkExpressionValueIsNotNull(param, "experiment.getParam(\"useHawiiYaw\", 0)");
                int intValue = ((Number) param).intValue();
                DLog.m10773d("ApolloUtils", "global_map_driver_HawaiiYaw_AB isUseHawaiiYaw allow=true group=" + intValue, new Object[0]);
                if (intValue == 1) {
                    return true;
                }
                return false;
            }
            DLog.m10773d("ApolloUtils", "global_map_driver_HawaiiYaw_AB isUseHawaiiYaw allow=false", new Object[0]);
            return false;
        } catch (Exception e) {
            DLog.m10773d("ApolloUtils", "global_map_driver_HawaiiYaw_AB exception=" + e, new Object[0]);
        }
    }

    public final boolean isPasNeedUseHawaiiMatcher() {
        try {
            if (m44332d()) {
                Object param = m44331c().getExperiment().getParam("useHawaiiYaw", 0);
                Intrinsics.checkExpressionValueIsNotNull(param, "experiment.getParam(\"useHawaiiYaw\", 0)");
                int intValue = ((Number) param).intValue();
                DLog.m10773d("ApolloUtils", "global_map_pas_HawaiiYaw_AB isUseHawaiiYaw allow=true group=" + intValue, new Object[0]);
                if (intValue == 1) {
                    return true;
                }
                return false;
            }
            DLog.m10773d("ApolloUtils", "global_map_pas_HawaiiYaw_AB isUseHawaiiYaw allow=false", new Object[0]);
            return false;
        } catch (Exception e) {
            DLog.m10773d("ApolloUtils", "global_map_pas_HawaiiYaw_AB exception=" + e, new Object[0]);
        }
    }
}
