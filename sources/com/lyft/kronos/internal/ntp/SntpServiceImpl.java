package com.lyft.kronos.internal.ntp;

import com.lyft.kronos.Clock;
import com.lyft.kronos.KronosTime;
import com.lyft.kronos.SyncListener;
import com.lyft.kronos.internal.ntp.SntpClient;
import com.lyft.kronos.internal.ntp.SntpService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001+B_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e¢\u0006\u0002\u0010\u0012J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020%H\u0016R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010!0!0 X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo148868d2 = {"Lcom/lyft/kronos/internal/ntp/SntpServiceImpl;", "Lcom/lyft/kronos/internal/ntp/SntpService;", "sntpClient", "Lcom/lyft/kronos/internal/ntp/SntpClient;", "deviceClock", "Lcom/lyft/kronos/Clock;", "responseCache", "Lcom/lyft/kronos/internal/ntp/SntpResponseCache;", "ntpSyncListener", "Lcom/lyft/kronos/SyncListener;", "ntpHosts", "", "", "requestTimeoutMs", "", "minWaitTimeBetweenSyncMs", "cacheExpirationMs", "maxNtpResponseTimeMs", "(Lcom/lyft/kronos/internal/ntp/SntpClient;Lcom/lyft/kronos/Clock;Lcom/lyft/kronos/internal/ntp/SntpResponseCache;Lcom/lyft/kronos/SyncListener;Ljava/util/List;JJJJ)V", "cacheSyncAge", "getCacheSyncAge", "()J", "cachedSyncTime", "Ljava/util/concurrent/atomic/AtomicLong;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "response", "Lcom/lyft/kronos/internal/ntp/SntpClient$Response;", "getResponse", "()Lcom/lyft/kronos/internal/ntp/SntpClient$Response;", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/lyft/kronos/internal/ntp/SntpServiceImpl$State;", "currentTime", "Lcom/lyft/kronos/KronosTime;", "ensureServiceIsRunning", "", "shutdown", "sync", "", "host", "syncInBackground", "State", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: SntpService.kt */
public final class SntpServiceImpl implements SntpService {

    /* renamed from: a */
    private final AtomicReference<State> f58524a;

    /* renamed from: b */
    private final AtomicLong f58525b;

    /* renamed from: c */
    private final ExecutorService f58526c;

    /* renamed from: d */
    private final SntpClient f58527d;

    /* renamed from: e */
    private final Clock f58528e;

    /* renamed from: f */
    private final SntpResponseCache f58529f;

    /* renamed from: g */
    private final SyncListener f58530g;

    /* renamed from: h */
    private final List<String> f58531h;

    /* renamed from: i */
    private final long f58532i;

    /* renamed from: j */
    private final long f58533j;

    /* renamed from: k */
    private final long f58534k;

    /* renamed from: l */
    private final long f58535l;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo148868d2 = {"Lcom/lyft/kronos/internal/ntp/SntpServiceImpl$State;", "", "(Ljava/lang/String;I)V", "IDLE", "SYNCING", "STOPPED", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
    /* compiled from: SntpService.kt */
    private enum State {
        IDLE,
        SYNCING,
        STOPPED
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, 0, 0, 0, 0, 480, (DefaultConstructorMarker) null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, j, 0, 0, 0, 448, (DefaultConstructorMarker) null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, j, j2, 0, 0, 384, (DefaultConstructorMarker) null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2, long j3) {
        this(sntpClient, clock, sntpResponseCache, syncListener, list, j, j2, j3, 0, 256, (DefaultConstructorMarker) null);
    }

    public SntpServiceImpl(SntpClient sntpClient, Clock clock, SntpResponseCache sntpResponseCache, SyncListener syncListener, List<String> list, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(sntpClient, "sntpClient");
        Intrinsics.checkNotNullParameter(clock, "deviceClock");
        Intrinsics.checkNotNullParameter(sntpResponseCache, "responseCache");
        Intrinsics.checkNotNullParameter(list, "ntpHosts");
        this.f58527d = sntpClient;
        this.f58528e = clock;
        this.f58529f = sntpResponseCache;
        this.f58530g = syncListener;
        this.f58531h = list;
        this.f58532i = j;
        this.f58533j = j2;
        this.f58534k = j3;
        this.f58535l = j4;
        this.f58524a = new AtomicReference<>(State.IDLE);
        this.f58525b = new AtomicLong(0);
        this.f58526c = Executors.newSingleThreadExecutor(SntpServiceImpl$executor$1.INSTANCE);
    }

    public long currentTimeMs() {
        return SntpService.DefaultImpls.currentTimeMs(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SntpServiceImpl(com.lyft.kronos.internal.ntp.SntpClient r18, com.lyft.kronos.Clock r19, com.lyft.kronos.internal.ntp.SntpResponseCache r20, com.lyft.kronos.SyncListener r21, java.util.List r22, long r23, long r25, long r27, long r29, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000e
            com.lyft.kronos.DefaultParam r1 = com.lyft.kronos.DefaultParam.INSTANCE
            long r1 = r1.getTIMEOUT_MS()
            r9 = r1
            goto L_0x0010
        L_0x000e:
            r9 = r23
        L_0x0010:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001c
            com.lyft.kronos.DefaultParam r1 = com.lyft.kronos.DefaultParam.INSTANCE
            long r1 = r1.getMIN_WAIT_TIME_BETWEEN_SYNC_MS()
            r11 = r1
            goto L_0x001e
        L_0x001c:
            r11 = r25
        L_0x001e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002a
            com.lyft.kronos.DefaultParam r1 = com.lyft.kronos.DefaultParam.INSTANCE
            long r1 = r1.getCACHE_EXPIRATION_MS()
            r13 = r1
            goto L_0x002c
        L_0x002a:
            r13 = r27
        L_0x002c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0038
            com.lyft.kronos.DefaultParam r0 = com.lyft.kronos.DefaultParam.INSTANCE
            long r0 = r0.getMAX_NTP_RESPONSE_TIME_MS()
            r15 = r0
            goto L_0x003a
        L_0x0038:
            r15 = r29
        L_0x003a:
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lyft.kronos.internal.ntp.SntpServiceImpl.<init>(com.lyft.kronos.internal.ntp.SntpClient, com.lyft.kronos.Clock, com.lyft.kronos.internal.ntp.SntpResponseCache, com.lyft.kronos.SyncListener, java.util.List, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: a */
    private final SntpClient.Response m44323a() {
        SntpClient.Response response = this.f58529f.get();
        if (!(this.f58524a.get() == State.IDLE && response != null && !response.isFromSameBoot())) {
            return response;
        }
        this.f58529f.clear();
        return null;
    }

    /* renamed from: b */
    private final long m44325b() {
        return this.f58528e.getElapsedTimeMs() - this.f58525b.get();
    }

    public KronosTime currentTime() {
        m44326c();
        SntpClient.Response a = m44323a();
        if (a != null) {
            long responseAge = a.getResponseAge();
            if (responseAge >= this.f58534k && m44325b() >= this.f58533j) {
                syncInBackground();
            }
            return new KronosTime(a.getCurrentTimeMs(), Long.valueOf(responseAge));
        } else if (m44325b() < this.f58533j) {
            return null;
        } else {
            syncInBackground();
            return null;
        }
    }

    public void syncInBackground() {
        m44326c();
        if (this.f58524a.get() != State.SYNCING) {
            this.f58526c.submit(new SntpServiceImpl$syncInBackground$1(this));
        }
    }

    public void shutdown() {
        m44326c();
        this.f58524a.set(State.STOPPED);
        this.f58526c.shutdown();
    }

    public boolean sync() {
        m44326c();
        for (String a : this.f58531h) {
            if (m44324a(a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private final void m44326c() {
        if (this.f58524a.get() == State.STOPPED) {
            throw new IllegalStateException("Service already shutdown");
        }
    }

    /* renamed from: a */
    private final boolean m44324a(String str) {
        if (this.f58524a.getAndSet(State.SYNCING) == State.SYNCING) {
            return false;
        }
        long elapsedTimeMs = this.f58528e.getElapsedTimeMs();
        SyncListener syncListener = this.f58530g;
        if (syncListener != null) {
            syncListener.onStartSync(str);
        }
        try {
            SntpClient.Response requestTime = this.f58527d.requestTime(str, Long.valueOf(this.f58532i));
            Intrinsics.checkNotNullExpressionValue(requestTime, "response");
            if (requestTime.getCurrentTimeMs() >= 0) {
                long elapsedTimeMs2 = this.f58528e.getElapsedTimeMs() - elapsedTimeMs;
                if (elapsedTimeMs2 <= this.f58535l) {
                    this.f58529f.update(requestTime);
                    long offsetMs = requestTime.getOffsetMs();
                    SyncListener syncListener2 = this.f58530g;
                    if (syncListener2 != null) {
                        syncListener2.onSuccess(offsetMs, elapsedTimeMs2);
                    }
                    return true;
                }
                throw new NTPSyncException("Ignoring response from " + str + " because the network latency (" + elapsedTimeMs2 + " ms) is longer than the required value (" + this.f58535l + " ms");
            }
            throw new NTPSyncException("Invalid time " + requestTime.getCurrentTimeMs() + " received from " + str);
        } catch (Throwable th) {
            SyncListener syncListener3 = this.f58530g;
            if (syncListener3 != null) {
                syncListener3.onError(str, th);
            }
            return false;
        } finally {
            this.f58524a.set(State.IDLE);
            this.f58525b.set(this.f58528e.getElapsedTimeMs());
        }
    }
}
