package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.ReminderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/soda/bill/model/datamodel/ReminderModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentType", "", "getContentType", "()I", "setContentType", "(I)V", "icon", "getIcon", "setIcon", "url", "getUrl", "setUrl", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ReminderModel.kt */
public final class ReminderModel extends ComponentAbsModel {

    /* renamed from: a */
    private int f41849a;

    /* renamed from: b */
    private String f41850b;

    /* renamed from: c */
    private String f41851c;

    /* renamed from: d */
    private String f41852d;

    public final int getContentType() {
        return this.f41849a;
    }

    public final void setContentType(int i) {
        this.f41849a = i;
    }

    public final String getContent() {
        return this.f41850b;
    }

    public final void setContent(String str) {
        this.f41850b = str;
    }

    public final String getIcon() {
        return this.f41851c;
    }

    public final void setIcon(String str) {
        this.f41851c = str;
    }

    public final String getUrl() {
        return this.f41852d;
    }

    public final void setUrl(String str) {
        this.f41852d = str;
    }

    public ReminderModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        ReminderInfo reminderInfo = billComponentDataEntity.getReminderInfo();
        if (reminderInfo == null) {
            return null;
        }
        setContentType(reminderInfo.getContentType());
        setContent(reminderInfo.getContent());
        setIcon(reminderInfo.getIcon());
        setUrl(reminderInfo.getUrl());
        return this;
    }
}
