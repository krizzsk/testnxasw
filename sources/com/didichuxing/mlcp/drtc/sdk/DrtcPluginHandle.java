package com.didichuxing.mlcp.drtc.sdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.RTCConsts;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcTransactionType;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16694d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16697g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16698h;
import com.didichuxing.mlcp.drtc.models.C16700a;
import com.didichuxing.mlcp.drtc.p192a.C16679e;
import com.didichuxing.mlcp.drtc.utils.C16718d;
import com.didichuxing.mlcp.drtc.utils.C16724g;
import java.lang.Thread;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Camera1Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.EglBase;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;

public class DrtcPluginHandle {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f50915c = "DrtcPluginHandle";

    /* renamed from: A */
    private PeerConnectionFactory.Options f50916A;

    /* renamed from: B */
    private SurfaceTextureHelper f50917B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public DrtcPluginRoleType f50918C;

    /* renamed from: D */
    private C16718d f50919D = null;

    /* renamed from: E */
    private Thread f50920E = null;

    /* renamed from: F */
    private int f50921F = 3;

    /* renamed from: G */
    private final CameraVideoCapturer.CameraEventsHandler f50922G = new C16704b();

    /* renamed from: a */
    public final DrtcSupportedPlugins f50923a;

    /* renamed from: b */
    public final Context f50924b;

    /* renamed from: d */
    private final BigInteger f50925d;

    /* renamed from: e */
    private final C16679e f50926e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C16694d f50927f;

    /* renamed from: g */
    private final ExecutorService f50928g = Executors.newSingleThreadExecutor();

    /* renamed from: h */
    private final ScheduledExecutorService f50929h = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: i */
    private String f50930i;

    /* renamed from: j */
    private String f50931j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MediaStream f50932k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SessionDescription f50933l = null;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public PeerConnection f50934m = null;

    /* renamed from: n */
    private AudioDeviceModule f50935n = null;

    /* renamed from: o */
    private RtpSender f50936o = null;

    /* renamed from: p */
    private VideoCapturer f50937p;

    /* renamed from: q */
    private DrtcCameraType f50938q;

    /* renamed from: r */
    private int f50939r = 8000;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f50940s = true;

    /* renamed from: t */
    private boolean f50941t = false;

    /* renamed from: u */
    private boolean f50942u = false;

    /* renamed from: v */
    private boolean f50943v = true;

    /* renamed from: w */
    private boolean f50944w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f50945x = true;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f50946y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public PeerConnectionFactory f50947z = null;

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$a */
    class C16703a implements JavaAudioDeviceModule.AudioRecordStateCallback {
        C16703a() {
        }

        public void onWebRtcAudioRecordStart() {
            boolean unused = DrtcPluginHandle.this.f50946y = true;
            if (DrtcPluginHandle.this.f50945x && DrtcPluginHandle.this.f50918C == DrtcPluginRoleType.PublisherRole) {
                DrtcPluginHandle.this.startExAudioRecorder();
            }
        }

