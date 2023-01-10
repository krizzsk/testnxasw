package com.didichuxing.mlcp.drtc.interfaces.p193f;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle;
import org.json.JSONObject;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;

/* renamed from: com.didichuxing.mlcp.drtc.interfaces.f.d */
/* compiled from: IDrtcPluginCallbacks */
public interface C16694d extends C16692b {
    /* renamed from: a */
    void mo125464a(int i);

    /* renamed from: a */
    void mo125465a(DrtcCameraType drtcCameraType);

    /* renamed from: a */
    void mo125466a(DrtcPluginHandle drtcPluginHandle);

    /* renamed from: a */
    void mo125467a(String str);

    /* renamed from: a */
    void mo125468a(JSONObject jSONObject, JSONObject jSONObject2, DrtcPluginHandle drtcPluginHandle);

    /* renamed from: a */
    void mo125469a(MediaStream mediaStream);

    /* renamed from: a */
    void mo125470a(PeerConnection.IceConnectionState iceConnectionState);

    /* renamed from: a */
    boolean mo125471a();

    /* renamed from: c */
    DrtcPluginRoleType mo125472c();

    /* renamed from: d */
    void mo125473d();

    /* renamed from: d */
    void mo125474d(String str);

    /* renamed from: g */
    DrtcSupportedPlugins mo125475g();

    /* renamed from: o */
    void mo125476o();

    /* renamed from: p */
    String mo125477p();
}
