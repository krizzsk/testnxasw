package com.didi.sdk.audiorecorder.helper.recorder.modules;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import com.didi.sdk.audiorecorder.utils.BroadcastHelper;
import com.didi.sdk.audiorecorder.utils.ByteArrayAllocator;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MicRecorderApi28 extends PcmRecorder implements Runnable {

    /* renamed from: a */
    private static final String f38144a = "MicRecorderApi28 -> ";

    /* renamed from: b */
    private final int f38145b = 16000;

    /* renamed from: c */
    private final int f38146c = 16;

    /* renamed from: d */
    private final int f38147d = 2;

    /* renamed from: e */
    private final int f38148e = 1;

    /* renamed from: f */
    private final int f38149f = 1000;

    /* renamed from: g */
    private final ExecutorService f38150g = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-mic_recorder");
        }
    });

    /* renamed from: h */
    private AudioRecord f38151h;

    /* renamed from: i */
    private AudioManager.AudioRecordingCallback f38152i;

    public MicRecorderApi28() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f38152i = new AudioRecordingCallback();
        }
    }

    /* access modifiers changed from: protected */
    public boolean performStart() {
        if (!super.performStart() || !m28798a()) {
            return false;
        }
        this.f38150g.execute(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        m28797a(this.f38151h);
        super.performStop();
    }

    public void run() {
        while (isStarted()) {
            try {
                byte[] allocate = ByteArrayAllocator.allocate(640);
                if (allocate != null) {
                    int read = this.f38151h.read(allocate, 0, allocate.length);
                    if (read > 0) {
                        dispatchPcm16k(allocate, read);
                        byte[] resample16kTo8k = resample16kTo8k(allocate, read);
                        dispatchPcm8k(resample16kTo8k, resample16kTo8k.length);
                    } else {
                        LogUtil.log(f38144a, "run -> read len illegal : " + read);
                    }
                }
            } catch (Throwable th) {
                LogUtil.log("MicRecorderApi28 -> run -> read fail", th);
            }
        }
    }

    /* renamed from: a */
    private boolean m28798a() {
        return m28799a(0);
    }

    /* renamed from: a */
    private boolean m28799a(int i) {
        AudioRecord audioRecord = this.f38151h;
        if (audioRecord != null) {
            m28797a(audioRecord);
            this.f38151h = null;
        }
        AudioRecord b = m28800b();
        this.f38151h = b;
        if (b == null) {
            return false;
        }
        try {
            if (!m28801b(i)) {
                return false;
            }
            this.f38151h.startRecording();
            if (m28803c(i) && m28802c()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LogUtil.log("MicRecorderApi28 -> start fail. ", e);
            m28797a(this.f38151h);
            notifyError(8);
            return false;
        }
    }

    /* renamed from: b */
    private synchronized AudioRecord m28800b() {
        AudioRecord audioRecord;
        audioRecord = null;
        int minBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
        if (minBufferSize == -2) {
            LogUtil.log(f38144a, "createAudioRecord -> error_bad_value.");
            notifyError(12);
        } else if (minBufferSize == -1) {
            LogUtil.log(f38144a, "createAudioRecord -> error.");
            notifyError(13);
        } else if (minBufferSize <= 0) {
            LogUtil.log(f38144a, "createAudioRecord -> illegal buffer size: " + minBufferSize);
            notifyError(14);
        } else {
            audioRecord = new AudioRecord(0, 16000, 16, 2, minBufferSize * 2);
            if (Build.VERSION.SDK_INT >= 29) {
                audioRecord.registerAudioRecordingCallback(AsyncTask.THREAD_POOL_EXECUTOR, this.f38152i);
            }
            LogUtil.log(f38144a, "createAudioRecord succeed. sample rate: 16000");
        }
        return audioRecord;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m28797a(android.media.AudioRecord r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0018 }
            r1 = 29
            if (r0 < r1) goto L_0x0010
            android.media.AudioManager$AudioRecordingCallback r0 = r2.f38152i     // Catch:{ all -> 0x0018 }
            r3.unregisterAudioRecordingCallback(r0)     // Catch:{ all -> 0x0018 }
        L_0x0010:
            r3.stop()     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r3.release()     // Catch:{ all -> 0x0016 }
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.helper.recorder.modules.MicRecorderApi28.m28797a(android.media.AudioRecord):void");
    }

    /* renamed from: b */
    private boolean m28801b(int i) {
        if (this.f38151h.getState() == 1) {
            return true;
        }
        if (i < 1) {
            LogUtil.log(f38144a, "start -> recorder didn't init, retry...");
            SystemClock.sleep(1000);
            return m28799a(i + 1);
        }
        LogUtil.log(f38144a, "start -> recorder didn't init.");
        m28797a(this.f38151h);
        notifyError(5);
        return false;
    }

    /* renamed from: c */
    private boolean m28803c(int i) {
        if (this.f38151h.getRecordingState() == 3) {
            return true;
        }
        if (i < 1) {
            LogUtil.log(f38144a, "start -> recorder status error, retry...   " + this.f38151h.getRecordingState());
            SystemClock.sleep(1000);
            return m28799a(i + 1);
        }
        LogUtil.log(f38144a, "start -> recorder status error " + this.f38151h.getRecordingState());
        m28797a(this.f38151h);
        notifyError(6);
        return false;
    }

    /* renamed from: c */
    private boolean m28802c() {
        byte[] allocate = ByteArrayAllocator.allocate(640);
        int read = allocate != null ? this.f38151h.read(allocate, 0, 640) : 0;
        if (read > 0) {
            return true;
        }
        String[] strArr = new String[2];
        strArr[0] = f38144a;
        StringBuilder sb = new StringBuilder();
        sb.append("start -> record test fail, read size = ");
        sb.append(read);
        sb.append(allocate == null ? " ~ failed to allocate byte buffer" : "");
        strArr[1] = sb.toString();
        LogUtil.log(strArr);
        m28797a(this.f38151h);
        notifyError(7);
        return false;
    }

    private class AudioRecordingCallback extends AudioManager.AudioRecordingCallback {
        private AudioRecordingCallback() {
        }

        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            super.onRecordingConfigChanged(list);
            if (Build.VERSION.SDK_INT >= 29) {
                LogUtil.log("MicRecorderApi28 -> onRecordingConfigChanged   " + list);
                BroadcastHelper.getInstance().sendBroadcast(9, "11");
            }
        }
    }
}
