package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.IAudioRecord;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.service.IRecordServiceConnection;
import com.didi.sdk.audiorecorder.service.multiprocess.service.MultiProcessRecordService;
import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer;
import com.didi.sdk.audiorecorder.speechdetect.TTServerWrapper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class MultiProcessRecordServiceConnection implements IRecordServiceConnection {

    /* renamed from: b */
    private static final String f38237b = "MultiProcessRecordServiceConnection -> ";

    /* renamed from: a */
    final ExecutorService f38238a = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-service-conn");
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f38239c = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final BinderRecordStateListener f38240d = new BinderRecordStateListener(this.f38239c, this);

    /* renamed from: e */
    private final C12925a f38241e = new C12925a(this.f38239c, new C12929e(this.f38246j));

    /* renamed from: f */
    private final C12926b f38242f = new C12926b(this.f38239c);

    /* renamed from: g */
    private final C12927c f38243g = new C12927c(this.f38239c);

    /* renamed from: h */
    private final C12928d f38244h = new C12928d(this.f38239c);

    /* renamed from: i */
    private final CrossProcessPcm16kConsumer f38245i = new CrossProcessPcm16kConsumer();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final ServiceConnectTask f38246j = new ServiceConnectTask();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final LinkedList<CmdOp> f38247k = new LinkedList<>();

    /* renamed from: l */
    private final CmdOp f38248l = new CmdOp();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f38249m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AudioRecordContext f38250n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IAudioRecord f38251o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TTServerWrapper f38252p = new TTServerWrapper();

    MultiProcessRecordServiceConnection() {
    }

    public void updateRecordContext(String str, AudioRecordContext audioRecordContext) {
        this.f38249m = str;
        this.f38250n = audioRecordContext;
    }

    public void startRecord() {
        m28844a(1);
    }

    public void stopRecord() {
        m28844a(2);
    }

    public void resumeRecord() {
        m28844a(3);
    }

    public void pauseRecord() {
        m28844a(4);
    }

    public boolean isRecording() {
        return m28844a(5);
    }

    public void sliceAudioFile() {
        m28844a(13);
    }

    public void updateSpeechDetectParams(String str) {
        m28845a(9, (Object) str);
    }

    public void clearTtsDataCache() {
        m28844a(10);
    }

    public void setRecordStateListener(AudioRecorder.RecordListener recordListener) {
        this.f38240d.f38225b = recordListener;
        m28844a(6);
    }

    public void setRecordErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f38241e.f38253a = onErrorListener;
        m28844a(7);
    }

    public void setRecordDurationListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f38243g.f38258a = durationChangedListener;
        m28844a(11);
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f38242f.f38256a = fileSliceListener;
        m28844a(8);
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        this.f38244h.f38261a = wordsDetectListener;
        m28844a(12);
    }

    public void set16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f38245i.setInnerConsumer(pcm16kConsumer);
        m28844a(pcm16kConsumer != null ? 14 : 15);
    }

    /* renamed from: a */
    private boolean m28844a(int i) {
        return m28845a(i, (Object) null);
    }

    /* renamed from: a */
    private boolean m28845a(int i, Object obj) {
        if (i == 5) {
            return m28852c(i, obj);
        }
        m28849b(i, obj);
        return false;
    }

    /* renamed from: b */
    private void m28849b(final int i, final Object obj) {
        this.f38238a.execute(new Runnable() {
            public void run() {
                CmdOp b;
                if (!MultiProcessRecordServiceConnection.this.m28852c(i, obj) && (b = MultiProcessRecordServiceConnection.this.m28854d(i, obj)) != null) {
                    MultiProcessRecordServiceConnection.this.m28841a(b);
                    int i = i;
                    if (i == 1 || i == 3) {
                        MultiProcessRecordServiceConnection.this.f38246j.connect();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m28852c(int r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = 3
            r1 = 2
            r2 = 0
            r3 = 1
            switch(r7) {
                case 1: goto L_0x00df;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00cb;
                case 4: goto L_0x00c0;
                case 5: goto L_0x00b0;
                case 6: goto L_0x009c;
                case 7: goto L_0x0088;
                case 8: goto L_0x0072;
                case 9: goto L_0x0067;
                case 10: goto L_0x0060;
                case 11: goto L_0x004a;
                case 12: goto L_0x0034;
                case 13: goto L_0x002d;
                case 14: goto L_0x0024;
                case 15: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00eb
        L_0x0009:
            java.util.LinkedList<com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp> r8 = r6.f38247k     // Catch:{ Exception -> 0x00e9 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r4 = r6.f38248l     // Catch:{ all -> 0x0021 }
            r5 = 14
            r4.f38231c = r5     // Catch:{ all -> 0x0021 }
            java.util.LinkedList<com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp> r4 = r6.f38247k     // Catch:{ all -> 0x0021 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r5 = r6.f38248l     // Catch:{ all -> 0x0021 }
            r4.remove(r5)     // Catch:{ all -> 0x0021 }
            monitor-exit(r8)     // Catch:{ all -> 0x0021 }
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.stop16kPcmServer()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0021:
            r4 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0021 }
            throw r4     // Catch:{ Exception -> 0x00e9 }
        L_0x0024:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CrossProcessPcm16kConsumer r4 = r6.f38245i     // Catch:{ Exception -> 0x00e9 }
            r8.start16kPcmServer(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x002d:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.sliceAudioFile()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0034:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.d r8 = r6.f38244h     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder$WordsDetectListener r8 = r8.f38261a     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x0043
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.d r4 = r6.f38244h     // Catch:{ Exception -> 0x00e9 }
            r8.regSpeechDetectListener(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0043:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.unregSpeechDetectListener()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x004a:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.c r8 = r6.f38243g     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder$DurationChangedListener r8 = r8.f38258a     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x0059
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.c r4 = r6.f38243g     // Catch:{ Exception -> 0x00e9 }
            r8.regDurationChangedListener(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0059:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.unregDurationChangedListener()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0060:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.clearTTSData()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0067:
            com.didi.sdk.audiorecorder.IAudioRecord r4 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e9 }
            r4.updateSpeechDetectParams(r8)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0072:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.b r8 = r6.f38242f     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder$FileSliceListener r8 = r8.f38256a     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x0081
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.b r4 = r6.f38242f     // Catch:{ Exception -> 0x00e9 }
            r8.regFileSliceListener(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0081:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.unregFileSliceListener()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0088:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.a r8 = r6.f38241e     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder$OnErrorListener r8 = r8.f38253a     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x0096
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.a r4 = r6.f38241e     // Catch:{ Exception -> 0x00e9 }
            r8.regErrorListener(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x0096:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.unregErrorListener()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x009c:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.BinderRecordStateListener r8 = r6.f38240d     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder$RecordListener r8 = r8.f38225b     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x00aa
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.BinderRecordStateListener r4 = r6.f38240d     // Catch:{ Exception -> 0x00e9 }
            r8.regRecordListener(r4)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x00aa:
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.unregRecordListener()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x00b0:
            boolean r8 = r6.m28843a()     // Catch:{ Exception -> 0x00e9 }
            if (r8 == 0) goto L_0x00bf
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            boolean r7 = r8.isRecording()     // Catch:{ Exception -> 0x00e9 }
            if (r7 == 0) goto L_0x00bf
            r2 = 1
        L_0x00bf:
            return r2
        L_0x00c0:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.BinderRecordStateListener r8 = r6.f38240d     // Catch:{ Exception -> 0x00e9 }
            r4 = 4
            r8.f38226c = r4     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.pause()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x00cb:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.BinderRecordStateListener r8 = r6.f38240d     // Catch:{ Exception -> 0x00e9 }
            r8.f38226c = r0     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.resume()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x00d5:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.BinderRecordStateListener r8 = r6.f38240d     // Catch:{ Exception -> 0x00e9 }
            r8.f38226c = r1     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.stop()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x00df:
            com.didi.sdk.audiorecorder.service.multiprocess.conn.BinderRecordStateListener r8 = r6.f38240d     // Catch:{ Exception -> 0x00e9 }
            r8.f38226c = r3     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.IAudioRecord r8 = r6.f38251o     // Catch:{ Exception -> 0x00e9 }
            r8.start()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00f6
        L_0x00e9:
            r8 = move-exception
            goto L_0x0119
        L_0x00eb:
            java.lang.String r8 = "MultiProcessRecordServiceConnection -> "
            java.lang.String r4 = "executeCmd fail.(unknown cmd)"
            java.lang.String[] r8 = new java.lang.String[]{r8, r4}     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r8)     // Catch:{ Exception -> 0x00e9 }
        L_0x00f6:
            java.lang.String[] r8 = new java.lang.String[r1]     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = "MultiProcessRecordServiceConnection -> "
            r8[r2] = r4     // Catch:{ Exception -> 0x00e9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e9 }
            r4.<init>()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r5 = "executeCmd "
            r4.append(r5)     // Catch:{ Exception -> 0x00e9 }
            r4.append(r7)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r5 = "， result = true"
            r4.append(r5)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e9 }
            r8[r3] = r4     // Catch:{ Exception -> 0x00e9 }
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r8)     // Catch:{ Exception -> 0x00e9 }
            r2 = 1
            goto L_0x0140
        L_0x0119:
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r4 = "MultiProcessRecordServiceConnection -> "
            r0[r2] = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "executeCmd "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r7 = "， result = false, errMsg = "
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r0[r3] = r7
            java.lang.String r7 = r8.getMessage()
            r0[r1] = r7
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r0)
        L_0x0140:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessRecordServiceConnection.m28852c(int, java.lang.Object):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0098, code lost:
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x010e, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010f, code lost:
        if (r1 == null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0111, code lost:
        com.didi.sdk.audiorecorder.utils.LogUtil.log("MultiProcessRecordServiceConnection -> generateCmdOp for " + r12);
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp m28854d(int r12, java.lang.Object r13) {
        /*
            r11 = this;
            java.util.LinkedList<com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp> r0 = r11.f38247k
            monitor-enter(r0)
            java.util.LinkedList<com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp> r1 = r11.f38247k     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r2 = r11.f38248l     // Catch:{ all -> 0x0127 }
            r3 = 5
            r4 = -1
            r5 = 4
            r6 = 2
            r7 = 0
            r8 = 3
            r9 = 1
            switch(r12) {
                case 1: goto L_0x009b;
                case 2: goto L_0x0030;
                case 3: goto L_0x009b;
                case 4: goto L_0x0030;
                case 5: goto L_0x0011;
                case 6: goto L_0x0013;
                case 7: goto L_0x0013;
                case 8: goto L_0x0013;
                case 9: goto L_0x0013;
                case 10: goto L_0x0011;
                case 11: goto L_0x0013;
                case 12: goto L_0x0013;
                case 13: goto L_0x0011;
                case 14: goto L_0x0013;
                default: goto L_0x0011;
            }     // Catch:{ all -> 0x0127 }
        L_0x0011:
            goto L_0x010e
        L_0x0013:
            r2.f38231c = r12     // Catch:{ all -> 0x0127 }
            int r2 = r1.indexOf(r2)     // Catch:{ all -> 0x0127 }
            if (r2 >= 0) goto L_0x0024
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r1 = new com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp     // Catch:{ all -> 0x0127 }
            r1.<init>(r12, r13)     // Catch:{ all -> 0x0127 }
            r1.f38233e = r7     // Catch:{ all -> 0x0127 }
            goto L_0x010f
        L_0x0024:
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r1 = (com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp) r1     // Catch:{ all -> 0x0127 }
            r1.f38231c = r12     // Catch:{ all -> 0x0127 }
            r1.f38232d = r13     // Catch:{ all -> 0x0127 }
            goto L_0x010e
        L_0x0030:
            boolean r10 = r11.m28850b()     // Catch:{ all -> 0x0127 }
            if (r10 == 0) goto L_0x010e
            r2.f38231c = r12     // Catch:{ all -> 0x0127 }
            int r10 = r1.indexOf(r2)     // Catch:{ all -> 0x0127 }
            if (r10 >= 0) goto L_0x0044
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r10 = new com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp     // Catch:{ all -> 0x0127 }
            r10.<init>(r12, r13)     // Catch:{ all -> 0x0127 }
            goto L_0x004e
        L_0x0044:
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r10 = (com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp) r10     // Catch:{ all -> 0x0127 }
            r10.f38231c = r12     // Catch:{ all -> 0x0127 }
            r10.f38232d = r13     // Catch:{ all -> 0x0127 }
        L_0x004e:
            r10.f38233e = r4     // Catch:{ all -> 0x0127 }
            r2.f38231c = r9     // Catch:{ all -> 0x0127 }
            boolean r13 = r1.remove(r2)     // Catch:{ all -> 0x0127 }
            r2.f38231c = r8     // Catch:{ all -> 0x0127 }
            boolean r1 = r1.remove(r2)     // Catch:{ all -> 0x0127 }
            java.lang.String[] r2 = new java.lang.String[r3]     // Catch:{ all -> 0x0127 }
            java.lang.String r3 = "MultiProcessRecordServiceConnection -> "
            r2[r7] = r3     // Catch:{ all -> 0x0127 }
            java.lang.String r3 = "generateCmdOp -> remove cmd -> 1"
            r2[r9] = r3     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r3.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = " : "
            r3.append(r4)     // Catch:{ all -> 0x0127 }
            r3.append(r13)     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = ", "
            r3.append(r13)     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = r3.toString()     // Catch:{ all -> 0x0127 }
            r2[r6] = r13     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = "3 : "
            r2[r8] = r13     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r13.<init>()     // Catch:{ all -> 0x0127 }
            r13.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = ""
            r13.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0127 }
            r2[r5] = r13     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r2)     // Catch:{ all -> 0x0127 }
        L_0x0098:
            r1 = r10
            goto L_0x010f
        L_0x009b:
            boolean r10 = r11.m28843a()     // Catch:{ all -> 0x0127 }
            if (r10 == 0) goto L_0x010e
            r2.f38231c = r12     // Catch:{ all -> 0x0127 }
            int r10 = r1.indexOf(r2)     // Catch:{ all -> 0x0127 }
            if (r10 >= 0) goto L_0x00af
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r10 = new com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp     // Catch:{ all -> 0x0127 }
            r10.<init>(r12, r13)     // Catch:{ all -> 0x0127 }
            goto L_0x00b9
        L_0x00af:
            java.lang.Object r10 = r1.remove(r10)     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp r10 = (com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp) r10     // Catch:{ all -> 0x0127 }
            r10.f38231c = r12     // Catch:{ all -> 0x0127 }
            r10.f38232d = r13     // Catch:{ all -> 0x0127 }
        L_0x00b9:
            r10.f38233e = r4     // Catch:{ all -> 0x0127 }
            if (r12 != r9) goto L_0x00bf
            r13 = 3
            goto L_0x00c0
        L_0x00bf:
            r13 = 1
        L_0x00c0:
            r2.f38231c = r13     // Catch:{ all -> 0x0127 }
            r1.remove(r2)     // Catch:{ all -> 0x0127 }
            r2.f38231c = r6     // Catch:{ all -> 0x0127 }
            boolean r13 = r1.remove(r2)     // Catch:{ all -> 0x0127 }
            r2.f38231c = r5     // Catch:{ all -> 0x0127 }
            boolean r1 = r1.remove(r2)     // Catch:{ all -> 0x0127 }
            java.lang.String[] r2 = new java.lang.String[r3]     // Catch:{ all -> 0x0127 }
            java.lang.String r3 = "MultiProcessRecordServiceConnection -> "
            r2[r7] = r3     // Catch:{ all -> 0x0127 }
            java.lang.String r3 = "generateCmdOp -> remove cmdOp -> 2"
            r2[r9] = r3     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r3.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = " : "
            r3.append(r4)     // Catch:{ all -> 0x0127 }
            r3.append(r13)     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = ", "
            r3.append(r13)     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = r3.toString()     // Catch:{ all -> 0x0127 }
            r2[r6] = r13     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = "4 : "
            r2[r8] = r13     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r13.<init>()     // Catch:{ all -> 0x0127 }
            r13.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = ""
            r13.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0127 }
            r2[r5] = r13     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r2)     // Catch:{ all -> 0x0127 }
            goto L_0x0098
        L_0x010e:
            r1 = 0
        L_0x010f:
            if (r1 == 0) goto L_0x0125
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r13.<init>()     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = "MultiProcessRecordServiceConnection -> generateCmdOp for "
            r13.append(r2)     // Catch:{ all -> 0x0127 }
            r13.append(r12)     // Catch:{ all -> 0x0127 }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x0127 }
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String) r12)     // Catch:{ all -> 0x0127 }
        L_0x0125:
            monitor-exit(r0)     // Catch:{ all -> 0x0127 }
            return r1
        L_0x0127:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0127 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessRecordServiceConnection.m28854d(int, java.lang.Object):com.didi.sdk.audiorecorder.service.multiprocess.conn.CmdOp");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28841a(CmdOp cmdOp) {
        LogUtil.log("MultiProcessRecordServiceConnection -> addPendingOp " + cmdOp);
        synchronized (this.f38247k) {
            if (cmdOp.f38233e == 0) {
                this.f38247k.add(0, cmdOp);
            } else {
                this.f38247k.add(cmdOp);
            }
        }
    }

    private class RecordServiceConn implements ServiceConnection {
        private RecordServiceConn() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtil.log("MultiProcessRecordServiceConnection -> onServiceConnected");
            MultiProcessRecordServiceConnection.this.f38246j.resetBindingFlag();
            IAudioRecord unused = MultiProcessRecordServiceConnection.this.f38251o = IAudioRecord.Stub.asInterface(iBinder);
            executePendingCmdOps();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.log("MultiProcessRecordServiceConnection -> onServiceDisconnected");
            connRetry();
        }

        public void onBindingDied(ComponentName componentName) {
            LogUtil.log("MultiProcessRecordServiceConnection -> onBindingDied");
            connRetry();
        }

        private void connRetry() {
            MultiProcessRecordServiceConnection.this.f38246j.resetBindingFlag();
            IAudioRecord unused = MultiProcessRecordServiceConnection.this.f38251o = null;
            MultiProcessRecordServiceConnection.this.f38240d.f38224a.start();
        }

        private void executePendingCmdOps() {
            synchronized (MultiProcessRecordServiceConnection.this.f38247k) {
                LinkedList c = MultiProcessRecordServiceConnection.this.f38247k;
                if (!c.isEmpty()) {
                    ArrayList arrayList = new ArrayList(c);
                    c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        executePendingCmdOp((CmdOp) it.next());
                    }
                }
            }
        }

        private void executePendingCmdOp(CmdOp cmdOp) {
            LogUtil.log("MultiProcessRecordServiceConnection -> performPendingOp -> " + cmdOp);
            if (!MultiProcessRecordServiceConnection.this.m28852c(cmdOp.f38231c, cmdOp.f38232d) || cmdOp.f38231c == 6 || cmdOp.f38231c == 7 || cmdOp.f38231c == 9 || cmdOp.f38231c == 8 || cmdOp.f38231c == 12 || cmdOp.f38231c == 11 || cmdOp.f38231c == 14) {
                MultiProcessRecordServiceConnection.this.m28841a(cmdOp);
            }
        }
    }

    class ServiceConnectTask implements Runnable {
        private static final int MAX_BIND_RETRY_COUNT = 1;
        private int bindFailCount;
        private boolean mBindingFlag;
        /* access modifiers changed from: private */
        public final ServiceConnection mConn = new RecordServiceConn();

        ServiceConnectTask() {
        }

        public void run() {
            if (MultiProcessRecordServiceConnection.this.f38250n == null || MultiProcessRecordServiceConnection.this.f38249m == null) {
                LogUtil.log("MultiProcessRecordServiceConnection -> ServiceConnectTask cancel.(Empty AudioRecordContext)");
                this.mBindingFlag = false;
                return;
            }
            LogUtil.log("MultiProcessRecordServiceConnection -> bindRecordService...");
            this.mBindingFlag = true;
            MultiProcessRecordServiceConnection.this.f38238a.execute(new Runnable() {
                public void run() {
                    MultiProcessRecordServiceConnection.this.f38252p.getTTServerName(new DataTransferServer.AcquireServerNameCallback() {
                        public void onAcquired(String str) {
                            ServiceConnectTask.this.performBind(AudioRecordContextParcel.newInstance(MultiProcessRecordServiceConnection.this.f38249m, MultiProcessRecordServiceConnection.this.f38250n, str));
                        }
                    });
                }
            });
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
            if (r2 <= 1) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
            if (0 <= 1) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
            performBind(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            r5.bindFailCount = 0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void performBind(com.didi.sdk.audiorecorder.model.AudioRecordContextParcel r6) {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessRecordServiceConnection r2 = com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessRecordServiceConnection.this     // Catch:{ all -> 0x001d }
                com.didi.sdk.audiorecorder.AudioRecordContext r2 = r2.f38250n     // Catch:{ all -> 0x001d }
                android.content.Context r2 = r2.getAppContext()     // Catch:{ all -> 0x001d }
                android.content.ServiceConnection r3 = r5.mConn     // Catch:{ all -> 0x001d }
                com.didi.sdk.audiorecorder.service.multiprocess.service.MultiProcessRecordService.bind(r2, r3, r6)     // Catch:{ all -> 0x001d }
                r5.bindFailCount = r0     // Catch:{ all -> 0x001d }
                if (r0 == 0) goto L_0x003e
                if (r0 > r1) goto L_0x001a
            L_0x0017:
                r5.performBind(r6)
            L_0x001a:
                r5.bindFailCount = r0
                goto L_0x003e
            L_0x001d:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
                r3.<init>()     // Catch:{ all -> 0x003f }
                java.lang.String r4 = "Failed to bind record service:  bindFailCount = "
                r3.append(r4)     // Catch:{ all -> 0x003f }
                int r4 = r5.bindFailCount     // Catch:{ all -> 0x003f }
                r3.append(r4)     // Catch:{ all -> 0x003f }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x003f }
                com.didi.sdk.audiorecorder.utils.LogUtil.log(r3, r2)     // Catch:{ all -> 0x003f }
                int r2 = r5.bindFailCount     // Catch:{ all -> 0x003f }
                int r2 = r2 + r1
                r5.bindFailCount = r2     // Catch:{ all -> 0x003f }
                if (r2 == 0) goto L_0x003e
                if (r2 > r1) goto L_0x001a
                goto L_0x0017
            L_0x003e:
                return
            L_0x003f:
                r2 = move-exception
                int r3 = r5.bindFailCount
                if (r3 == 0) goto L_0x004b
                if (r3 > r1) goto L_0x0049
                r5.performBind(r6)
            L_0x0049:
                r5.bindFailCount = r0
            L_0x004b:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessRecordServiceConnection.ServiceConnectTask.performBind(com.didi.sdk.audiorecorder.model.AudioRecordContextParcel):void");
        }

        public void connect() {
            if (this.mBindingFlag) {
                LogUtil.log("MultiProcessRecordServiceConnection -> ServiceConnectTask start cancel.(is binding)");
            } else if (MultiProcessRecordServiceConnection.this.f38250n == null) {
                LogUtil.log("MultiProcessRecordServiceConnection -> Failed to start ServiceConnectTask.");
            } else {
                MultiProcessRecordServiceConnection.this.f38239c.removeCallbacks(this);
                MultiProcessRecordServiceConnection.this.f38239c.postDelayed(this, 500);
            }
        }

        public void disconnect() {
            resetBindingFlag();
            MultiProcessRecordServiceConnection.this.f38238a.execute(new Runnable() {
                public void run() {
                    MultiProcessRecordService.unbind(MultiProcessRecordServiceConnection.this.f38250n.getAppContext(), ServiceConnectTask.this.mConn);
                }
            });
        }

        public void resetBindingFlag() {
            this.mBindingFlag = false;
        }
    }

    /* renamed from: a */
    private boolean m28843a() {
        return this.f38240d.f38226c == 1 || this.f38240d.f38226c == 3;
    }

    /* renamed from: b */
    private boolean m28850b() {
        return this.f38240d.f38226c == 2 || this.f38240d.f38226c == 4;
    }
}
