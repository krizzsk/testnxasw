package com.didi.sdk.audiorecorder.service.multiprocess.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.service.IRecordService;
import com.didi.sdk.audiorecorder.service.multiprocess.service.RecordBinder;
import com.didi.sdk.audiorecorder.utils.BroadcastHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MultiProcessRecordService extends Service implements AudioRecorder.FileSlicer, RecordBinder.ServiceManager {
    public static final String PROCESS_NAME = ":didi_recorder";

    /* renamed from: a */
    private static final String f38267a = "MultiProcessRecordService -> ";

    /* renamed from: b */
    private static final String f38268b = "recordContext";

    /* renamed from: c */
    private Binder f38269c;

    /* renamed from: d */
    private AudioRecorderImpl f38270d;

    /* renamed from: e */
    private C12937c f38271e;

    /* renamed from: f */
    private AudioRecordContextParcel f38272f;

    /* renamed from: g */
    private ExecutorService f38273g;

    public static void bind(Context context, ServiceConnection serviceConnection, AudioRecordContextParcel audioRecordContextParcel) {
        Intent intent = new Intent(context, MultiProcessRecordService.class);
        intent.putExtra(f38268b, audioRecordContextParcel);
        context.bindService(intent, serviceConnection, 1);
    }

    public static void unbind(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        LogUtil.init(applicationContext, false);
        BroadcastHelper.getInstance().init(applicationContext);
        LogUtil.log(f38267a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        this.f38273g = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "didi-recorder-service");
            }
        });
        AudioRecorderImpl audioRecorderImpl = new AudioRecorderImpl(applicationContext, getFilesDir().getAbsolutePath() + IRecordService.DEFAULT_AUDIO_CACHE_FOLDER);
        this.f38270d = audioRecorderImpl;
        C12937c cVar = new C12937c(audioRecorderImpl, this, this.f38273g);
        this.f38271e = cVar;
        audioRecorderImpl.setRecordListener(cVar);
        this.f38270d.setDurationChangedListener(this.f38271e);
        C12938d dVar = new C12938d(this.f38273g);
        this.f38270d.setSpeechDetectListener(dVar);
        C12935a aVar = new C12935a(this.f38273g);
        this.f38270d.setOnErrorListener(aVar);
        C12936b bVar = new C12936b(this.f38273g);
        this.f38270d.setFileSliceListener(bVar);
        this.f38269c = new RecordBinder(this.f38270d, this, this.f38271e, aVar, bVar, dVar, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        LogUtil.log(f38267a, "onStartCommand");
        m28860a(intent);
        return 1;
    }

    public IBinder onBind(Intent intent) {
        LogUtil.log(f38267a, "onBind");
        m28861b(intent);
        BroadcastHelper.getInstance().sendBroadcast(13, "3");
        return this.f38269c;
    }

    public void onRebind(Intent intent) {
        m28860a(intent);
    }

    public void onDestroy() {
        LogUtil.log("MultiProcessRecordService ->  -> onDestroy");
        this.f38269c = null;
        this.f38271e.mo97633b(2);
        this.f38270d.stopRecord();
        this.f38273g.shutdownNow();
        BroadcastHelper.getInstance().sendBroadcast(13, "5");
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    public void sliceAudioFile() {
        this.f38271e.mo97632b();
        this.f38270d.sliceAudioFile();
    }

    /* renamed from: a */
    private void m28860a(Intent intent) {
        if (m28861b(intent) && this.f38270d.isRecording()) {
            LogUtil.log(f38267a, "handleParamsReceived -> sliceAudio");
            sliceAudioFile();
        }
    }

    /* renamed from: b */
    private boolean m28861b(Intent intent) {
        AudioRecordContextParcel audioRecordContextParcel = (AudioRecordContextParcel) intent.getParcelableExtra(f38268b);
        if (audioRecordContextParcel == null) {
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed cancel.(empty businessAlias)");
            return false;
        } else if (audioRecordContextParcel.equals(this.f38272f)) {
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed cancel.(the same RecordContextParcel)");
            return false;
        } else {
            this.f38272f = audioRecordContextParcel;
            LogUtil.init(getApplicationContext(), audioRecordContextParcel.debugable);
            LogUtil.updateUserPhone(audioRecordContextParcel.userPhone);
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed recordContextParcel = " + audioRecordContextParcel);
            this.f38271e.mo97629a(audioRecordContextParcel.audioSegmentDuration);
            this.f38270d.update((AudioRecordContext) null, audioRecordContextParcel, audioRecordContextParcel.businessAlias, audioRecordContextParcel.isBluetoothRecordEnable, audioRecordContextParcel.audioCacheDir, audioRecordContextParcel.ttsServerName);
            LogUtil.log("MultiProcessRecordService ->  -> updateParamsIfNeed succ");
            return true;
        }
    }
}
