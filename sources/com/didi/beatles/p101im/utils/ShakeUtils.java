package com.didi.beatles.p101im.utils;

import android.content.Context;
import android.os.Vibrator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C2404Reflection;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/beatles/im/utils/ShakeUtils;", "", "()V", "TAG", "", "lastClick", "", "timeInterval", "shake", "", "context", "Landroid/content/Context;", "millisecond", "isRepeat", "", "im_library_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.utils.ShakeUtils */
/* compiled from: ShakeUtils.kt */
public final class ShakeUtils {
    public static final ShakeUtils INSTANCE = new ShakeUtils();

    /* renamed from: a */
    private static final String f11663a = C2404Reflection.getOrCreateKotlinClass(ShakeUtils.class).getSimpleName();

    /* renamed from: b */
    private static long f11664b = 0;

    /* renamed from: c */
    private static final long f11665c = 1000;

    private ShakeUtils() {
    }

    @JvmStatic
    public static final void shake(Context context, long j, boolean z) {
        if (context != null) {
            int i = 1;
            if (System.currentTimeMillis() - f11664b >= 1000) {
                Object systemService = context.getSystemService("vibrator");
                if (systemService instanceof Vibrator) {
                    long[] jArr = {0, j, 0, j};
                    Vibrator vibrator = (Vibrator) systemService;
                    if (!z) {
                        i = -1;
                    }
                    vibrator.vibrate(jArr, i);
                    f11664b = System.currentTimeMillis();
                    return;
                }
                return;
            }
            IMLog.m10024i(f11663a, "shake:震动过快");
        }
    }
}
