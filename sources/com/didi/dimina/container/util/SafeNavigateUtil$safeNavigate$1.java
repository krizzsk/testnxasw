package com.didi.dimina.container.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: SafeNavigateUtil.kt */
final class SafeNavigateUtil$safeNavigate$1 implements Runnable {
    final /* synthetic */ Function0 $navigateMethod;

    SafeNavigateUtil$safeNavigate$1(Function0 function0) {
        this.$navigateMethod = function0;
    }

    public final void run() {
        this.$navigateMethod.invoke();
        SafeNavigateUtil.setLastRunTime(System.currentTimeMillis());
    }
}
