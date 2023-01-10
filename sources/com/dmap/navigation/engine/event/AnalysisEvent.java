package com.dmap.navigation.engine.event;

import com.dmap.navigation.jni.swig.AnalysisLog;
import com.dmap.navigation.jni.swig.AnalysisLogList;
import java.util.HashMap;
import java.util.Map;

public class AnalysisEvent extends NaviEvent {

    /* renamed from: a */
    private final String f54392a;

    /* renamed from: b */
    private final Map<String, Object> f54393b;

    public AnalysisEvent(String str, AnalysisLogList analysisLogList) {
        this.f54392a = str;
        int size = (int) analysisLogList.size();
        if (size > 0) {
            this.f54393b = new HashMap(size);
            for (int i = 0; i < size; i++) {
                AnalysisLog analysisLog = analysisLogList.get(i);
                this.f54393b.put(analysisLog.getKey(), analysisLog.getValue());
            }
            return;
        }
        this.f54393b = null;
    }

    public String toString() {
        return "AnalysisEvent{key='" + this.f54392a + '\'' + ", data=" + this.f54393b + '}';
    }

    public String getKey() {
        return this.f54392a;
    }

    public Map<String, Object> getData() {
        return this.f54393b;
    }
}
