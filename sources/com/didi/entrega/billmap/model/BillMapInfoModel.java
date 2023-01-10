package com.didi.entrega.billmap.model;

import com.didi.common.map.model.LatLng;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/entrega/billmap/model/BillMapInfoModel;", "", "()V", "etaTips", "", "getEtaTips", "()Ljava/lang/String;", "setEtaTips", "(Ljava/lang/String;)V", "receiverDisplayName", "getReceiverDisplayName", "setReceiverDisplayName", "receiverLatLng", "Lcom/didi/common/map/model/LatLng;", "getReceiverLatLng", "()Lcom/didi/common/map/model/LatLng;", "setReceiverLatLng", "(Lcom/didi/common/map/model/LatLng;)V", "senderDisplayName", "getSenderDisplayName", "setSenderDisplayName", "senderLatLng", "getSenderLatLng", "setSenderLatLng", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillMapInfoModel.kt */
public final class BillMapInfoModel {

    /* renamed from: a */
    private String f21478a;

    /* renamed from: b */
    private String f21479b;

    /* renamed from: c */
    private LatLng f21480c;

    /* renamed from: d */
    private LatLng f21481d;

    /* renamed from: e */
    private String f21482e;

    public final String getSenderDisplayName() {
        return this.f21478a;
    }

    public final void setSenderDisplayName(String str) {
        this.f21478a = str;
    }

    public final String getReceiverDisplayName() {
        return this.f21479b;
    }

    public final void setReceiverDisplayName(String str) {
        this.f21479b = str;
    }

    public final LatLng getSenderLatLng() {
        return this.f21480c;
    }

    public final void setSenderLatLng(LatLng latLng) {
        this.f21480c = latLng;
    }

    public final LatLng getReceiverLatLng() {
        return this.f21481d;
    }

    public final void setReceiverLatLng(LatLng latLng) {
        this.f21481d = latLng;
    }

    public final String getEtaTips() {
        return this.f21482e;
    }

    public final void setEtaTips(String str) {
        this.f21482e = str;
    }
}
