package com.didi.soda.customer.biz.order.looper.mix.statemachine;

import android.os.Handler;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.IMixMachineTrigger;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class MixMachineTrigger implements IMixMachineTrigger {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Handler f43018a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMixMachineTrigger.OnTriggerListener f43019b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f43020c = 3000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f43021d = new Runnable() {
        public void run() {
            if (MixMachineTrigger.this.f43019b != null) {
                MixMachineTrigger.this.f43019b.doTrigger();
            }
            MixMachineTrigger.this.f43018a.postDelayed(MixMachineTrigger.this.f43021d, (long) MixMachineTrigger.this.f43020c);
        }
    };

    public void onCreate() {
        LogUtil.m32584d("Looper", "MixMachineTrigger--> onCreate");
        this.f43018a = new Handler();
    }

    public void onDestroy() {
        LogUtil.m32584d("Looper", "MixMachineTrigger--> onDestroy");
        this.f43018a.removeCallbacks(this.f43021d);
        this.f43018a = null;
        this.f43019b = null;
    }

    public void setInterval(int i) {
        this.f43020c = i;
        if (i < 3000) {
            this.f43020c = 3000;
        }
    }

    public void setTriggerListener(IMixMachineTrigger.OnTriggerListener onTriggerListener) {
        this.f43019b = onTriggerListener;
    }

    public void start() {
        LogUtil.m32584d("Looper", "MixMachineTrigger--> start");
        this.f43018a.post(this.f43021d);
    }

    public void stop() {
        LogUtil.m32584d("Looper", "MixMachineTrigger--> stop");
        this.f43018a.removeCallbacks(this.f43021d);
    }
}
