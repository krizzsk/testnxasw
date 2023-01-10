package com.didichuxing.comp.telecom.core.voip;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallToastUtil;
import com.didichuxing.comp.telecom.core.CallUtils;
import com.didichuxing.comp.telecom.core.base.ICallSession;
import com.didichuxing.comp.telecom.core.request.VoipCallRequest;
import com.didichuxing.comp.telecom.core.util.TtsServiceHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.mlcp.drtc.enums.DrtcEnvType;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import com.didichuxing.mlcp.drtc.interfaces.DrtcSDKInitializeListener;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import com.didichuxing.mlcp.drtc.sdk.DrtcSDK;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013*\u0001\u001a\u0018\u00002\u00020\u0001:\u0003567B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001dH\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020!H\u0016J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0016J\b\u0010.\u001a\u00020!H\u0016J\u0014\u0010/\u001a\u00020!2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\nH\u0002J\b\u00101\u001a\u00020!H\u0016J\b\u00102\u001a\u00020!H\u0002J\u0012\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;", "Lcom/didichuxing/comp/telecom/core/base/ICallSession;", "role", "Lcom/didichuxing/comp/telecom/core/CallRole;", "voipCallModel", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "callback", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionListener;", "(Lcom/didichuxing/comp/telecom/core/CallRole;Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;Lcom/didichuxing/comp/telecom/core/voip/VoipSessionListener;)V", "TAG", "", "mActionDelay", "Ljava/lang/Runnable;", "mBindWithTripRecorder", "Lcom/didichuxing/comp/telecom/core/voip/BindWithTripRecorder;", "mCallFunctionService", "Lcom/didichuxing/mlcp/drtc/interfaces/InCallingService;", "mCallService", "Lcom/didichuxing/mlcp/drtc/interfaces/CallingService;", "mDrtcSDK", "Lcom/didichuxing/mlcp/drtc/sdk/DrtcSDK;", "mHandler", "Landroid/os/Handler;", "mSdkIniState", "", "mSdkInitCallback", "com/didichuxing/comp/telecom/core/voip/VoipSessionImpl$mSdkInitCallback$1", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl$mSdkInitCallback$1;", "mState", "Lcom/didichuxing/comp/telecom/core/CallState;", "mTryEnterRoomTime", "", "answerCall", "", "changeCallState", "newState", "changeMicState", "", "open", "getModel", "getState", "hangUp", "initSdk", "innerEnterRoom", "innerLeaveRoom", "makeCall", "notifyRinging", "quitForError", "errorMsg", "rejectComingCall", "release", "toastAndTtsForError", "tipMsg", "ACallingCallback", "CallMakerStateListener", "CalleeStateListener", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: VoipSessionImpl.kt */
public final class VoipSessionImpl implements ICallSession {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f49100a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f49101b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CallState f49102c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f49103d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DrtcSDK f49104e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CallingService f49105f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public InCallingService f49106g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BindWithTripRecorder f49107h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f49108i;

    /* renamed from: j */
    private final VoipSessionImpl$mSdkInitCallback$1 f49109j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f49110k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final CallRole f49111l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final VoipCallModel f49112m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final VoipSessionListener f49113n;

