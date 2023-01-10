package com.didichuxing.mlcp.drtc.sdk;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import com.didichuxing.mlcp.drtc.utils.DrtcAudioManager;

public class DrtcInCallingServiceImpl implements InCallingService {

    /* renamed from: a */
    private final DrtcSDK f50913a;

    /* renamed from: b */
    private final DrtcAudioManager f50914b;

    DrtcInCallingServiceImpl(DrtcSDK drtcSDK) {
        if (drtcSDK != null) {
            this.f50913a = drtcSDK;
            this.f50914b = drtcSDK.f50958b;
            return;
        }
        throw new NullPointerException("Drtc SDK should not be null");
    }

    public void enableSpeaker(boolean z) {
        DrtcSDK drtcSDK = this.f50913a;
        if (drtcSDK != null) {
            drtcSDK.mo125541a("[I] Client change speaker:" + z);
            this.f50914b.mo125563a(z);
        }
    }

    public void pushExternalAudioFrame(byte[] bArr) {
        DrtcPluginHandle drtcPluginHandle = this.f50913a.f50957a;
        if (drtcPluginHandle != null) {
            drtcPluginHandle.pushAudioManual(bArr);
        }
    }

    public boolean restartExAudioRec() {
        DrtcPluginHandle drtcPluginHandle = this.f50913a.f50957a;
        if (drtcPluginHandle != null) {
            return drtcPluginHandle.startExAudioRecorder();
        }
        return false;
    }

    public boolean setAudioStatus(boolean z) {
        DrtcSDK drtcSDK = this.f50913a;
        if (drtcSDK == null) {
            return false;
        }
        drtcSDK.mo125541a("[I] Client mute audio :" + z);
        this.f50913a.f50957a.mute(z);
        return true;
    }

    public boolean stopExAudioRec() {
        DrtcPluginHandle drtcPluginHandle = this.f50913a.f50957a;
        if (drtcPluginHandle != null) {
            return drtcPluginHandle.stopExAudioRecorder();
        }
        return false;
    }

    public boolean switchCamera(DrtcCameraType drtcCameraType) {
        DrtcSDK drtcSDK = this.f50913a;
        if (drtcSDK == null || drtcSDK.f50957a == null) {
            return false;
        }
        drtcSDK.mo125541a("[I] Client switch camera to :" + drtcCameraType.toString());
        return this.f50913a.f50957a.mo125519a(drtcCameraType);
    }
}
