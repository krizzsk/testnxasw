package com.didi.rfusion.widget.push;

import com.didi.rfusion.widget.push.RFPush;
import com.didi.rfusion.widget.push.RFPushView;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/rfusion/widget/push/RFPush$pushViewDismissListener$1", "Lcom/didi/rfusion/widget/push/RFPushView$OnDismissListener;", "onDismiss", "", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFPush.kt */
public final class RFPush$pushViewDismissListener$1 implements RFPushView.OnDismissListener {
    final /* synthetic */ RFPush this$0;

    RFPush$pushViewDismissListener$1(RFPush rFPush) {
        this.this$0 = rFPush;
    }

    public void onDismiss() {
        this.this$0.m27443b();
        RFPush.OnDismissListener access$getOnDismissListener$p = this.this$0.f36427e;
        if (access$getOnDismissListener$p != null) {
            access$getOnDismissListener$p.onDismiss(this.this$0);
        }
    }
}