    public VoipSessionImpl(CallRole callRole, VoipCallModel voipCallModel, VoipSessionListener voipSessionListener) {
        Intrinsics.checkParameterIsNotNull(callRole, "role");
        Intrinsics.checkParameterIsNotNull(voipCallModel, "voipCallModel");
        this.f49111l = callRole;
        this.f49112m = voipCallModel;
        this.f49113n = voipSessionListener;
        this.f49100a = "VoipSessionImpl";
        this.f49101b = new Handler(Looper.getMainLooper());
        this.f49102c = CallState.INITIALED;
        this.f49108i = 1;
        this.f49109j = new VoipSessionImpl$mSdkInitCallback$1(this);
        this.f49110k = -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoipSessionImpl(CallRole callRole, VoipCallModel voipCallModel, VoipSessionListener voipSessionListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(callRole, voipCallModel, (i & 4) != 0 ? null : voipSessionListener);
    }

    /* renamed from: a */
    private final void m36788a() {
        String str;
        if (this.f49108i == 1) {
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            CallManagerAssist.CallManagerConfig config = instance.getConfig();
            Intrinsics.checkExpressionValueIsNotNull(config, "CallManagerAssist.getInstance().config");
            int env = config.getEnv();
            String str2 = this.f49100a;
            CallLogUtil.logI(str2, "initSdk - env:" + env);
            try {
                this.f49108i = 2;
                this.f49104e = DrtcSDK.getInstance();
                if (!CallManagerAssist.isTest()) {
                    DrtcSDK drtcSDK = this.f49104e;
                    if (drtcSDK != null) {
                        Context appContext = CallManager.Companion.getInstance().getAppContext();
                        DrtcSDKInitializeListener drtcSDKInitializeListener = this.f49109j;
                        RoomInfo roomInfo = this.f49112m.getRoomInfo();
                        if (roomInfo == null || (str = roomInfo.getRoomUrl()) == null) {
                            str = "";
                        }
                        drtcSDK.initializeSDK(appContext, drtcSDKInitializeListener, str);
                        return;
                    }
                    return;
                }
                DrtcSDK drtcSDK2 = this.f49104e;
                if (drtcSDK2 != null) {
                    drtcSDK2.initializeSDK(CallManager.Companion.getInstance().getAppContext(), (DrtcSDKInitializeListener) this.f49109j, DrtcEnvType.ENV_TEST_CN);
                }
            } catch (Exception e) {
                CallLogUtil.logError(this.f49100a, "initSdk error", e);
                m36790a(this, (String) null, 1, (Object) null);
            }
        }
    }

    public VoipCallModel getModel() {
        return this.f49112m;
    }

    public CallState getState() {
        return this.f49102c;
    }

    public void makeCall() {
        String str = this.f49100a;
        CallLogUtil.logI(str, "makeCall " + this.f49102c);
        if (this.f49103d == null && this.f49102c.getValue() < CallState.OUTGOING_CALL.getValue()) {
            m36789a(CallState.OUTGOING_CALL);
            CallMakerStateListener callMakerStateListener = new CallMakerStateListener();
            callMakerStateListener.delayCheckOvertime();
            Runnable voipSessionImpl$makeCall$action$1 = new VoipSessionImpl$makeCall$action$1(this, callMakerStateListener);
            if (this.f49108i != 3) {
                CallLogUtil.logI(this.f49100a, "makeCall - wait for init voip sdk");
                this.f49103d = voipSessionImpl$makeCall$action$1;
                m36788a();
                return;
            }
            CallLogUtil.logI(this.f49100a, "makeCall - ready, start call");
            voipSessionImpl$makeCall$action$1.run();
        }
    }

    public void answerCall() {
        String str = this.f49100a;
        CallLogUtil.logI(str, "answerCall " + this.f49102c);
        if (this.f49103d == null && this.f49102c.getValue() < CallState.INCOMING_CALL.getValue()) {
            m36789a(CallState.INCOMING_CALL);
            Runnable voipSessionImpl$answerCall$action$1 = new VoipSessionImpl$answerCall$action$1(this);
            if (this.f49108i != 3) {
                CallLogUtil.logI(this.f49100a, "answerCall - wait for init voip sdk");
                this.f49103d = voipSessionImpl$answerCall$action$1;
                m36788a();
                return;
            }
            CallLogUtil.logI(this.f49100a, "answerCall - ready, start call");
            voipSessionImpl$answerCall$action$1.run();
        }
    }

    public void hangUp() {
        String str = this.f49100a;
        CallLogUtil.logI(str, "hangUp " + this.f49102c);
        if (this.f49102c != CallState.END_CALL) {
            m36794c();
        }
    }

    public void notifyRinging() {
        String str = this.f49100a;
        CallLogUtil.logI(str, "notifyRinging " + this.f49102c);
        if (this.f49102c != CallState.END_CALL) {
            m36789a(CallState.INCOME_RINGING);
        }
    }

    public void rejectComingCall() {
        String str = this.f49100a;
        CallLogUtil.logI(str, "rejectComingCall " + this.f49102c);
        if (this.f49102c != CallState.END_CALL) {
            m36794c();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002b, code lost:
        r1 = kotlin.text.StringsKt.toIntOrNull((r1 = r0.getRoomId()));
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m36792b() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f49100a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "innerEnterRoom curState:"
            r1.append(r2)
            com.didichuxing.comp.telecom.core.CallState r2 = r8.f49102c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r0 = r8.f49112m
            com.didichuxing.comp.telecom.core.voip.RoomInfo r0 = r0.getRoomInfo()
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            if (r0 == 0) goto L_0x0036
            java.lang.String r1 = r0.getRoomId()
            if (r1 == 0) goto L_0x0036
            java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
            if (r1 == 0) goto L_0x0036
            int r1 = r1.intValue()
            goto L_0x0037
        L_0x0036:
            r1 = -1
        L_0x0037:
            r3.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            if (r0 == 0) goto L_0x0045
            java.lang.String r1 = r0.getRoomPin()
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r5.element = r1
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r0.getClientId()
            if (r0 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            java.lang.String r0 = "GLOBAL_UNKNOWN"
        L_0x0053:
            r4 = r0
            com.didichuxing.comp.telecom.core.voip.BindWithTripRecorder r0 = r8.f49107h
            if (r0 == 0) goto L_0x005d
            boolean r0 = r0.isRecording()
            goto L_0x005e
        L_0x005d:
            r0 = 0
        L_0x005e:
            r6 = r0 ^ 1
            long r0 = java.lang.System.currentTimeMillis()
            r8.f49110k = r0
            java.lang.String r0 = r8.f49100a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "innerEnterRoom needSdkRecord:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            com.didichuxing.comp.telecom.core.CallThreadDispatcher$Companion r0 = com.didichuxing.comp.telecom.core.CallThreadDispatcher.Companion
            com.didichuxing.comp.telecom.core.CallThreadDispatcher r0 = r0.getInstance()
            com.didichuxing.comp.telecom.core.voip.VoipSessionImpl$innerEnterRoom$1 r7 = new com.didichuxing.comp.telecom.core.voip.VoipSessionImpl$innerEnterRoom$1
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r0.runAsync(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.m36792b():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m36794c() {
        String str = this.f49100a;
        CallLogUtil.logI(str, "innerLeaveRoom " + this.f49102c);
        if (this.f49102c != CallState.END_CALL) {
            m36789a(CallState.END_CALL);
            try {
                CallingService callingService = this.f49105f;
                if (callingService != null) {
                    callingService.hangupCalling();
                }
            } catch (Exception e) {
                CallLogUtil.logError(this.f49100a, "sdk hangupCalling error", e);
            }
            m36795d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36789a(CallState callState) {
        CallState callState2 = this.f49102c;
        String str = this.f49100a;
        CallLogUtil.logI(str, "changeCallState - old:" + callState2 + " new:" + callState);
        this.f49102c = callState;
        if (callState == CallState.IN_CALL) {
            AnalyseTickHelper.INSTANCE.tickVoipSteps(AnalyseTickHelper.STEP_INCALL, this.f49112m, this.f49111l);
        }
        VoipSessionListener voipSessionListener = this.f49113n;
        if (voipSessionListener != null) {
            voipSessionListener.onCallStateChange(this.f49102c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36791a(String str) {
        if (str != null && this.f49102c != CallState.END_CALL) {
            CallToastUtil.makeToast(str);
            TtsServiceHelper.play$default(TtsServiceHelper.Companion.getInstance(), str, false, 2, (Object) null);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m36790a(VoipSessionImpl voipSessionImpl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        voipSessionImpl.m36793b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36793b(String str) {
        String str2 = this.f49100a;
        CallLogUtil.logI(str2, "quitForError - " + str);
        m36794c();
    }

    /* renamed from: d */
    private final void m36795d() {
        CallLogUtil.logI(this.f49100a, "release");
        Handler handler = this.f49101b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f49101b = null;
        BindWithTripRecorder bindWithTripRecorder = this.f49107h;
        if (bindWithTripRecorder != null) {
            bindWithTripRecorder.onRelease();
        }
        this.f49107h = null;
        try {
            DrtcSDK drtcSDK = this.f49104e;
            if (drtcSDK != null) {
                drtcSDK.releaseSDK();
            }
        } catch (Exception e) {
            CallLogUtil.logError(this.f49100a, "release error", e);
        }
        this.f49104e = null;
        this.f49105f = null;
        this.f49106g = null;
    }

    public final boolean changeMicState(boolean z) {
        try {
            InCallingService inCallingService = this.f49106g;
            if (inCallingService == null) {
                return true;
            }
            inCallingService.setAudioStatus(!z);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0004J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H\u0004J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0004H\u0017J\b\u0010\u0014\u001a\u00020\bH\u0017J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0017J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0017J\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0017J\b\u0010\u001c\u001a\u00020\bH\u0017J\b\u0010\u001d\u001a\u00020\bH\u0014J\b\u0010\u001e\u001a\u00020\bH\u0014J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl$ACallingCallback;", "Lcom/didichuxing/comp/telecom/core/voip/SimpleCallingListener;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;)V", "mCurrentPersonCount", "", "mOvertimeQuitRunnable", "Ljava/lang/Runnable;", "cancelOvertimeTick", "", "changePersonCount", "feedCount", "emitOvertimeTick", "timeDelay", "", "getCompName", "", "isAllPersonInCall", "", "onConnectReady", "isVoiceLow", "onDisconnectedByError", "onJoinFailed", "p0", "onNetworkQuality", "level", "onNewRemoteFeedWithCount", "feedId", "onRemoteFeedLeaveWithCount", "onSessionDestroy", "onWaitOverTime", "quitForOvertime", "shouldAutoQuit", "stopCallForOppositeLeave", "toastNetworkError", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
    /* compiled from: VoipSessionImpl.kt */
    public abstract class ACallingCallback extends SimpleCallingListener {
        private int mCurrentPersonCount;
        private Runnable mOvertimeQuitRunnable;

        public abstract String getCompName();

        /* access modifiers changed from: protected */
        public void onWaitOverTime() {
        }

        public ACallingCallback() {
        }

        private final void changePersonCount(int i) {
            this.mCurrentPersonCount = i;
            VoipSessionListener access$getCallback$p = VoipSessionImpl.this.f49113n;
            if (access$getCallback$p != null) {
                access$getCallback$p.onPersonChange(i);
            }
        }

        public void onConnectReady(boolean z, int i) {
            String access$getTAG$p = VoipSessionImpl.this.f49100a;
            CallLogUtil.logI(access$getTAG$p, "onConnectReady state:" + VoipSessionImpl.this.f49102c + " feedCount:" + i);
            if (VoipSessionImpl.this.f49102c != CallState.END_CALL) {
                if (VoipSessionImpl.this.f49110k > 0) {
                    AnalyseTickHelper.INSTANCE.tickSdkConnected(System.currentTimeMillis() - VoipSessionImpl.this.f49110k, VoipSessionImpl.this.f49112m, VoipSessionImpl.this.f49111l);
                }
                changePersonCount(i);
            }
        }

        public void onNewRemoteFeedWithCount(String str, int i) {
            super.onNewRemoteFeedWithCount(str, i);
            String access$getTAG$p = VoipSessionImpl.this.f49100a;
            CallLogUtil.logI(access$getTAG$p, "onNewRemoteFeedWithCount - " + i);
            changePersonCount(i);
        }

        public void onRemoteFeedLeaveWithCount(String str, int i) {
            super.onRemoteFeedLeaveWithCount(str, i);
            String compName = getCompName();
            CallLogUtil.logI(compName, "onRemoteFeedLeaveWithCount " + i);
            changePersonCount(i);
            if (shouldAutoQuit() && VoipSessionImpl.this.f49102c == CallState.IN_CALL) {
                VoipSessionListener access$getCallback$p = VoipSessionImpl.this.f49113n;
                if (access$getCallback$p != null) {
                    access$getCallback$p.onOppositeLeave();
                }
                stopCallForOppositeLeave();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
            r0 = r0.getAppServiceProvider();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void stopCallForOppositeLeave() {
            /*
                r7 = this;
                java.lang.String r0 = r7.getCompName()
                java.lang.String r1 = "stopCallForOppositeLeave - quit for target leave"
                com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
                com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
                java.lang.String r1 = "CallManagerAssist.getInstance()"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
                com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
                if (r0 == 0) goto L_0x0028
                com.didichuxing.comp.telecom.core.CallManagerAssist$AppServiceProvider r0 = r0.getAppServiceProvider()
                if (r0 == 0) goto L_0x0028
                boolean r0 = r0.isForeGround()
                r1 = 1
                if (r0 != r1) goto L_0x0028
                java.lang.String r0 = "f_hang_up"
                goto L_0x002a
            L_0x0028:
                java.lang.String r0 = "b_hang_up"
            L_0x002a:
                r2 = r0
                com.didichuxing.comp.telecom.core.request.VoipCallRequest r1 = com.didichuxing.comp.telecom.core.request.VoipCallRequest.INSTANCE
                com.didichuxing.comp.telecom.core.voip.VoipSessionImpl r0 = com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.this
                com.didichuxing.comp.telecom.core.voip.VoipCallModel r3 = r0.f49112m
                r4 = 0
                r5 = 4
                r6 = 0
                com.didichuxing.comp.telecom.core.request.VoipCallRequest.requestEventReport$default(r1, r2, r3, r4, r5, r6)
                com.didichuxing.comp.telecom.core.voip.VoipSessionImpl r0 = com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.this
                r0.m36794c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.ACallingCallback.stopCallForOppositeLeave():void");
        }

        public void onJoinFailed(String str) {
            String str2 = "onJoinFailed " + str;
            CallLogUtil.logI(getCompName(), str2);
            AnalyseTickHelper.INSTANCE.tickSdkEvents(AnalyseTickHelper.SDK_JOIN_FAIL, VoipSessionImpl.this.f49112m, VoipSessionImpl.this.f49111l);
            toastNetworkError();
            VoipSessionImpl.this.m36793b(str2);
        }

        public void onDisconnectedByError() {
            CallLogUtil.logI(getCompName(), "onDisconnectedByError");
            AnalyseTickHelper.INSTANCE.tickSdkEvents(AnalyseTickHelper.SDK_DIS_ERROR, VoipSessionImpl.this.f49112m, VoipSessionImpl.this.f49111l);
            toastNetworkError();
            VoipSessionImpl.this.m36793b("onDisconnectedByError");
        }

        public void onSessionDestroy() {
            CallLogUtil.logI(getCompName(), "onSessionDestroy");
            AnalyseTickHelper.INSTANCE.tickSdkEvents(AnalyseTickHelper.SDK_SESSION_DESTROY, VoipSessionImpl.this.f49112m, VoipSessionImpl.this.f49111l);
            toastNetworkError();
            VoipSessionImpl.this.m36793b("onSessionDestroy");
        }

        private final void toastNetworkError() {
            if (VoipSessionImpl.this.f49102c != CallState.END_CALL) {
                VoipSessionImpl.this.m36791a(CallUtils.INSTANCE.getStringRes(Integer.valueOf(R.string.GDriver_IBT_Network_interrupt_xSfY)));
            }
        }

        public void onNetworkQuality(int i) {
            VoipSessionListener access$getCallback$p;
            super.onNetworkQuality(i);
            String compName = getCompName();
            CallLogUtil.logI(compName, "onNetworkQuality - " + i);
            RoomInfo roomInfo = VoipSessionImpl.this.f49112m.getRoomInfo();
            Integer poor_network_level = roomInfo != null ? roomInfo.getPoor_network_level() : null;
            if (poor_network_level != null && (access$getCallback$p = VoipSessionImpl.this.f49113n) != null) {
                access$getCallback$p.onNetworkUnstable(Intrinsics.compare(i, poor_network_level.intValue()) <= 0);
            }
        }

        /* access modifiers changed from: protected */
        public final void emitOvertimeTick(long j) {
            Runnable voipSessionImpl$ACallingCallback$emitOvertimeTick$action$1 = new VoipSessionImpl$ACallingCallback$emitOvertimeTick$action$1(this);
            Handler access$getMHandler$p = VoipSessionImpl.this.f49101b;
            if (access$getMHandler$p != null) {
                access$getMHandler$p.postDelayed(voipSessionImpl$ACallingCallback$emitOvertimeTick$action$1, j);
            }
            this.mOvertimeQuitRunnable = voipSessionImpl$ACallingCallback$emitOvertimeTick$action$1;
        }

        /* access modifiers changed from: protected */
        public final void cancelOvertimeTick() {
            Runnable runnable = this.mOvertimeQuitRunnable;
            if (runnable != null) {
                this.mOvertimeQuitRunnable = null;
                Handler access$getMHandler$p = VoipSessionImpl.this.f49101b;
                if (access$getMHandler$p != null) {
                    access$getMHandler$p.removeCallbacks(runnable);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void quitForOvertime() {
            VoipSessionImpl.this.m36794c();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
            r1 = r1.getOnMicNum();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean isAllPersonInCall() {
            /*
                r2 = this;
                int r0 = r2.mCurrentPersonCount
                com.didichuxing.comp.telecom.core.voip.VoipSessionImpl r1 = com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.this
                com.didichuxing.comp.telecom.core.voip.VoipCallModel r1 = r1.f49112m
                com.didichuxing.comp.telecom.core.voip.RoomInfo r1 = r1.getRoomInfo()
                if (r1 == 0) goto L_0x0019
                java.lang.Integer r1 = r1.getOnMicNum()
                if (r1 == 0) goto L_0x0019
                int r1 = r1.intValue()
                goto L_0x001a
            L_0x0019:
                r1 = 2
            L_0x001a:
                if (r0 < r1) goto L_0x001e
                r0 = 1
                goto L_0x001f
            L_0x001e:
                r0 = 0
            L_0x001f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.ACallingCallback.isAllPersonInCall():boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
            r1 = r1.getCallingExitNum();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final boolean shouldAutoQuit() {
            /*
                r3 = this;
                int r0 = r3.mCurrentPersonCount
                com.didichuxing.comp.telecom.core.voip.VoipSessionImpl r1 = com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.this
                com.didichuxing.comp.telecom.core.voip.VoipCallModel r1 = r1.f49112m
                com.didichuxing.comp.telecom.core.voip.RoomInfo r1 = r1.getRoomInfo()
                r2 = 1
                if (r1 == 0) goto L_0x001a
                java.lang.Integer r1 = r1.getCallingExitNum()
                if (r1 == 0) goto L_0x001a
                int r1 = r1.intValue()
                goto L_0x001b
            L_0x001a:
                r1 = 1
            L_0x001b:
                if (r0 > r1) goto L_0x001e
                goto L_0x001f
            L_0x001e:
                r2 = 0
            L_0x001f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.ACallingCallback.shouldAutoQuit():boolean");
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0014J\b\u0010\u0013\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl$CallMakerStateListener;", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl$ACallingCallback;", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;)V", "TAG", "", "waitOvertime", "", "delayCheckOvertime", "", "getCompName", "onConnectReady", "isVoiceLow", "", "feedCount", "", "onNewRemoteFeedWithCount", "feedId", "onWaitOverTime", "quitForOvertime", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
    /* compiled from: VoipSessionImpl.kt */
    public final class CallMakerStateListener extends ACallingCallback {
        private final String TAG = "CallMakerStateListener";
        private final long waitOvertime;

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
            r5 = r5.getNotAnswerExit();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CallMakerStateListener() {
            /*
                r4 = this;
                com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.this = r5
                r4.<init>()
                java.lang.String r0 = "CallMakerStateListener"
                r4.TAG = r0
                com.didichuxing.comp.telecom.core.voip.VoipCallModel r5 = r5.f49112m
                com.didichuxing.comp.telecom.core.voip.RoomInfo r5 = r5.getRoomInfo()
                if (r5 == 0) goto L_0x001e
                java.lang.Integer r5 = r5.getNotAnswerExit()
                if (r5 == 0) goto L_0x001e
                int r5 = r5.intValue()
                goto L_0x0020
            L_0x001e:
                r5 = 30
            L_0x0020:
                long r0 = (long) r5
                r2 = 1000(0x3e8, double:4.94E-321)
                long r0 = r0 * r2
                r4.waitOvertime = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.VoipSessionImpl.CallMakerStateListener.<init>(com.didichuxing.comp.telecom.core.voip.VoipSessionImpl):void");
        }

        public String getCompName() {
            return this.TAG;
        }

        public void onConnectReady(boolean z, int i) {
            super.onConnectReady(z, i);
            if (VoipSessionImpl.this.f49102c == CallState.OUTGOING_CALL) {
                VoipSessionImpl.this.m36789a(CallState.OUTGOING_CALL_WAITING);
                if (isAllPersonInCall()) {
                    VoipSessionImpl.this.m36789a(CallState.OUTGOING_CALL_ANSWERING);
                    VoipSessionImpl.this.m36789a(CallState.IN_CALL);
                }
            }
        }

        public void onNewRemoteFeedWithCount(String str, int i) {
            super.onNewRemoteFeedWithCount(str, i);
            if (isAllPersonInCall() && VoipSessionImpl.this.f49102c == CallState.OUTGOING_CALL_WAITING) {
                cancelOvertimeTick();
                VoipSessionImpl.this.m36789a(CallState.OUTGOING_CALL_ANSWERING);
                VoipSessionImpl.this.m36789a(CallState.IN_CALL);
            }
        }

        /* access modifiers changed from: protected */
        public void quitForOvertime() {
            CallLogUtil.logI(this.TAG, "quitForOvertime");
            VoipSessionImpl.this.m36789a(CallState.OUTGOING_CALL_CANCELING);
            super.quitForOvertime();
        }

        /* access modifiers changed from: protected */
        public void onWaitOverTime() {
            super.onWaitOverTime();
            String stringRes = CallUtils.INSTANCE.getStringRes(Integer.valueOf(R.string.GDriver_IBT_No_answer_morb));
            TtsServiceHelper.play$default(TtsServiceHelper.Companion.getInstance(), stringRes, false, 2, (Object) null);
            CallToastUtil.makeToast(stringRes);
            AnalyseTickHelper.INSTANCE.tickUserActions(VoipCallRequest.REPORT_UNANSWERED, VoipSessionImpl.this.f49112m, VoipSessionImpl.this.f49111l);
            VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, VoipCallRequest.REPORT_UNANSWERED, VoipSessionImpl.this.f49112m, (RpcService.Callback) null, 4, (Object) null);
        }

        public final void delayCheckOvertime() {
            emitOvertimeTick(this.waitOvertime);
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl$CalleeStateListener;", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl$ACallingCallback;", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;)V", "TAG", "", "waitOvertime", "", "getCompName", "onConnectReady", "", "isVoiceLow", "", "feedCount", "", "onNewRemoteFeedWithCount", "feedId", "quitForOvertime", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
    /* compiled from: VoipSessionImpl.kt */
    public final class CalleeStateListener extends ACallingCallback {
        private final String TAG = "CalleeStateListener";
        private final long waitOvertime = 5000;

        public CalleeStateListener() {
            super();
        }

        public String getCompName() {
            return this.TAG;
        }

        public void onConnectReady(boolean z, int i) {
            super.onConnectReady(z, i);
            if (VoipSessionImpl.this.f49102c == CallState.INCOMING_CALL) {
                VoipSessionImpl.this.m36789a(CallState.INCOMING_CALL_WAITING);
                if (isAllPersonInCall()) {
                    VoipSessionImpl.this.m36789a(CallState.INCOMING_CALL_ESTABLISHED);
                    VoipSessionImpl.this.m36789a(CallState.IN_CALL);
                    return;
                }
                emitOvertimeTick(this.waitOvertime);
            }
        }

        public void onNewRemoteFeedWithCount(String str, int i) {
            super.onNewRemoteFeedWithCount(str, i);
            if (isAllPersonInCall() && VoipSessionImpl.this.f49102c == CallState.INCOMING_CALL_WAITING) {
                cancelOvertimeTick();
                VoipSessionImpl.this.m36789a(CallState.INCOMING_CALL_ESTABLISHED);
                VoipSessionImpl.this.m36789a(CallState.IN_CALL);
            }
        }

        /* access modifiers changed from: protected */
        public void quitForOvertime() {
            CallLogUtil.logI(this.TAG, "quitForOvertime");
            VoipSessionImpl.this.m36789a(CallState.INCOMING_CALL_CANCELING);
            super.quitForOvertime();
        }
    }
}
