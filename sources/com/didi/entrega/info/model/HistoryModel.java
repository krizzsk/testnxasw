package com.didi.entrega.info.model;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo148868d2 = {"Lcom/didi/entrega/info/model/HistoryModel;", "Lcom/didi/entrega/info/model/BaseContactModel;", "()V", "historyEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;", "getHistoryEntity", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;", "setHistoryEntity", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HistoryModel.kt */
public final class HistoryModel implements BaseContactModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CommonInfoEntity.HistoryContact f22648a;

    public final CommonInfoEntity.HistoryContact getHistoryEntity() {
        return this.f22648a;
    }

    public final void setHistoryEntity(CommonInfoEntity.HistoryContact historyContact) {
        this.f22648a = historyContact;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/entrega/info/model/HistoryModel$Companion;", "", "()V", "newInstance", "Lcom/didi/entrega/info/model/HistoryModel;", "historyEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$HistoryContact;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HistoryModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HistoryModel newInstance(CommonInfoEntity.HistoryContact historyContact) {
            HistoryModel historyModel = new HistoryModel();
            historyModel.setHistoryEntity(historyContact);
            return historyModel;
        }
    }
}
