package com.didiglobal.travel.infra.app;

import android.app.Activity;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo148868d2 = {"finishIfNeeded", "", "Landroid/app/Activity;", "lib-common_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: Activity.kt */
public final class ActivityKt {
    public static final void finishIfNeeded(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$finishIfNeeded");
        if (!activity.isFinishing()) {
            if (!(Build.VERSION.SDK_INT >= 17) || !activity.isDestroyed()) {
                activity.finish();
            }
        }
    }
}
