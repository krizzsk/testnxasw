package com.didi.component.driverbar.presenter;

import com.didi.component.core.event.BaseEventPublisher;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n"}, mo148868d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "event", "Lcom/didi/component/core/event/BaseEventPublisher$NullEvent;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
final class DriverBarV2Presenter$mBlueToothOnserviceListener$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ DriverBarV2Presenter this$0;

    DriverBarV2Presenter$mBlueToothOnserviceListener$1(DriverBarV2Presenter driverBarV2Presenter) {
        this.this$0 = driverBarV2Presenter;
    }

    public final void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
        this.this$0.handleBluetoothMeetOnservice();
    }
}