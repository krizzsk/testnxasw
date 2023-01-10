package com.didi.globalsafetoolkit.business.triprecording;

import android.widget.Toast;
import com.didi.globalsafetoolkit.dialog.DiDiLoadingDialog;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.globalsafetoolkit.util.SfUIThreadHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/globalsafetoolkit/business/triprecording/TripRecordingActivity$startRecord$1", "Lcom/didi/globalsafetoolkit/business/triprecording/RecordListenerImpl;", "onAlreadyStart", "", "onError", "errCode", "", "onPause", "onResume", "onStart", "onStop", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
public final class TripRecordingActivity$startRecord$1 implements RecordListenerImpl {
    final /* synthetic */ DiDiLoadingDialog $loadingDialog;
    final /* synthetic */ TripRecordingActivity this$0;

    TripRecordingActivity$startRecord$1(TripRecordingActivity tripRecordingActivity, DiDiLoadingDialog diDiLoadingDialog) {
        this.this$0 = tripRecordingActivity;
        this.$loadingDialog = diDiLoadingDialog;
    }

    public void onResume() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m20114a();
    }

    public void onPause() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m20114a();
    }

    public void onStart() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m20114a();
        SfUIThreadHelper.post(TripRecordingActivity$startRecord$1$onStart$1.INSTANCE);
    }

    public void onStop() {
        this.$loadingDialog.removeLoadingDialog();
        this.this$0.m20114a();
    }

    public void onError(int i) {
        this.$loadingDialog.removeLoadingDialog();
        SystemUtils.showToast(Toast.makeText(this.this$0, SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_V1_Try_again_Zkua), 1));
    }

    public void onAlreadyStart() {
        this.$loadingDialog.removeLoadingDialog();
    }
}
