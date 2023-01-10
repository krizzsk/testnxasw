package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IRecordListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;

final class BinderRecordStateListener extends IRecordListener.Stub {

    /* renamed from: d */
    private static final String f38223d = "BinderRecordStateListener -> ";

    /* renamed from: a */
    final LoopCheckTask f38224a = new LoopCheckTask();

    /* renamed from: b */
    AudioRecorder.RecordListener f38225b;

    /* renamed from: c */
    volatile int f38226c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f38227e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final MultiProcessRecordServiceConnection f38228f;

    BinderRecordStateListener(Handler handler, MultiProcessRecordServiceConnection multiProcessRecordServiceConnection) {
        this.f38227e = handler;
        this.f38228f = multiProcessRecordServiceConnection;
    }

    public void onStart() {
        LogUtil.log("BinderRecordStateListener -> onStart -> finalRecordState = " + this.f38226c);
        this.f38224a.start();
        if (this.f38225b != null) {
            this.f38227e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f38225b != null) {
                        BinderRecordStateListener.this.f38225b.onStart();
                    }
                }
            });
        }
    }

    public void onResume() {
        LogUtil.log("BinderRecordStateListener -> onResume -> finalRecordState = " + this.f38226c);
        this.f38224a.start();
        if (this.f38225b != null) {
            this.f38227e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f38225b != null) {
                        BinderRecordStateListener.this.f38225b.onResume();
                    }
                }
            });
        }
    }

    public void onPause() {
        LogUtil.log("BinderRecordStateListener -> onPause -> finalRecordState = " + this.f38226c);
        this.f38224a.cancel();
        if (this.f38225b != null) {
            this.f38227e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f38225b != null) {
                        BinderRecordStateListener.this.f38225b.onPause();
                    }
                }
            });
        }
    }

    public void onStop() {
        LogUtil.log("BinderRecordStateListener -> onStop -> finalRecordState = " + this.f38226c);
        this.f38224a.cancel();
        if (this.f38225b != null) {
            this.f38227e.post(new Runnable() {
                public void run() {
                    if (BinderRecordStateListener.this.f38225b != null) {
                        BinderRecordStateListener.this.f38225b.onStop();
                    }
                }
            });
        }
    }

    class LoopCheckTask implements Runnable {
        private final long LOOP_INTERVAL = 10000;
        private AtomicBoolean mRunFlag = new AtomicBoolean(false);

        LoopCheckTask() {
        }

        /* access modifiers changed from: package-private */
        public void start() {
            start(10000);
        }

        /* access modifiers changed from: package-private */
        public void start(long j) {
            cancel();
            BinderRecordStateListener.this.f38227e.postDelayed(this, j);
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            this.mRunFlag.set(false);
            BinderRecordStateListener.this.f38227e.removeCallbacks(this);
        }

        public void run() {
            if (!this.mRunFlag.get()) {
                this.mRunFlag.set(true);
                BinderRecordStateListener.this.f38228f.f38238a.execute(this);
                return;
            }
            boolean z = BinderRecordStateListener.this.f38226c == 1 || BinderRecordStateListener.this.f38226c == 3;
            LogUtil.log("BinderRecordStateListener -> loopCheckTask finalRecordState = " + BinderRecordStateListener.this.f38226c);
            if (z) {
                if (!BinderRecordStateListener.this.f38228f.isRecording()) {
                    LogUtil.log("BinderRecordStateListener -> loopCheckTask run. record status illegal");
                    if (BinderRecordStateListener.this.f38226c == 1) {
                        BinderRecordStateListener.this.f38228f.startRecord();
                    } else {
                        BinderRecordStateListener.this.f38228f.resumeRecord();
                    }
                }
                if (this.mRunFlag.get()) {
                    this.mRunFlag.set(false);
                    BinderRecordStateListener.this.f38227e.postDelayed(this, 10000);
                }
            }
        }
    }
}
