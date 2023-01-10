package com.didichuxing.apollo.sdk;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ApolloLooper {

    /* renamed from: a */
    private static final long f48249a = 900000;

    /* renamed from: b */
    private static final long f48250b = 5000;

    /* renamed from: c */
    private static volatile ApolloLooper f48251c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C15867a f48252d;

    /* renamed from: e */
    private long f48253e = 900000;

    /* renamed from: f */
    private Timer f48254f;

    /* renamed from: g */
    private TimerTask f48255g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f48256h = false;

    /* renamed from: i */
    private ScheduledThreadPoolExecutor f48257i;

    public static ApolloLooper getInstance(C15867a aVar) {
        if (f48251c == null) {
            synchronized (ApolloLooper.class) {
                if (f48251c == null) {
                    f48251c = new ApolloLooper(aVar);
                }
            }
        }
        return f48251c;
    }

    private ApolloLooper(C15867a aVar) {
        this.f48252d = aVar;
    }

    /* renamed from: a */
    private synchronized void m36165a() {
        if (!this.f48256h) {
            if (this.f48254f == null) {
                this.f48254f = new Timer();
            }
            C158651 r2 = new TimerTask() {
                public void run() {
                    if (ApolloLooper.this.f48256h && ApolloLooper.this.f48252d != null) {
                        ApolloLooper.this.f48252d.checkUpdate();
                    }
                }
            };
            this.f48255g = r2;
            this.f48254f.schedule(r2, this.f48253e, this.f48253e);
            this.f48256h = true;
        }
    }

    /* renamed from: b */
    private synchronized void m36168b() {
        this.f48256h = false;
        if (this.f48255g != null) {
            this.f48255g.cancel();
        }
    }

    public synchronized void startup() {
        if (!this.f48256h) {
            if (this.f48257i != null && !this.f48257i.isShutdown()) {
                this.f48257i.shutdownNow();
            }
            this.f48257i = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);
            this.f48257i.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    if (ApolloLooper.this.f48256h && ApolloLooper.this.f48252d != null) {
                        ApolloLooper.this.f48252d.checkUpdate();
                    }
                }
            }, this.f48253e, this.f48253e, TimeUnit.MILLISECONDS);
            this.f48256h = true;
        }
    }

    public synchronized void shutdown() {
        this.f48256h = false;
        if (this.f48257i != null) {
            this.f48257i.shutdownNow();
        }
    }

    public void setInterval(long j) {
        if (j < 5000) {
            j = 5000;
        }
        this.f48253e = j;
    }
}
