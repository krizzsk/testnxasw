package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0007J\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BluetoothPermissionHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "targetApi", "", "checkBlueToothPermission", "", "enableBluetooth", "isEnable", "requestBluetoothPermission", "", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BluetoothPermissionHelper.kt */
public final class BluetoothPermissionHelper {

    /* renamed from: a */
    private final Context f28964a;

    /* renamed from: b */
    private final int f28965b;

    /* renamed from: c */
    private final BluetoothAdapter f28966c = BluetoothAdapter.getDefaultAdapter();

    public BluetoothPermissionHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f28964a = context;
        this.f28965b = context.getApplicationInfo().targetSdkVersion;
    }

    public final Context getContext() {
        return this.f28964a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean checkBlueToothPermission() {
        /*
            r4 = this;
            int r0 = r4.f28965b
            r1 = 1
            r2 = 0
            r3 = 31
            if (r0 < r3) goto L_0x002b
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x002b
            android.content.Context r0 = r4.f28964a
            java.lang.String r3 = "android.permission.BLUETOOTH_CONNECT"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)
            if (r0 != 0) goto L_0x0040
            android.content.Context r0 = r4.f28964a
            java.lang.String r3 = "android.permission.BLUETOOTH_ADVERTISE"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)
            if (r0 != 0) goto L_0x0040
            android.content.Context r0 = r4.f28964a
            java.lang.String r3 = "android.permission.BLUETOOTH_SCAN"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)
            if (r0 != 0) goto L_0x0040
            goto L_0x0041
        L_0x002b:
            android.content.Context r0 = r4.f28964a
            java.lang.String r3 = "android.permission.BLUETOOTH"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)
            if (r0 != 0) goto L_0x0040
            android.content.Context r0 = r4.f28964a
            java.lang.String r3 = "android.permission.BLUETOOTH_ADMIN"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r3)
            if (r0 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.bluetooth_meet.BluetoothPermissionHelper.checkBlueToothPermission():boolean");
    }

    public final boolean isEnable() {
        return this.f28966c.isEnabled();
    }

    public final boolean enableBluetooth() {
        return this.f28966c.enable();
    }

    public final void requestBluetoothPermission() {
        if (this.f28965b >= 31 && Build.VERSION.SDK_INT >= 31) {
            String[] strArr = {"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_SCAN"};
            Context context = this.f28964a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.requestPermissions(strArr, SctxBTMView.Companion.getBLE_REQUEST_CODE());
            }
        }
    }
}
