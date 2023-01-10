package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import android.view.Choreographer;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p108ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.ForegroundChecker;

public class FPSProvider implements Choreographer.FrameCallback, IPerformance<Integer>, ForegroundChecker.OnForegroundChange {

    /* renamed from: c */
    private static final int f19953c = 1000000000;

    /* renamed from: a */
    long f19954a = -1;

    /* renamed from: b */
    int f19955b = -1;

    /* renamed from: d */
    private Choreographer f19956d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDataProvider<Integer> f19957e;

    public void registerProvider(IDataProvider<Integer> iDataProvider) {
        this.f19957e = iDataProvider;
        Choreographer instance = Choreographer.getInstance();
        this.f19956d = instance;
        instance.postFrameCallback(this);
    }

    public void doFrame(long j) {
        final int i;
        long j2 = this.f19954a;
        if (j2 > 0 && this.f19955b != (i = (int) (((1.0f / ((float) (j - j2))) * 1.0E9f) + 0.5f))) {
            this.f19955b = i;
            if (i > 60) {
                i = 60;
            }
            if (this.f19957e != null) {
                GlobalDispatcher.post(new Runnable() {
                    public void run() {
                        FPSProvider.this.f19957e.onProvide(Integer.valueOf(i));
                    }
                });
            }
        }
        this.f19954a = j;
        this.f19956d.postFrameCallback(this);
    }

    public void onChange(boolean z) {
        Choreographer choreographer = this.f19956d;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this);
            if (z) {
                this.f19956d.postFrameCallback(this);
            }
        }
    }
}
