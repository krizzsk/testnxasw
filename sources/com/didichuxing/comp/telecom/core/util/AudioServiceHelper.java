package com.didichuxing.comp.telecom.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010!\u001a\u00020\u001aH\u0002J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/util/AudioServiceHelper;", "", "()V", "TAG", "", "value", "Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;", "changeListener", "getChangeListener", "()Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;", "setChangeListener", "(Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;)V", "isBluetoothLinked", "", "isHeadsetLinked", "isMicOn", "isSpeakerOn", "mAudioManager", "Landroid/media/AudioManager;", "mHandler", "Landroid/os/Handler;", "mReceiver", "Landroid/content/BroadcastReceiver;", "mStopCallRunnable", "Ljava/lang/Runnable;", "cancelStopCallAction", "", "checkAndConfigOutput", "destroy", "emitStopCallAction", "getSelectOutput", "", "isMickOn", "registerAudioFocusListener", "setMicOn", "newState", "setSpeakerOn", "Companion", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: AudioServiceHelper.kt */
public final class AudioServiceHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATE_BLUETOOTH = 1;
    public static final int STATE_HEADSET = 2;
    public static final int STATE_NORMAL = 4;
    public static final int STATE_SPEAKER = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f49058a = "AudioServiceHelper";

    /* renamed from: b */
    private AudioServiceListener f49059b;

    /* renamed from: c */
    private Handler f49060c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private AudioManager f49061d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f49062e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f49063f;

    /* renamed from: g */
    private boolean f49064g;

    /* renamed from: h */
    private BroadcastReceiver f49065h = new AudioServiceHelper$mReceiver$1(this);

    /* renamed from: i */
    private boolean f49066i;

    /* renamed from: j */
    private Runnable f49067j;

    public AudioServiceHelper() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        Object obj = null;
        Object systemService = appContext != null ? appContext.getSystemService("audio") : null;
        AudioManager audioManager = (AudioManager) (systemService instanceof AudioManager ? systemService : obj);
        this.f49061d = audioManager;
        if (audioManager != null) {
            audioManager.setMode(3);
            boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
            this.f49064g = isSpeakerphoneOn;
            if (isSpeakerphoneOn) {
                this.f49064g = false;
                audioManager.setSpeakerphoneOn(false);
            }
            this.f49062e = audioManager.isBluetoothScoOn();
            this.f49063f = audioManager.isWiredHeadsetOn();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            BroadcastReceiver broadcastReceiver = this.f49065h;
            if (broadcastReceiver != null) {
                try {
                    appContext.registerReceiver(broadcastReceiver, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            }
            String str = this.f49058a;
            CallLogUtil.logI(str, "AudioServiceHelper init - speakOn:" + this.f49064g + " bluetooth:" + this.f49062e + " headSet:" + this.f49063f + " normal:");
        }
        m36772a();
        m36773b();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/util/AudioServiceHelper$Companion;", "", "()V", "STATE_BLUETOOTH", "", "STATE_HEADSET", "STATE_NORMAL", "STATE_SPEAKER", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
    /* compiled from: AudioServiceHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final AudioServiceListener getChangeListener() {
        return this.f49059b;
    }

    public final void setChangeListener(AudioServiceListener audioServiceListener) {
        if (audioServiceListener != null) {
            audioServiceListener.onAudioDeviceChange(getSelectOutput());
        }
        this.f49059b = audioServiceListener;
    }

    public final int getSelectOutput() {
        if (this.f49062e) {
            return 1;
        }
        if (this.f49063f) {
            return 2;
        }
        return this.f49064g ? 3 : 4;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36772a() {
        AudioManager audioManager = this.f49061d;
        if (audioManager != null) {
            if (this.f49062e) {
                this.f49063f = false;
                this.f49064g = false;
                audioManager.setMode(3);
                audioManager.setSpeakerphoneOn(false);
                audioManager.setWiredHeadsetOn(false);
                audioManager.startBluetoothSco();
                audioManager.setBluetoothScoOn(true);
            } else if (this.f49063f) {
                this.f49062e = false;
                this.f49064g = false;
                audioManager.setMode(3);
                audioManager.setSpeakerphoneOn(false);
                audioManager.setWiredHeadsetOn(true);
                audioManager.setBluetoothScoOn(false);
            } else if (this.f49064g) {
                audioManager.setMode(3);
                audioManager.setWiredHeadsetOn(false);
                audioManager.stopBluetoothSco();
                audioManager.setBluetoothScoOn(false);
                audioManager.setSpeakerphoneOn(true);
            } else {
                audioManager.setMode(0);
                audioManager.setWiredHeadsetOn(false);
                audioManager.setBluetoothScoOn(false);
                audioManager.setSpeakerphoneOn(false);
            }
            String str = this.f49058a;
            CallLogUtil.logI(str, "checkOutputState - speakOn:" + this.f49064g + " bluetooth:" + this.f49062e + " headSet:" + this.f49063f + " normal:");
            AudioServiceListener audioServiceListener = this.f49059b;
            if (audioServiceListener != null) {
                audioServiceListener.onAudioDeviceChange(getSelectOutput());
            }
        }
    }

    public final boolean setSpeakerOn(boolean z) {
        if (this.f49062e || this.f49063f) {
            return false;
        }
        String str = this.f49058a;
        CallLogUtil.logI(str, "setSpeakerOn - newState:" + z);
        this.f49064g = z;
        m36772a();
        return true;
    }

    public final boolean isSpeakerOn() {
        return this.f49064g;
    }

    public final boolean isMickOn() {
        return this.f49066i;
    }

    public final boolean setMicOn(boolean z) {
        String str = this.f49058a;
        CallLogUtil.logI(str, "setMicOn - newState:" + z);
        this.f49066i = z;
        return z;
    }

    public final void destroy() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            try {
                appContext.unregisterReceiver(this.f49065h);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
        m36775d();
        this.f49060c = null;
        this.f49065h = null;
        this.f49061d = null;
    }

    /* renamed from: b */
    private final void m36773b() {
        AudioManager audioManager = this.f49061d;
        if (audioManager != null) {
            boolean z = false;
            int requestAudioFocus = audioManager.requestAudioFocus(new C16049x9978aa0a(this), 0, 1);
            String str = this.f49058a;
            StringBuilder sb = new StringBuilder();
            sb.append("registerAudioFocusListener - requestAudioFocus:");
            if (requestAudioFocus == 1) {
                z = true;
            }
            sb.append(z);
            CallLogUtil.logI(str, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m36774c() {
        m36775d();
        Runnable audioServiceHelper$emitStopCallAction$runnable$1 = new AudioServiceHelper$emitStopCallAction$runnable$1(this);
        Handler handler = this.f49060c;
        if (handler != null) {
            handler.postDelayed(audioServiceHelper$emitStopCallAction$runnable$1, 500);
        }
        this.f49067j = audioServiceHelper$emitStopCallAction$runnable$1;
    }

    /* renamed from: d */
    private final void m36775d() {
        Runnable runnable = this.f49067j;
        if (runnable != null) {
            this.f49067j = null;
            Handler handler = this.f49060c;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }
}
