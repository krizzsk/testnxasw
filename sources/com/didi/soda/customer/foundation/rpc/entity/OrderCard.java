package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderCard;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "template", "", "cardId", "data", "Lcom/didi/soda/customer/foundation/rpc/entity/CardData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/CardData;)V", "getCardId", "()Ljava/lang/String;", "getData", "()Lcom/didi/soda/customer/foundation/rpc/entity/CardData;", "getTemplate", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderCard implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4849272478476231047L;
    private final String cardId;
    private final CardData data;
    private final String template;

    public OrderCard() {
        this((String) null, (String) null, (CardData) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderCard copy$default(OrderCard orderCard, String str, String str2, CardData cardData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderCard.template;
        }
        if ((i & 2) != 0) {
            str2 = orderCard.cardId;
        }
        if ((i & 4) != 0) {
            cardData = orderCard.data;
        }
        return orderCard.copy(str, str2, cardData);
    }

    public final String component1() {
        return this.template;
    }

    public final String component2() {
        return this.cardId;
    }

    public final CardData component3() {
        return this.data;
    }

    public final OrderCard copy(String str, String str2, CardData cardData) {
        return new OrderCard(str, str2, cardData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderCard)) {
            return false;
        }
        OrderCard orderCard = (OrderCard) obj;
        return Intrinsics.areEqual((Object) this.template, (Object) orderCard.template) && Intrinsics.areEqual((Object) this.cardId, (Object) orderCard.cardId) && Intrinsics.areEqual((Object) this.data, (Object) orderCard.data);
    }

    public int hashCode() {
        String str = this.template;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cardId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        CardData cardData = this.data;
        if (cardData != null) {
            i = cardData.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "OrderCard(template=" + this.template + ", cardId=" + this.cardId + ", data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public OrderCard(String str, String str2, CardData cardData) {
        this.template = str;
        this.cardId = str2;
        this.data = cardData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderCard(String str, String str2, CardData cardData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : cardData);
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final CardData getData() {
        return this.data;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderCard$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
