package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.dialog.LEGODialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$onBluetoothTurnOff$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMViewModel.kt */
public final class BTMViewModel$onBluetoothTurnOff$1 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ Ref.ObjectRef<LEGODialogFragment> $dialog;
    final /* synthetic */ BTMViewModel this$0;

    BTMViewModel$onBluetoothTurnOff$1(Ref.ObjectRef<LEGODialogFragment> objectRef, BTMViewModel bTMViewModel) {
        this.$dialog = objectRef;
        this.this$0 = bTMViewModel;
    }

    public void onAntiShakeClick(View view) {
        LEGODialogFragment lEGODialogFragment = (LEGODialogFragment) this.$dialog.element;
        if (lEGODialogFragment != null) {
            lEGODialogFragment.dismiss();
        }
        this.this$0.f29016j = null;
        this.this$0.m22608e();
    }
}
