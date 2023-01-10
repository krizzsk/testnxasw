package com.didichuxing.comp.telecom.core.voip;

import android.media.MediaPlayer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.CallToastUtil;
import com.didichuxing.comp.telecom.core.base.ICall;
import com.didichuxing.comp.telecom.core.request.VoipCallRequest;
import com.didichuxing.comp.telecom.core.util.AudioServiceHelper;
import com.didichuxing.comp.telecom.core.util.AudioServiceListener;
import com.didichuxing.comp.telecom.core.util.MediaServiceHelper;
import com.didichuxing.comp.telecom.core.util.TtsServiceHelper;
import com.didichuxing.comp.telecom.core.voip.tipstate.TipStateComponent;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010$\u001a\u00020%H\u0016J&\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0016J\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020\u0012H\u0002J\b\u00101\u001a\u0004\u0018\u00010\tJ\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u000204H\u0016J\u0012\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020%H\u0016J\u0006\u00109\u001a\u00020+J\u0006\u0010:\u001a\u00020+J\b\u0010;\u001a\u00020%H\u0016J\b\u0010<\u001a\u00020%H\u0016J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020/H\u0016J\b\u0010?\u001a\u00020%H\u0016J\u0006\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u00020%J\u0006\u0010B\u001a\u00020%J\u0006\u0010C\u001a\u00020%J\u0006\u0010D\u001a\u00020%J\b\u0010E\u001a\u00020%H\u0016J\b\u0010F\u001a\u00020%H\u0002J\u000e\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020+J\u000e\u0010I\u001a\u00020%2\u0006\u0010H\u001a\u00020+J\u0006\u0010J\u001a\u00020%J\u0006\u0010K\u001a\u00020%J\u000e\u0010L\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0015J\u0010\u0010M\u001a\u00020%2\b\u0010N\u001a\u0004\u0018\u00010\tR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006O"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "Lcom/didichuxing/comp/telecom/core/base/ICall;", "Lcom/didichuxing/comp/telecom/core/util/AudioServiceListener;", "role", "Lcom/didichuxing/comp/telecom/core/CallRole;", "voipCallModel", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "(Lcom/didichuxing/comp/telecom/core/CallRole;Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;)V", "TAG", "", "callInitTime", "", "getCallInitTime", "()J", "<set-?>", "callStartTime", "getCallStartTime", "mAudioService", "Lcom/didichuxing/comp/telecom/core/util/AudioServiceHelper;", "mCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "mRingtoneService", "Lcom/didichuxing/comp/telecom/core/util/MediaServiceHelper;", "mSession", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionImpl;", "Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "mStateTextHelper", "getMStateTextHelper", "()Lcom/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent;", "mVoipCallPage", "Lcom/didichuxing/comp/telecom/core/voip/IVoipCallPage;", "getRole", "()Lcom/didichuxing/comp/telecom/core/CallRole;", "getVoipCallModel", "()Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "answerCall", "", "bindCallListener", "callback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "callbackInstant", "", "cancelMakeCall", "forceStop", "getAudioDeviceState", "", "getAudioService", "getCallPageState", "getModel", "getState", "Lcom/didichuxing/comp/telecom/core/CallState;", "handleCallEvent", "event", "", "hangUp", "isMicOn", "isSpeakerOn", "makeCall", "notifyRinging", "onAudioDeviceChange", "deviceState", "onDestroy", "pauseRingCallIncome", "playCallEnd", "playRingCallIncome", "playTip", "playWait", "rejectIncomeCall", "release", "setMicState", "toOpen", "setSpeakerState", "stopPlayingAudio", "stopRingCallIncome", "unbindCallListener", "updateStateString", "stateStr", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: VoipAudioCall.kt */
public final class VoipAudioCall implements ICall, AudioServiceListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f49089a = "VoipAudioCall";

    /* renamed from: b */
    private final long f49090b = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f49091c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CopyOnWriteArrayList<VoipCallListener> f49092d = new CopyOnWriteArrayList<>();

    /* renamed from: e */
    private final VoipSessionImpl f49093e = new VoipSessionImpl(this.f49098j, this.f49099k, new VoipAudioCall$mSession$1(this));
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TipStateComponent f49094f = new TipStateComponent(this);

    /* renamed from: g */
    private AudioServiceHelper f49095g;

    /* renamed from: h */
    private MediaServiceHelper f49096h = new MediaServiceHelper();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IVoipCallPage f49097i;

    /* renamed from: j */
    private final CallRole f49098j;

    /* renamed from: k */
    private final VoipCallModel f49099k;

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CallState.INCOME_RINGING.ordinal()] = 1;
            $EnumSwitchMapping$0[CallState.INCOMING_CALL.ordinal()] = 2;
            $EnumSwitchMapping$0[CallState.IN_CALL.ordinal()] = 3;
        }
    }

    public VoipAudioCall(CallRole callRole, VoipCallModel voipCallModel) {
        Intrinsics.checkParameterIsNotNull(callRole, "role");
        Intrinsics.checkParameterIsNotNull(voipCallModel, "voipCallModel");
        this.f49098j = callRole;
        this.f49099k = voipCallModel;
    }

    public final CallRole getRole() {
        return this.f49098j;
    }

    public final VoipCallModel getVoipCallModel() {
        return this.f49099k;
    }

    public final long getCallInitTime() {
        return this.f49090b;
    }

    public final long getCallStartTime() {
        return this.f49091c;
    }

    public VoipCallModel getModel() {
        return this.f49099k;
    }

    public CallState getState() {
        return this.f49093e.getState();
    }

    public void makeCall() {
        if (getState().getValue() < CallState.OUTGOING_CALL.getValue()) {
            CallLogUtil.logI(this.f49089a, "makeCall");
            VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, VoipCallRequest.REPORT_CALL_IN, this.f49099k, (RpcService.Callback) null, 4, (Object) null);
            this.f49093e.makeCall();
        }
    }

    public void notifyRinging() {
        CallLogUtil.logI(this.f49089a, "notifyRinging");
        this.f49093e.notifyRinging();
    }

    public void answerCall() {
        if (getState().getValue() < CallState.INCOMING_CALL.getValue()) {
            CallLogUtil.logI(this.f49089a, "answerCall");
            VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, VoipCallRequest.REPORT_ANSWERED, this.f49099k, (RpcService.Callback) null, 4, (Object) null);
            this.f49093e.answerCall();
        }
    }

    public void rejectIncomeCall() {
        CallLogUtil.logI(this.f49089a, "rejectIncomeCall");
        VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, "reject", this.f49099k, (RpcService.Callback) null, 4, (Object) null);
        this.f49093e.rejectComingCall();
    }

    public void hangUp() {
        CallLogUtil.logI(this.f49089a, "hangUp");
        VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, VoipCallRequest.REPORT_HANG_UP, this.f49099k, (RpcService.Callback) null, 4, (Object) null);
        this.f49093e.hangUp();
    }

    public void cancelMakeCall() {
        CallLogUtil.logI(this.f49089a, "cancelCall");
        VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, "cf_hang_up", this.f49099k, (RpcService.Callback) null, 4, (Object) null);
        this.f49093e.hangUp();
    }

    public void forceStop() {
        CallLogUtil.logI(this.f49089a, "forceStop");
        if (getState() == CallState.IN_CALL) {
            VoipCallRequest.requestEventReport$default(VoipCallRequest.INSTANCE, VoipCallRequest.REPORT_HANG_UP, this.f49099k, (RpcService.Callback) null, 4, (Object) null);
        }
        this.f49093e.hangUp();
    }

    public void handleCallEvent(Object obj) {
        String event;
        CallManagerAssist.CallManagerConfig config;
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        CallLogUtil.logI(this.f49089a, "handleCallEvent " + obj);
        if (!(obj instanceof VoipCallModel)) {
            obj = null;
        }
        VoipCallModel voipCallModel = (VoipCallModel) obj;
        if (voipCallModel != null && (event = voipCallModel.getEvent()) != null) {
            int hashCode = event.hashCode();
            if (hashCode != -934710369) {
                if (hashCode == 3035641 && event.equals("busy")) {
                    TtsServiceHelper.play$default(TtsServiceHelper.Companion.getInstance(), (int) R.string.GDriver_IBT_The_other_RMIP, false, 2, (Object) null);
                    CallToastUtil.makeToast(Integer.valueOf(R.string.GDriver_IBT_The_other_RMIP));
                    CallManagerAssist instance = CallManagerAssist.getInstance();
                    if (!(instance == null || (config = instance.getConfig()) == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
                        eventTickHandler.onToastShow(getCallPageState(), CallStateKt.toStr(this.f49098j), "Busy", this.f49099k);
                    }
                    this.f49093e.hangUp();
                }
            } else if (event.equals("reject")) {
                CallToastUtil.makeToast(Integer.valueOf(R.string.GDriver_IBT_The_call_CxWX));
                this.f49093e.hangUp();
            }
        }
    }

    public void onDestroy() {
        m36786a();
    }

    /* renamed from: a */
    private final void m36786a() {
        this.f49097i = null;
        AudioServiceHelper audioServiceHelper = this.f49095g;
        if (audioServiceHelper != null) {
            audioServiceHelper.destroy();
        }
        this.f49095g = null;
        TipStateComponent tipStateComponent = this.f49094f;
        if (tipStateComponent != null) {
            tipStateComponent.destroy();
        }
        this.f49094f = null;
        CopyOnWriteArrayList<VoipCallListener> copyOnWriteArrayList = this.f49092d;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        this.f49092d = null;
    }

    public final TipStateComponent getMStateTextHelper() {
        return this.f49094f;
    }

    public final void updateStateString(String str) {
        CopyOnWriteArrayList<VoipCallListener> copyOnWriteArrayList = this.f49092d;
        if (copyOnWriteArrayList != null) {
            for (VoipCallListener notifyStateDes : copyOnWriteArrayList) {
                notifyStateDes.notifyStateDes(str);
            }
        }
    }

    /* renamed from: b */
    private final AudioServiceHelper m36787b() {
        if (this.f49095g == null) {
            AudioServiceHelper audioServiceHelper = new AudioServiceHelper();
            audioServiceHelper.setChangeListener(this);
            this.f49095g = audioServiceHelper;
        }
        AudioServiceHelper audioServiceHelper2 = this.f49095g;
        if (audioServiceHelper2 == null) {
            Intrinsics.throwNpe();
        }
        return audioServiceHelper2;
    }

    public void onAudioDeviceChange(int i) {
        CopyOnWriteArrayList<VoipCallListener> copyOnWriteArrayList = this.f49092d;
        if (copyOnWriteArrayList != null) {
            for (VoipCallListener onAudioDeviceChange : copyOnWriteArrayList) {
                onAudioDeviceChange.onAudioDeviceChange(this, i);
            }
        }
    }

    public final boolean isMicOn() {
        return m36787b().isMickOn();
    }

    public final boolean setMicState(boolean z) {
        if (this.f49093e.changeMicState(z)) {
            m36787b().setMicOn(z);
            return true;
        }
        String str = this.f49089a;
        CallLogUtil.logI(str, "setMicState toOpen:" + z + ", voip sdk fail to change ");
        return false;
    }

    public final int getAudioDeviceState() {
        return m36787b().getSelectOutput();
    }

    public final boolean isSpeakerOn() {
        return m36787b().isSpeakerOn();
    }

    public final void setSpeakerState(boolean z) {
        m36787b().setSpeakerOn(z);
    }

    public final void playRingCallIncome() {
        MediaServiceHelper.RingtonePlayTask curIncomeRingtone = this.f49096h.getCurIncomeRingtone();
        if (curIncomeRingtone != null) {
            curIncomeRingtone.start();
        } else {
            MediaServiceHelper.callIncomeRingtone$default(this.f49096h, (MediaPlayer.OnCompletionListener) null, 1, (Object) null).start();
        }
    }

    public final void pauseRingCallIncome() {
        MediaServiceHelper.RingtonePlayTask curIncomeRingtone = this.f49096h.getCurIncomeRingtone();
        if (curIncomeRingtone != null) {
            curIncomeRingtone.pause();
        }
    }

    public final void stopRingCallIncome() {
        MediaServiceHelper.RingtonePlayTask curIncomeRingtone = this.f49096h.getCurIncomeRingtone();
        if (curIncomeRingtone != null) {
            curIncomeRingtone.stop();
        }
    }

    public final void playWait() {
        MediaServiceHelper.waitRingtone$default(this.f49096h, (MediaPlayer.OnCompletionListener) null, 1, (Object) null).start();
    }

    public final void playTip() {
        MediaServiceHelper.tipRingtone$default(this.f49096h, (MediaPlayer.OnCompletionListener) null, 1, (Object) null).start();
    }

    public final void playCallEnd() {
        MediaServiceHelper.callEndRingtone$default(this.f49096h, (MediaPlayer.OnCompletionListener) null, 1, (Object) null).start();
    }

    public final void stopPlayingAudio() {
        this.f49096h.stopPlayingAudio();
    }

    public final String getCallPageState() {
        IVoipCallPage iVoipCallPage = this.f49097i;
        if (iVoipCallPage != null) {
            return iVoipCallPage.getPageState();
        }
        return null;
    }

    public static /* synthetic */ void bindCallListener$default(VoipAudioCall voipAudioCall, VoipCallListener voipCallListener, LifecycleOwner lifecycleOwner, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            lifecycleOwner = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        voipAudioCall.bindCallListener(voipCallListener, lifecycleOwner, z);
    }

    public final void bindCallListener(VoipCallListener voipCallListener, LifecycleOwner lifecycleOwner, boolean z) {
        CopyOnWriteArrayList<VoipCallListener> copyOnWriteArrayList;
        Lifecycle lifecycle;
        if (voipCallListener != null && (copyOnWriteArrayList = this.f49092d) != null) {
            if (voipCallListener instanceof IVoipCallPage) {
                this.f49097i = (IVoipCallPage) voipCallListener;
            }
            if (!copyOnWriteArrayList.contains(voipCallListener)) {
                copyOnWriteArrayList.add(voipCallListener);
                if (!(lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                    lifecycle.addObserver(new VoipAudioCall$bindCallListener$1(this, copyOnWriteArrayList, voipCallListener));
                }
            }
            if (z) {
                voipCallListener.onStateChange(this, getState());
            }
        }
    }

    public final void unbindCallListener(VoipCallListener voipCallListener) {
        Intrinsics.checkParameterIsNotNull(voipCallListener, "callback");
        CopyOnWriteArrayList<VoipCallListener> copyOnWriteArrayList = this.f49092d;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(voipCallListener);
        }
    }
}
