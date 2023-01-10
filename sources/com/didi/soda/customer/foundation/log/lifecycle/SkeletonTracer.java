package com.didi.soda.customer.foundation.log.lifecycle;

import com.didi.app.nova.skeleton.Skeleton;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class SkeletonTracer implements Skeleton.Tracer {

    /* renamed from: a */
    private static final String f43537a = "SkeletonTracer";

    public void trace(String str, String str2) {
        LogUtil.m32584d(str, str2);
        RecordTracker.Builder.create().setTag(f43537a).setLogModule("m-skeleton|").setMessage(str2).setLogCategory("c-data|").build().info();
    }
}
