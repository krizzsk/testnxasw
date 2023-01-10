package com.didi.soda.bill.model.datamodel;

import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00002\u0006\u00102\u001a\u000203H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00064"}, mo148868d2 = {"Lcom/didi/soda/bill/model/datamodel/PayChannelModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "bizContent", "", "getBizContent", "()Ljava/lang/String;", "setBizContent", "(Ljava/lang/String;)V", "cardOrg", "getCardOrg", "setCardOrg", "cardPrefix", "getCardPrefix", "setCardPrefix", "cardSuffix", "getCardSuffix", "setCardSuffix", "channelId", "", "getChannelId", "()I", "setChannelId", "(I)V", "channelName", "getChannelName", "setChannelName", "combinedCardOrg", "getCombinedCardOrg", "setCombinedCardOrg", "payChannelEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "getPayChannelEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "setPayChannelEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;)V", "sign", "getSign", "setSign", "signType", "getSignType", "setSignType", "userSelect", "", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "getUserSelect", "()Ljava/util/List;", "setUserSelect", "(Ljava/util/List;)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayChannelModel.kt */
public final class PayChannelModel extends ComponentAbsModel {

    /* renamed from: a */
    private int f41831a;

    /* renamed from: b */
    private String f41832b;

    /* renamed from: c */
    private String f41833c;

    /* renamed from: d */
    private String f41834d;

    /* renamed from: e */
    private String f41835e;

    /* renamed from: f */
    private String f41836f;

    /* renamed from: g */
    private PayChannelEntity f41837g;

    /* renamed from: h */
    private String f41838h;

    /* renamed from: i */
    private String f41839i;

    /* renamed from: j */
    private String f41840j;

    /* renamed from: k */
    private List<GPayMethodItem> f41841k;

    public final int getChannelId() {
        return this.f41831a;
    }

    public final void setChannelId(int i) {
        this.f41831a = i;
    }

    public final String getChannelName() {
        return this.f41832b;
    }

    public final void setChannelName(String str) {
        this.f41832b = str;
    }

    public final String getCardSuffix() {
        return this.f41833c;
    }

    public final void setCardSuffix(String str) {
        this.f41833c = str;
    }

    public final String getCardPrefix() {
        return this.f41834d;
    }

    public final void setCardPrefix(String str) {
        this.f41834d = str;
    }

    public final String getCardOrg() {
        return this.f41835e;
    }

    public final void setCardOrg(String str) {
        this.f41835e = str;
    }

    public final String getCombinedCardOrg() {
        return this.f41836f;
    }

    public final void setCombinedCardOrg(String str) {
        this.f41836f = str;
    }

    public final PayChannelEntity getPayChannelEntity() {
        return this.f41837g;
    }

    public final void setPayChannelEntity(PayChannelEntity payChannelEntity) {
        this.f41837g = payChannelEntity;
    }

    public final String getBizContent() {
        return this.f41838h;
    }

    public final void setBizContent(String str) {
        this.f41838h = str;
    }

    public final String getSignType() {
        return this.f41839i;
    }

    public final void setSignType(String str) {
        this.f41839i = str;
    }

    public final String getSign() {
        return this.f41840j;
    }

    public final void setSign(String str) {
        this.f41840j = str;
    }

    public final List<GPayMethodItem> getUserSelect() {
        return this.f41841k;
    }

    public final void setUserSelect(List<GPayMethodItem> list) {
        this.f41841k = list;
    }

    public PayChannelModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        PayChannelEntity payChannel = billComponentDataEntity.getPayChannel();
        String str = null;
        if (payChannel == null) {
            return null;
        }
        PayChannelModel payChannelModel = new PayChannelModel();
        payChannelModel.setChannelId(payChannel.channelId);
        payChannelModel.setChannelName(payChannel.channelName);
        payChannelModel.setCardSuffix(payChannel.cardSuffix);
        Collection collection = payChannel.combinedChannelList;
        if (collection == null || collection.isEmpty()) {
            payChannelModel.setCardOrg(payChannel.cardOrg);
        } else {
            List<PayChannelEntity> list = payChannel.combinedChannelList;
            if (list != null) {
                if (list.size() >= 1) {
                    PayChannelEntity payChannelEntity = list.get(0);
                    payChannelModel.setCardOrg(payChannelEntity == null ? null : payChannelEntity.cardOrg);
                }
                if (list.size() >= 2) {
                    PayChannelEntity payChannelEntity2 = list.get(1);
                    if (payChannelEntity2 != null) {
                        str = payChannelEntity2.cardOrg;
                    }
                    payChannelModel.setCombinedCardOrg(str);
                }
            }
        }
        payChannelModel.setCardPrefix(payChannel.cardPrefix);
        payChannelModel.setBizContent(payChannel.bizContent);
        payChannelModel.setSignType(payChannel.signType);
        payChannelModel.setSign(payChannel.sign);
        payChannelModel.setUserSelect(payChannel.userSelect);
        payChannelModel.setPayChannelEntity(payChannel);
        return payChannelModel;
    }
}
