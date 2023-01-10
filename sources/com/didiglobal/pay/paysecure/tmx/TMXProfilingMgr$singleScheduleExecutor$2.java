package com.didiglobal.pay.paysecure.tmx;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: TMXProfilingMgr.kt */
final class TMXProfilingMgr$singleScheduleExecutor$2 extends Lambda implements Function0<ScheduledExecutorService> {
    public static final TMXProfilingMgr$singleScheduleExecutor$2 INSTANCE = new TMXProfilingMgr$singleScheduleExecutor$2();

    TMXProfilingMgr$singleScheduleExecutor$2() {
        super(0);
    }

    public final ScheduledExecutorService invoke() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
