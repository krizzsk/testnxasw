package com.didi.sdk.audiorecorder.service.multiprocess.service;

import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.audiorecorder.IAudioRecord;
import com.didi.sdk.audiorecorder.IDurationChangedListener;
import com.didi.sdk.audiorecorder.IErrorListener;
import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.IGetDataServerAddressCallback;
import com.didi.sdk.audiorecorder.IRecordListener;
import com.didi.sdk.audiorecorder.ISpeechDetectListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer;
import com.didi.sdk.audiorecorder.utils.LogUtil;

final class RecordBinder extends IAudioRecord.Stub {

    /* renamed from: a */
    private static final String f38274a = "RecordBinder -> ";

    /* renamed from: j */
    private static final Handler f38275j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AudioRecorderImpl f38276b;

    /* renamed from: c */
    private AudioRecorder.FileSlicer f38277c;

    /* renamed from: d */
    private C12937c f38278d;

    /* renamed from: e */
    private C12935a f38279e;

    /* renamed from: f */
    private C12936b f38280f;

    /* renamed from: g */
    private C12938d f38281g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ServiceManager f38282h;

    /* renamed from: i */
    private final long f38283i;

    /* renamed from: k */
    private final Runnable f38284k = new Runnable() {
        public void run() {
            LogUtil.log(RecordBinder.f38274a, "StartRecordTask run");
            RecordBinder.this.f38276b.startRecord();
        }
    };

    /* renamed from: l */
    private final Runnable f38285l = new Runnable() {
        public void run() {
            LogUtil.log(RecordBinder.f38274a, "ResumeRecordTask run");
            RecordBinder.this.f38276b.resumeRecord();
        }
    };

    /* renamed from: m */
    private final Runnable f38286m = new Runnable() {
        public void run() {
            LogUtil.log(RecordBinder.f38274a, "StopServiceTask run");
            RecordBinder.this.f38282h.stopSelf();
        }
    };

    interface ServiceManager {
        void stopSelf();
    }

    RecordBinder(AudioRecorderImpl audioRecorderImpl, AudioRecorder.FileSlicer fileSlicer, C12937c cVar, C12935a aVar, C12936b bVar, C12938d dVar, ServiceManager serviceManager) {
        this.f38276b = audioRecorderImpl;
        this.f38277c = fileSlicer;
        this.f38278d = cVar;
        this.f38279e = aVar;
        this.f38280f = bVar;
        this.f38281g = dVar;
        this.f38282h = serviceManager;
        this.f38283i = System.currentTimeMillis();
    }

    public void start() {
        LogUtil.log(f38274a, "start");
        this.f38278d.mo97633b(1);
        f38275j.removeCallbacks(this.f38284k);
        f38275j.removeCallbacks(this.f38285l);
        f38275j.removeCallbacks(this.f38286m);
        long a = m28862a();
        if (a > 0) {
            f38275j.postDelayed(this.f38284k, a);
        } else {
            this.f38284k.run();
        }
    }

    public void stop() {
        LogUtil.log(f38274a, "stop");
        this.f38278d.mo97633b(2);
        f38275j.removeCallbacks(this.f38284k);
        f38275j.removeCallbacks(this.f38285l);
        f38275j.removeCallbacks(this.f38286m);
        f38275j.postDelayed(this.f38286m, 60000);
        this.f38276b.stopRecord();
    }

    public void pause() {
        LogUtil.log(f38274a, "pause");
        this.f38278d.mo97633b(4);
        f38275j.removeCallbacks(this.f38284k);
        f38275j.removeCallbacks(this.f38285l);
        f38275j.removeCallbacks(this.f38286m);
        this.f38276b.pauseRecord();
    }

    public void resume() {
        LogUtil.log(f38274a, "resume");
        this.f38278d.mo97633b(3);
        f38275j.removeCallbacks(this.f38284k);
        f38275j.removeCallbacks(this.f38285l);
        f38275j.removeCallbacks(this.f38286m);
        long a = m28862a();
        if (a > 0) {
            f38275j.postDelayed(this.f38285l, a);
        } else {
            this.f38285l.run();
        }
    }

    public boolean isRecording() {
        int a = this.f38278d.mo97628a();
        boolean z = this.f38276b.isRecording() && (a == 1 || a == 3);
        LogUtil.log(f38274a, "isRecording = " + z);
        return z;
    }

    public void updateSpeechDetectParams(String str) {
        LogUtil.log(f38274a, "updateSpeechDetectParams ： " + str);
        this.f38276b.updateSpeechDetectParams(str);
    }

    public void regRecordListener(IRecordListener iRecordListener) {
        this.f38278d.mo97631a(iRecordListener);
    }

    public void unregRecordListener() {
        this.f38278d.mo97631a((IRecordListener) null);
    }

    public void regDurationChangedListener(IDurationChangedListener iDurationChangedListener) {
        this.f38278d.mo97630a(iDurationChangedListener);
    }

    public void unregDurationChangedListener() {
        this.f38278d.mo97630a((IDurationChangedListener) null);
    }

    public void regErrorListener(IErrorListener iErrorListener) {
        this.f38279e.mo97626a(iErrorListener);
    }

    public void unregErrorListener() {
        LogUtil.log(f38274a, "unregErrorListener");
        this.f38279e.mo97626a((IErrorListener) null);
    }

    public void regFileSliceListener(IFileSliceListener iFileSliceListener) {
        this.f38280f.mo97627a(iFileSliceListener);
    }

    public void unregFileSliceListener() {
        this.f38280f.mo97627a((IFileSliceListener) null);
    }

    public void regSpeechDetectListener(ISpeechDetectListener iSpeechDetectListener) {
        this.f38281g.mo97634a(iSpeechDetectListener);
    }

    public void unregSpeechDetectListener() {
        this.f38281g.mo97634a((ISpeechDetectListener) null);
    }

    public void start16kPcmServer(final IGetDataServerAddressCallback iGetDataServerAddressCallback) {
        DataTransferServer.getInstance().startServer().acquireServerName(new DataTransferServer.AcquireServerNameCallback() {
            public void onAcquired(String str) {
                try {
                    iGetDataServerAddressCallback.onGetAddress(str);
                } catch (Exception unused) {
                }
            }
        });
        this.f38276b.setPcm16kConsumer(DataTransferServer.getInstance());
    }

    public void stop16kPcmServer() {
        this.f38276b.setPcm16kConsumer((Supporter.Pcm16kConsumer) null);
        DataTransferServer.getInstance().stopServer();
    }

    public void clearTTSData() {
        this.f38276b.clearTtsDataCache();
    }

    public void sliceAudioFile() {
        LogUtil.log(f38274a, "sliceAudioFile");
        this.f38277c.sliceAudioFile();
    }

    /* renamed from: a */
    private long m28862a() {
        return System.currentTimeMillis() - this.f38283i < 1000 ? 1000 : 0;
    }
}
