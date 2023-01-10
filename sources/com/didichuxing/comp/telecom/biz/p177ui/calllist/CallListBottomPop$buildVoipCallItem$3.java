package com.didichuxing.comp.telecom.biz.p177ui.calllist;

import android.content.Context;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.biz.util.AudioGrantedCallback;
import com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallToastUtil;
import com.didichuxing.comp.telecom.core.request.model.CallMethodItem;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.calllist.CallListBottomPop$buildVoipCallItem$3 */
/* compiled from: CallListBottomPop.kt */
final class CallListBottomPop$buildVoipCallItem$3 implements View.OnClickListener {
    final /* synthetic */ CallMethodItem $itemModel;
    final /* synthetic */ VoipCallModel $voipData;
    final /* synthetic */ CallListBottomPop this$0;

    CallListBottomPop$buildVoipCallItem$3(CallListBottomPop callListBottomPop, CallMethodItem callMethodItem, VoipCallModel voipCallModel) {
        this.this$0 = callListBottomPop;
        this.$itemModel = callMethodItem;
        this.$voipData = voipCallModel;
    }

    public final void onClick(View view) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.dismiss();
        CallLogUtil.logI(this.this$0.f48945a, "call methods - voip item click");
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (!(config == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
            eventTickHandler.onCallListItemClick(this.$itemModel, this.$voipData);
        }
        if (CallManager.Companion.getInstance().inCalling()) {
            CallLogUtil.logI(this.this$0.f48945a, "click ignore for in voip calling");
            CallToastUtil.makeToast(Integer.valueOf(R.string.GDriver_IBT_On_the_eVku));
            return;
        }
        if (this.this$0.f48954j != null) {
            VoipClickCallback access$getMVoipCallback$p = this.this$0.f48954j;
            if (access$getMVoipCallback$p == null) {
                Intrinsics.throwNpe();
            }
            if (access$getMVoipCallback$p.onClick(this.$voipData)) {
                return;
            }
        }
        AnalyseTickHelper.INSTANCE.tickVoipSteps(AnalyseTickHelper.STEP_CALLOUT, this.$voipData, CallRole.CALL_MAKER);
        VoipPermissionHelper.INSTANCE.checkAudioPermission(this.this$0.f48951g, new AudioGrantedCallback(this) {
            final /* synthetic */ CallListBottomPop$buildVoipCallItem$3 this$0;

            public void onCancel() {
            }

            {
                this.this$0 = r1;
            }

            public void onGranted() {
                AnalyseTickHelper.INSTANCE.tickVoipSteps(AnalyseTickHelper.STEP_GRANTED, this.this$0.$voipData, CallRole.CALL_MAKER);
                this.this$0.this$0.m36727a((Context) this.this$0.this$0.f48951g, this.this$0.$voipData);
            }
        });
    }
}
