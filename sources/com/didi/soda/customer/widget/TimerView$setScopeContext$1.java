package com.didi.soda.customer.widget;

import android.os.Handler;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/soda/customer/widget/TimerView$setScopeContext$1", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "onCreate", "", "live", "Lcom/didi/app/nova/skeleton/ILive;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TimerView.kt */
public final class TimerView$setScopeContext$1 implements IScopeLifecycle {
    final /* synthetic */ TimerView this$0;

    public void onCreate(ILive iLive) {
    }

    public void onPause(ILive iLive) {
    }

    public void onResume(ILive iLive) {
    }

    public void onStart(ILive iLive) {
    }

    public void onStop(ILive iLive) {
    }

    TimerView$setScopeContext$1(TimerView timerView) {
        this.this$0 = timerView;
    }

    public void onDestroy(ILive iLive) {
        Handler handler = this.this$0.getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.this$0.f44224k);
        }
    }
}
