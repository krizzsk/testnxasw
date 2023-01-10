package com.didi.payment.base.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletExecutors.kt */
final class WalletExecutors$singleScheduleExecutor$2 extends Lambda implements Function0<ScheduledExecutorService> {
    public static final WalletExecutors$singleScheduleExecutor$2 INSTANCE = new WalletExecutors$singleScheduleExecutor$2();

    WalletExecutors$singleScheduleExecutor$2() {
        super(0);
    }

    public final ScheduledExecutorService invoke() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
