package com.didi.map.global.task.engine;

import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalTaskEngine {

    /* renamed from: a */
    private static final String f30226a = "GlobalTaskEngine";

    /* renamed from: b */
    private ExecutorService f30227b = new ThreadPoolManage().newSingleThreadExecutor();

    /* renamed from: c */
    private Handler f30228c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f30229d;

    /* renamed from: e */
    private Runnable f30230e;

    /* renamed from: f */
    private AtomicBoolean f30231f;

    /* renamed from: g */
    private AtomicBoolean f30232g;

    /* renamed from: h */
    private Runnable f30233h = new Runnable() {
        public void run() {
            GlobalTaskEngine.this.m23497a().postDelayed(this, (long) GlobalTaskEngine.this.f30229d);
            GlobalTaskEngine.this.m23500c();
        }
    };

    public GlobalTaskEngine(int i, Runnable runnable) {
        this.f30229d = i;
        this.f30230e = runnable;
        this.f30231f = new AtomicBoolean(false);
        this.f30232g = new AtomicBoolean(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Handler m23497a() {
        Handler handler;
        synchronized (GlobalTaskEngine.class) {
            if (this.f30228c == null) {
                this.f30228c = new Handler(Looper.getMainLooper());
            }
            handler = this.f30228c;
        }
        return handler;
    }

    public void setLoopTimeMillis(int i) {
        this.f30229d = i;
    }

    public boolean isRunning() {
        return this.f30231f.get();
    }

    public boolean isPaused() {
        return this.f30232g.get();
    }

    /* renamed from: b */
    private void m23499b() {
        ExecutorService executorService = this.f30227b;
        if (executorService != null && !executorService.isShutdown() && isRunning() && !isPaused()) {
            m23497a().removeCallbacksAndMessages((Object) null);
            m23497a().post(this.f30233h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m23500c() {
        ExecutorService executorService = this.f30227b;
        if (executorService != null && !executorService.isShutdown() && isRunning() && !isPaused()) {
            SystemUtils.log(3, f30226a, "Task Loop", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 68);
            this.f30227b.execute(this.f30230e);
        }
    }

    public void start() {
        if (this.f30230e == null) {
            SystemUtils.log(3, f30226a, "mLoopTask is null", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 75);
        } else if (isRunning()) {
            SystemUtils.log(3, f30226a, "mLoopTask is running", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 80);
        } else {
            SystemUtils.log(3, f30226a, "start()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 84);
            this.f30231f.set(true);
            this.f30232g.set(false);
            m23499b();
        }
    }

    public void resume() {
        if (isRunning() && isPaused()) {
            SystemUtils.log(3, f30226a, "resume()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 92);
            this.f30232g.set(false);
            m23499b();
        }
    }

    public void pause() {
        if (isRunning() && !isPaused()) {
            SystemUtils.log(3, f30226a, "pause()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 100);
            this.f30232g.set(true);
        }
    }

    public void stop() {
        SystemUtils.log(3, f30226a, "stop()", (Throwable) null, "com.didi.map.global.task.engine.GlobalTaskEngine", 106);
        this.f30231f.set(false);
        this.f30232g.set(true);
        Handler handler = this.f30228c;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f30228c = null;
        }
        ExecutorService executorService = this.f30227b;
        if (executorService != null && !executorService.isShutdown()) {
            this.f30227b.shutdownNow();
            this.f30227b = null;
        }
    }
}
