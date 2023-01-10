package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzgd extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzgf zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgd(zzgf zzgf, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzb = zzgf;
        Preconditions.checkNotNull(str);
        long andIncrement = zzgf.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgf.zzs.zzaz().zzd().zza("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzgd zzgd = (zzgd) obj;
        boolean z = this.zza;
        if (z != zzgd.zza) {
            return !z ? 1 : -1;
        }
        int i = (this.zzc > zzgd.zzc ? 1 : (this.zzc == zzgd.zzc ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        this.zzb.zzs.zzaz().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzs.zzaz().zzd().zzb(this.zzd, th);
        if ((th instanceof zzgb) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgd(zzgf zzgf, Callable callable, boolean z, String str) {
        super(callable);
        this.zzb = zzgf;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzgf.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgf.zzs.zzaz().zzd().zza("Tasks index overflow");
        }
    }
}
