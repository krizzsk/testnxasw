package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzgf extends zzhc {
    /* access modifiers changed from: private */
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzge zzb;
    /* access modifiers changed from: private */
    public zzge zzc;
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final BlockingQueue zze = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzf = new zzgc(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzg = new zzgc(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzh = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzi = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzj;

    zzgf(zzgi zzgi) {
        super(zzgi);
    }

    private final void zzt(zzgd zzgd) {
        synchronized (this.zzh) {
            this.zzd.add(zzgd);
            zzge zzge = this.zzb;
            if (zzge == null) {
                zzge zzge2 = new zzge(this, "Measurement Worker", this.zzd);
                this.zzb = zzge2;
                zzge2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzge.zza();
            }
        }
    }

    public final void zzay() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = r1.zzs.zzaz().zzk();
        r3.zza("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1.zzs.zzaz().zzk().zza("Timed out waiting for ".concat(r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()     // Catch:{ all -> 0x0049 }
            r0.zzp(r6)     // Catch:{ all -> 0x0049 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzk()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r5)
            r3.zza(r4)
        L_0x0027:
            return r2
        L_0x0028:
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzs     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzk()     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "Interrupted waiting for "
            r4.append(r6)     // Catch:{ all -> 0x0049 }
            r4.append(r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0049 }
            r3.zza(r4)     // Catch:{ all -> 0x0049 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            r2 = 0
            return r2
        L_0x0049:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgf.zzd(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzgd zzgd = new zzgd(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                this.zzs.zzaz().zzk().zza("Callable skipped the worker queue.");
            }
            zzgd.run();
        } else {
            zzt(zzgd);
        }
        return zzgd;
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzgd zzgd = new zzgd(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zzgd.run();
        } else {
            zzt(zzgd);
        }
        return zzgd;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzgd zzgd = new zzgd(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzgd);
            zzge zzge = this.zzc;
            if (zzge == null) {
                zzge zzge2 = new zzge(this, "Measurement Network", this.zze);
                this.zzc = zzge2;
                zzge2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                zzge.zza();
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzgd(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzgd(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        return Thread.currentThread() == this.zzb;
    }
}
