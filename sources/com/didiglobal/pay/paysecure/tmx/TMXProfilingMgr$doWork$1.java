package com.didiglobal.pay.paysecure.tmx;

import android.content.Context;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: TMXProfilingMgr.kt */
final class TMXProfilingMgr$doWork$1 implements Runnable {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ String $srcFrom;

    TMXProfilingMgr$doWork$1(Context context, String str) {
        this.$applicationContext = context;
        this.$srcFrom = str;
    }

    public final void run() {
        TMXProfilingMgr.INSTANCE.m39670a(this.$applicationContext, this.$srcFrom);
    }
}
