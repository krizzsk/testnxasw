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
final class InfoOmegaHelper$trackConfirmCk$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<String> $eventName;
    final /* synthetic */ OmegaCommonModel $omegaCommonModel;
    final /* synthetic */ Ref.ObjectRef<String> $poiCityKey;
    final /* synthetic */ Ref.ObjectRef<String> $poiKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfoOmegaHelper$trackConfirmCk$2(OmegaCommonModel omegaCommonModel, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3) {
        super(0);
        this.$omegaCommonModel = omegaCommonModel;
        this.$poiKey = objectRef;
        this.$poiCityKey = objectRef2;
        this.$eventName = objectRef3;
    }

    public final void invoke() {
        this.$omegaCommonModel.setFromPage(201);
        this.$poiKey.element = "sender_poi_id";
        this.$poiCityKey.element = ParamConst.InfoOmega.SENDER_CITY_ID;
        this.$eventName.element = EventConst.INFO.SAILING_C_E_ENTREGAPAGE_SENDER_CONFIRM_CK;
    }
}
