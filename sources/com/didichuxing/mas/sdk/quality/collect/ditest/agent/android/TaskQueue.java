package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.NamedThreadFactory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskQueue {

    /* renamed from: a */
    private static final AgentLog f50463a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private static final long f50464b = 1000;

    /* renamed from: c */
    private static final ScheduledExecutorService f50465c = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("TaskQueue"));

    /* renamed from: d */
    private static final ConcurrentLinkedQueue<Object> f50466d = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private static final Runnable f50467e = new Runnable() {
        public void run() {
            TaskQueue.m37661b();
        }
    };

    /* renamed from: f */
    private static Future f50468f;

    /* renamed from: g */
    private static boolean f50469g;

    public static void queue(Object obj) {
        if (f50469g) {
            f50466d.add(obj);
        } else {
            f50463a.debug("drop data!");
        }
    }

    public static void backgroundDequeue() {
        f50465c.execute(f50467e);
    }

    public static void synchronousDequeue() {
        try {
            f50465c.submit(f50467e).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
        }
    }

    public static void start() {
        if (f50468f == null) {
            f50468f = f50465c.scheduleAtFixedRate(f50467e, 0, 1000, TimeUnit.MILLISECONDS);
        }
        f50469g = true;
    }

    public static void stop() {
        Future future = f50468f;
        if (future != null) {
            future.cancel(true);
            f50468f = null;
        }
        f50469g = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m37661b() {
        if (f50466d.size() != 0) {
            while (!f50466d.isEmpty()) {
                try {
                    Object remove = f50466d.remove();
                    if (remove instanceof HttpTransactionMeasurement) {
                        Measurements.addHttpTransaction((HttpTransactionMeasurement) remove);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int size() {
        return f50466d.size();
    }

    public static void clear() {
        f50466d.clear();
    }
}
