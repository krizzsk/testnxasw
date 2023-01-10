package com.didi.sdk.audiorecorder.helper.recorder;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.AmrEncoder;
import com.didi.sdk.audiorecorder.helper.recorder.modules.AmrFileWriter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.PcmRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.modules.SilenceDetector;
import com.didi.sdk.audiorecorder.model.AudioRecordContextParcel;
import com.didi.sdk.audiorecorder.speechdetect.SpeechDetectorWrapper;
import com.didi.sdk.audiorecorder.utils.BroadcastHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class AudioRecorderImpl implements AudioRecorder, AudioRecorder.FileSlicer, AudioRecorder.Inner, Supporter.FileConsumer, Supporter.Pcm8kConsumer {

    /* renamed from: a */
    private static final String f38086a = "AudioRecorderImpl -> ";

    /* renamed from: b */
    private static final int f38087b = 1;

    /* renamed from: c */
    private static final int f38088c = 2;

    /* renamed from: d */
    private static final int f38089d = 3;

    /* renamed from: e */
    private static final int f38090e = 4;

    /* renamed from: f */
    private static final int f38091f = 5;

    /* renamed from: g */
    private static final int f38092g = 6;

    /* renamed from: h */
    private static final int f38093h = 7;

    /* renamed from: i */
    private static final int f38094i = 8;

    /* renamed from: A */
    private AudioRecorder.WordsDetectListener f38095A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public AudioRecorder.FileSliceListener f38096B;

    /* renamed from: C */
    private AudioRecorder.OnErrorListener f38097C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public AudioRecorder.DurationChangedListener f38098D;

    /* renamed from: E */
    private Supporter.Pcm16kConsumer f38099E;

    /* renamed from: F */
    private boolean f38100F;

    /* renamed from: G */
    private final ExecutorService f38101G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public final Handler f38102H = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                case 2:
                    removeMessages(5);
                    sendMessageDelayed(obtainMessage(5, AudioRecorderImpl.this.m28770b() + 1000, 0), 1000);
                    if (AudioRecorderImpl.this.f38124y != null) {
                        if (message.what == 1) {
                            AudioRecorderImpl.this.f38124y.onStart();
                        } else {
                            AudioRecorderImpl.this.f38124y.onResume();
                        }
                    }
                    if (AudioRecorderImpl.this.f38118s && AudioRecorderImpl.this.f38123x) {
                        AudioRecorderImpl.this.m28774c();
                        return;
                    }
                    return;
                case 3:
                case 4:
                    removeMessages(5);
                    if (message.what == 4) {
                        AudioRecorderImpl.this.m28761a();
                    }
                    if (AudioRecorderImpl.this.f38124y != null) {
                        if (message.what == 4) {
                            AudioRecorderImpl.this.f38124y.onStop();
                        } else {
                            AudioRecorderImpl.this.f38124y.onPause();
                        }
                    }
                    if (AudioRecorderImpl.this.f38118s && AudioRecorderImpl.this.f38123x) {
                        AudioRecorderImpl.this.m28779e();
                        return;
                    }
                    return;
                case 5:
                    int i = message.arg1;
                    AudioRecorderImpl.this.m28762a(i);
                    sendMessageDelayed(obtainMessage(5, i + 1000, 0), 1000);
                    if (AudioRecorderImpl.this.f38098D != null) {
                        AudioRecorderImpl.this.f38098D.onTimeTick(i);
                        return;
                    }
                    return;
                case 6:
                    if (AudioRecorderImpl.this.f38096B != null) {
                        AudioRecorderImpl.this.f38096B.onAudioFileSliced(((File) message.obj).getAbsolutePath());
                        return;
                    }
                    return;
                case 7:
                    if (AudioRecorderImpl.this.f38096B != null) {
                        AudioRecorderImpl.this.f38096B.onAudioFileCreated(((File) message.obj).getAbsolutePath());
                        return;
                    }
                    return;
                case 8:
                    if (AudioRecorderImpl.this.f38123x && AudioRecorderImpl.this.isRecording()) {
                        AudioRecorderImpl.this.m28777d();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: I */
    private BroadcastReceiver f38103I = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int profileConnectionState = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
            if (profileConnectionState == 0) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt headset disconnect");
            } else if (2 == profileConnectionState) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt headset connected");
                AudioRecorderImpl.this.f38102H.removeMessages(8);
                AudioRecorderImpl.this.f38102H.sendEmptyMessageDelayed(8, 1000);
            } else if (1 == profileConnectionState) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt headset connecting");
            } else if (3 == profileConnectionState) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt headset disconnecting");
            } else {
                LogUtil.log(AudioRecorderImpl.f38086a, "btn headset unknown status：" + profileConnectionState);
            }
        }
    };

    /* renamed from: J */
    private IntentFilter f38104J = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");

    /* renamed from: K */
    private BroadcastReceiver f38105K = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 0) {
                    LogUtil.log(AudioRecorderImpl.f38086a, "wired headset disconnected");
                    AudioRecorderImpl.this.f38102H.removeMessages(8);
                    AudioRecorderImpl.this.f38102H.sendEmptyMessageDelayed(8, 1000);
                } else if (1 == intExtra) {
                    LogUtil.log(AudioRecorderImpl.f38086a, "wired headset connect");
                } else {
                    LogUtil.log(AudioRecorderImpl.f38086a, "wired headset unknown status: " + intExtra);
                }
            } else {
                LogUtil.log(AudioRecorderImpl.f38086a, "wired headset broadcast empty status");
            }
        }
    };

    /* renamed from: L */
    private IntentFilter f38106L = new IntentFilter("android.intent.action.HEADSET_PLUG");

    /* renamed from: M */
    private BroadcastReceiver f38107M = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if (1 == intExtra) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt sco connected");
            } else if (2 == intExtra) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt sco connecting");
            } else if (intExtra == 0) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt sco disconnected");
            } else if (-1 == intExtra) {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt sco error");
            } else {
                LogUtil.log(AudioRecorderImpl.f38086a, "bt sco illegal state：" + intExtra);
            }
        }
    };

    /* renamed from: N */
    private IntentFilter f38108N = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");

    /* renamed from: j */
    private final File f38109j;

    /* renamed from: k */
    private final Map<String, Integer> f38110k;

    /* renamed from: l */
    private final C12903a f38111l = new C12903a();

    /* renamed from: m */
    private PcmRecorder f38112m;

    /* renamed from: n */
    private AmrEncoder f38113n;

    /* renamed from: o */
    private AmrFileWriter f38114o;

    /* renamed from: p */
    private SilenceDetector f38115p;

    /* renamed from: q */
    private SpeechDetectorWrapper f38116q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Context f38117r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f38118s;

    /* renamed from: t */
    private String f38119t;

    /* renamed from: u */
    private AudioRecordContext f38120u;

    /* renamed from: v */
    private AudioRecordContextParcel f38121v;

    /* renamed from: w */
    private File f38122w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f38123x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public AudioRecorder.RecordListener f38124y;

    /* renamed from: z */
    private AudioRecorder.RecordListener2 f38125z;

    public AudioRecorderImpl(Context context, String str) {
        this.f38117r = context;
        File file = new File(str);
        this.f38109j = file;
        if (!file.exists()) {
            this.f38109j.mkdirs();
        }
        LogUtil.log(f38086a, "default dir: " + this.f38109j.getAbsolutePath());
        this.f38110k = new HashMap();
        this.f38113n = new AmrEncoder();
        this.f38114o = new AmrFileWriter();
        this.f38115p = new SilenceDetector();
        this.f38116q = new SpeechDetectorWrapper(this.f38117r);
        this.f38114o.setFileConsumer(this);
        this.f38101G = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "didi-recorder");
                thread.setPriority(1);
                return thread;
            }
        });
        m28763a(this.f38117r);
    }

    /* renamed from: a */
    private void m28763a(final Context context) {
        this.f38101G.execute(new Runnable() {
            public void run() {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                try {
                    boolean unused = AudioRecorderImpl.this.f38118s = audioManager != null && audioManager.isBluetoothScoAvailableOffCall();
                } catch (Exception e) {
                    LogUtil.log(AudioRecorderImpl.f38086a, "Failed to get bluetoothSoc available state. ", e.getMessage());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28761a() {
        m28762a(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28762a(int i) {
        this.f38110k.put(this.f38119t, Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m28770b() {
        Integer num = this.f38110k.get(this.f38119t);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void update(AudioRecordContext audioRecordContext, AudioRecordContextParcel audioRecordContextParcel, String str, final boolean z, final String str2, String str3) {
        this.f38120u = audioRecordContext;
        this.f38121v = audioRecordContextParcel;
        this.f38119t = str;
        LogUtil.log("AudioRecorderImpl update : businessAlias = " + str);
        this.f38116q.connectToTtsServer(str3);
        m28764a(audioRecordContext, audioRecordContextParcel);
        this.f38101G.execute(new Runnable() {
            public void run() {
                AudioRecorderImpl.this.m28767a(str2);
                AudioRecorderImpl.this.m28768a(z);
            }
        });
    }

    /* renamed from: a */
    private void m28764a(AudioRecordContext audioRecordContext, AudioRecordContextParcel audioRecordContextParcel) {
        PcmRecorder a = this.f38111l.mo97477a(audioRecordContext, audioRecordContextParcel);
        PcmRecorder pcmRecorder = this.f38112m;
        if (!(pcmRecorder == null || a == pcmRecorder || !pcmRecorder.isStarted())) {
            LogUtil.log(f38086a, "Unable to switch recorder until it was stopped.");
        }
        AmrEncoder amrEncoder = this.f38113n;
        if (!(amrEncoder == null || audioRecordContextParcel == null)) {
            amrEncoder.setConfig(audioRecordContextParcel.amrConvertSwitch, audioRecordContextParcel.amrBitRate);
        }
        if (this.f38112m != a) {
            LogUtil.log(f38086a, "buildRelations");
            this.f38112m = a;
            this.f38115p.setPcm8kProvider(a);
            this.f38116q.buildRelations(a, this.f38113n, this.f38114o);
            AudioRecorder.OnErrorListener onErrorListener = this.f38097C;
            if (onErrorListener != null) {
                a.setOnErrorListener(onErrorListener);
            }
            Supporter.Pcm16kConsumer pcm16kConsumer = this.f38099E;
            if (pcm16kConsumer != null) {
                a.addPcm16kConsumer(pcm16kConsumer);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28768a(boolean z) {
        LogUtil.log(f38086a, "initBluetoothRecordConfig, isBluetoothRecordEnable = " + z + ", mScoAvailable = " + this.f38118s);
        if (this.f38118s && this.f38123x != z) {
            this.f38123x = z;
            if (!isRecording()) {
                return;
            }
            if (z) {
                m28774c();
            } else {
                m28779e();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28767a(String str) {
        LogUtil.log(f38086a, "initAudioCacheDir, target dir:" + str);
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    file = this.f38109j;
                }
                this.f38122w = file;
                LogUtil.log(f38086a, "initAudioCacheDir -> create defined cacheDir. success = " + mkdirs);
            } else if (!file.isDirectory() || !file.canRead() || !file.canWrite()) {
                this.f38122w = this.f38109j;
                LogUtil.log(f38086a, "initAudioCacheDir -> illegal dir");
            } else {
                this.f38122w = file;
            }
        } else {
            this.f38122w = this.f38109j;
        }
        LogUtil.log(f38086a, "initAudioCacheDir -> final dir: ", this.f38122w.getAbsolutePath());
    }

    public synchronized void startRecord() {
        m28764a(this.f38120u, this.f38121v);
        m28773b(true);
    }

    public synchronized void resumeRecord() {
        m28773b(false);
    }

    /* renamed from: b */
    private void m28773b(boolean z) {
        PcmRecorder pcmRecorder;
        if (!this.f38100F && (pcmRecorder = this.f38112m) != null) {
            try {
                pcmRecorder.start();
                if (this.f38112m.isStarted()) {
                    this.f38114o.start();
                    if (!this.f38114o.isStarted()) {
                        this.f38112m.stop();
                        return;
                    }
                    this.f38113n.start();
                    if (!this.f38113n.isStarted()) {
                        this.f38112m.stop();
                        this.f38114o.stop();
                        return;
                    }
                    this.f38116q.start();
                    this.f38115p.start();
                    this.f38100F = true;
                    this.f38102H.sendMessage(this.f38102H.obtainMessage(z ? 1 : 2));
                    BroadcastHelper.getInstance().sendBroadcast(9, "9");
                }
            } catch (Throwable th) {
                LogUtil.log("AudioRecorderImpl resumeRecord -> startRecording failed, state illegal. ", th.getMessage());
                AudioRecorder.OnErrorListener onErrorListener = this.f38097C;
                if (onErrorListener != null) {
                    onErrorListener.onError(0);
                }
            }
        }
    }

    public synchronized void stopRecord() {
        if (this.f38100F) {
            m28775c(true);
        }
    }

    public synchronized void pauseRecord() {
        if (this.f38100F) {
            m28775c(false);
        }
    }

    public void setRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f38124y = recordListener;
        this.f38125z = (recordListener == null || !(recordListener instanceof AudioRecorder.RecordListener2)) ? null : (AudioRecorder.RecordListener2) recordListener;
    }

    public boolean isRecording() {
        return this.f38100F;
    }

    public void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f38097C = onErrorListener;
        PcmRecorder pcmRecorder = this.f38112m;
        if (pcmRecorder != null) {
            pcmRecorder.setOnErrorListener(onErrorListener);
        }
        this.f38114o.setOnErrorListener(onErrorListener);
        this.f38115p.setOnErrorListener(onErrorListener);
    }

    /* renamed from: c */
    private void m28775c(boolean z) {
        this.f38100F = false;
        PcmRecorder pcmRecorder = this.f38112m;
        if (pcmRecorder != null) {
            pcmRecorder.stop();
        }
        this.f38113n.stop();
        this.f38114o.stop();
        this.f38116q.stop();
        this.f38115p.stop();
        Handler handler = this.f38102H;
        handler.sendMessage(handler.obtainMessage(z ? 4 : 3, (Object) null));
        BroadcastHelper.getInstance().sendBroadcast(9, "10");
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        AudioRecorder.RecordListener2 recordListener2 = this.f38125z;
        if (recordListener2 != null) {
            recordListener2.onGetPcmStream(bArr, 0, i);
        }
    }

    public File getCacheDir() {
        return this.f38122w;
    }

    public File getDefaultDir() {
        return this.f38109j;
    }

    public boolean isDefaultDir(File file) {
        return file != null && (file == this.f38109j || TextUtils.equals(file.getAbsolutePath(), this.f38109j.getAbsolutePath()));
    }

    public void sliceAudioFile() {
        if (this.f38100F) {
            this.f38114o.sliceFile();
        }
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        this.f38095A = wordsDetectListener;
        this.f38116q.setDetectListener(wordsDetectListener);
    }

    public void setDurationChangedListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f38098D = durationChangedListener;
    }

    public void setPcm16kConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        Supporter.Pcm16kConsumer pcm16kConsumer2 = this.f38099E;
        if (pcm16kConsumer2 == null || pcm16kConsumer2 != pcm16kConsumer) {
            PcmRecorder pcmRecorder = this.f38112m;
            if (pcmRecorder != null) {
                if (pcm16kConsumer != null) {
                    pcmRecorder.addPcm16kConsumer(pcm16kConsumer);
                } else {
                    pcmRecorder.removePcm16kConsumer(this.f38099E);
                }
            }
            this.f38099E = pcm16kConsumer;
        }
    }

    public void onTmpFileCreated(File file) {
        Handler handler = this.f38102H;
        handler.sendMessage(handler.obtainMessage(7, file));
    }

    public void onFileFeed(File file) {
        Handler handler = this.f38102H;
        handler.sendMessage(handler.obtainMessage(6, file));
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f38096B = fileSliceListener;
    }

    public void updateSpeechDetectParams(String str) {
        this.f38116q.updateParams(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28774c() {
        LogUtil.log(f38086a, "startBluetoothScoConnection");
        try {
            try {
                this.f38117r.registerReceiver(this.f38103I, this.f38104J);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        } catch (Exception e2) {
            LogUtil.log(f38086a, "Fail to reg mBluetoothHeadsetReceiver. " + e2.getMessage());
        }
        try {
            try {
                this.f38117r.registerReceiver(this.f38105K, this.f38106L);
            } catch (Exception e3) {
                Log.d("Context", "registerReceiver", e3);
            }
        } catch (Exception e4) {
            LogUtil.log(f38086a, "Fail to reg mWiredHeadsetReceiver. " + e4.getMessage());
        }
        try {
            try {
                this.f38117r.registerReceiver(this.f38107M, this.f38108N);
            } catch (Exception e5) {
                Log.d("Context", "registerReceiver", e5);
            }
        } catch (Exception e6) {
            LogUtil.log(f38086a, "Fail to reg mScoChangedReceiver. " + e6.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m28777d() {
        this.f38101G.execute(new Runnable() {
            public void run() {
                AudioManager audioManager;
                if (AudioRecorderImpl.this.f38123x && AudioRecorderImpl.this.isRecording() && (audioManager = (AudioManager) AudioRecorderImpl.this.f38117r.getSystemService("audio")) != null) {
                    LogUtil.log(AudioRecorderImpl.f38086a, "startBluetoothSco");
                    audioManager.setBluetoothScoOn(true);
                    audioManager.startBluetoothSco();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m28779e() {
        LogUtil.log(f38086a, "stopBluetoothScoConnection");
        this.f38102H.removeMessages(8);
        try {
            try {
                this.f38117r.unregisterReceiver(this.f38103I);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        } catch (Exception e2) {
            LogUtil.log(f38086a, "Fail to reg mWiredHeadsetReceiver. " + e2.getMessage());
        }
        try {
            try {
                this.f38117r.unregisterReceiver(this.f38105K);
            } catch (Exception e3) {
                Log.d("Context", "unregisterReceiver", e3);
            }
        } catch (Exception e4) {
            LogUtil.log(f38086a, "Fail to reg mWiredHeadsetReceiver. " + e4.getMessage());
        }
        m28781f();
    }

    /* renamed from: f */
    private void m28781f() {
        this.f38101G.execute(new Runnable() {
            public void run() {
                AudioManager audioManager = (AudioManager) AudioRecorderImpl.this.f38117r.getSystemService("audio");
                if (audioManager != null) {
                    LogUtil.log(AudioRecorderImpl.f38086a, "stopBluetoothSco");
                    audioManager.setBluetoothScoOn(false);
                    audioManager.stopBluetoothSco();
                }
            }
        });
    }

    public void clearTtsDataCache() {
        this.f38116q.clearTtsDataCache();
    }
}
