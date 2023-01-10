package com.didichuxing.swarm.launcher;

import com.didichuxing.swarm.toolkit.TimeService;
import com.didichuxing.swarm.toolkit.TraceIdService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;

public class TraceIdServiceImpl implements TraceIdService {

    /* renamed from: a */
    private final Framework f51755a;

    TraceIdServiceImpl(Framework framework) {
        this.f51755a = framework;
    }

    public String getTraceId(int i) {
        BundleContext bundleContext = this.f51755a.getBundleContext();
        TimeService timeService = (TimeService) bundleContext.getService(bundleContext.getServiceReference(TimeService.class));
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (timeService != null) {
            currentTimeMillis += (int) (timeService.getTimeDifference() / 1000);
        }
        return TraceIdGenerator.m38910a(currentTimeMillis, i);
    }
}
