package com.didi.globalsafetoolkit.business.triprecording;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
final class TripRecordingActivity$setListener$2 implements View.OnClickListener {
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$setListener$2(TripRecordingActivity tripRecordingActivity) {
        this.this$0 = tripRecordingActivity;
    }

    public final void onClick(View view) {
        String str;
        AutoTrackHelper.trackViewOnClick(view);
        SfViewRecordMenuModel access$getSfViewRecordingModel$p = this.this$0.f25142h;
        boolean z = false;
        TripRecordOmageUtils.sendLawBtnClickOmega(access$getSfViewRecordingModel$p != null ? access$getSfViewRecordingModel$p.canRecord : false, this.this$0.f25135a);
        SfViewRecordMenuModel access$getSfViewRecordingModel$p2 = this.this$0.f25142h;
        if (!(access$getSfViewRecordingModel$p2 == null || (str = access$getSfViewRecordingModel$p2.detailLawUrl) == null)) {
            if (str.length() > 0) {
                z = true;
            }
            if (z) {
                SfViewRecordMenuModel access$getSfViewRecordingModel$p3 = this.this$0.f25142h;
                DRouter.build(access$getSfViewRecordingModel$p3 != null ? access$getSfViewRecordingModel$p3.detailLawUrl : null).start(SfContextHelper.getContext());
                return;
            }
        }
        GlobalSfBusinessInterface.openLawWebView();
    }
}
