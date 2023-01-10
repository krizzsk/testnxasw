package com.didi.map.global.sctx.mock;

import com.didi.common.map.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/map/global/sctx/mock/MockParam;", "", "()V", "destPosition", "Lcom/didi/common/map/model/LatLng;", "getDestPosition", "()Lcom/didi/common/map/model/LatLng;", "setDestPosition", "(Lcom/didi/common/map/model/LatLng;)V", "driverPosition", "getDriverPosition", "setDriverPosition", "location", "getLocation", "setLocation", "pickupPosition", "getPickupPosition", "setPickupPosition", "recommendPickupPosition", "getRecommendPickupPosition", "setRecommendPickupPosition", "Companion", "SingletonHolder", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MockParam.kt */
public final class MockParam {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final MockParam f30083f = SingletonHolder.INSTANCE.getINSTANCE();

    /* renamed from: a */
    private LatLng f30084a;

    /* renamed from: b */
    private LatLng f30085b;

    /* renamed from: c */
    private LatLng f30086c;

    /* renamed from: d */
    private LatLng f30087d;

    /* renamed from: e */
    private LatLng f30088e;

    public /* synthetic */ MockParam(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MockParam() {
        this.f30084a = new LatLng(-25.57269d, -49.39746d);
        this.f30085b = new LatLng(-25.57527d, -49.39706d);
        this.f30086c = new LatLng(-25.57286d, -49.39946d);
        this.f30087d = new LatLng(-25.5736579d, -49.3989945d);
        this.f30088e = new LatLng(-25.56945d, -49.40373d);
    }

    public final LatLng getLocation() {
        return this.f30084a;
    }

    public final void setLocation(LatLng latLng) {
        this.f30084a = latLng;
    }

    public final LatLng getDriverPosition() {
        return this.f30085b;
    }

    public final void setDriverPosition(LatLng latLng) {
        this.f30085b = latLng;
    }

    public final LatLng getPickupPosition() {
        return this.f30086c;
    }

    public final void setPickupPosition(LatLng latLng) {
        this.f30086c = latLng;
    }

    public final LatLng getRecommendPickupPosition() {
        return this.f30087d;
    }

    public final void setRecommendPickupPosition(LatLng latLng) {
        this.f30087d = latLng;
    }

    public final LatLng getDestPosition() {
        return this.f30088e;
    }

    public final void setDestPosition(LatLng latLng) {
        this.f30088e = latLng;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/map/global/sctx/mock/MockParam$Companion;", "", "()V", "instance", "Lcom/didi/map/global/sctx/mock/MockParam;", "getInstance", "()Lcom/didi/map/global/sctx/mock/MockParam;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: MockParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MockParam getInstance() {
            return MockParam.f30083f;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\b\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo148868d2 = {"Lcom/didi/map/global/sctx/mock/MockParam$SingletonHolder;", "", "()V", "INSTANCE", "Lcom/didi/map/global/sctx/mock/MockParam;", "getINSTANCE", "()Lcom/didi/map/global/sctx/mock/MockParam;", "INSTANCE$1", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: MockParam.kt */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final MockParam INSTANCE$1 = new MockParam((DefaultConstructorMarker) null);

        private SingletonHolder() {
        }

        public final MockParam getINSTANCE() {
            return INSTANCE$1;
        }
    }
}
