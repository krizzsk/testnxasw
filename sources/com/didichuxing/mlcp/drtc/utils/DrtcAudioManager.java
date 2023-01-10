package com.didichuxing.mlcp.drtc.utils;

import android.content.Context;
import android.media.AudioManager;
import com.didi.sdk.apm.SystemUtils;
import org.webrtc.ThreadUtils;

public class DrtcAudioManager {

    /* renamed from: a */
    private AudioManager f51007a;

    /* renamed from: b */
    private AudioManagerState f51008b;

    /* renamed from: c */
    private int f51009c = 2;

    /* renamed from: d */
    private boolean f51010d;

    /* renamed from: e */
    private boolean f51011e;

    public enum AudioDevice {
        SPEAKER_PHONE,
        WIRED_HEADSET,
        EARPIECE,
        BLUETOOTH,
        NONE
    }

    public enum AudioManagerState {
        UNINITIALIZED,
        PREINITIALIZED,
        RUNNING
    }

    /* renamed from: com.didichuxing.mlcp.drtc.utils.DrtcAudioManager$a */
    public interface C16714a {
    }

    private DrtcAudioManager(Context context) {
        SystemUtils.log(3, "DrtcAudioManager", "ctor", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 12);
        ThreadUtils.checkIsOnMainThread();
        this.f51007a = (AudioManager) context.getSystemService("audio");
        this.f51008b = AudioManagerState.UNINITIALIZED;
    }

    /* renamed from: a */
    public static DrtcAudioManager m38156a(Context context) {
        return new DrtcAudioManager(context);
    }

    /* renamed from: a */
    public void mo125562a(C16714a aVar) {
        SystemUtils.log(3, "DrtcAudioManager", "start", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 2);
        ThreadUtils.checkIsOnMainThread();
        if (this.f51008b == AudioManagerState.RUNNING) {
            SystemUtils.log(6, "DrtcAudioManager", "AudioManager is already active", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 5);
            return;
        }
        SystemUtils.log(3, "DrtcAudioManager", "AudioManager starts...", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 9);
        this.f51008b = AudioManagerState.RUNNING;
        this.f51009c = this.f51007a.getMode();
        this.f51010d = this.f51007a.isSpeakerphoneOn();
        this.f51011e = this.f51007a.isMicrophoneMute();
        this.f51007a.getStreamVolume(0);
        SystemUtils.log(3, "DrtcAudioManager", "Current Audio Setting: audioMode:[" + this.f51009c + "] Speaker:[" + this.f51010d + " ] Mute:" + this.f51011e, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 19);
        this.f51007a.setMode(3);
    }

    /* renamed from: a */
    public void mo125561a() {
        SystemUtils.log(3, "DrtcAudioManager", "Stop,reset audio status", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 24);
        if (this.f51008b != AudioManagerState.RUNNING) {
            SystemUtils.log(6, "DrtcAudioManager", "Trying to stop AudioManager in incorrect state: " + this.f51008b, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 27);
            return;
        }
        this.f51008b = AudioManagerState.UNINITIALIZED;
        mo125563a(this.f51010d);
        this.f51007a.setMode(this.f51009c);
        SystemUtils.log(3, "DrtcAudioManager", "AudioManager stopped", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.DrtcAudioManager", 38);
    }

    /* renamed from: a */
    public void mo125563a(boolean z) {
        if (this.f51007a.isSpeakerphoneOn() != z) {
            this.f51007a.setSpeakerphoneOn(z);
        }
    }
}
