package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.tracing;

import com.didi.flutter.nacho2.p116v2.NachoConstants;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.MetricCategory;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.C16586Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Trace {

    /* renamed from: a */
    private static final String f50615a = "category";

    /* renamed from: b */
    private static final AgentLog f50616b = AgentLogManager.getAgentLog();

    /* renamed from: c */
    private volatile Map<String, Object> f50617c;
    public long childExclusiveTime;

    /* renamed from: d */
    private List<String> f50618d;
    public String displayName;

    /* renamed from: e */
    private volatile Set<UUID> f50619e;
    public long entryTimestamp;
    public long exclusiveTime;
    public long exitTimestamp;

    /* renamed from: f */
    private TraceType f50620f;

    /* renamed from: g */
    private boolean f50621g;
    public String metricBackgroundName;
    public String metricName;
    public final UUID myUUID;
    public final UUID parentUUID;
    public String scope;
    public long threadId;
    public String threadName;
    public TraceMachine traceMachine;

    public Trace() {
        this.myUUID = new UUID(C16586Util.getRandom().nextLong(), C16586Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = NachoConstants.NACHO_ENTRYPOINT_NAME;
        this.f50620f = TraceType.TRACE;
        this.f50621g = false;
        this.parentUUID = null;
    }

    public Trace(String str, UUID uuid, TraceMachine traceMachine2) {
        this.myUUID = new UUID(C16586Util.getRandom().nextLong(), C16586Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = NachoConstants.NACHO_ENTRYPOINT_NAME;
        this.f50620f = TraceType.TRACE;
        this.f50621g = false;
        this.displayName = str;
        this.parentUUID = uuid;
        this.traceMachine = traceMachine2;
    }

    public void addChild(Trace trace) {
        if (this.f50619e == null) {
            synchronized (this) {
                if (this.f50619e == null) {
                    this.f50619e = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        this.f50619e.add(trace.myUUID);
    }

    public Set<UUID> getChildren() {
        if (this.f50619e == null) {
            synchronized (this) {
                if (this.f50619e == null) {
                    this.f50619e = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        return this.f50619e;
    }

    public Map<String, Object> getParams() {
        if (this.f50617c == null) {
            synchronized (this) {
                if (this.f50617c == null) {
                    this.f50617c = new ConcurrentHashMap();
                }
            }
        }
        return this.f50617c;
    }

    public void setAnnotationParams(List<String> list) {
        this.f50618d = list;
    }

    public Map<String, Object> getAnnotationParams() {
        HashMap hashMap = new HashMap();
        List<String> list = this.f50618d;
        if (list != null && list.size() > 0) {
            Iterator<String> it = this.f50618d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object a = m37721a(next, it.next(), it.next());
                if (a != null) {
                    hashMap.put(next, a);
                }
            }
        }
        return hashMap;
    }

    public boolean isComplete() {
        return this.f50621g;
    }

    public void complete() throws TracingInactiveException {
        if (this.f50621g) {
            AgentLog agentLog = f50616b;
            agentLog.warning("Attempted to double complete trace " + this.myUUID.toString());
            return;
        }
        if (this.exitTimestamp == 0) {
            this.exitTimestamp = System.currentTimeMillis();
        }
        this.exclusiveTime = getDuration() - this.childExclusiveTime;
        this.f50621g = true;
        try {
            this.traceMachine.storeCompletedTrace(this);
        } catch (NullPointerException unused) {
            throw new TracingInactiveException();
        }
    }

    public void prepareForSerialization() {
        getParams().put("type", this.f50620f.toString());
    }

    public TraceType getType() {
        return this.f50620f;
    }

    public void setType(TraceType traceType) {
        this.f50620f = traceType;
    }

    public long getDuration() {
        return this.exitTimestamp - this.entryTimestamp;
    }

    public MetricCategory getCategory() {
        if (!getAnnotationParams().containsKey(f50615a)) {
            return null;
        }
        Object obj = getAnnotationParams().get(f50615a);
        if (obj instanceof MetricCategory) {
            return (MetricCategory) obj;
        }
        f50616b.error("Category annotation parameter is not of type MetricCategory");
        return null;
    }

    /* renamed from: a */
    private static Object m37721a(String str, String str2, String str3) {
        try {
            Class<?> cls = Class.forName(str2);
            if (MetricCategory.class == cls) {
                return MetricCategory.valueOf(str3);
            }
            if (String.class == cls) {
                return str3;
            }
            return null;
        } catch (ClassNotFoundException e) {
            AgentLog agentLog = f50616b;
            agentLog.error("Unable to resolve parameter class in enterMethod: " + e.getMessage(), e);
            return null;
        }
    }
}
