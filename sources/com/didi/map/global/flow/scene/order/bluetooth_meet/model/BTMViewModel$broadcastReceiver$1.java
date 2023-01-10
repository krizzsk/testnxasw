package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMViewKt;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMViewModel.kt */
public final class BTMViewModel$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BTMViewModel this$0;

    BTMViewModel$broadcastReceiver$1(BTMViewModel bTMViewModel) {
        this.this$0 = bTMViewModel;
    }

    public void onReceive(Context context, Intent intent) {
        Integer valueOf = intent == null ? null : Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1));
        if (valueOf != null && valueOf.intValue() == 12) {
            DLog.m10773d(SctxBTMViewKt.BTM_TAG, "Bluetooth State: STATE_ON", new Object[0]);
            if (this.this$0.getUiStateLiveData().getValue() == BTMState.BLUETOOTH_TURNOFF) {
                this.this$0.m22611h();
            }
        } else if (valueOf != null && valueOf.intValue() == 10) {
            DLog.m10773d(SctxBTMViewKt.BTM_TAG, "Bluetooth State: STATE_OFF", new Object[0]);
        } else if (valueOf != null && valueOf.intValue() == 11) {
            DLog.m10773d(SctxBTMViewKt.BTM_TAG, "Bluetooth State: STATE_TURNING_ON", new Object[0]);
        } else if (valueOf != null && valueOf.intValue() == 13) {
            DLog.m10773d(SctxBTMViewKt.BTM_TAG, "Bluetooth State: STATE_TURNING_OFF", new Object[0]);
            this.this$0.m22597a();
        }
    }
}
