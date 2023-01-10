package com.didi.map.sdk.sharetrack.google.inner.handler;

import com.didi.common.map.util.DLog;
import com.didi.map.sdk.sharetrack.google.inner.apollo.PushEdaApollo;

public class PushEdaHandler {

    /* renamed from: a */
    private static final String f31274a = "PushEdaHandler";

    /* renamed from: b */
    private boolean f31275b = false;

    /* renamed from: c */
    private boolean f31276c = false;

    /* renamed from: d */
    private PushEdaApollo f31277d;

    public PushEdaHandler() {
        PushEdaApollo pushEdaApollo = new PushEdaApollo();
        this.f31277d = pushEdaApollo;
        pushEdaApollo.init();
    }

    public boolean dispatchEvent(int i) {
        int i2;
        if (this.f31276c && this.f31275b) {
            return false;
        }
        PushEdaApollo pushEdaApollo = this.f31277d;
        int i3 = -1;
        if (pushEdaApollo != null) {
            i3 = pushEdaApollo.getShortEda();
            i2 = this.f31277d.getLongEda();
        } else {
            i2 = -1;
        }
        DLog.m10773d(f31274a, "当前eda=%d ,edaShort=%d ,edaLong=%d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
        if (i <= i2 && !this.f31276c) {
            this.f31276c = true;
            DLog.m10773d(f31274a, "eda长距离条件触发 当前eda %d 触发阈值 %d", Integer.valueOf(i), Integer.valueOf(i2));
            return true;
        } else if (i > i3 || this.f31275b) {
            return false;
        } else {
            this.f31275b = true;
            DLog.m10773d(f31274a, "eda短距离条件触发 当前eda %d 触发阈值 %d", Integer.valueOf(i), Integer.valueOf(i3));
            return true;
        }
    }
}
