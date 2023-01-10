package com.didichuxing.comp.telecom.biz.p177ui.voipcall;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didichuxing.comp.telecom.biz.p177ui.base.ATelecomFragment;
import com.didichuxing.comp.telecom.biz.p177ui.notitication.VoipNotificationHelper;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.page.ACallPageController;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.page.CalledPageController;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.page.CallingPageController;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallToastUtil;
import com.didichuxing.comp.telecom.core.CallUtils;
import com.didichuxing.comp.telecom.core.base.ICall;
import com.didichuxing.comp.telecom.core.util.TtsServiceHelper;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\u001a\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipBusinessFragment;", "Lcom/didichuxing/comp/telecom/biz/ui/base/ATelecomFragment;", "()V", "TAG", "", "mPageAction", "", "Ljava/lang/Integer;", "mPageController", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/page/ACallPageController;", "mPageModel", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "mRootView", "Landroid/view/View;", "checkCallAction", "", "newAction", "newVoipModel", "(Ljava/lang/Integer;Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;)V", "exitForError", "handleCallInCome", "handleCallResume", "handleMakeCall", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipBusinessFragment */
/* compiled from: VoipBusinessActivity.kt */
public final class VoipBusinessFragment extends ATelecomFragment {

    /* renamed from: a */
    private final String f48969a = "VoipBusinessFragment";

    /* renamed from: b */
    private ACallPageController f48970b;

    /* renamed from: c */
    private View f48971c;

    /* renamed from: d */
    private Integer f48972d;

    /* renamed from: e */
    private VoipCallModel f48973e;

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.VoipBusinessFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallRole.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CallRole.CALL_MAKER.ordinal()] = 1;
            $EnumSwitchMapping$0[CallRole.CALLEE.ordinal()] = 2;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f48972d = Integer.valueOf(arguments != null ? arguments.getInt(VoipBusinessActivity.KEY_ACTION) : 1);
        Bundle arguments2 = getArguments();
        Object obj = null;
        Object serializable = arguments2 != null ? arguments2.getSerializable(VoipBusinessActivity.KEY_VOIP_DATA) : null;
        if (serializable instanceof VoipCallModel) {
            obj = serializable;
        }
        this.f48973e = (VoipCallModel) obj;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.voip_biz_page_call, viewGroup, false);
        this.f48971c = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        CallLogUtil.logI(this.f48969a, "onViewCreated");
        m36739a(this.f48972d, this.f48973e);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACallPageController aCallPageController = this.f48970b;
        if (aCallPageController != null) {
            aCallPageController.onActivityResult(i, i2, intent);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        CallLogUtil.logI(this.f48969a, "onDestroyView");
        ACallPageController aCallPageController = this.f48970b;
        if (aCallPageController != null) {
            aCallPageController.onDestroyView();
        }
    }

    /* renamed from: a */
    private final void m36739a(Integer num, VoipCallModel voipCallModel) {
        if (num != null && num.intValue() == 2) {
            m36738a(voipCallModel);
        } else if (num != null && num.intValue() == 3) {
            VoipNotificationHelper.Companion.getInstance().clearIncomeCallNotification();
            m36741b(voipCallModel);
        } else if (num != null && num.intValue() == 1) {
            m36737a();
        } else {
            m36740b();
        }
    }

    /* renamed from: a */
    private final void m36738a(VoipCallModel voipCallModel) {
        String str = this.f48969a;
        CallLogUtil.logI(str, "handleMakeCall - model:" + voipCallModel);
        View view = this.f48971c;
        ICall mCurrentCall = CallManager.Companion.getInstance().getMCurrentCall();
        if (!(mCurrentCall instanceof VoipAudioCall)) {
            mCurrentCall = null;
        }
        if (((VoipAudioCall) mCurrentCall) != null || voipCallModel == null) {
            m36737a();
            return;
        }
        CallingPageController callingPageController = new CallingPageController();
        this.f48970b = callingPageController;
        callingPageController.bindController(this, view, CallManager.Companion.getInstance().makeVoipCall(voipCallModel));
    }

    /* renamed from: b */
    private final void m36741b(VoipCallModel voipCallModel) {
        View view = this.f48971c;
        String str = this.f48969a;
        CallLogUtil.logI(str, "handleCallInCome - model:" + voipCallModel);
        if (CallManager.Companion.getInstance().getMCurrentCall() != null || voipCallModel == null) {
            m36737a();
            return;
        }
        CallingPageController callingPageController = new CallingPageController();
        this.f48970b = callingPageController;
        callingPageController.bindController(this, view, CallManager.Companion.getInstance().onCallIncome(voipCallModel));
    }

    /* renamed from: a */
    private final void m36737a() {
        View view = this.f48971c;
        ICall mCurrentCall = CallManager.Companion.getInstance().getMCurrentCall();
        CallRole callRole = null;
        if (!(mCurrentCall instanceof VoipAudioCall)) {
            mCurrentCall = null;
        }
        VoipAudioCall voipAudioCall = (VoipAudioCall) mCurrentCall;
        String str = this.f48969a;
        StringBuilder sb = new StringBuilder();
        sb.append("handleCallResume - role:");
        sb.append(voipAudioCall != null ? voipAudioCall.getRole() : null);
        sb.append(" cur:");
        sb.append(voipAudioCall != null ? voipAudioCall.getModel() : null);
        CallLogUtil.logI(str, sb.toString());
        if (voipAudioCall != null) {
            callRole = voipAudioCall.getRole();
        }
        if (callRole != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[callRole.ordinal()];
            if (i == 1) {
                CallingPageController callingPageController = new CallingPageController();
                this.f48970b = callingPageController;
                callingPageController.bindController(this, view, voipAudioCall);
                return;
            } else if (i == 2) {
                CalledPageController calledPageController = new CalledPageController();
                this.f48970b = calledPageController;
                calledPageController.bindController(this, view, voipAudioCall);
                return;
            }
        }
        m36740b();
    }

    /* renamed from: b */
    private final void m36740b() {
        CallLogUtil.logI(this.f48969a, "exitForError");
        String stringRes = CallUtils.INSTANCE.getStringRes(Integer.valueOf(R.string.GDriver_IBT_System_exception_uzlx));
        CallToastUtil.makeToast(stringRes);
        TtsServiceHelper.play$default(TtsServiceHelper.Companion.getInstance(), stringRes, false, 2, (Object) null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final boolean onBackPressed() {
        ACallPageController aCallPageController = this.f48970b;
        if (aCallPageController != null) {
            return aCallPageController.onBackPressed();
        }
        return false;
    }
}
