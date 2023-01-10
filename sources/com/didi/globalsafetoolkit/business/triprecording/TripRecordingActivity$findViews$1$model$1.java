package com.didi.globalsafetoolkit.business.triprecording;

import android.widget.Switch;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener2;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/globalsafetoolkit/business/triprecording/TripRecordingActivity$findViews$1$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener2;", "onClickInDrawer", "", "drawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
public final class TripRecordingActivity$findViews$1$model$1 extends LEGOOnAntiShakeClickListener2 {
    final /* synthetic */ TripRecordingActivity$findViews$1 this$0;

    TripRecordingActivity$findViews$1$model$1(TripRecordingActivity$findViews$1 tripRecordingActivity$findViews$1) {
        this.this$0 = tripRecordingActivity$findViews$1;
    }

    public void onClickInDrawer(LEGODrawer lEGODrawer) {
        Intrinsics.checkParameterIsNotNull(lEGODrawer, Const.DRAWER);
        Switch access$getSwitchAutoRecording$p = this.this$0.this$0.f25143i;
        if (access$getSwitchAutoRecording$p != null) {
            access$getSwitchAutoRecording$p.setChecked(true);
        }
        lEGODrawer.dismiss();
        TripRecordOmageUtils.ibt_gp_autorecord_close_turnon_ck();
    }
}
