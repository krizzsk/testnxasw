package com.didi.globalsafetoolkit.business.share.controller;

import android.app.Activity;
import android.content.Context;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.util.BroadcastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/share/controller/SfShareOptController;", "", "()V", "share", "", "context", "Landroid/content/Context;", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: SfShareOptController.kt */
public final class SfShareOptController {
    public final void share(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        GlobalSfBusinessInterface.onNewTrustedContactAdded(true);
        BroadcastUtil.sendBroadcast(context, "sf_add_contacts_success");
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
