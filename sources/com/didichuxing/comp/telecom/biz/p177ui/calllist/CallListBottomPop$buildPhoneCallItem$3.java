package com.didichuxing.comp.telecom.biz.p177ui.calllist;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.request.model.CallListModel;
import com.didichuxing.comp.telecom.core.request.model.CallMethodItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.calllist.CallListBottomPop$buildPhoneCallItem$3 */
/* compiled from: CallListBottomPop.kt */
final class CallListBottomPop$buildPhoneCallItem$3 implements View.OnClickListener {
    final /* synthetic */ CallMethodItem $itemModel;
    final /* synthetic */ CallListModel $model;
    final /* synthetic */ CallListBottomPop this$0;

    CallListBottomPop$buildPhoneCallItem$3(CallListBottomPop callListBottomPop, CallMethodItem callMethodItem, CallListModel callListModel) {
        this.this$0 = callListBottomPop;
        this.$itemModel = callMethodItem;
        this.$model = callListModel;
    }

    public final void onClick(View view) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.dismiss();
        CallLogUtil.logI(this.this$0.f48945a, "call methods - phone item click");
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (!(config == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
            eventTickHandler.onCallListItemClick(this.$itemModel, this.$model);
        }
        PhoneClickCallback access$getMPhoneCallback$p = this.this$0.f48953i;
        if (access$getMPhoneCallback$p != null) {
            access$getMPhoneCallback$p.onClick();
        }
    }
}