        public void onWebRtcAudioRecordStop() {
            boolean unused = DrtcPluginHandle.this.f50946y = false;
            DrtcPluginHandle.this.stopExAudioRecorder();
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$b */
    class C16704b implements CameraVideoCapturer.CameraEventsHandler {
        C16704b() {
        }

        public void onCameraClosed() {
        }

        public void onCameraDisconnected() {
        }

        public void onCameraError(String str) {
            DrtcPluginHandle.this.f50927f.mo125474d(str);
        }

        public void onCameraFreezed(String str) {
        }

        public void onCameraOpening(String str) {
        }

        public void onFirstFrameAvailable() {
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$c */
    static /* synthetic */ class C16705c {

        /* renamed from: a */
        static final /* synthetic */ int[] f50950a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.webrtc.PeerConnection$IceGatheringState[] r0 = org.webrtc.PeerConnection.IceGatheringState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50950a = r0
                org.webrtc.PeerConnection$IceGatheringState r1 = org.webrtc.PeerConnection.IceGatheringState.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50950a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.webrtc.PeerConnection$IceGatheringState r1 = org.webrtc.PeerConnection.IceGatheringState.NEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50950a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.webrtc.PeerConnection$IceGatheringState r1 = org.webrtc.PeerConnection.IceGatheringState.GATHERING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle.C16705c.<clinit>():void");
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$d */
    private class C16706d extends AsyncTask<C16698h, Void, Void> {
        private C16706d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(C16698h... hVarArr) {
            C16698h hVar = hVarArr[0];
            if (DrtcPluginHandle.this.f50947z == null) {
                hVar.mo125407c("WebRtc PeerFactory is not initialized. Please call initializeMediaContext");
                return null;
            }
            JSONObject j = hVar.mo125427j();
            if (j != null) {
                if (DrtcPluginHandle.this.f50934m == null) {
                    DrtcPluginHandle.this.f50927f.mo125407c("No peerconnection created, if this is an answer please use createAnswer");
                    return null;
                }
                try {
                    DrtcPluginHandle.this.f50934m.setRemoteDescription(new C16708f(hVar), new SessionDescription(SessionDescription.Type.fromCanonicalForm(j.getString("type")), j.getString("sdp")));
                } catch (JSONException e) {
                    hVar.mo125407c(e.getMessage());
                }
            }
            return null;
        }

        /* synthetic */ C16706d(DrtcPluginHandle drtcPluginHandle, C16703a aVar) {
            this();
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$e */
    private class C16707e extends AsyncTask<C16698h, Void, Void> {
        private C16707e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(C16698h... hVarArr) {
            DrtcPluginHandle.this.m38035d(hVarArr[0]);
            return null;
        }

        /* synthetic */ C16707e(DrtcPluginHandle drtcPluginHandle, C16703a aVar) {
            this();
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f */
    private class C16708f implements PeerConnection.Observer, SdpObserver {

        /* renamed from: a */
        private final C16698h f50953a;

        C16708f(C16698h hVar) {
            this.f50953a = hVar;
        }

        public void onAddStream(MediaStream mediaStream) {
            String a = DrtcPluginHandle.f50915c;
            SystemUtils.log(3, a, "[I] Adding remote stream " + mediaStream.getId(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
            MediaStream unused = DrtcPluginHandle.this.f50932k = mediaStream;
            DrtcPluginHandle.this.m38025a(mediaStream);
        }

        public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
            String a = DrtcPluginHandle.f50915c;
            SystemUtils.log(3, a, "[I] On add track,receiver id:" + rtpReceiver.mo42893id() + " ms length:" + mediaStreamArr.length, (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }

        public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
            PeerConnection.Observer.CC.$default$onConnectionChange(this, peerConnectionState);
        }

        public void onCreateFailure(String str) {
            C16698h hVar = this.f50953a;
            hVar.mo125407c("[E] Create local SDP failure:" + str);
        }

        public void onCreateSuccess(SessionDescription sessionDescription) {
            this.f50953a.mo125407c("[I] Create local SDP Success");
            DrtcPluginHandle.this.m38026a(sessionDescription, this.f50953a);
        }

        public void onDataChannel(DataChannel dataChannel) {
            SystemUtils.log(3, DrtcPluginHandle.f50915c, "we don't have any channel", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }

        public void onIceCandidate(IceCandidate iceCandidate) {
            if (DrtcPluginHandle.this.f50940s) {
                DrtcPluginHandle.this.m38024a(iceCandidate);
            }
        }

        public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
            this.f50953a.mo125407c("[I] ICE candidate removing...");
        }

        public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
            C16698h hVar = this.f50953a;
            hVar.mo125407c("[I] ICE connection change to:" + iceConnectionState.toString());
            if (DrtcPluginHandle.this.f50927f != null) {
                DrtcPluginHandle.this.f50927f.mo125470a(iceConnectionState);
            }
        }

        public void onIceConnectionReceivingChange(boolean z) {
            C16698h hVar = this.f50953a;
            hVar.mo125407c("[I] ICE connection Receiving change to:" + z);
        }

        public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
            if (C16705c.f50950a[iceGatheringState.ordinal()] == 1) {
                if (!DrtcPluginHandle.this.f50940s) {
                    DrtcPluginHandle drtcPluginHandle = DrtcPluginHandle.this;
                    SessionDescription unused = drtcPluginHandle.f50933l = drtcPluginHandle.f50934m.getLocalDescription();
                    DrtcPluginHandle.this.m38041f(this.f50953a);
                } else {
                    DrtcPluginHandle.this.m38024a((IceCandidate) null);
                }
            }
            C16698h hVar = this.f50953a;
            hVar.mo125407c("[I] ICE gathering change to:" + iceGatheringState.toString());
        }

        public void onRemoveStream(MediaStream mediaStream) {
            String a = DrtcPluginHandle.f50915c;
            SystemUtils.log(6, a, "[I] Removing remote stream " + mediaStream.getId(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
            if (mediaStream != null && mediaStream.videoTracks.size() > 0) {
                mediaStream.videoTracks.get(0).setEnabled(false);
                mediaStream.dispose();
            }
        }

        public void onRenegotiationNeeded() {
            SystemUtils.log(3, DrtcPluginHandle.f50915c, "[I] Ice Renegotiation needed", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }

        public /* synthetic */ void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
            PeerConnection.Observer.CC.$default$onSelectedCandidatePairChanged(this, candidatePairChangeEvent);
        }

        public void onSetFailure(String str) {
            C16698h hVar = this.f50953a;
            hVar.mo125407c("[E] On set Remote SDP Failure" + str);
        }

        public void onSetSuccess() {
            this.f50953a.mo125407c("[I] Set Remote SDP Success");
            if (DrtcPluginHandle.this.f50933l == null) {
                DrtcPluginHandle.this.m38018a(this.f50953a, (Boolean) false);
            }
        }

        public void onSignalingChange(PeerConnection.SignalingState signalingState) {
            C16698h hVar = this.f50953a;
            hVar.mo125407c("[I] RTC signaling change to:" + signalingState.toString());
        }

        public /* synthetic */ void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
            PeerConnection.Observer.CC.$default$onStandardizedIceConnectionChange(this, iceConnectionState);
        }

        public void onTrack(RtpTransceiver rtpTransceiver) {
            String a = DrtcPluginHandle.f50915c;
            SystemUtils.log(3, a, "[I] On add transceiver,transceiver id:" + rtpTransceiver.getMid() + " ,type:" + rtpTransceiver.getMediaType(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle$f", 1);
        }
    }

    public DrtcPluginHandle(C16679e eVar, Context context, DrtcSupportedPlugins drtcSupportedPlugins, BigInteger bigInteger, C16694d dVar, DrtcPluginRoleType drtcPluginRoleType, boolean z) {
        this.f50926e = eVar;
        this.f50923a = drtcSupportedPlugins;
        this.f50925d = bigInteger;
        this.f50927f = dVar;
        this.f50924b = context;
        this.f50918C = drtcPluginRoleType;
        this.f50938q = DrtcCameraType.FrontFace;
        this.f50945x = z;
        PeerConnectionFactory.Options options = new PeerConnectionFactory.Options();
        this.f50916A = options;
        options.disableNetworkMonitor = true;
        this.f50928g.execute(new Runnable() {
            public final void run() {
                DrtcPluginHandle.this.m38033c();
            }
        });
    }

    public void detach() {
        this.f50926e.mo125400a(new JSONObject(), DrtcMessageType.detach, this.f50925d);
    }

    public DrtcPluginRoleType getPluginRoleType() {
        return this.f50918C;
    }

    public void getStats() {
        if (this.f50934m != null) {
            this.f50927f.mo125464a(this.f50921F);
            this.f50921F = 3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hangUp() {
        /*
            r4 = this;
            com.didichuxing.mlcp.drtc.interfaces.f.d r0 = r4.f50927f
            r0.mo125476o()
            java.util.concurrent.ScheduledExecutorService r0 = r4.f50929h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isShutdown()
            if (r0 != 0) goto L_0x0014
            java.util.concurrent.ScheduledExecutorService r0 = r4.f50929h
            r0.shutdown()
        L_0x0014:
            com.didichuxing.mlcp.drtc.utils.d r0 = r4.f50919D
            if (r0 == 0) goto L_0x001b
            r0.mo125575b()
        L_0x001b:
            org.webrtc.PeerConnection r0 = r4.f50934m
            r1 = 0
            if (r0 == 0) goto L_0x0051
            org.webrtc.PeerConnection$SignalingState r0 = r0.signalingState()
            org.webrtc.PeerConnection$SignalingState r2 = org.webrtc.PeerConnection.SignalingState.CLOSED
            if (r0 == r2) goto L_0x0051
            org.webrtc.PeerConnection r0 = r4.f50934m
            java.util.List r0 = r0.getTransceivers()
            java.util.Iterator r0 = r0.iterator()
        L_0x0032:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r0.next()
            org.webrtc.RtpTransceiver r2 = (org.webrtc.RtpTransceiver) r2
            if (r2 == 0) goto L_0x0032
            boolean r3 = r2.isStopped()
            if (r3 != 0) goto L_0x0032
            r2.stop()
            goto L_0x0032
        L_0x004a:
            org.webrtc.PeerConnection r0 = r4.f50934m
            r0.dispose()
            r4.f50934m = r1
        L_0x0051:
            org.webrtc.PeerConnectionFactory r0 = r4.f50947z
            if (r0 == 0) goto L_0x005a
            r0.dispose()
            r4.f50947z = r1
        L_0x005a:
            r4.f50933l = r1
            r0 = 1
            r4.f50940s = r0
            r0 = 0
            r4.f50941t = r0
            r4.f50942u = r0
            org.webrtc.VideoCapturer r0 = r4.f50937p     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            if (r0 == 0) goto L_0x0072
            org.webrtc.VideoCapturer r0 = r4.f50937p     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            r0.stopCapture()     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            r4.f50937p = r1     // Catch:{ InterruptedException -> 0x0072, all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r0 = move-exception
            throw r0
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle.hangUp():void");
    }

    public void mute(boolean z) {
        if (this.f50936o != null || (this.f50918C == DrtcPluginRoleType.PublisherRole && this.f50935n != null)) {
            C16694d dVar = this.f50927f;
            dVar.mo125407c("[I] Audio sender mute audio :" + z);
            this.f50935n.setMicrophoneMute(z);
        }
    }

    public void onDetached() {
        this.f50927f.mo125473d();
    }

    public void onMediaStreamArrived(String str, String str2) {
        this.f50927f.mo125407c(String.format("[I] Media stream arrived,type:%s -- receiving:%s", new Object[]{str, str2}));
        this.f50929h.scheduleAtFixedRate(new Runnable() {
            public final void run() {
                DrtcPluginHandle.this.getStats();
            }
        }, 0, 10000, TimeUnit.MILLISECONDS);
    }

    public void onMessage(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f50927f.mo125468a(jSONObject, jSONObject2, this);
    }

    public void pushAudioManual(byte[] bArr) {
        AudioDeviceModule audioDeviceModule;
        if (Build.VERSION.SDK_INT <= 28 && (audioDeviceModule = this.f50935n) != null && bArr != null && bArr.length > 0 && this.f50946y) {
            audioDeviceModule.setAudioBuffer(bArr);
        }
    }

    public void speakerStatus(boolean z) {
        if (this.f50936o != null || (this.f50918C == DrtcPluginRoleType.PublisherRole && this.f50935n != null)) {
            this.f50935n.setSpeakerMute(!z);
        }
    }

    public boolean startExAudioRecorder() {
        if (Build.VERSION.SDK_INT > 28) {
            return true;
        }
        if (this.f50919D == null) {
            C16718d c = C16718d.m38167c();
            this.f50919D = c;
            c.mo125573a(new C16718d.C16719a() {
                /* renamed from: a */
                public final void mo125513a(byte[] bArr) {
                    DrtcPluginHandle.this.m38027a(bArr);
                }
            });
            this.f50920E = new Thread(this.f50919D);
        }
        if (!this.f50919D.mo125574a() && this.f50920E.getState() != Thread.State.NEW) {
            this.f50920E = null;
            this.f50920E = new Thread(this.f50919D);
        }
        this.f50920E.start();
        return true;
    }

    public boolean stopExAudioRecorder() {
        C16718d dVar;
        if (Build.VERSION.SDK_INT <= 28 && (dVar = this.f50919D) != null && dVar.mo125574a()) {
            this.f50919D.mo125575b();
        }
        return true;
    }

    public void updateNtQua(int i) {
        this.f50921F = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m38033c() {
        this.f50930i = RTCConsts.VIDEO_CODEC_H264;
        this.f50931j = RTCConsts.AUDIO_CODEC_OPUS;
        if (this.f50943v) {
            AudioDeviceModule d = m38034d();
            this.f50935n = d;
            if (d != null) {
                this.f50947z = PeerConnectionFactory.builder().setOptions(this.f50916A).setAudioDeviceModule(this.f50935n).createPeerConnectionFactory();
                this.f50935n.release();
                this.f50935n.setMicrophoneMute(false);
            }
        } else {
            this.f50947z = PeerConnectionFactory.builder().setOptions(this.f50916A).createPeerConnectionFactory();
        }
        this.f50944w = true;
    }

    /* renamed from: d */
    private AudioDeviceModule m38034d() {
        if (this.f50924b == null) {
            this.f50927f.mo125407c("[E] Create audio device failed since ctx is null");
            return null;
        } else if (Build.VERSION.SDK_INT > 28) {
            this.f50927f.mo125407c("[I] Create audio device with default recorder");
            JavaAudioDeviceModule.Builder builder = JavaAudioDeviceModule.builder(this.f50924b);
            getClass();
            return builder.setAudioFormat(2).setInputSampleRate(this.f50939r).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).setAudioSource(7).setNeedLocalAuidoRecord(true).createAudioDeviceModule();
        } else {
            this.f50927f.mo125407c("[I] Create audio device with extra recorder");
            JavaAudioDeviceModule.Builder builder2 = JavaAudioDeviceModule.builder(this.f50924b);
            getClass();
            return builder2.setAudioFormat(2).setInputSampleRate(this.f50939r).setUseHardwareAcousticEchoCanceler(true).setUseHardwareNoiseSuppressor(true).setAudioRecordStateCallback(new C16703a()).setAudioSource(7).setNeedLocalAuidoRecord(false).createAudioDeviceModule();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m38041f(C16698h hVar) {
        if (this.f50933l != null) {
            SessionDescription localDescription = this.f50934m.getLocalDescription();
            this.f50933l = localDescription;
            if (!this.f50942u) {
                this.f50942u = true;
                try {
                    SessionDescription sessionDescription = new SessionDescription(this.f50933l.type, C16724g.m38188a(C16724g.m38188a(C16724g.m38189a(this.f50930i, true, localDescription.description, 1), this.f50930i, false), this.f50931j, true));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdp", sessionDescription.description);
                    jSONObject.put("type", sessionDescription.type.canonicalForm());
                    hVar.mo125425a(jSONObject);
                } catch (JSONException e) {
                    hVar.mo125407c("[ERROR]Send sdp error:" + e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo125522c(C16698h hVar) {
        new C16706d(this, (C16703a) null).execute(new C16698h[]{hVar});
        this.f50927f.mo125407c("[I] Handling remote Jsep");
    }

    /* renamed from: e */
    private AudioTrack m38038e() {
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_ECHO_CANCELLATION_CONSTRAINT, "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT, "true"));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_HIGH_PASS_FILTER_CONSTRAINT, SDKConsts.BOOLEAN_FALSE));
        mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.AUDIO_NOISE_SUPPRESSION_CONSTRAINT, "true"));
        PeerConnectionFactory peerConnectionFactory = this.f50947z;
        if (peerConnectionFactory == null) {
            this.f50927f.mo125407c("[E] Create audio track failed:factory is null");
            return null;
        }
        AudioSource createAudioSource = peerConnectionFactory.createAudioSource(mediaConstraints);
        if (createAudioSource == null) {
            this.f50927f.mo125407c("[E] Audio source create failed");
            return null;
        }
        this.f50927f.mo125407c("[I] Audio source create success");
        return this.f50947z.createAudioTrack(RTCConsts.AUDIO_TRACK_ID, createAudioSource);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo125518a(C16698h hVar) {
        new C16707e(this, (C16703a) null).execute(new C16698h[]{hVar});
        this.f50927f.mo125407c("[I] Creating offer sdp");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public BigInteger mo125520b() {
        return this.f50925d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38027a(byte[] bArr) {
        this.f50935n.setAudioBuffer(bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo125517a(C16697g gVar) {
        this.f50926e.mo125396a(DrtcTransactionType.plugin_handle_message, this.f50925d, gVar, this.f50923a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo125521b(C16698h hVar) {
        new C16707e(this, (C16703a) null).execute(new C16698h[]{hVar});
        this.f50927f.mo125407c("[I] Creating answer sdp");
    }

    /* renamed from: a */
    private void m38019a(C16698h hVar, MediaStreamTrack mediaStreamTrack, MediaStreamTrack mediaStreamTrack2) {
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(this.f50926e.mo125416u());
        rTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
        rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
        rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rTCConfiguration.keyType = PeerConnection.KeyType.ECDSA;
        rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        rTCConfiguration.iceTransportsType = this.f50926e.f50870a;
        rTCConfiguration.presumeWritableWhenFullyRelayed = true;
        rTCConfiguration.disableIpv6 = true;
        rTCConfiguration.iceCandidatePoolSize = 0;
        rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
        rTCConfiguration.iceConnectionReceivingTimeout = 3000;
        do {
        } while (!this.f50944w);
        PeerConnectionFactory peerConnectionFactory = this.f50947z;
        if (peerConnectionFactory != null) {
            PeerConnection createPeerConnection = peerConnectionFactory.createPeerConnection(rTCConfiguration, (PeerConnection.Observer) new C16708f(hVar));
            this.f50934m = createPeerConnection;
            if (createPeerConnection == null) {
                hVar.mo125407c("[E] Create peerconnection failed");
                return;
            }
            hVar.mo125407c("[I] PeerConnection is prepared and creating... ");
            RtpTransceiver.RtpTransceiverInit a = m38014a(hVar, true);
            if (mediaStreamTrack != null && a != null) {
                this.f50936o = this.f50934m.addTransceiver(mediaStreamTrack, a).getSender();
            } else if (a != null) {
                hVar.mo125407c("[E] audio track is null,add audio track self");
                this.f50936o = this.f50934m.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO, a).getSender();
            }
            RtpTransceiver.RtpTransceiverInit a2 = m38014a(hVar, false);
            if (mediaStreamTrack2 != null) {
                this.f50934m.addTransceiver(mediaStreamTrack2, a2).getSender();
            } else if (a2 != null) {
                this.f50934m.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, a2).getSender();
            }
            if (hVar.mo125427j() == null) {
                m38018a(hVar, (Boolean) true);
                return;
            }
            try {
                JSONObject j = hVar.mo125427j();
                this.f50934m.setRemoteDescription(new C16708f(hVar), new SessionDescription(SessionDescription.Type.fromCanonicalForm(j.getString("type")), j.getString("sdp")));
            } catch (Exception e) {
                hVar.mo125407c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m38035d(C16698h hVar) {
        MediaStreamTrack mediaStreamTrack;
        MediaStreamTrack mediaStreamTrack2;
        if (this.f50934m == null) {
            this.f50940s = hVar.mo125430s() != null ? hVar.mo125430s().booleanValue() : false;
            do {
            } while (!this.f50944w);
            MediaStreamTrack mediaStreamTrack3 = null;
            if (this.f50918C == DrtcPluginRoleType.PublisherRole) {
                if (hVar.mo125429r().mo125504f()) {
                    mediaStreamTrack2 = m38038e();
                    if (mediaStreamTrack2 == null) {
                        hVar.mo125407c("[E] Audio track created fail");
                    } else {
                        hVar.mo125407c("[I] Audio track created success");
                    }
                } else {
                    mediaStreamTrack2 = null;
                }
                if (hVar.mo125429r().mo125505g().booleanValue()) {
                    try {
                        C16700a r = hVar.mo125429r();
                        mediaStreamTrack3 = m38017a(r.mo125497b(), r.mo125506h().mo125511c(), r.mo125506h().mo125510b(), r.mo125506h().mo125509a(), hVar.mo125428m(), hVar.mo125426b());
                        hVar.mo125407c("[I] Video track created");
                    } catch (Exception e) {
                        hVar.mo125407c(e.getMessage());
                    }
                }
                MediaStreamTrack mediaStreamTrack4 = mediaStreamTrack3;
                mediaStreamTrack3 = mediaStreamTrack2;
                mediaStreamTrack = mediaStreamTrack4;
            } else {
                mediaStreamTrack = null;
            }
            m38019a(hVar, mediaStreamTrack3, mediaStreamTrack);
        } else if (hVar.mo125427j() == null) {
            hVar.mo125407c("[E] Set remote sdp failed,remote sdp is null");
            m38018a(hVar, (Boolean) true);
        } else {
            try {
                JSONObject j = hVar.mo125427j();
                String string = j.getString("sdp");
                this.f50934m.setRemoteDescription(new C16708f(hVar), new SessionDescription(SessionDescription.Type.fromCanonicalForm(j.getString("type")), string));
                hVar.mo125407c("[I] Setting remote sdp ......" + string);
            } catch (JSONException e2) {
                hVar.mo125407c(e2.getMessage());
            }
        }
    }

    /* renamed from: e */
    private MediaConstraints m38039e(C16698h hVar) {
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.optional.add(new MediaConstraints.KeyValuePair(RTCConsts.DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT, "true"));
        if (hVar.mo125429r().mo125502d()) {
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.MEDIA_CONSTRAINTS_RECV_AUDIO, "true"));
        }
        if (hVar.mo125429r().mo125503e()) {
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(RTCConsts.MEDIA_CONSTRAINTS_RECV_VIDEO, "true"));
        }
        return mediaConstraints;
    }

    /* renamed from: a */
    private RtpTransceiver.RtpTransceiverInit m38014a(C16698h hVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1198181");
        RtpTransceiver.RtpTransceiverDirection rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.INACTIVE;
        if (z) {
            if (hVar.mo125429r().mo125502d() && hVar.mo125429r().mo125504f()) {
                rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_RECV;
            } else if (hVar.mo125429r().mo125502d()) {
                rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.RECV_ONLY;
            } else if (hVar.mo125429r().mo125504f()) {
                rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_ONLY;
            }
        } else if (hVar.mo125429r().mo125503e() && hVar.mo125429r().mo125505g().booleanValue()) {
            rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_RECV;
        } else if (hVar.mo125429r().mo125503e()) {
            rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.RECV_ONLY;
        } else if (hVar.mo125429r().mo125505g().booleanValue()) {
            rtpTransceiverDirection = RtpTransceiver.RtpTransceiverDirection.SEND_ONLY;
        }
        if (rtpTransceiverDirection == RtpTransceiver.RtpTransceiverDirection.INACTIVE) {
            return null;
        }
        return new RtpTransceiver.RtpTransceiverInit(rtpTransceiverDirection, arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38025a(MediaStream mediaStream) {
        this.f50927f.mo125469a(mediaStream);
    }

    /* renamed from: a */
    private VideoTrack m38017a(DrtcCameraType drtcCameraType, int i, int i2, int i3, EglBase.Context context, Context context2) throws Exception {
        VideoCapturer videoCapturer = this.f50937p;
        if (videoCapturer != null) {
            videoCapturer.stopCapture();
        }
        VideoCapturer a = m38016a((CameraEnumerator) new Camera1Enumerator(false), drtcCameraType);
        this.f50937p = a;
        if (a != null) {
            this.f50917B = SurfaceTextureHelper.create("CaptureThread", context);
            VideoSource createVideoSource = this.f50947z.createVideoSource(this.f50937p.isScreencast());
            if (createVideoSource != null) {
                this.f50937p.initialize(this.f50917B, context2, createVideoSource.getCapturerObserver());
                this.f50937p.startCapture(i, i2, i3);
                VideoTrack createVideoTrack = this.f50947z.createVideoTrack(RTCConsts.VIDEO_TRACK_ID, createVideoSource);
                createVideoTrack.setEnabled(true);
                return createVideoTrack;
            }
            throw new Exception("[Ex] Can't create local video track");
        }
        throw new Exception("[Ex] Can't create local video track");
    }

    /* renamed from: a */
    private VideoCapturer m38016a(CameraEnumerator cameraEnumerator, DrtcCameraType drtcCameraType) {
        CameraVideoCapturer createCapturer;
        CameraVideoCapturer createCapturer2;
        CameraVideoCapturer createCapturer3;
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        for (String str : deviceNames) {
            if (DrtcCameraType.FrontFace.equals(drtcCameraType)) {
                if (cameraEnumerator.isFrontFacing(str) && (createCapturer3 = cameraEnumerator.createCapturer(str, this.f50922G)) != null) {
                    return createCapturer3;
                }
            } else if (cameraEnumerator.isBackFacing(str) && (createCapturer2 = cameraEnumerator.createCapturer(str, this.f50922G)) != null) {
                return createCapturer2;
            }
        }
        for (String str2 : deviceNames) {
            if (!cameraEnumerator.isFrontFacing(str2) && (createCapturer = cameraEnumerator.createCapturer(str2, (CameraVideoCapturer.CameraEventsHandler) null)) != null) {
                return createCapturer;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38018a(C16698h hVar, Boolean bool) {
        if (bool.booleanValue()) {
            this.f50934m.createOffer(new C16708f(hVar), m38039e(hVar));
        } else {
            this.f50934m.createAnswer(new C16708f(hVar), m38039e(hVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo125519a(DrtcCameraType drtcCameraType) {
        C16694d dVar = this.f50927f;
        dVar.mo125407c("[I] Switch camera :" + drtcCameraType.toString());
        if (this.f50938q.equals(drtcCameraType)) {
            return true;
        }
        VideoCapturer videoCapturer = this.f50937p;
        if (!(videoCapturer instanceof CameraVideoCapturer)) {
            return false;
        }
        ((CameraVideoCapturer) videoCapturer).switchCamera((CameraVideoCapturer.CameraSwitchHandler) null);
        this.f50938q = drtcCameraType;
        this.f50927f.mo125465a(drtcCameraType);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38026a(SessionDescription sessionDescription, C16698h hVar) {
        if (this.f50934m != null) {
            if (this.f50933l == null) {
                SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, C16724g.m38188a(C16724g.m38188a(C16724g.m38189a(this.f50930i, true, sessionDescription.description, 1), this.f50930i, false), this.f50931j, true));
                this.f50933l = null;
                this.f50933l = sessionDescription2;
                this.f50934m.setLocalDescription(new C16708f(hVar), sessionDescription2);
                hVar.mo125407c("[I] Setting local sdp,sdp type : " + this.f50933l.type);
            }
            if ((this.f50941t || this.f50940s) && !this.f50942u) {
                try {
                    this.f50942u = true;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdp", this.f50933l.description);
                    jSONObject.put("type", this.f50933l.type.canonicalForm());
                    hVar.mo125425a(jSONObject);
                } catch (JSONException e) {
                    hVar.mo125407c(e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38024a(IceCandidate iceCandidate) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (iceCandidate == null) {
                jSONObject2.put("completed", true);
            } else {
                jSONObject2.put("candidate", iceCandidate.sdp);
                jSONObject2.put("sdpMid", iceCandidate.sdpMid);
                jSONObject2.put("sdpMLineIndex", iceCandidate.sdpMLineIndex);
            }
            jSONObject.put("candidate", jSONObject2);
            this.f50926e.mo125400a(jSONObject, DrtcMessageType.trickle, this.f50925d);
        } catch (JSONException e) {
            C16694d dVar = this.f50927f;
            dVar.mo125407c("[ERROR]Send candidates error:" + e.getMessage());
        }
    }
}
