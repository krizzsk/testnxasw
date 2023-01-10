package com.didichuxing.comp.telecom.biz.p177ui.voipcall.page;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipCallPageState;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipCallPageStateKt;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.floatwindow.FloatWindowUtils;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.IVoipCallPage;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J$\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010\f2\b\u0010W\u001a\u0004\u0018\u00010\u0018H\u0017J\u0010\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020ZH\u0004J\u0010\u0010[\u001a\u00020T2\u0006\u0010\\\u001a\u00020ZH\u0004J\u0010\u0010]\u001a\u00020T2\u0006\u0010Y\u001a\u00020ZH\u0004J\u0010\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020ZH\u0004J\u0017\u0010`\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010\u0006H\u0004¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020\bH\u0014J\b\u0010d\u001a\u00020\bH\u0016J\u001a\u0010e\u001a\u00020T2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010f\u001a\u00020T2\u0006\u0010g\u001a\u00020HH\u0015J\u0012\u0010h\u001a\u00020T2\b\u0010i\u001a\u0004\u0018\u00010\bH\u0016J \u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u00062\b\u0010m\u001a\u0004\u0018\u00010nJ\b\u0010o\u001a\u00020TH\u0016J\u0018\u0010p\u001a\u00020T2\u0006\u0010q\u001a\u00020\u00182\u0006\u0010r\u001a\u00020\u0006H\u0016J\u0006\u0010s\u001a\u00020TJ\b\u0010t\u001a\u00020TH&J\u0018\u0010u\u001a\u00020T2\u0006\u0010v\u001a\u00020\u00182\u0006\u0010w\u001a\u00020ZH\u0016J\u0018\u0010x\u001a\u00020T2\u0006\u0010q\u001a\u00020\u00182\u0006\u0010a\u001a\u00020yH\u0016J\u0018\u0010z\u001a\u00020T2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~H\u0016J\b\u0010\u001a\u00020TH\u0004R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001c\u0010,\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u001c\u0010/\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001c\u00102\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R\u001c\u0010>\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u001c\u0010A\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R\u001c\u0010D\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006\u0001"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/page/ACallPageController;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "Lcom/didichuxing/comp/telecom/core/voip/IVoipCallPage;", "Landroidx/lifecycle/LifecycleEventObserver;", "()V", "REQUEST_CODE_FLOATWINDOW", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "mAnswerBtn", "Landroid/view/View;", "getMAnswerBtn", "()Landroid/view/View;", "setMAnswerBtn", "(Landroid/view/View;)V", "mAvatarView", "Landroid/widget/ImageView;", "getMAvatarView", "()Landroid/widget/ImageView;", "setMAvatarView", "(Landroid/widget/ImageView;)V", "mCurCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "getMCurCall", "()Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "setMCurCall", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "mDeviceOptionFrame", "Landroid/view/ViewGroup;", "getMDeviceOptionFrame", "()Landroid/view/ViewGroup;", "setMDeviceOptionFrame", "(Landroid/view/ViewGroup;)V", "mFragment", "Landroidx/fragment/app/Fragment;", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "mHangUpBtn", "getMHangUpBtn", "setMHangUpBtn", "mHideView", "getMHideView", "setMHideView", "mMicIcon", "getMMicIcon", "setMMicIcon", "mMicSwitch", "getMMicSwitch", "setMMicSwitch", "mNicknameView", "Landroid/widget/TextView;", "getMNicknameView", "()Landroid/widget/TextView;", "setMNicknameView", "(Landroid/widget/TextView;)V", "mRootView", "getMRootView", "setMRootView", "mSoundIcon", "getMSoundIcon", "setMSoundIcon", "mSoundSwitch", "getMSoundSwitch", "setMSoundSwitch", "mStateDes", "getMStateDes", "setMStateDes", "mUiState", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "getMUiState", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "setMUiState", "(Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;)V", "mVoipModel", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "getMVoipModel", "()Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "setMVoipModel", "(Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;)V", "bindController", "", "fragment", "rootView", "voipCall", "changeAnswerState", "show", "", "changeDeviceOptionState", "inCall", "changeHangUpState", "changeMicOnShowState", "open", "changeSpeakerOnShowState", "state", "(Ljava/lang/Integer;)V", "getLogTag", "getPageState", "initViews", "notifyPageStateChange", "newState", "notifyStateDes", "msg", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAnswerClick", "onAudioDeviceChange", "call", "deviceState", "onDestroyView", "onHangUpClick", "onMicStateChange", "voipAudioCall", "stateOn", "onStateChange", "Lcom/didichuxing/comp/telecom/core/CallState;", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "resetUiInitialed", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController */
/* compiled from: ACallPageController.kt */
public abstract class ACallPageController implements LifecycleEventObserver, IVoipCallPage, VoipCallListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f49027a = 101;

    /* renamed from: b */
    private Fragment f49028b;

    /* renamed from: c */
    private View f49029c;

    /* renamed from: d */
    private View f49030d;

    /* renamed from: e */
    private ImageView f49031e;

    /* renamed from: f */
    private TextView f49032f;

    /* renamed from: g */
    private TextView f49033g;

    /* renamed from: h */
    private ViewGroup f49034h;

    /* renamed from: i */
    private View f49035i;

    /* renamed from: j */
    private ImageView f49036j;

    /* renamed from: k */
    private View f49037k;

    /* renamed from: l */
    private ImageView f49038l;

    /* renamed from: m */
    private View f49039m;

    /* renamed from: n */
    private View f49040n;

    /* renamed from: o */
    private VoipCallPageState f49041o = VoipCallPageState.INITIALED;

    /* renamed from: p */
    private VoipAudioCall f49042p;

    /* renamed from: q */
    private VoipCallModel f49043q;

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            $EnumSwitchMapping$0[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            $EnumSwitchMapping$0[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            $EnumSwitchMapping$0[Lifecycle.Event.ON_STOP.ordinal()] = 4;
            int[] iArr2 = new int[CallState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CallState.OUTGOING_CALL.ordinal()] = 1;
            $EnumSwitchMapping$1[CallState.OUTGOING_CALL_WAITING.ordinal()] = 2;
            $EnumSwitchMapping$1[CallState.INCOME_RINGING.ordinal()] = 3;
            $EnumSwitchMapping$1[CallState.INCOMING_CALL.ordinal()] = 4;
            $EnumSwitchMapping$1[CallState.IN_CALL.ordinal()] = 5;
            $EnumSwitchMapping$1[CallState.END_CALL.ordinal()] = 6;
            int[] iArr3 = new int[VoipCallPageState.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[VoipCallPageState.OUTGOING_CALLING.ordinal()] = 1;
            $EnumSwitchMapping$2[VoipCallPageState.INCOME_RINGING.ordinal()] = 2;
            $EnumSwitchMapping$2[VoipCallPageState.IN_CALL.ordinal()] = 3;
        }
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return "ACallPageController";
    }

    public void onAnswerClick() {
    }

    public abstract void onHangUpClick();

    public boolean onBackPressed() {
        return IVoipCallPage.DefaultImpls.onBackPressed(this);
    }

    public void onPause() {
        IVoipCallPage.DefaultImpls.onPause(this);
    }

    public void onResume() {
        IVoipCallPage.DefaultImpls.onResume(this);
    }

    public void onStart() {
        IVoipCallPage.DefaultImpls.onStart(this);
    }

    public void onStop() {
        IVoipCallPage.DefaultImpls.onStop(this);
    }

    /* access modifiers changed from: protected */
    public final String getTAG() {
        return getLogTag();
    }

    /* access modifiers changed from: protected */
    public final Fragment getMFragment() {
        return this.f49028b;
    }

    /* access modifiers changed from: protected */
    public final void setMFragment(Fragment fragment) {
        this.f49028b = fragment;
    }

    /* access modifiers changed from: protected */
    public final View getMRootView() {
        return this.f49029c;
    }

    /* access modifiers changed from: protected */
    public final void setMRootView(View view) {
        this.f49029c = view;
    }

    /* access modifiers changed from: protected */
    public final View getMHideView() {
        return this.f49030d;
    }

    /* access modifiers changed from: protected */
    public final void setMHideView(View view) {
        this.f49030d = view;
    }

    /* access modifiers changed from: protected */
    public final ImageView getMAvatarView() {
        return this.f49031e;
    }

    /* access modifiers changed from: protected */
    public final void setMAvatarView(ImageView imageView) {
        this.f49031e = imageView;
    }

    /* access modifiers changed from: protected */
    public final TextView getMNicknameView() {
        return this.f49032f;
    }

    /* access modifiers changed from: protected */
    public final void setMNicknameView(TextView textView) {
        this.f49032f = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getMStateDes() {
        return this.f49033g;
    }

    /* access modifiers changed from: protected */
    public final void setMStateDes(TextView textView) {
        this.f49033g = textView;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getMDeviceOptionFrame() {
        return this.f49034h;
    }

    /* access modifiers changed from: protected */
    public final void setMDeviceOptionFrame(ViewGroup viewGroup) {
        this.f49034h = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final View getMMicSwitch() {
        return this.f49035i;
    }

    /* access modifiers changed from: protected */
    public final void setMMicSwitch(View view) {
        this.f49035i = view;
    }

    /* access modifiers changed from: protected */
    public final ImageView getMMicIcon() {
        return this.f49036j;
    }

    /* access modifiers changed from: protected */
    public final void setMMicIcon(ImageView imageView) {
        this.f49036j = imageView;
    }

    /* access modifiers changed from: protected */
    public final View getMSoundSwitch() {
        return this.f49037k;
    }

    /* access modifiers changed from: protected */
    public final void setMSoundSwitch(View view) {
        this.f49037k = view;
    }

    /* access modifiers changed from: protected */
    public final ImageView getMSoundIcon() {
        return this.f49038l;
    }

    /* access modifiers changed from: protected */
    public final void setMSoundIcon(ImageView imageView) {
        this.f49038l = imageView;
    }

    /* access modifiers changed from: protected */
    public final View getMHangUpBtn() {
        return this.f49039m;
    }

    /* access modifiers changed from: protected */
    public final void setMHangUpBtn(View view) {
        this.f49039m = view;
    }

    /* access modifiers changed from: protected */
    public final View getMAnswerBtn() {
        return this.f49040n;
    }

    /* access modifiers changed from: protected */
    public final void setMAnswerBtn(View view) {
        this.f49040n = view;
    }

    /* access modifiers changed from: protected */
    public final VoipCallPageState getMUiState() {
        return this.f49041o;
    }

    /* access modifiers changed from: protected */
    public final void setMUiState(VoipCallPageState voipCallPageState) {
        Intrinsics.checkParameterIsNotNull(voipCallPageState, "<set-?>");
        this.f49041o = voipCallPageState;
    }

    /* access modifiers changed from: protected */
    public final VoipAudioCall getMCurCall() {
        return this.f49042p;
    }

    /* access modifiers changed from: protected */
    public final void setMCurCall(VoipAudioCall voipAudioCall) {
        this.f49042p = voipAudioCall;
    }

    /* access modifiers changed from: protected */
    public final VoipCallModel getMVoipModel() {
        return this.f49043q;
    }

    /* access modifiers changed from: protected */
    public final void setMVoipModel(VoipCallModel voipCallModel) {
        this.f49043q = voipCallModel;
    }

    public String getPageState() {
        return VoipCallPageStateKt.toStr(this.f49041o);
    }

    public void bindController(Fragment fragment, View view, VoipAudioCall voipAudioCall) {
        Lifecycle lifecycle;
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        this.f49028b = fragment;
        if (!(fragment == null || (lifecycle = fragment.getLifecycle()) == null)) {
            lifecycle.addObserver(this);
        }
        this.f49029c = view;
        this.f49042p = voipAudioCall;
        this.f49043q = voipAudioCall != null ? voipAudioCall.getModel() : null;
        m36763a(fragment, view);
        notifyPageStateChange(VoipCallPageState.INITIALED);
        if (voipAudioCall != null) {
            VoipAudioCall.bindCallListener$default(voipAudioCall, this, fragment, false, 4, (Object) null);
        }
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "source");
        Intrinsics.checkParameterIsNotNull(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            onStart();
        } else if (i == 2) {
            onResume();
        } else if (i == 3) {
            onPause();
        } else if (i == 4) {
            onStop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r2 = r2.getRoomInfo();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m36763a(androidx.fragment.app.Fragment r5, android.view.View r6) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x01a0
            r0 = 2131431289(0x7f0b0f79, float:1.8484303E38)
            android.view.View r0 = r6.findViewById(r0)
            r4.f49030d = r0
            if (r0 == 0) goto L_0x0017
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1 r1 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1
            r1.<init>(r4, r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x0017:
            r0 = 2131427684(0x7f0b0164, float:1.8476991E38)
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.f49031e = r0
            r1 = 0
            if (r0 == 0) goto L_0x0076
            com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.with((androidx.fragment.app.Fragment) r5)
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r4.f49043q
            if (r2 == 0) goto L_0x0038
            com.didichuxing.comp.telecom.core.voip.RoomInfo r2 = r2.getRoomInfo()
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r2.getOppositeAvatar()
            goto L_0x0039
        L_0x0038:
            r2 = r1
        L_0x0039:
            com.bumptech.glide.RequestBuilder r5 = r5.load((java.lang.String) r2)
            java.lang.String r2 = "Glide.with(fragment).loa…roomInfo?.oppositeAvatar)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist r2 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r3 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            java.util.Map r2 = r2.getResources()
            java.lang.String r3 = "voip_call_page_default_avatar"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x005f
            int r2 = r2.intValue()
            goto L_0x0060
        L_0x005f:
            r2 = -1
        L_0x0060:
            if (r2 <= 0) goto L_0x0073
            com.bumptech.glide.request.BaseRequestOptions r5 = r5.placeholder((int) r2)
            com.bumptech.glide.RequestBuilder r5 = (com.bumptech.glide.RequestBuilder) r5
            com.bumptech.glide.request.BaseRequestOptions r5 = r5.fallback((int) r2)
            java.lang.String r2 = "requestBuilder.placehold…Res).fallback(defaultRes)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r2)
            com.bumptech.glide.RequestBuilder r5 = (com.bumptech.glide.RequestBuilder) r5
        L_0x0073:
            r5.into((android.widget.ImageView) r0)
        L_0x0076:
            r5 = 2131432822(0x7f0b1576, float:1.8487412E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f49032f = r5
            if (r5 == 0) goto L_0x0098
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r0 = r4.f49043q
            if (r0 == 0) goto L_0x0092
            com.didichuxing.comp.telecom.core.voip.RoomInfo r0 = r0.getRoomInfo()
            if (r0 == 0) goto L_0x0092
            java.lang.String r0 = r0.getOppositeNickname()
            goto L_0x0093
        L_0x0092:
            r0 = r1
        L_0x0093:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
        L_0x0098:
            r5 = 2131434369(0x7f0b1b81, float:1.849055E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f49033g = r5
            r5 = 2131430132(0x7f0b0af4, float:1.8481956E38)
            android.view.View r5 = r6.findViewById(r5)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r4.f49034h = r5
            r5 = 2131434481(0x7f0b1bf1, float:1.8490777E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.f49036j = r5
            r5 = 2131434483(0x7f0b1bf3, float:1.8490781E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r0 = "this"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            android.content.Context r2 = r5.getContext()
            r3 = 2131952244(0x7f130274, float:1.9540925E38)
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            r5 = 2131434482(0x7f0b1bf2, float:1.849078E38)
            android.view.View r5 = r6.findViewById(r5)
            r4.f49035i = r5
            if (r5 == 0) goto L_0x00ed
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$4 r2 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$4
            r2.<init>(r4)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r5.setOnClickListener(r2)
        L_0x00ed:
            r5 = 0
            r4.changeMicOnShowState(r5)
            r5 = 2131434485(0x7f0b1bf5, float:1.8490785E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.f49038l = r5
            r5 = 2131434484(0x7f0b1bf4, float:1.8490783E38)
            android.view.View r5 = r6.findViewById(r5)
            r4.f49037k = r5
            r5 = 2131434486(0x7f0b1bf6, float:1.8490787E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            android.content.Context r2 = r5.getContext()
            r3 = 2131952232(0x7f130268, float:1.95409E38)
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            android.view.View r5 = r4.f49037k
            if (r5 == 0) goto L_0x012f
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$6 r2 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$6
            r2.<init>(r4)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r5.setOnClickListener(r2)
        L_0x012f:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r5 = r4.f49042p
            if (r5 == 0) goto L_0x013b
            int r5 = r5.getAudioDeviceState()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
        L_0x013b:
            r4.changeSpeakerOnShowState(r1)
            r5 = 2131427822(0x7f0b01ee, float:1.8477271E38)
            android.view.View r5 = r6.findViewById(r5)
            r4.f49039m = r5
            if (r5 == 0) goto L_0x0153
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$7 r1 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$7
            r1.<init>(r4)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r5.setOnClickListener(r1)
        L_0x0153:
            r5 = 2131427823(0x7f0b01ef, float:1.8477273E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            android.content.Context r1 = r5.getContext()
            r2 = 2131952234(0x7f13026a, float:1.9540905E38)
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5.setText(r1)
            r5 = 2131427820(0x7f0b01ec, float:1.8477267E38)
            android.view.View r5 = r6.findViewById(r5)
            r4.f49040n = r5
            if (r5 == 0) goto L_0x0184
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$9 r1 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$9
            r1.<init>(r4)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r5.setOnClickListener(r1)
        L_0x0184:
            r5 = 2131427821(0x7f0b01ed, float:1.847727E38)
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            android.content.Context r6 = r5.getContext()
            r0 = 2131952228(0x7f130264, float:1.9540893E38)
            java.lang.String r6 = r6.getString(r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p177ui.voipcall.page.ACallPageController.m36763a(androidx.fragment.app.Fragment, android.view.View):void");
    }

    public final void onDestroyView() {
        Lifecycle lifecycle;
        Fragment fragment = this.f49028b;
        if (!(fragment == null || (lifecycle = fragment.getLifecycle()) == null)) {
            lifecycle.removeObserver(this);
        }
        this.f49028b = null;
        this.f49042p = null;
    }

    /* access modifiers changed from: protected */
    public final void resetUiInitialed() {
        changeDeviceOptionState(false);
        changeHangUpState(false);
        changeAnswerState(false);
    }

    /* access modifiers changed from: protected */
    public final void changeDeviceOptionState(boolean z) {
        CallLogUtil.logI(getTAG(), "changeDeviceOptionState - show click buttons, make clickable");
        ViewGroup viewGroup = this.f49034h;
        boolean z2 = false;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 4);
        }
        View view = this.f49035i;
        if (view != null) {
            view.setClickable(z);
        }
        View view2 = this.f49037k;
        if (view2 != null) {
            view2.setClickable(z);
        }
        VoipAudioCall voipAudioCall = this.f49042p;
        if (voipAudioCall != null && voipAudioCall.isMicOn()) {
            z2 = true;
        }
        changeMicOnShowState(z2);
        VoipAudioCall voipAudioCall2 = this.f49042p;
        changeSpeakerOnShowState(voipAudioCall2 != null ? Integer.valueOf(voipAudioCall2.getAudioDeviceState()) : null);
    }

    /* access modifiers changed from: protected */
    public final void changeMicOnShowState(boolean z) {
        ImageView imageView = this.f49036j;
        if (imageView != null) {
            imageView.setImageResource(z ? R.drawable.voip_biz_callpage_mic_on : R.drawable.voip_biz_callpage_mic_close);
        }
    }

    /* access modifiers changed from: protected */
    public final void changeSpeakerOnShowState(Integer num) {
        View view = this.f49037k;
        boolean z = false;
        if (view != null) {
            view.setClickable((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4));
        }
        if (num != null && num.intValue() == 3) {
            z = true;
        }
        ImageView imageView = this.f49038l;
        if (imageView != null) {
            imageView.setImageResource(z ? R.drawable.voip_biz_callpage_sound_on : R.drawable.voip_biz_callpage_sound_close);
        }
    }

    /* access modifiers changed from: protected */
    public final void changeHangUpState(boolean z) {
        View view = this.f49039m;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: protected */
    public final void changeAnswerState(boolean z) {
        View view = this.f49040n;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void onAudioDeviceChange(VoipAudioCall voipAudioCall, int i) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        VoipCallListener.DefaultImpls.onAudioDeviceChange(this, voipAudioCall, i);
        changeSpeakerOnShowState(Integer.valueOf(i));
    }

    public void notifyStateDes(String str) {
        TextView textView = this.f49033g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void onStateChange(VoipAudioCall voipAudioCall, CallState callState) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(callState, "state");
        switch (WhenMappings.$EnumSwitchMapping$1[callState.ordinal()]) {
            case 1:
                VoipAudioCall voipAudioCall2 = this.f49042p;
                if (voipAudioCall2 != null) {
                    voipAudioCall2.playWait();
                }
                notifyPageStateChange(VoipCallPageState.OUTGOING_CALLING);
                return;
            case 2:
                notifyPageStateChange(VoipCallPageState.OUTGOING_CALLING_WAITING);
                return;
            case 3:
                notifyPageStateChange(VoipCallPageState.INCOME_RINGING);
                return;
            case 4:
                notifyPageStateChange(VoipCallPageState.INCOME_CALLING);
                return;
            case 5:
                notifyPageStateChange(VoipCallPageState.IN_CALL);
                return;
            case 6:
                View view = this.f49029c;
                if (view != null) {
                    view.postDelayed(new ACallPageController$onStateChange$1(this), 1000);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onMicStateChange(VoipAudioCall voipAudioCall, boolean z) {
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipAudioCall");
        VoipCallListener.DefaultImpls.onMicStateChange(this, voipAudioCall, z);
        changeMicOnShowState(z);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        r1 = r1.getRole();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyPageStateChange(com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipCallPageState r5) {
        /*
            r4 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = r4.getTAG()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "notifyPageStateChange - cur:"
            r1.append(r2)
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r2 = r4.f49041o
            r1.append(r2)
            java.lang.String r2 = " new:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            r4.f49041o = r5
            int[] r0 = com.didichuxing.comp.telecom.biz.p177ui.voipcall.page.ACallPageController.WhenMappings.$EnumSwitchMapping$2
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 1
            java.lang.String r1 = "CallManagerAssist.getInstance()"
            r2 = 0
            if (r5 == r0) goto L_0x00aa
            r0 = 2
            if (r5 == r0) goto L_0x0075
            r0 = 3
            if (r5 == r0) goto L_0x003f
            goto L_0x00de
        L_0x003f:
            com.didichuxing.comp.telecom.core.CallManagerAssist r5 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r5 = r5.getConfig()
            if (r5 == 0) goto L_0x00de
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r5 = r5.getEventTickHandler()
            if (r5 == 0) goto L_0x00de
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r0 = r4.f49041o
            java.lang.String r0 = com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipCallPageStateKt.toStr(r0)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r4.f49042p
            if (r1 == 0) goto L_0x0067
            com.didichuxing.comp.telecom.core.CallRole r1 = r1.getRole()
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r1)
            goto L_0x0068
        L_0x0067:
            r1 = r2
        L_0x0068:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r4.f49042p
            if (r3 == 0) goto L_0x0070
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r3.getModel()
        L_0x0070:
            r5.onCallPageShow(r0, r1, r2)
            goto L_0x00de
        L_0x0075:
            com.didichuxing.comp.telecom.core.CallManagerAssist r5 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r5 = r5.getConfig()
            if (r5 == 0) goto L_0x00de
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r5 = r5.getEventTickHandler()
            if (r5 == 0) goto L_0x00de
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r0 = r4.f49041o
            java.lang.String r0 = com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipCallPageStateKt.toStr(r0)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r4.f49042p
            if (r1 == 0) goto L_0x009d
            com.didichuxing.comp.telecom.core.CallRole r1 = r1.getRole()
            if (r1 == 0) goto L_0x009d
            java.lang.String r1 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r1)
            goto L_0x009e
        L_0x009d:
            r1 = r2
        L_0x009e:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r4.f49042p
            if (r3 == 0) goto L_0x00a6
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r3.getModel()
        L_0x00a6:
            r5.onCallPageShow(r0, r1, r2)
            goto L_0x00de
        L_0x00aa:
            com.didichuxing.comp.telecom.core.CallManagerAssist r5 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r5 = r5.getConfig()
            if (r5 == 0) goto L_0x00de
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r5 = r5.getEventTickHandler()
            if (r5 == 0) goto L_0x00de
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r0 = r4.f49041o
            java.lang.String r0 = com.didichuxing.comp.telecom.biz.p177ui.voipcall.VoipCallPageStateKt.toStr(r0)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r4.f49042p
            if (r1 == 0) goto L_0x00d2
            com.didichuxing.comp.telecom.core.CallRole r1 = r1.getRole()
            if (r1 == 0) goto L_0x00d2
            java.lang.String r1 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r1)
            goto L_0x00d3
        L_0x00d2:
            r1 = r2
        L_0x00d3:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r4.f49042p
            if (r3 == 0) goto L_0x00db
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r3.getModel()
        L_0x00db:
            r5.onCallPageShow(r0, r1, r2)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p177ui.voipcall.page.ACallPageController.notifyPageStateChange(com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState):void");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        FragmentActivity activity;
        Fragment fragment = this.f49028b;
        if (fragment != null && (activity = fragment.getActivity()) != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "mFragment?.activity ?: return");
            if (i == this.f49027a && FloatWindowUtils.INSTANCE.hasFloatWindowPermission(activity)) {
                activity.finish();
            }
        }
    }
}
