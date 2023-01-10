package com.didi.map.sdk.sharetrack.common;

import android.content.Context;
import android.text.TextUtils;
import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.sdk.util.ToastUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aJ,\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo148868d2 = {"Lcom/didi/map/sdk/sharetrack/common/ShareTrackUtils;", "", "()V", "KEY_100M_TTS", "", "KEY_ARRIVE_TTS_WINDOW", "KEY_DRIVE_AWAY_TTS_WINDOW", "mCurOrderId", "mEventLimiter", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mIsNoRoadNet", "", "debugToast", "", "context", "Landroid/content/Context;", "str", "isNoRoadNet", "isUsingDemo", "shouldShowApproachTTSAndDisable", "shouldShowArriveTTSWindowAndDisable", "shouldShowDriveAwayTTSWindowAndDisable", "traceEvent", "id", "eventMap", "", "tag", "updateCurOrderId", "orderId", "updateRoadNetStatus", "isNoRoad", "CommonShareTrack_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ShareTrackUtils.kt */
public final class ShareTrackUtils {
    public static final ShareTrackUtils INSTANCE = new ShareTrackUtils();

    /* renamed from: a */
    private static String f31080a = "0";

    /* renamed from: b */
    private static boolean f31081b = false;

    /* renamed from: c */
    private static HashMap<String, String> f31082c = null;

    /* renamed from: d */
    private static final String f31083d = "key_100M_TTS";

    /* renamed from: e */
    private static final String f31084e = "key_arrive_tts_window";

    /* renamed from: f */
    private static final String f31085f = "key_drive_away_tts_window";

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f31082c = hashMap;
        hashMap.put(f31083d, "0");
        f31082c.put(f31084e, "0");
        f31082c.put(f31085f, "0");
    }

    private ShareTrackUtils() {
    }

    public final boolean isUsingDemo(Context context) {
        String str;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (context.getApplicationContext() != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
            str = applicationContext.getPackageName();
            Intrinsics.checkExpressionValueIsNotNull(str, "context.applicationContext.packageName");
        } else {
            str = "";
        }
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence) || !StringsKt.contains$default(charSequence, (CharSequence) "demo", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public final void debugToast(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(str, "str");
        if (context != null && ShareTrackApolloHelper.INSTANCE.getCanDebugToast()) {
            ToastUtil.show(context, str, 1, new Object[0]);
        }
    }

    public final void updateCurOrderId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "orderId");
        f31080a = str;
    }

    public final boolean shouldShowApproachTTSAndDisable() {
        f31082c.put(f31083d, f31080a);
        return !Intrinsics.areEqual((Object) f31080a, (Object) f31082c.get(f31083d));
    }

    public final boolean shouldShowArriveTTSWindowAndDisable() {
        f31082c.put(f31084e, f31080a);
        return !Intrinsics.areEqual((Object) f31080a, (Object) f31082c.get(f31084e));
    }

    public final boolean shouldShowDriveAwayTTSWindowAndDisable() {
        f31082c.put(f31085f, f31080a);
        return !Intrinsics.areEqual((Object) f31080a, (Object) f31082c.get(f31085f));
    }

    public final void traceEvent(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(map, "eventMap");
        traceEvent(str, map, "");
    }

    public final void traceEvent(String str, Map<String, ? extends Object> map, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(map, "eventMap");
        Intrinsics.checkParameterIsNotNull(str2, "tag");
        GlobalDriverOmega.trackEvent(str, map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ? extends Object> append : map.entrySet()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(append);
            sb2.append(' ');
            sb.append(sb2.toString());
        }
        DLog.m23962d(str2, "traceEvent:" + str + ", " + sb, new Object[0]);
    }

    public final void updateRoadNetStatus(boolean z) {
        DLog.m23962d(BaseRoundStrategy.TAG, "update road status: " + z, new Object[0]);
        f31081b = z;
    }

    public final boolean isNoRoadNet() {
        return f31081b;
    }
}
