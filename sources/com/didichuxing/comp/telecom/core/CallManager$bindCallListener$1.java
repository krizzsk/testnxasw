package com.didichuxing.comp.telecom.core;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didichuxing/comp/telecom/core/CallManager$bindCallListener$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "voip-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* compiled from: CallManager.kt */
public final class CallManager$bindCallListener$1 implements LifecycleEventObserver {
    final /* synthetic */ CallManagerStateListener $callback;
    final /* synthetic */ CallManager this$0;

    CallManager$bindCallListener$1(CallManager callManager, CallManagerStateListener callManagerStateListener) {
        this.this$0 = callManager;
        this.$callback = callManagerStateListener;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "source");
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.this$0.f49049c.remove(this.$callback);
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
