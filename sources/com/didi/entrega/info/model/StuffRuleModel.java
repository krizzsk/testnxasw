package com.didi.entrega.info.model;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo148868d2 = {"Lcom/didi/entrega/info/model/StuffRuleModel;", "Lcom/didi/entrega/info/model/BaseContactModel;", "()V", "stuffEntityData", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;", "getStuffEntityData", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;", "setStuffEntityData", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StuffRuleModel.kt */
public final class StuffRuleModel implements BaseContactModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CommonInfoEntity.ServiceRule f22653a;

    @JvmStatic
    public static final StuffRuleModel newInstant(CommonInfoEntity.ServiceRule serviceRule) {
        return Companion.newInstant(serviceRule);
    }

    public final CommonInfoEntity.ServiceRule getStuffEntityData() {
        return this.f22653a;
    }

    public final void setStuffEntityData(CommonInfoEntity.ServiceRule serviceRule) {
        this.f22653a = serviceRule;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/entrega/info/model/StuffRuleModel$Companion;", "", "()V", "newInstant", "Lcom/didi/entrega/info/model/StuffRuleModel;", "contact", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$ServiceRule;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StuffRuleModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StuffRuleModel newInstant(CommonInfoEntity.ServiceRule serviceRule) {
            StuffRuleModel stuffRuleModel = new StuffRuleModel();
            stuffRuleModel.setStuffEntityData(serviceRule);
            return stuffRuleModel;
        }
    }
}
