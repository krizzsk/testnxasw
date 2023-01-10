package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.PriceInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, mo148868d2 = {"Lcom/didi/soda/bill/model/datamodel/PriceInfoModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "highLight", "", "getHighLight", "()I", "setHighLight", "(I)V", "oriPrice", "getOriPrice", "setOriPrice", "oriPriceDisplay", "", "getOriPriceDisplay", "()Ljava/lang/String;", "setOriPriceDisplay", "(Ljava/lang/String;)V", "payPrice", "getPayPrice", "setPayPrice", "payPriceDisplay", "getPayPriceDisplay", "setPayPriceDisplay", "ruleDesc", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "getRuleDesc", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "setRuleDesc", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PriceInfoModel.kt */
public final class PriceInfoModel extends ComponentAbsModel {

    /* renamed from: a */
    private int f41842a;

    /* renamed from: b */
    private String f41843b;

    /* renamed from: c */
    private int f41844c;

    /* renamed from: d */
    private String f41845d;

    /* renamed from: e */
    private int f41846e;

    /* renamed from: f */
    private RuleDescEntity f41847f;

    public final int getOriPrice() {
        return this.f41842a;
    }

    public final void setOriPrice(int i) {
        this.f41842a = i;
    }

    public final String getOriPriceDisplay() {
        return this.f41843b;
    }

    public final void setOriPriceDisplay(String str) {
        this.f41843b = str;
    }

    public final int getPayPrice() {
        return this.f41844c;
    }

    public final void setPayPrice(int i) {
        this.f41844c = i;
    }

    public final String getPayPriceDisplay() {
        return this.f41845d;
    }

    public final void setPayPriceDisplay(String str) {
        this.f41845d = str;
    }

    public final int getHighLight() {
        return this.f41846e;
    }

    public final void setHighLight(int i) {
        this.f41846e = i;
    }

    public final RuleDescEntity getRuleDesc() {
        return this.f41847f;
    }

    public final void setRuleDesc(RuleDescEntity ruleDescEntity) {
        this.f41847f = ruleDescEntity;
    }

    public PriceInfoModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        PriceInfo priceInfo = billComponentDataEntity.getPriceInfo();
        if (priceInfo == null) {
            return null;
        }
        PriceInfoModel priceInfoModel = new PriceInfoModel();
        priceInfoModel.setOriPrice(priceInfo.getOriPrice());
        priceInfoModel.setOriPriceDisplay(priceInfo.getOriPriceDisplay());
        priceInfoModel.setPayPrice(priceInfo.getPayPrice());
        priceInfoModel.setPayPriceDisplay(priceInfo.getPayPriceDisplay());
        priceInfoModel.setHighLight(priceInfo.getHighLight());
        priceInfoModel.setRuleDesc(priceInfo.getRuleDesc());
        return priceInfoModel;
    }
}
