package com.didi.map.global.flow.scene.order.bluetooth_meet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMNavDataEngindParam;", "", "orderId", "", "bluetoothStateCallback", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/IBTMBluetoothStateCallback;", "(Ljava/lang/String;Lcom/didi/map/global/flow/scene/order/bluetooth_meet/IBTMBluetoothStateCallback;)V", "getBluetoothStateCallback", "()Lcom/didi/map/global/flow/scene/order/bluetooth_meet/IBTMBluetoothStateCallback;", "getOrderId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMNavDataEngine.kt */
public final class BTMNavDataEngindParam {

    /* renamed from: a */
    private final String f28939a;

    /* renamed from: b */
    private final IBTMBluetoothStateCallback f28940b;

    public static /* synthetic */ BTMNavDataEngindParam copy$default(BTMNavDataEngindParam bTMNavDataEngindParam, String str, IBTMBluetoothStateCallback iBTMBluetoothStateCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bTMNavDataEngindParam.f28939a;
        }
        if ((i & 2) != 0) {
            iBTMBluetoothStateCallback = bTMNavDataEngindParam.f28940b;
        }
        return bTMNavDataEngindParam.copy(str, iBTMBluetoothStateCallback);
    }

    public final String component1() {
        return this.f28939a;
    }

    public final IBTMBluetoothStateCallback component2() {
        return this.f28940b;
    }

    public final BTMNavDataEngindParam copy(String str, IBTMBluetoothStateCallback iBTMBluetoothStateCallback) {
        return new BTMNavDataEngindParam(str, iBTMBluetoothStateCallback);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BTMNavDataEngindParam)) {
            return false;
        }
        BTMNavDataEngindParam bTMNavDataEngindParam = (BTMNavDataEngindParam) obj;
        return Intrinsics.areEqual((Object) this.f28939a, (Object) bTMNavDataEngindParam.f28939a) && Intrinsics.areEqual((Object) this.f28940b, (Object) bTMNavDataEngindParam.f28940b);
    }

    public int hashCode() {
        String str = this.f28939a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        IBTMBluetoothStateCallback iBTMBluetoothStateCallback = this.f28940b;
        if (iBTMBluetoothStateCallback != null) {
            i = iBTMBluetoothStateCallback.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "BTMNavDataEngindParam(orderId=" + this.f28939a + ", bluetoothStateCallback=" + this.f28940b + VersionRange.RIGHT_OPEN;
    }

    public BTMNavDataEngindParam(String str, IBTMBluetoothStateCallback iBTMBluetoothStateCallback) {
        this.f28939a = str;
        this.f28940b = iBTMBluetoothStateCallback;
    }

    public final String getOrderId() {
        return this.f28939a;
    }

    public final IBTMBluetoothStateCallback getBluetoothStateCallback() {
        return this.f28940b;
    }
}
