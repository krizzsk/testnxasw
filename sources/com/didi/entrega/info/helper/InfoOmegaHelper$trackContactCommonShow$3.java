package com.didi.entrega.info.helper;

import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.info.model.OmegaCommonModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InfoOmegaHelper.kt */
final class InfoOmegaHelper$trackContactCommonShow$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<String> $eventName;
    final /* synthetic */ OmegaCommonModel $omegaCommonModel;
    final /* synthetic */ Ref.ObjectRef<String> $poiCityIdKey;
    final /* synthetic */ Ref.ObjectRef<String> $poiKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoOmegaHelper$trackContactCommonShow$3(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, OmegaCommonModel omegaCommonModel) {
        super(0);
        this.$eventName = objectRef;
        this.$poiKey = objectRef2;
        this.$poiCityIdKey = objectRef3;
        this.$omegaCommonModel = omegaCommonModel;
    }

    public final void invoke() {
        this.$eventName.element = EventConst.INFO.SAILING_C_E_ENTREGAPAGE_RECEIVER_COMMON_SW;
        this.$poiKey.element = "receiver_poi_id";
        this.$poiCityIdKey.element = ParamConst.InfoOmega.RECEIVER_CITY_ID;
        this.$omegaCommonModel.setFromPage(101);
    }
}
