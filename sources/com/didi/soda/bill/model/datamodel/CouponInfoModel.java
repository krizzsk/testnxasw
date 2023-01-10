package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/soda/bill/model/datamodel/CouponInfoModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "activityId", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "batchId", "getBatchId", "setBatchId", "couponId", "getCouponId", "setCouponId", "selected", "", "getSelected", "()I", "setSelected", "(I)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CouponInfoModel.kt */
public final class CouponInfoModel extends ComponentAbsModel {

    /* renamed from: a */
    private String f41812a = "";

    /* renamed from: b */
    private String f41813b = "";

    /* renamed from: c */
    private String f41814c = "-1";

    /* renamed from: d */
    private int f41815d;

    public final String getBatchId() {
        return this.f41812a;
    }

    public final void setBatchId(String str) {
        this.f41812a = str;
    }

    public final String getActivityId() {
        return this.f41813b;
    }

    public final void setActivityId(String str) {
        this.f41813b = str;
    }

    public final String getCouponId() {
        return this.f41814c;
    }

    public final void setCouponId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f41814c = str;
    }

    public final int getSelected() {
        return this.f41815d;
    }

    public final void setSelected(int i) {
        this.f41815d = i;
    }

    public CouponInfoModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        CouponInfoEntity couponInfo = billComponentDataEntity.getCouponInfo();
        if (couponInfo == null) {
            return null;
        }
        setBatchId(couponInfo.getBatchId());
        String couponId = couponInfo.getCouponId();
        if (couponId == null) {
            couponId = "-1";
        }
        setCouponId(couponId);
        setSelected(couponInfo.getSelected());
        setActivityId(couponInfo.getActivityId());
        return this;
    }
}
