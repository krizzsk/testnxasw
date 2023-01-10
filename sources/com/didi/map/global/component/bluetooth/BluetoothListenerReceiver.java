package com.didi.map.global.component.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BluetoothListenerReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final BluetoothStateCallBack f27021a;

    public BluetoothListenerReceiver(BluetoothStateCallBack bluetoothStateCallBack) {
        this.f27021a = bluetoothStateCallBack;
    }

    public void onReceive(Context context, Intent intent) {
        BluetoothStateCallBack bluetoothStateCallBack;
        if (intent != null && intent.getAction() != null && "android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            if (intExtra == 12) {
                BluetoothStateCallBack bluetoothStateCallBack2 = this.f27021a;
                if (bluetoothStateCallBack2 != null) {
                    bluetoothStateCallBack2.bluetoothOpened();
                }
            } else if (intExtra == 13 && (bluetoothStateCallBack = this.f27021a) != null) {
                bluetoothStateCallBack.bluetoothClosed();
            }
        }
    }
}
