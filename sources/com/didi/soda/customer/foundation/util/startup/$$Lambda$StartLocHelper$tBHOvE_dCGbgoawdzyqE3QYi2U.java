package com.didi.soda.customer.foundation.util.startup;

import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;

/* renamed from: com.didi.soda.customer.foundation.util.startup.-$$Lambda$StartLocHelper$tBHOvE_dCGbg-oawdzyqE3QYi2U  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$StartLocHelper$tBHOvE_dCGbgoawdzyqE3QYi2U implements Runnable {
    public static final /* synthetic */ $$Lambda$StartLocHelper$tBHOvE_dCGbgoawdzyqE3QYi2U INSTANCE = new $$Lambda$StartLocHelper$tBHOvE_dCGbgoawdzyqE3QYi2U();

    private /* synthetic */ $$Lambda$StartLocHelper$tBHOvE_dCGbgoawdzyqE3QYi2U() {
    }

    public final void run() {
        LaunchAppTracker.Companion.endTrace("StartLocMainWait");
    }
}
