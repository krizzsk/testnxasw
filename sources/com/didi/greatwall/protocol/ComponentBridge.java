package com.didi.greatwall.protocol;

import com.didi.greatwall.util.log.GLogger;
import java.util.HashMap;
import org.json.JSONObject;

public class ComponentBridge {

    /* renamed from: a */
    private static final ComponentBridge f25223a = new ComponentBridge();

    /* renamed from: b */
    private GLogger f25224b = GLogger.getLogger();

    /* renamed from: c */
    private HashMap<String, ComponentListener> f25225c = new HashMap<>();

    public static ComponentBridge getInstance() {
        return f25223a;
    }

    private ComponentBridge() {
    }

    public synchronized void executeFinish(String str, int i, JSONObject jSONObject) {
        ComponentListener componentListener = this.f25225c.get(str);
        GLogger gLogger = this.f25224b;
        gLogger.info("component [" + str + "] execute finish,lis = " + componentListener + ",jsonObject = " + jSONObject);
        m20197a(str);
        if (componentListener != null) {
            componentListener.onFinish(i, jSONObject);
        }
    }

    public synchronized void addExecuteCallback(String str, ComponentListener componentListener) {
        GLogger gLogger = this.f25224b;
        gLogger.info("addExecuteCallback componentID = " + str + ",listener = " + componentListener);
        this.f25225c.put(str, componentListener);
    }

    /* renamed from: a */
    private synchronized void m20197a(String str) {
        GLogger gLogger = this.f25224b;
        gLogger.info("removeExecuteCallback componentID = " + str + ",listener = " + this.f25225c.remove(str));
    }
}
