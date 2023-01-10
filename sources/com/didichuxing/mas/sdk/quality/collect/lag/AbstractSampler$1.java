package com.didichuxing.mas.sdk.quality.collect.lag;

class AbstractSampler$1 implements Runnable {
    final /* synthetic */ C16598a this$0;

    AbstractSampler$1(C16598a aVar) {
        this.this$0 = aVar;
    }

    public void run() {
        this.this$0.mo124923c();
        if (this.this$0.f50688a.get()) {
            HandlerThreadFactory.getTimerThreadHandler().postDelayed(this.this$0.f50690d, this.this$0.f50689b);
        }
    }
}
