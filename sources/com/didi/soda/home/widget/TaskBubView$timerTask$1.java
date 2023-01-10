package com.didi.soda.home.widget;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/soda/home/widget/TaskBubView$timerTask$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TaskBubView.kt */
public final class TaskBubView$timerTask$1 extends CountDownTimer {
    final /* synthetic */ TaskBubView this$0;

    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskBubView$timerTask$1(TaskBubView taskBubView, long j) {
        super(j, 1000);
        this.this$0 = taskBubView;
    }

    public void onFinish() {
        this.this$0.onHomeFeedStopScroll();
    }
}
