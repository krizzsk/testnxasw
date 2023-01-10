package com.didi.map.global.sctx.work.core;

import android.os.Handler;
import android.os.Looper;
import com.didi.map.utils.logger.Logger;

public class WorkManager {

    /* renamed from: a */
    private Handler f30161a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private boolean f30162b;

    public void enqueue(WorkRequest workRequest) {
        if (Logger.isLoggable()) {
            Logger.m24040d("enqueue");
        }
        this.f30162b = false;
        if (workRequest.getWorkSpec().initialDelay > 0) {
            this.f30161a.postDelayed(new Runnable(workRequest) {
                public final /* synthetic */ WorkRequest f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WorkManager.this.m23461c(this.f$1);
                }
            }, workRequest.getWorkSpec().initialDelay);
        } else {
            workRequest.getWorkSpec().worker.onRun();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m23461c(WorkRequest workRequest) {
        workRequest.getWorkSpec().worker.onRun();
        if (workRequest.getWorkSpec().intervalDuration > 0) {
            m23459a(workRequest);
        }
    }

    /* renamed from: a */
    private void m23459a(WorkRequest workRequest) {
        if (Logger.isLoggable()) {
            Logger.m24040d("runWorkInterval");
        }
        this.f30161a.postDelayed(new Runnable(workRequest) {
            public final /* synthetic */ WorkRequest f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WorkManager.this.m23460b(this.f$1);
            }
        }, workRequest.getWorkSpec().intervalDuration);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23460b(WorkRequest workRequest) {
        workRequest.getWorkSpec().worker.onRun();
        if (!this.f30162b) {
            m23459a(workRequest);
        }
    }

    public void cancelAllWork() {
        if (Logger.isLoggable()) {
            Logger.m24040d("cancelAllWOrk");
        }
        this.f30161a.removeCallbacksAndMessages((Object) null);
        this.f30162b = true;
    }
}
