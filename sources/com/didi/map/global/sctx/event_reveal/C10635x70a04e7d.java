package com.didi.map.global.sctx.event_reveal;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.sctx.event_reveal.TrafficEventsController;
import com.didi.map.sdk.proto.driver_gl.event.ButtonInfo;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/map/global/sctx/event_reveal/TrafficEventsController$tryShowUserClickedVerifyDialog$majorBtn$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryShowUserClickedVerifyDialog$majorBtn$1 */
/* compiled from: TrafficEventsController.kt */
public final class C10635x70a04e7d extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ List<ButtonInfo> $btnInfos;
    final /* synthetic */ Ref.BooleanRef $buttonClicked;
    final /* synthetic */ Ref.ObjectRef<LEGODrawer> $drawer;
    final /* synthetic */ TrafficEventModel $eventModel;
    final /* synthetic */ TrafficEventsController this$0;

    C10635x70a04e7d(Ref.ObjectRef<LEGODrawer> objectRef, Ref.BooleanRef booleanRef, TrafficEventModel trafficEventModel, TrafficEventsController trafficEventsController, List<ButtonInfo> list) {
        this.$drawer = objectRef;
        this.$buttonClicked = booleanRef;
        this.$eventModel = trafficEventModel;
        this.this$0 = trafficEventsController;
        this.$btnInfos = list;
    }

    public void onAntiShakeClick(View view) {
        LEGODrawer lEGODrawer = (LEGODrawer) this.$drawer.element;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        this.$buttonClicked.element = true;
        if (this.$eventModel.getEventOper() == 3) {
            LEGOToastHelper.showShortNagToast(this.this$0.f30046a, this.this$0.f30046a.getString(R.string.GRider_PassengerReports__ZGAx));
            return;
        }
        TrafficEventsController trafficEventsController = this.this$0;
        TrafficEventModel trafficEventModel = this.$eventModel;
        Integer num = ((ButtonInfo) CollectionsKt.first(this.$btnInfos)).buttonValue;
        Intrinsics.checkNotNullExpressionValue(num, "btnInfos.first().buttonValue");
        trafficEventsController.m23417a(trafficEventModel, num.intValue(), TrafficEventsController.OmegaCardType.CLICK_TYPE.getType());
        TrafficEventsController trafficEventsController2 = this.this$0;
        ITrafficEventsReqParamGetter access$getParamGetter$p = trafficEventsController2.f30050e;
        String orderId = access$getParamGetter$p == null ? null : access$getParamGetter$p.getOrderId();
        TrafficEventModel trafficEventModel2 = this.$eventModel;
        Integer num2 = ((ButtonInfo) CollectionsKt.first(this.$btnInfos)).buttonValue;
        Intrinsics.checkNotNullExpressionValue(num2, "btnInfos.first().buttonValue");
        int intValue = num2.intValue();
        ITrafficEventsReqParamGetter access$getParamGetter$p2 = this.this$0.f30050e;
        trafficEventsController2.m23424a(orderId, trafficEventModel2, intValue, access$getParamGetter$p2 == null ? null : Long.valueOf(access$getParamGetter$p2.getCurRouteId()), TrafficEventsController.OmegaCardType.CLICK_TYPE);
    }
}
