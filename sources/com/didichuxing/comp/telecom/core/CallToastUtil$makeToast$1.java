package com.didichuxing.comp.telecom.core;

import android.content.Context;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
final class CallToastUtil$makeToast$1 implements Runnable {
    final /* synthetic */ String $str;

    CallToastUtil$makeToast$1(String str) {
        this.$str = str;
    }

    public final void run() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            SystemUtils.showToast(Toast.makeText(appContext, this.$str, 1));
        }
    }
}
