package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;", "", "orderId", "", "driverInfo", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMDriverParam;", "handler", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/IBTMHandler;", "(Ljava/lang/String;Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMDriverParam;Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/IBTMHandler;)V", "getDriverInfo", "()Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMDriverParam;", "getHandler", "()Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/IBTMHandler;", "getOrderId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxBTMParam.kt */
public final class SctxBTMParam {

    /* renamed from: a */
    private final String f29028a;

    /* renamed from: b */
    private final SctxBTMDriverParam f29029b;

    /* renamed from: c */
    private final IBTMHandler f29030c;

    public static /* synthetic */ SctxBTMParam copy$default(SctxBTMParam sctxBTMParam, String str, SctxBTMDriverParam sctxBTMDriverParam, IBTMHandler iBTMHandler, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sctxBTMParam.f29028a;
        }
        if ((i & 2) != 0) {
            sctxBTMDriverParam = sctxBTMParam.f29029b;
        }
        if ((i & 4) != 0) {
            iBTMHandler = sctxBTMParam.f29030c;
        }
        return sctxBTMParam.copy(str, sctxBTMDriverParam, iBTMHandler);
    }

    public final String component1() {
        return this.f29028a;
    }

    public final SctxBTMDriverParam component2() {
        return this.f29029b;
    }

    public final IBTMHandler component3() {
        return this.f29030c;
    }

    public final SctxBTMParam copy(String str, SctxBTMDriverParam sctxBTMDriverParam, IBTMHandler iBTMHandler) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        return new SctxBTMParam(str, sctxBTMDriverParam, iBTMHandler);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SctxBTMParam)) {
            return false;
        }
        SctxBTMParam sctxBTMParam = (SctxBTMParam) obj;
        return Intrinsics.areEqual((Object) this.f29028a, (Object) sctxBTMParam.f29028a) && Intrinsics.areEqual((Object) this.f29029b, (Object) sctxBTMParam.f29029b) && Intrinsics.areEqual((Object) this.f29030c, (Object) sctxBTMParam.f29030c);
    }

    public int hashCode() {
        int hashCode = this.f29028a.hashCode() * 31;
        SctxBTMDriverParam sctxBTMDriverParam = this.f29029b;
        int i = 0;
        int hashCode2 = (hashCode + (sctxBTMDriverParam == null ? 0 : sctxBTMDriverParam.hashCode())) * 31;
        IBTMHandler iBTMHandler = this.f29030c;
        if (iBTMHandler != null) {
            i = iBTMHandler.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SctxBTMParam(orderId=" + this.f29028a + ", driverInfo=" + this.f29029b + ", handler=" + this.f29030c + VersionRange.RIGHT_OPEN;
    }

    public SctxBTMParam(String str, SctxBTMDriverParam sctxBTMDriverParam, IBTMHandler iBTMHandler) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.f29028a = str;
        this.f29029b = sctxBTMDriverParam;
        this.f29030c = iBTMHandler;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SctxBTMParam(String str, SctxBTMDriverParam sctxBTMDriverParam, IBTMHandler iBTMHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, sctxBTMDriverParam, iBTMHandler);
    }

    public final String getOrderId() {
        return this.f29028a;
    }

    public final SctxBTMDriverParam getDriverInfo() {
        return this.f29029b;
    }

    public final IBTMHandler getHandler() {
        return this.f29030c;
    }
}
