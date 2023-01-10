package com.didi.dimina.container.monitor;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;

public class TrackSubPackExec implements IDMCommonAction<Void> {

    /* renamed from: a */
    IDMCommonAction<Void> f18849a;

    /* renamed from: b */
    String f18850b;

    /* renamed from: c */
    String f18851c;

    /* renamed from: d */
    DMMina f18852d;

    /* renamed from: e */
    long f18853e = TimeUtil.currentNanoMillis();

    public TrackSubPackExec(DMMina dMMina, String str, IDMCommonAction<Void> iDMCommonAction) {
        this.f18849a = iDMCommonAction;
        this.f18850b = str;
        this.f18851c = dMMina.getConfig().getLaunchConfig().getBundleManagerStrategy().getTag();
        this.f18852d = dMMina;
        trackTechSagaSubPkgExecStart();
    }

    public void callback(Void voidR) {
        trackTechSagaSubPkgExecSuccess();
        this.f18849a.callback(voidR);
    }

    public void trackTechSagaSubPkgExecStart() {
        TraceUtil.trackTechSagaSubPkgExecStart(this.f18852d.getMinaIndex(), this.f18851c, this.f18850b, !this.f18852d.getPerformance().isFirstDomReady());
    }

    public void trackTechSagaSubPkgExecSuccess() {
        long currentNanoMillis = TimeUtil.currentNanoMillis() - this.f18853e;
        this.f18852d.getPerformance().appendStartSubPackageLoadExec(currentNanoMillis);
        TraceUtil.trackTechSagaSubPkgExecSuccess(this.f18852d.getMinaIndex(), this.f18851c, this.f18850b, currentNanoMillis, !this.f18852d.getPerformance().isFirstDomReady());
    }
}
