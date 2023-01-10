package com.didi.component.driverbar.view;

import com.didiglobal.travel.biz.util.OmegaTraceWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo148868d2 = {"<anonymous>", "", "Lcom/didiglobal/travel/biz/util/OmegaTraceWrapper;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DriverBarWaitingJapanStyleView.kt */
final class DriverBarWaitingJapanStyleView$onDriverAvatarClick$1 extends Lambda implements Function1<OmegaTraceWrapper, Unit> {
    public static final DriverBarWaitingJapanStyleView$onDriverAvatarClick$1 INSTANCE = new DriverBarWaitingJapanStyleView$onDriverAvatarClick$1();

    DriverBarWaitingJapanStyleView$onDriverAvatarClick$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OmegaTraceWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(OmegaTraceWrapper omegaTraceWrapper) {
        Intrinsics.checkNotNullParameter(omegaTraceWrapper, "$this$omega");
        omegaTraceWrapper.setEventId("ibt_gp_tripservice_driverhead_ck");
        omegaTraceWrapper.prop("type", "2");
    }
}
