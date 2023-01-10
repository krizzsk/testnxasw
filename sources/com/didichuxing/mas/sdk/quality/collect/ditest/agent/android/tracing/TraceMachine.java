package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.tracing;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.TaskQueue;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.p190v2.TraceFieldInterface;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.p190v2.TraceMachineInterface;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class TraceMachine {
    public static final String ACTIVITY_BACKGROUND_METRIC_PREFIX = "Mobile/Activity/Background/Name/";
    public static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Name/";
    public static final String ACTIVTY_DISPLAY_NAME_PREFIX = "Display ";
    public static final int HEALTHY_TRACE_TIMEOUT = 500;
    public static final String NR_TRACE_FIELD = "_nr_trace";
    public static final String NR_TRACE_TYPE = "Lcom/didichuxing/ditest/agent/android/tracing/Trace;";
    public static final int UNHEALTHY_TRACE_TIMEOUT = 60000;

    /* renamed from: a */
    private static final AgentLog f50622a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private static final ThreadLocal<Trace> f50623b = new ThreadLocal<>();

    /* renamed from: c */
    private static final ThreadLocal<TraceStack> f50624c = new ThreadLocal<>();

    /* renamed from: d */
    private static TraceMachine f50625d = null;
    public static final AtomicBoolean disabled = new AtomicBoolean(false);

    /* renamed from: e */
    private static TraceMachineInterface f50626e;

    public static void endTrace(String str) {
    }

    public static String getCurrentScope() {
        return null;
    }

    public static Trace getCurrentTrace() throws TracingInactiveException {
        return null;
    }

    public static void setTraceMachineInterface(TraceMachineInterface traceMachineInterface) {
    }

    public void completeActivityTrace() {
    }

    protected TraceMachine(Trace trace) {
    }

    public static TraceMachine getTraceMachine() {
        return f50625d;
    }

    public static void startTracing(String str) {
        startTracing(str, false);
    }

    public static void startTracing(String str, boolean z) {
        try {
            if (isTracingActive()) {
                f50625d.completeActivityTrace();
            }
            f50623b.remove();
            f50624c.set(new TraceStack());
            Trace trace = new Trace();
            if (z) {
                trace.displayName = str;
            } else {
                trace.displayName = formatActivityDisplayName(str);
            }
            trace.metricName = formatActivityMetricName(trace.displayName);
            trace.metricBackgroundName = formatActivityBackgroundMetricName(trace.displayName);
            trace.entryTimestamp = System.currentTimeMillis();
            if (f50622a.getLevel() == 5) {
                AgentLog agentLog = f50622a;
                agentLog.debug("Started trace of " + str + ":" + trace.myUUID.toString());
            }
            TraceMachine traceMachine = new TraceMachine(trace);
            f50625d = traceMachine;
            trace.traceMachine = traceMachine;
            m37723a(trace);
        } catch (Exception e) {
            f50622a.error("Caught error while initializing TraceMachine, shutting it down", e);
            f50625d = null;
            f50623b.remove();
            f50624c.remove();
        }
    }

    public static void haltTracing() {
        if (!isTracingInactive()) {
            f50625d = null;
            f50623b.remove();
            f50624c.remove();
        }
    }

    public static void endTrace() {
        f50625d.completeActivityTrace();
    }

    public static String formatActivityMetricName(String str) {
        return "Mobile/Activity/Name/" + str;
    }

    public static String formatActivityBackgroundMetricName(String str) {
        return "Mobile/Activity/Background/Name/" + str;
    }

    public static String formatActivityDisplayName(String str) {
        return "Display " + str;
    }

    /* renamed from: a */
    private static Trace m37722a(String str) throws TracingInactiveException {
        if (!isTracingInactive()) {
            Trace currentTrace = getCurrentTrace();
            Trace trace = new Trace(str, currentTrace.myUUID, f50625d);
            if (f50622a.getLevel() == 5) {
                AgentLog agentLog = f50622a;
                agentLog.debug("Registering trace of " + str + " with parent " + currentTrace.displayName);
            }
            currentTrace.addChild(trace);
            return trace;
        }
        f50622a.debug("Tried to register a new trace but tracing is inactive!");
        throw new TracingInactiveException();
    }

    public static void enterNetworkSegment(String str) {
        try {
            if (!isTracingInactive()) {
                if (getCurrentTrace().getType() == TraceType.NETWORK) {
                    exitMethod();
                }
                enterMethod((Trace) null, str, (ArrayList<String>) null);
                getCurrentTrace().setType(TraceType.NETWORK);
            }
        } catch (TracingInactiveException unused) {
        } catch (Exception e) {
            f50622a.error("Caught error while calling enterNetworkSegment()", e);
        }
    }

    public static void enterMethod(String str) {
        enterMethod((Trace) null, str, (ArrayList<String>) null);
    }

    public static void enterMethod(String str, ArrayList<String> arrayList) {
        enterMethod((Trace) null, str, arrayList);
    }

    public static void enterMethod(Trace trace, String str, ArrayList<String> arrayList) {
        try {
            if (!isTracingInactive()) {
                System.currentTimeMillis();
                m37724b(trace);
                Trace a = m37722a(str);
                m37723a(a);
                a.scope = getCurrentScope();
                a.setAnnotationParams(arrayList);
                a.entryTimestamp = System.currentTimeMillis();
            }
        } catch (TracingInactiveException unused) {
        } catch (Exception e) {
            f50622a.error("Caught error while calling enterMethod()", e);
        }
    }

    public static void exitMethod() {
        try {
            if (!isTracingInactive()) {
                Trace trace = f50623b.get();
                if (trace == null) {
                    f50622a.debug("threadLocalTrace is null");
                    return;
                }
                trace.exitTimestamp = System.currentTimeMillis();
                if (trace.threadId == 0 && f50626e != null) {
                    trace.threadId = f50626e.getCurrentThreadId();
                    trace.threadName = f50626e.getCurrentThreadName();
                }
                try {
                    trace.complete();
                    f50624c.get().pop();
                    if (f50624c.get().empty()) {
                        f50623b.set((Object) null);
                    } else {
                        Trace trace2 = (Trace) f50624c.get().peek();
                        f50623b.set(trace2);
                        trace2.childExclusiveTime += trace.getDuration();
                    }
                    if (trace.getType() == TraceType.TRACE) {
                        TaskQueue.queue(trace);
                    }
                } catch (TracingInactiveException unused) {
                    f50623b.remove();
                    f50624c.remove();
                    if (trace.getType() == TraceType.TRACE) {
                        TaskQueue.queue(trace);
                    }
                }
            }
        } catch (Exception e) {
            f50622a.error("Caught error while calling exitMethod()", e);
        }
    }

    /* renamed from: a */
    private static void m37723a(Trace trace) {
        if (!isTracingInactive() && trace != null) {
            TraceStack traceStack = f50624c.get();
            if (traceStack.empty()) {
                traceStack.push(trace);
            } else if (traceStack.peek() != trace) {
                traceStack.push(trace);
            }
            f50623b.set(trace);
        }
    }

    /* renamed from: b */
    private static void m37724b(Trace trace) {
        if (!isTracingInactive()) {
            if (f50623b.get() == null) {
                f50623b.set(trace);
                f50624c.set(new TraceStack());
                if (trace != null) {
                    f50624c.get().push(trace);
                } else {
                    return;
                }
            } else if (trace == null) {
                if (f50624c.get().isEmpty()) {
                    if (f50622a.getLevel() == 5) {
                        f50622a.debug("No context to load!");
                    }
                    f50623b.set((Object) null);
                    return;
                }
                trace = (Trace) f50624c.get().peek();
                f50623b.set(trace);
            }
            if (f50622a.getLevel() == 5) {
                AgentLog agentLog = f50622a;
                agentLog.debug("Trace " + trace.myUUID.toString() + " is now active");
            }
        }
    }

    public static void unloadTraceContext(Object obj) {
        try {
            if (!isTracingInactive()) {
                if (f50626e == null || !f50626e.isUIThread()) {
                    if (f50623b.get() != null && f50622a.getLevel() == 5) {
                        AgentLog agentLog = f50622a;
                        agentLog.debug("Trace " + f50623b.get().myUUID.toString() + " is now inactive");
                    }
                    f50623b.remove();
                    f50624c.remove();
                    ((TraceFieldInterface) obj)._nr_setTrace((Trace) null);
                }
            }
        } catch (Exception e) {
            f50622a.error("Caught error while calling unloadTraceContext()", e);
        }
    }

    public static Map<String, Object> getCurrentTraceParams() throws TracingInactiveException {
        return getCurrentTrace().getParams();
    }

    public static void setCurrentTraceParam(String str, Object obj) {
        if (!isTracingInactive()) {
            try {
                getCurrentTrace().getParams().put(str, obj);
            } catch (TracingInactiveException unused) {
            }
        }
    }

    public static void setCurrentDisplayName(String str) {
        if (!isTracingInactive()) {
            try {
                getCurrentTrace().displayName = str;
            } catch (TracingInactiveException unused) {
            }
        }
    }

    public static boolean isTracingActive() {
        return f50625d != null;
    }

    public static boolean isTracingInactive() {
        return f50625d == null;
    }

    public void storeCompletedTrace(Trace trace) {
        try {
            if (isTracingInactive()) {
                f50622a.debug("Attempted to store a completed trace with no trace machine!");
            }
        } catch (Exception e) {
            f50622a.error("Caught error while calling storeCompletedTrace()", e);
        }
    }

    private static class TraceStack extends Stack<Trace> {
        private TraceStack() {
        }
    }
}
